package featuredefinition.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionBatchContainer;
import com.freddiemac.service.event.model.Events;
import com.freddiemac.sls.SLSAttributesType;
import com.freddiemac.sls.SLSRequestType;
import com.freddiemac.sls.SLSResponseType;

import datageneration.sls.SlsScenario;
import featuredefinition.GlobalHooks;
import generic.GeneralTestConstants;
import reports.MessageFormatter;
import utils.data.validation.PayloadValidation;
import utils.datageneration.payloads.PayloadHandler;
import utils.datageneration.payloads.PropertiesUtils;
import utils.db.PmlTestDao;
import utils.ddlvalidation.DDLValidation;
import webservice.RequestData;
import webservice.WebServiceFunctions;

public class StepsUtils {
    private PayloadHandler payloadHandler;
    private DDLValidation dDLValidation;
    private static final Logger logger = Logger.getLogger(StepsUtils.class);

    public StepsUtils() {
        payloadHandler = new PayloadHandler();
        dDLValidation = new DDLValidation();
    }

    public void setPmlAppRequest(String sourceSystem, String slsId, String messageId, SLSRequestType slsRequestType)
            throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {
        SLSAttributesType slsAttributesType = slsRequestType.getSLSInputRequests().getSLSInputRequest().get(0)
                .getSLSAttributes();
        payloadHandler.loadProperties(slsId, sourceSystem, messageId, slsAttributesType);
    }

    public void modifyPropertiesFile(String messageId, String attributeTag, String attributeValue) throws IOException {
        Properties properties = payloadHandler.getProperties(messageId);
        PropertiesUtils.modifyPropertiesfile(properties, attributeTag, attributeValue);
    }

    public void removeContainerFromPayload(String messageId, String containerName) {
        Properties properties = payloadHandler.getProperties(messageId);
        PropertiesUtils.setContainerToBeRemoved(properties, containerName);
    }

    public Events sendRequestToPmlApp(String messageId) throws Exception {
        return payloadHandler.submitPayload(GlobalHooks.getScenario(), messageId);
    }

    public void validatePmlWithDb(String slsId, String status, String messageId)
            throws SQLException, ReflectiveOperationException {
        payloadHandler.validateMessageProcessed(slsId, status, messageId);
    }

    @SuppressWarnings("unchecked")
    public void validateDBInfo(String slsId, String eventStatus, String sourceSystem, PmlTestDao dao, Events payload)
            throws XPathExpressionException, SQLException, ReflectiveOperationException, JAXBException {
        logger.debug("Started validating the DB values that was persisted");
        if (eventStatus.toLowerCase().equals("persist_error")) {
            logger.error("Persist error received for sourceSystem : " + sourceSystem);
            GlobalHooks.getScenario().write("No validation required - persist error");
            return;
        }
        // creating the JAXB context
        JAXBElement<PrimaryMarketLoanSubmissionBatchContainer> pmlBatchContainer = null;
        JAXBContext jContext = JAXBContext.newInstance(com.freddiemac.datamanager.jaxb.ObjectFactory.class);
        // creating the unmarshall object
        Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
        Element element = payload.getEventPayload().getEventContainer().get(0).getBusinessData().getAny().get(0);
        pmlBatchContainer = (JAXBElement<PrimaryMarketLoanSubmissionBatchContainer>) unmarshallerObj.unmarshal(element);

        if (sourceSystem.equals("LCLA")) {
            PayloadValidation.validateLCLA(slsId, dao, pmlBatchContainer);
        } else if (sourceSystem.equals("LQA")) {
            PayloadValidation.validateLQA(slsId, dao, pmlBatchContainer);
        } else if (sourceSystem.equals("LCAE")) {
            PayloadValidation.validateLCAE(slsId, dao, pmlBatchContainer);
        } else if (sourceSystem.equals("LPA")) {
            PayloadValidation.validateLPA(slsId, dao, pmlBatchContainer);
        }
    }

    public boolean setDDLInfo(String tableName, String currentSchema) {
        if (tableName == null || tableName.isEmpty() || currentSchema == null || currentSchema.isEmpty()) {
            return false;
        }
        dDLValidation.setTableName(tableName);
        dDLValidation.setCurrentSchema(currentSchema);
        return true;
    }

    public boolean validateDDLInfo(String dataType, String nullable, String columnName, List<String> constraints)
            throws SQLException, ReflectiveOperationException {
        return dDLValidation.validateDDLInfo(dataType, nullable, columnName, constraints);
    }

    public Map.Entry<String, SLSRequestType> sendRequestToSLSService() throws SOAPException, JAXBException,
            ParserConfigurationException, DatatypeConfigurationException, IOException, ClassNotFoundException,
            InstantiationException, IllegalAccessException, ClassCastException, SAXException, URISyntaxException {

        WebServiceFunctions serviceMethods = new WebServiceFunctions();
        SlsScenario slsScenario = new SlsScenario(-1, -1, true);
        SLSRequestType slsRequest = slsScenario.generateSLSRequestType();
        String url = GlobalHooks.getProperties().getProperty(GeneralTestConstants.SLS_WEBSERVICE_URL);
        // SOAP call
        SOAPMessage soapMessage = serviceMethods.createSOAPRequest(setUpRequestData(slsRequest));
        GlobalHooks.getScenario().write(MessageFormatter.formatSoapMessage(soapMessage));
        soapMessage = serviceMethods.sendSOAPRequest(soapMessage, url);
        GlobalHooks.getScenario().write(MessageFormatter.formatSoapMessage(soapMessage));
        SLSResponseType response = (SLSResponseType) serviceMethods.unmarshallSoapObject(soapMessage,
                SLSResponseType.class);
        String slsId = response.getSLSOutputResponses().getSLSOuputResponse().get(0)
                .getSubmissionLinkServiceIdentifier();
        Map.Entry<String, SLSRequestType> entry = new AbstractMap.SimpleEntry<String, SLSRequestType>(slsId,
                slsRequest);

        return entry;
    }

    private RequestData setUpRequestData(SLSRequestType slsRequest) {
        String url = GlobalHooks.getProperties().getProperty(GeneralTestConstants.SLS_WEBSERVICE_URL);
        String username = GlobalHooks.getProperties().getProperty(GeneralTestConstants.SLS_WEBSERVICE_USER);
        String password = GlobalHooks.getProperties().getProperty(GeneralTestConstants.SLS_WEBSERVICE_PWD);
        return new RequestData(url, username, password, slsRequest, slsRequest.getClass(), SLSResponseType.class);
    }
}
