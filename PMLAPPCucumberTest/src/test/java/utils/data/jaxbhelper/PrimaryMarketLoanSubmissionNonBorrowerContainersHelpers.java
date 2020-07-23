package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionNonBorrowerContainer;
import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionNonBorrowerContainers;

public class PrimaryMarketLoanSubmissionNonBorrowerContainersHelpers {

    public static PrimaryMarketLoanSubmissionNonBorrowerContainers getPrimaryMarketLoanSubmissionNonBorrowerContainers(
            Properties properties) {
        PrimaryMarketLoanSubmissionNonBorrowerContainers primaryMarketLoanSubmissionNonBorrowerContainers = new PrimaryMarketLoanSubmissionNonBorrowerContainers();
        List<PrimaryMarketLoanSubmissionNonBorrowerContainer> primaryMarketLoanSubmissionNonBorrowerContainersList = primaryMarketLoanSubmissionNonBorrowerContainers
                .getPrimaryMarketLoanSubmissionNonBorrowerContainer();
        PrimaryMarketLoanSubmissionNonBorrowerContainer primaryMarketLoanSubmissionNonBorrowerContainer = PrimaryMarketLoanSubmissionNonBorrowerContainerHelper
                .getPrimaryMarketLoanSubmissionNonBorrowerContainer(properties);
        primaryMarketLoanSubmissionNonBorrowerContainersList.add(primaryMarketLoanSubmissionNonBorrowerContainer);
        return primaryMarketLoanSubmissionNonBorrowerContainers;
    }
}
