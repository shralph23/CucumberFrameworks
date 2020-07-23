package utils.data.jaxbhelper;

import java.math.BigInteger;
import java.util.Properties;

import javax.xml.datatype.DatatypeConfigurationException;

import com.freddiemac.service.event.model.EventClassificationEnumerated;
import com.freddiemac.service.event.model.EventMetaData;
import com.freddiemac.service.event.model.EventTypeEnumerated;

import datageneration.generic.DataGeneratorUtils;
import utils.datageneration.payloads.PropertiesUtils;

public class EventMetaDataHelper {

    private static final int EVENT_COUNT_KEY = 1;
    private static final String HASH_VALUE_KEY = "HASH_VALUE";
    private static final String CORRELATION_IDENTIFIER = "CORRELATION_IDENTIFIER";
    private static final String MESSAGE_IDENTIFIER_KEY = "MESSAGE_IDENTIFIER";
    private static final String EVENT_NAME_KEY = "EVENT_NAME";

    public static EventMetaData getEventMetaData(Properties properties) throws DatatypeConfigurationException {
        EventMetaData eventMetaData = new EventMetaData();
        eventMetaData.setEventName(properties.getProperty(EVENT_NAME_KEY));
        eventMetaData.setMessageIdentifier(properties.getProperty(MESSAGE_IDENTIFIER_KEY));
        eventMetaData.setEventType(EventTypeEnumerated.BUSINESS);
        eventMetaData.setCorrelationIdentifier(properties.getProperty(CORRELATION_IDENTIFIER));
        eventMetaData.setEventClassification(EventClassificationEnumerated.NOTIFICATION);
        eventMetaData.setProducerName(PropertiesUtils.getPayloadType(properties));
        eventMetaData.setMessageTimestamp(DataGeneratorUtils.getXMLGregorianCalendarNow());
        eventMetaData.setHashValue(properties.getProperty(HASH_VALUE_KEY));
        eventMetaData.setEventCount(BigInteger.valueOf(EVENT_COUNT_KEY));
        return eventMetaData;
    }
}
