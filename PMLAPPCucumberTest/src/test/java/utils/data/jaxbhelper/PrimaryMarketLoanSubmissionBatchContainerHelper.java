package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionBatchContainer;

public class PrimaryMarketLoanSubmissionBatchContainerHelper {

    public static PrimaryMarketLoanSubmissionBatchContainer getPrimaryMarketLoanSubmissionBatchContainer(
            Properties properties) {
        PrimaryMarketLoanSubmissionBatchContainer primaryMarketLoanSubmissionBatchContainer = new PrimaryMarketLoanSubmissionBatchContainer();
        primaryMarketLoanSubmissionBatchContainer
                .setLoanSubmissionBatch(LoanSubmissionBatchHelper.getLoanSubmissionBatch(properties));
        primaryMarketLoanSubmissionBatchContainer.setPrimaryMarketLoanSubmissionTransactionContainer(
                PrimaryMarketLoanSubmissionTransactionContainerHelper
                        .getPrimaryMarketLoanSubmissionTransactionContainer(properties));
        primaryMarketLoanSubmissionBatchContainer.setSellerAccount(SellerAccountHelper.getSellerAccount(properties));
        primaryMarketLoanSubmissionBatchContainer.setSellerUser(SellerUserHelper.getSellerUser(properties));
        return primaryMarketLoanSubmissionBatchContainer;
    }
}
