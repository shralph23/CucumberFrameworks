package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;

import com.freddiemac.service.event.model.EventContainerType;
import com.freddiemac.service.event.model.EventPayloadType;

public class EventPayloadTypeHelper {

    public static EventPayloadType getEventPayloadType(Properties properties)
            throws DatatypeConfigurationException, JAXBException, ParserConfigurationException {
        EventPayloadType eventPayloadType = new EventPayloadType();
        List<EventContainerType> eventConatinerTypeList = eventPayloadType.getEventContainer();
        EventContainerType eventContainerType = EventContainerTypeHelper.getEventContainerType(properties);
        eventConatinerTypeList.add(eventContainerType);
        return eventPayloadType;
    }
}
