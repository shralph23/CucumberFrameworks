package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionPartyRoleContainer;

import utils.datageneration.payloads.PropertiesUtils;
import utils.generic.TestConstants;

public class PrimaryMarketLoanSubmissionPartyRoleContainerHelper {

    public static PrimaryMarketLoanSubmissionPartyRoleContainer getPrimaryMarketLoanSubmissionPartyRoleContainer(
            Properties properties) {
        PrimaryMarketLoanSubmissionPartyRoleContainer primaryMarketLoanSubmissionPartyRoleContainer = new PrimaryMarketLoanSubmissionPartyRoleContainer();
        if (!PropertiesUtils.getContainerToBeRemoved(properties)
                .equals(TestConstants.PRIMARY_MARKET_LOAN_SUBMISSION_PARTY_ROLE_CONTAINER)) {
            primaryMarketLoanSubmissionPartyRoleContainer.setPartyRole(PartyRoleHelper.getPartyRole(properties));
            primaryMarketLoanSubmissionPartyRoleContainer.setPrimaryMarketLoanSubmissionPartyLicenseContainers(
                    PrimaryMarketLoanSubmissionPartyLicenseContainersHelper
                            .getPrimaryMarketLoanSubmissionPartyLicenseContainers(properties));
        }
        return primaryMarketLoanSubmissionPartyRoleContainer;
    }

}
