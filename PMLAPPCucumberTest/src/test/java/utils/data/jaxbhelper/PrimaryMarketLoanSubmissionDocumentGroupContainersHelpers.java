package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionDocumentGroupContainer;
import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionDocumentGroupContainers;

import utils.datageneration.payloads.PropertiesUtils;
import utils.generic.TestConstants;

public class PrimaryMarketLoanSubmissionDocumentGroupContainersHelpers {

    public static PrimaryMarketLoanSubmissionDocumentGroupContainers getPrimaryMarketLoanSubmissionDocumentGroupContainers(
            Properties properties) {
        PrimaryMarketLoanSubmissionDocumentGroupContainers primaryMarketLoanSubmissionDocumentGroupContainers = new PrimaryMarketLoanSubmissionDocumentGroupContainers();
        List<PrimaryMarketLoanSubmissionDocumentGroupContainer> primaryMarketLoanSubmissionDocumentGroupContainersList = primaryMarketLoanSubmissionDocumentGroupContainers
                .getPrimaryMarketLoanSubmissionDocumentGroupContainer();
        if (!PropertiesUtils.getContainerToBeRemoved(properties)
                .equals(TestConstants.PRIMARY_MARKET_LOAN_SUBMISSION_DOCUMENT_GROUP_CONTAINERS)) {
            PrimaryMarketLoanSubmissionDocumentGroupContainer primaryMarketLoanSubmissionDocumentGroupContainer = PrimaryMarketLoanSubmissionDocumentGroupContainerHelper
                    .getPrimaryMarketLoanSubmissionDocumentGroupContainer(properties);
            if (!PropertiesUtils.getContainerToBeRemoved(properties)
                    .equals(TestConstants.PRIMARY_MARKET_LOAN_SUBMISSION_DOCUMENT_GROUP_CONTAINER)) {
            primaryMarketLoanSubmissionDocumentGroupContainersList
                    .add(primaryMarketLoanSubmissionDocumentGroupContainer);
            }
        }
        return primaryMarketLoanSubmissionDocumentGroupContainers;
    }

}
