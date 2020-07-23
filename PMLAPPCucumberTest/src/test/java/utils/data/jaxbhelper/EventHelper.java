package utils.data.jaxbhelper;

import java.util.Properties;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;

import com.freddiemac.service.event.model.Events;

/**
 * This class is the root element and all the other containers are set inside this. We use the event-schema-jar for
 * interacting with the respective classes for setting up event container details.
 *
 */

public class EventHelper {

    public static Events getEvent(Properties properties)
            throws DatatypeConfigurationException, JAXBException, ParserConfigurationException {
        Events event = new Events();
        event.setEventMetaData(EventMetaDataHelper.getEventMetaData(properties));
        event.setEventPayload(EventPayloadTypeHelper.getEventPayloadType(properties));
        return event;
    }
}
