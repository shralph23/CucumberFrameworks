package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionPartyLicenseContainer;

public class PrimaryMarketLoanSubmissionPartyLicenseContainerHelper {

    public static PrimaryMarketLoanSubmissionPartyLicenseContainer getPrimaryMarketLoanSubmissionPartyLicenseContainer(
            Properties properties) {
        PrimaryMarketLoanSubmissionPartyLicenseContainer primaryMarketLoanSubmissionPartyLicenseContainer = new PrimaryMarketLoanSubmissionPartyLicenseContainer();
        primaryMarketLoanSubmissionPartyLicenseContainer.setPrimaryMarketLoanSubmissionPartyLicense(
                PrimaryMarketLoanSubmissionPartyLicenseHelper.getPrimaryMarketLoanSubmissionPartyLicense(properties));
        return primaryMarketLoanSubmissionPartyLicenseContainer;
    }
}
