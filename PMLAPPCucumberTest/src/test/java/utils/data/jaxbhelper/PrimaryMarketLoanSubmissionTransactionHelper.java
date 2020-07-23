package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransaction;

public class PrimaryMarketLoanSubmissionTransactionHelper {

    private static final String PRIMARY_MARKET_LOAN_SUBMISSION_LINK_IDENTIFIER_KEY = "PRIMARY_MARKET_LOAN_SUBMISSION_LINK_IDENTIFIER";
    private static final String PRIMARY_MARKET_LOAN_SOURCE_SUBMISSION_TRANSACTION_IDENTIFIER_KEY = "PRIMARY_MARKET_LOAN_SOURCE_SUBMISSION_TRANSACTION_IDENTIFIER";
    private static final String MORTGAGE_INSURANCE_REQUIRED_INDICATOR_KEY = "MORTGAGE_INSURANCE_REQUIRED_INDICATOR";

    public static PrimaryMarketLoanSubmissionTransaction getPrimaryMarketLoanSubmissionTransaction(
            Properties properties) {
        PrimaryMarketLoanSubmissionTransaction primaryMarketLoanSubmissionTransaction = new PrimaryMarketLoanSubmissionTransaction();
        primaryMarketLoanSubmissionTransaction.setPrimaryMarketLoanSubmissionLinkIdentifier(
                properties.getProperty(PRIMARY_MARKET_LOAN_SUBMISSION_LINK_IDENTIFIER_KEY));
        primaryMarketLoanSubmissionTransaction.setPrimaryMarketLoanSourceSubmissionTransactionIdentifier(
                properties.getProperty(PRIMARY_MARKET_LOAN_SOURCE_SUBMISSION_TRANSACTION_IDENTIFIER_KEY));
        primaryMarketLoanSubmissionTransaction.setMortgageInsuranceRequiredIndicator(
                properties.getProperty(MORTGAGE_INSURANCE_REQUIRED_INDICATOR_KEY));
        return primaryMarketLoanSubmissionTransaction;
    }
}
