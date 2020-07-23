package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionDocumentDetailContainer;

public class PrimaryMarketLoanSubmissionDocumentDetailContainerHelper {

    public static PrimaryMarketLoanSubmissionDocumentDetailContainer getPrimaryMarketLoanSubmissionDocumentDetailContainer(
            Properties properties) {
        PrimaryMarketLoanSubmissionDocumentDetailContainer primaryMarketLoanSubmissionDocumentDetailContainer = new PrimaryMarketLoanSubmissionDocumentDetailContainer();
        primaryMarketLoanSubmissionDocumentDetailContainer.setDocument(DocumentHelper.getDocument(properties));
        primaryMarketLoanSubmissionDocumentDetailContainer
                .setDocumentStatus(DocumentStatusHelper.getDocumentStatus(properties));
        return primaryMarketLoanSubmissionDocumentDetailContainer;
    }
}
