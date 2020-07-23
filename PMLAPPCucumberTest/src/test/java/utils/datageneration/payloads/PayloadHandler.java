package utils.datageneration.payloads;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Assert;
import org.w3c.dom.Document;

import com.freddiemac.service.event.api.EventNotification;
import com.freddiemac.service.event.model.EventContainerType;
import com.freddiemac.service.event.model.Events;
import com.freddiemac.service.event.util.EventUtils;
import com.freddiemac.service.udmcevent.api.UdmcEventNotification;
import com.freddiemac.service.udmcevent.model.EventType;
import com.freddiemac.service.udmcevent.model.EventTypeEnumerated;
import com.freddiemac.service.udmcevent.model.EventsType;
import com.freddiemac.service.udmcevent.model.MessageActionTypeEnumerated;
import com.freddiemac.service.udmcevent.model.SenderClassificationEnumerated;
import com.freddiemac.service.udmcevent.model.UniformDataMovementControlEvent;
import com.freddiemac.sls.SLSAttributesType;

import cucumber.api.Scenario;
import db.DatabaseHandler;
import featuredefinition.GlobalHooks;
import featuredefinition.utils.SourceSystem;
import generic.GeneralTestConstants;
import generic.GeneralUtils;
import utils.data.jaxbhelper.EventHelper;

public class PayloadHandler {
    private Document doc;
    private Map<String, String> dbDetails;
    private String eventProcessStatusType = "";
    private Map<String, Properties> propertiesMap;

    public PayloadHandler() {
        dbDetails = GeneralUtils.loadDbDetails(GlobalHooks.getProperties());
        propertiesMap = new HashMap<>();
    }

    public Document getDoc() {
        return doc;
    }

    public Properties getProperties(String messageId) {
        return propertiesMap.get(messageId);
    }

    public void loadProperties(String slsId, String sourceSystem, String messageId, SLSAttributesType slsAttributesType)
            throws IOException {
        Properties properties = PropertiesUtils.loadPropertiesFile();
        GlobalHooks.getScenario().write("Message Identifier -> " + messageId);
        PropertiesUtils.modifyUniqueValuesForPayload(slsId, sourceSystem, messageId, properties);
        if (SourceSystem.contains(sourceSystem)) {
            PropertiesUtils.setSLSKeysForPayload(properties, slsAttributesType);
        } else {
            PropertiesUtils.setLCAEPayloadSLSKeys(properties, slsAttributesType);
        }
        propertiesMap.put(messageId, properties);
    }

    public Events submitPayload(Scenario scenario, String messageId) throws Exception {
        Events eventObj = EventHelper.getEvent(propertiesMap.get(messageId));
        EventNotification en = new EventNotification();
        String event = EventUtils.createEventXML(eventObj);
        Events evntRet = en.notifyEvent(event);
        sendBAMMessage(evntRet);
        printPayload(scenario, eventObj);
        return eventObj;
    }

    public void printPayload(Scenario scenario, Events eventObj) throws JAXBException {
        StringWriter sw = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(Events.class);
        Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(eventObj, sw);
        String xmlNew = sw.toString();
        xmlNew = xmlNew.replace("<", "&lt;");
        xmlNew = xmlNew.replace(">", "&gt;");
        scenario.write(xmlNew);
    }

    private void sendBAMMessage(Events notifyEvent) throws Exception {
        UniformDataMovementControlEvent bamEvent = createUDMCEvent(notifyEvent);
        UdmcEventNotification en = new UdmcEventNotification();
        en.notifyEvent(bamEvent);
    }

    private UniformDataMovementControlEvent createUDMCEvent(Events event) {
        UniformDataMovementControlEvent e = new UniformDataMovementControlEvent();
        e.setMessageID(event.getEventMetaData().getMessageIdentifier());
        e.setEventType(EventTypeEnumerated.TECHNICAL);
        e.setMessageActionType(MessageActionTypeEnumerated.INSERT);
        // EventMetaData
        e.setEventCount(event.getEventMetaData().getEventCount());
        e.setSenderName(event.getEventMetaData().getProducerName());
        e.setSenderClassification(SenderClassificationEnumerated.SOURCE);
        e.setEventName(event.getEventMetaData().getEventName());
        e.setMessageTimeStamp(event.getEventMetaData().getMessageTimestamp());
        e.setCorrelationID(event.getEventMetaData().getCorrelationIdentifier());
        EventsType bamEventsType = new EventsType();
        List<EventContainerType> containers = event.getEventPayload().getEventContainer();
        Iterator<EventContainerType> itContainers = containers.iterator();
        while (itContainers.hasNext()) {
            EventType bEventType = new EventType();
            EventContainerType type = itContainers.next();
            bEventType.setCorrelationID(event.getEventMetaData().getCorrelationIdentifier());
            bEventType.setEventID(type.getEventIdentifier());
            bEventType.setEntityID(type.getBusinessContext().getEntityIdentifier());
            bEventType.setEntityType(type.getBusinessContext().getEntityType());
            bEventType.setRelatedEventID(type.getBusinessContext().getRelatedEventIdentifier());
            bamEventsType.getEvent().add(bEventType);
        }
        e.setEvents(bamEventsType);
        return e;
    }

    public void validateMessageProcessed(String slsid, String status, String messageId)
            throws SQLException, ReflectiveOperationException {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Connection dbConnection = null;
        try {
            dbConnection = databaseHandler.getDBConnection(dbDetails);
            boolean eventTable = doesMessageExistInEventTables(dbConnection, messageId, status);
            for (int index = 0; !eventTable && index < GeneralTestConstants.PML_CONSUME_WAIT_SECONDS; index++) {
                GeneralUtils.sleep(400);
                eventTable = doesMessageExistInEventTables(dbConnection, messageId, status);
            }
            boolean businessTable = doesMessageExistInBusinessTables(dbConnection, messageId, slsid);
            for (int index = 0; !businessTable && index < GeneralTestConstants.PML_CONSUME_WAIT_SECONDS; index++) {
                GeneralUtils.sleep(400);
                businessTable = doesMessageExistInBusinessTables(dbConnection, messageId, slsid);
            }
            Assert.assertTrue("Message does not exist in event tables with message id -> " + messageId, eventTable);
            if (!eventProcessStatusType.toLowerCase().equals("persist_error")) {
                Assert.assertTrue("Message does not exist in business tables with message id -> " + messageId
                        + " and slsid -> " + slsid, businessTable);
            }
        } finally {
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private boolean doesMessageExistInEventTables(Connection dbConnection, String messageId, String status)
            throws SQLException {
        if (checkIfResults(dbConnection, "SELECT * FROM EVNT_MSG where ID_EVNT_MSG_UNVRSL_UNIQ = ?", messageId)) {
            eventProcessStatusType = getEventProcessStatusType(dbConnection, messageId);
            Assert.assertTrue(
                    "Message status = " + eventProcessStatusType.toUpperCase() + ", expected: " + status.toUpperCase(),
                    eventProcessStatusType.equalsIgnoreCase(status));
            return true;
        } else {
            return false;
        }
    }

    private String getEventProcessStatusType(Connection dbConnection, String messageId) throws SQLException {
        String status = "";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = dbConnection.prepareStatement(
                    "select * from evnt_procss_sts where id_evnt in(select id_evnt from evnt where id_evnt_msg_unvrsl_uniq in (?))");
            statement.setString(1, messageId);
            resultSet = null;
            do {
                // Waiting two second before each check to verify if message has
                // completely processed. Status will be "INITIATED" while
                // processing
                // until it reaches a "PROCESSED" or "PERSIST_ERROR" status
                GeneralUtils.sleep(400);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    status = resultSet.getString("NAME_EVNT_PROCSS_STS_TYPE");
                }
            } while (status.equals("INITIATED") || status.equals(""));
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return status;
    }

    private boolean doesMessageExistInBusinessTables(Connection dbConnection, String messageId, String slsid)
            throws SQLException {
        boolean doesExistFlag = false;
        if (checkIfResults(dbConnection,
                "select * from pml_submn_bch where id_evnt in(select id_evnt from evnt where id_evnt_msg_unvrsl_uniq in (?))",
                messageId)
                && checkIfResults(dbConnection,
                        "select * from pml_submn_trans where id_evnt in(select id_evnt from evnt where id_evnt_msg_unvrsl_uniq in (?))",
                        messageId)) {
            doesExistFlag = checkIfResults(dbConnection, "select * from pml_submn_link where id_pml_submn_link in (?)",
                    slsid);
        }
        return doesExistFlag;
    }

    private boolean checkIfResults(Connection dbConnection, String sqlQuery, String messageId) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement(sqlQuery);
        statement.setString(1, messageId);
        ResultSet resultSet;
        int tries = 0;
        boolean doesExistFlag = false;
        do {
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                doesExistFlag = true;
                break;
            }
            tries++;
            GeneralUtils.sleep(400);
        } while (GeneralTestConstants.PML_CONSUME_WAIT_SECONDS >= tries);
        resultSet.close();
        statement.close();
        return doesExistFlag;
    }
}
