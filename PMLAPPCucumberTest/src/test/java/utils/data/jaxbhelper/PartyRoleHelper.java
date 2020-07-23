package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PartyRole;

import utils.datageneration.payloads.PropertiesUtils;
import utils.generic.TestConstants;

public class PartyRoleHelper {

    private static final String PARTY_ROLE_TYPE_DESCRIPTION_KEY = "PARTY_ROLE_TYPE_DESCRIPTION";
    private static final String PARTY_ROLE_TYPE_KEY = "PARTY_ROLE_TYPE";
    private static final String PARTY_ROLE_IDENTIFIER_KEY = "PARTY_ROLE_IDENTIFIER";
    private static final String PARTY_IDENTIFIER_KEY = "PARTY_IDENTIFIER";

    public static PartyRole getPartyRole(Properties properties) {
        PartyRole partyRole = new PartyRole();
        if (!PropertiesUtils.getContainerToBeRemoved(properties).equals(TestConstants.PARTY_ROLE)) {
            partyRole.setPartyIdentifier(PropertiesUtils.getStringValue(properties, PARTY_IDENTIFIER_KEY));
            partyRole.setPartyRoleIdentifier(properties.getProperty(PARTY_ROLE_IDENTIFIER_KEY));
            partyRole.setPartyRoleType(PropertiesUtils.getStringValue(properties, PARTY_ROLE_TYPE_KEY));
            partyRole.setPartyRoleTypeDescription(properties.getProperty(PARTY_ROLE_TYPE_DESCRIPTION_KEY));
        }
        return partyRole;
    }
}
