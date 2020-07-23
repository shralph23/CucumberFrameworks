package utils.data.jaxbhelper;

import java.util.Properties;

import javax.xml.datatype.DatatypeConfigurationException;

import com.freddiemac.service.event.model.BusinessContextType;
import com.freddiemac.service.event.model.RequestActionTypeEnumerated;

import datageneration.generic.DataGeneratorUtils;

public class BusinessContextTypeHelper {

    private static final String PRODUCT_TYPE_KEY = "PRODUCT_TYPE";
    private static final String ENTITY_TYPE_KEY = "ENTITY_TYPE";
    private static final String ENTITY_IDENTIFIER_KEY = "ENTITY_IDENTIFIER";

    public static BusinessContextType getBusinessContextType(Properties properties)
            throws DatatypeConfigurationException {
        BusinessContextType businessContextType = new BusinessContextType();
        businessContextType.setBusinessEventTimestamp(DataGeneratorUtils.getXMLGregorianCalendarNow());
        businessContextType.setEntityIdentifier(properties.getProperty(ENTITY_IDENTIFIER_KEY));
        businessContextType.setEntityType(properties.getProperty(ENTITY_TYPE_KEY));
        businessContextType.setProductType(properties.getProperty(PRODUCT_TYPE_KEY));
        businessContextType.setRequestActionType(RequestActionTypeEnumerated.NEW);
        return businessContextType;
    }

}
