package utils.data.jaxbhelper;

import java.util.Properties;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;

import com.freddiemac.service.event.model.EventContainerType;

public class EventContainerTypeHelper {

    private static final String EVENT_IDENTIFIER_KEY = "EVENT_IDENTIFIER";

    public static EventContainerType getEventContainerType(Properties properties)
            throws DatatypeConfigurationException, JAXBException, ParserConfigurationException {
        EventContainerType eventContainerType = new EventContainerType();
        eventContainerType.setBusinessContext(BusinessContextTypeHelper.getBusinessContextType(properties));
        eventContainerType.setBusinessData(BusinessDataTypeHelper.getBusinessDataType(properties));
        eventContainerType.setEventIdentifier(properties.getProperty(EVENT_IDENTIFIER_KEY));
        return eventContainerType;
    }

}
