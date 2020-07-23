package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionDocumentDetailContainer;
import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionDocumentDetailContainers;

public class PrimaryMarketLoanSubmissionDocumentDetailContainersHelper {

    public static PrimaryMarketLoanSubmissionDocumentDetailContainers getPrimaryMarketLoanSubmissionDocumentDetailContainers(
            Properties properties) {
        PrimaryMarketLoanSubmissionDocumentDetailContainers primaryMarketLoanSubmissionDocumentDetailContainers = new PrimaryMarketLoanSubmissionDocumentDetailContainers();
        List<PrimaryMarketLoanSubmissionDocumentDetailContainer> primaryMarketLoanSubmissionDocumentDetailContainerList = primaryMarketLoanSubmissionDocumentDetailContainers
                .getPrimaryMarketLoanSubmissionDocumentDetailContainer();
        PrimaryMarketLoanSubmissionDocumentDetailContainer primaryMarketLoanSubmissionDocumentDetailContainer = PrimaryMarketLoanSubmissionDocumentDetailContainerHelper
                .getPrimaryMarketLoanSubmissionDocumentDetailContainer(properties);
        primaryMarketLoanSubmissionDocumentDetailContainerList.add(primaryMarketLoanSubmissionDocumentDetailContainer);
        return primaryMarketLoanSubmissionDocumentDetailContainers;
    }

}
