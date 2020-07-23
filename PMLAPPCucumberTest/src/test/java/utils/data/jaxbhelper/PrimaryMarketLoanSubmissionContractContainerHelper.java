package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionContractContainer;

public class PrimaryMarketLoanSubmissionContractContainerHelper {

	public static PrimaryMarketLoanSubmissionContractContainer getPrimaryMarketLoanSubmissionContractContainer(
			Properties properties) {
		PrimaryMarketLoanSubmissionContractContainer primaryMarketLoanSubmissionContractContainer = new PrimaryMarketLoanSubmissionContractContainer();
		primaryMarketLoanSubmissionContractContainer
				.setLoanPurchaseContract(LoanPurchaseContractHelper.getLoanPurchaseContract(properties));
		return primaryMarketLoanSubmissionContractContainer;
	}
}
