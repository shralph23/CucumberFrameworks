package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionDocumentGroupContainer;

public class PrimaryMarketLoanSubmissionDocumentGroupContainerHelper {

	public static PrimaryMarketLoanSubmissionDocumentGroupContainer getPrimaryMarketLoanSubmissionDocumentGroupContainer(
			Properties properties) {
		PrimaryMarketLoanSubmissionDocumentGroupContainer primaryMarketLoanSubmissionDocumentGroupContainer = new PrimaryMarketLoanSubmissionDocumentGroupContainer();
		primaryMarketLoanSubmissionDocumentGroupContainer.setPrimaryMarketLoanSubmissionDocumentDetailContainers(
				PrimaryMarketLoanSubmissionDocumentDetailContainersHelper
						.getPrimaryMarketLoanSubmissionDocumentDetailContainers(properties));
		primaryMarketLoanSubmissionDocumentGroupContainer
				.setDocumentGroup(DocumentGroupHelper.getDocumentGroup(properties));
		return primaryMarketLoanSubmissionDocumentGroupContainer;
	}
}
