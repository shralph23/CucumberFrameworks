package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.Address;

import utils.datageneration.payloads.PropertiesUtils;

public class AddressHelper {

    private static final String ADDRESS_IDENTIFIER_KEY = "ADDRESS_IDENTIFIER";
    private static final String ADDRESS_LINE_TEXT_KEY = "ADDRESS_LINE_TEXT";
    private static final String ADDRESS_UNIT_DESIGNATOR_TYPE_KEY = "ADDRESS_UNIT_DESIGNATOR_TYPE";
    private static final String ADDRESS_SOURCE_TYPE_KEY = "ADDRESS_SOURCE_TYPE";
    private static final String CITYNAME_KEY = "CITYNAME";
    private static final String STATE_CODE_KEY = "STATE_CODE";
    private static final String POSTAL_CODE_KEY = "POSTAL_CODE";
    private static final String ADDRESS_UNIT_IDENTIFIER_KEY = "ADDRESS_UNIT_IDENTIFIER";
    private static final String ZIP_PLUS_FOUR_CODE_KEY = "ZIP_PLUS_FOUR_CODE";

    public static Address getAddress(Properties properties) {
        Address address = new Address();
        address.setAddressIdentifier(PropertiesUtils.getBigIntegerValue(properties, ADDRESS_IDENTIFIER_KEY));
        address.setAddressLineText(PropertiesUtils.getStringValue(properties, ADDRESS_LINE_TEXT_KEY));
        address.setAddressUnitDesignatorType(properties.getProperty(ADDRESS_UNIT_DESIGNATOR_TYPE_KEY));
        address.setAddressSourceType(PropertiesUtils.getStringValue(properties, ADDRESS_SOURCE_TYPE_KEY));
        address.setCityName(PropertiesUtils.getStringValue(properties, CITYNAME_KEY));
        address.setStateCode(PropertiesUtils.getStringValue(properties, STATE_CODE_KEY));
        address.setPostalCode(PropertiesUtils.getStringValue(properties, POSTAL_CODE_KEY));
        address.setAddressUnitIdentifier(PropertiesUtils.getStringValue(properties, ADDRESS_UNIT_IDENTIFIER_KEY));
        address.setZIPPlusFourCode(PropertiesUtils.getStringValue(properties, ZIP_PLUS_FOUR_CODE_KEY));
        return address;

    }
}
