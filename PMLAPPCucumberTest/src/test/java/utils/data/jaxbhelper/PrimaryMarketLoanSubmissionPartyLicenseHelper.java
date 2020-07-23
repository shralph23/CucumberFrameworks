package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionPartyLicense;

public class PrimaryMarketLoanSubmissionPartyLicenseHelper {

    private static final String LICENSE_IDENTIFIER_KEY = "LICENSE_IDENTIFIER";
    private static final String LICENSE_AUTHORITY_LEVEL_TYPE_KEY = "LICENSE_AUTHORITY_LEVEL_TYPE";
    private static final String LICENSE_ISSUER_IDENTIFIER_KEY = "LICENSE_ISSUER_IDENTIFIER";
    private static final String LICENSE_TYPE_KEY = "LICENSE_TYPE";

    public static PrimaryMarketLoanSubmissionPartyLicense getPrimaryMarketLoanSubmissionPartyLicense(
            Properties properties) {
        PrimaryMarketLoanSubmissionPartyLicense primaryMarketLoanSubmissionPartyLicense = new PrimaryMarketLoanSubmissionPartyLicense();
        primaryMarketLoanSubmissionPartyLicense.setLicenseIdentifier(properties.getProperty(LICENSE_IDENTIFIER_KEY));
        primaryMarketLoanSubmissionPartyLicense
                .setLicenseAuthorityLevelType(properties.getProperty(LICENSE_AUTHORITY_LEVEL_TYPE_KEY));
        primaryMarketLoanSubmissionPartyLicense
                .setLicenseIssuerIdentifier(properties.getProperty(LICENSE_ISSUER_IDENTIFIER_KEY));
        primaryMarketLoanSubmissionPartyLicense.setLicenseType(properties.getProperty(LICENSE_TYPE_KEY));
        return primaryMarketLoanSubmissionPartyLicense;
    }
}
