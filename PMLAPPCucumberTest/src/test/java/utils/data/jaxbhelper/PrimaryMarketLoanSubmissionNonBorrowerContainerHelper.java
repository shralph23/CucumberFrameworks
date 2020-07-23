package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionNonBorrowerContainer;

public class PrimaryMarketLoanSubmissionNonBorrowerContainerHelper {

    public static PrimaryMarketLoanSubmissionNonBorrowerContainer getPrimaryMarketLoanSubmissionNonBorrowerContainer(
            Properties properties) {
        PrimaryMarketLoanSubmissionNonBorrowerContainer primaryMarketLoanSubmissionNonBorrowerContainer = new PrimaryMarketLoanSubmissionNonBorrowerContainer();
        primaryMarketLoanSubmissionNonBorrowerContainer
                .setIndividualName(IndividualNameHelper.getIndividualName(properties));
        primaryMarketLoanSubmissionNonBorrowerContainer.setPartyRole(PartyRoleHelper.getPartyRole(properties));
        return primaryMarketLoanSubmissionNonBorrowerContainer;
    }
}
