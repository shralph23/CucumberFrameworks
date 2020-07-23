package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionPartyLicenseContainer;
import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionPartyLicenseContainers;

public class PrimaryMarketLoanSubmissionPartyLicenseContainersHelper {

    public static PrimaryMarketLoanSubmissionPartyLicenseContainers getPrimaryMarketLoanSubmissionPartyLicenseContainers(
            Properties properties) {
        PrimaryMarketLoanSubmissionPartyLicenseContainers primaryMarketLoanSubmissionPartyLicenseContainers = new PrimaryMarketLoanSubmissionPartyLicenseContainers();
        List<PrimaryMarketLoanSubmissionPartyLicenseContainer> primaryMarketLoanSubmissionPartyLicenseContainersList = primaryMarketLoanSubmissionPartyLicenseContainers
                .getPrimaryMarketLoanSubmissionPartyLicenseContainer();
        PrimaryMarketLoanSubmissionPartyLicenseContainer primaryMarketLoanSubmissionPartyLicenseContainer = PrimaryMarketLoanSubmissionPartyLicenseContainerHelper
                .getPrimaryMarketLoanSubmissionPartyLicenseContainer(properties);
        primaryMarketLoanSubmissionPartyLicenseContainersList.add(primaryMarketLoanSubmissionPartyLicenseContainer);
        return primaryMarketLoanSubmissionPartyLicenseContainers;
    }
}
