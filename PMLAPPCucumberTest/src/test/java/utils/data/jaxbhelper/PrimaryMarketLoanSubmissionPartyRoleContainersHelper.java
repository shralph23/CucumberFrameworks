package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionPartyRoleContainer;
import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionPartyRoleContainers;

import utils.datageneration.payloads.PropertiesUtils;
import utils.generic.TestConstants;

public class PrimaryMarketLoanSubmissionPartyRoleContainersHelper {

    public static PrimaryMarketLoanSubmissionPartyRoleContainers getPrimaryMarketLoanSubmissionPartyRoleContainers(
            Properties properties) {
        PrimaryMarketLoanSubmissionPartyRoleContainers primaryMarketLoanSubmissionPartyRoleContainers = new PrimaryMarketLoanSubmissionPartyRoleContainers();
        List<PrimaryMarketLoanSubmissionPartyRoleContainer> primaryMarketLoanSubmissionPartyRoleContainersList = primaryMarketLoanSubmissionPartyRoleContainers
                .getPrimaryMarketLoanSubmissionPartyRoleContainer();
        PrimaryMarketLoanSubmissionPartyRoleContainer primaryMarketLoanSubmissionPartyRoleContainer = PrimaryMarketLoanSubmissionPartyRoleContainerHelper
                .getPrimaryMarketLoanSubmissionPartyRoleContainer(properties);
        if (!PropertiesUtils.getContainerToBeRemoved(properties)
                .equals(TestConstants.PRIMARY_MARKET_LOAN_SUBMISSION_PARTY_ROLE_CONTAINERS)) {
            primaryMarketLoanSubmissionPartyRoleContainersList.add(primaryMarketLoanSubmissionPartyRoleContainer);
        }
        return primaryMarketLoanSubmissionPartyRoleContainers;
    }

}
