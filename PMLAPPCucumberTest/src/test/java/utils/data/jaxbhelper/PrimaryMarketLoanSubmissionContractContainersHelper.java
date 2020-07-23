package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionContractContainer;
import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionContractContainers;

import utils.datageneration.payloads.PropertiesUtils;
import utils.generic.TestConstants;

public class PrimaryMarketLoanSubmissionContractContainersHelper {

    public static PrimaryMarketLoanSubmissionContractContainers getPrimaryMarketLoanSubmissionContractContainers(
            Properties properties) {
        PrimaryMarketLoanSubmissionContractContainers primaryMarketLoanSubmissionContractContainers = new PrimaryMarketLoanSubmissionContractContainers();
        List<PrimaryMarketLoanSubmissionContractContainer> primaryMarketLoanSubmissionContractContainersList = primaryMarketLoanSubmissionContractContainers
                .getPrimaryMarketLoanSubmissionContractContainer();
        if (!PropertiesUtils.getContainerToBeRemoved(properties)
                .equals(TestConstants.PRIMARY_MARKET_LOAN_SUBMISSION_CONTRACT_CONTAINER)) {
            PrimaryMarketLoanSubmissionContractContainer primaryMarketLoanSubmissionContractContainer = PrimaryMarketLoanSubmissionContractContainerHelper
                    .getPrimaryMarketLoanSubmissionContractContainer(properties);
            if (!PropertiesUtils.getContainerToBeRemoved(properties).equals(TestConstants.LOAN_PURCHASE_CONTRACT)) {
            primaryMarketLoanSubmissionContractContainersList.add(primaryMarketLoanSubmissionContractContainer);
        }
        }
        return primaryMarketLoanSubmissionContractContainers;
    }

}
