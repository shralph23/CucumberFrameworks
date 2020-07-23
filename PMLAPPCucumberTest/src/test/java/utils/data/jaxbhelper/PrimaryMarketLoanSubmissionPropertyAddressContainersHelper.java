package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionPropertyAddressContainer;
import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionPropertyAddressContainers;

import utils.datageneration.payloads.PropertiesUtils;
import utils.generic.TestConstants;

public class PrimaryMarketLoanSubmissionPropertyAddressContainersHelper {

    public static PrimaryMarketLoanSubmissionPropertyAddressContainers getPrimaryMarketLoanSubmissionPropertyAddressContainers(
            Properties properties) {
        PrimaryMarketLoanSubmissionPropertyAddressContainers primaryMarketLoanSubmissionPropertyAddressContainers = new PrimaryMarketLoanSubmissionPropertyAddressContainers();
        List<PrimaryMarketLoanSubmissionPropertyAddressContainer> primaryMarketLoanSubmissionPropertyAddressContainerList = primaryMarketLoanSubmissionPropertyAddressContainers
                .getPrimaryMarketLoanSubmissionPropertyAddressContainer();
        if (!PropertiesUtils.getContainerToBeRemoved(properties)
                .equals(TestConstants.PRIMARY_MARKET_LOAN_SUBMISSION_PROPERTY_ADDRESS_CONTAINERS)) {
            PrimaryMarketLoanSubmissionPropertyAddressContainer primaryMarketLoanSubmissionPropertyAddressContainer = PrimaryMarketLoanSubmissionPropertyAddressContainerHelper
                    .getprimaryMarketLoanSubmissionPropertyAddressContainer(properties);
            primaryMarketLoanSubmissionPropertyAddressContainerList
                    .add(primaryMarketLoanSubmissionPropertyAddressContainer);
        }
        return primaryMarketLoanSubmissionPropertyAddressContainers;
    }

}
