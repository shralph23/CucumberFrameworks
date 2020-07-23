package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.Loan;

public class LoanHelper {

    private static final String ASSUMABLITY_INDICATOR_KEY = "ASSUMABLITY_INDICATOR";
    private static final String LOAN_MATURITY_PERIODTYPE_KEY = "LOAN_MATURITY_PERIODTYPE";
    private static final String MORTGAGE_TYPE_KEY = "MORTGAGE_TYPE";
    private static final String LOAN_PURPOSE_TYPE_KEY = "LOAN_PURPOSE_TYPE";
    private static final String LOAN_PREPAYMENT_PENALTY_INDICATOR_KEY = "LOAN_PREPAYMENT_PENALTY_INDICATOR";
    private static final String LOAN_PARTIAL_PAYMENTALLOWED_INDICATOR_KEY = "LOAN_PARTIAL_PAYMENTALLOWED_INDICATOR";
    private static final String LOAN_INTEREST_ONLY_INDICATOR_KEY = "LOAN_INTEREST_ONLY_INDICATOR";
    private static final String LOAN_IDENTIFIER_KEY = "LOAN_IDENTIFIER";
    private static final String LOAN_DEMAND_FEATURE_INDICATOR_KEY = "LOAN_DEMAND_FEATURE_INDICATOR";
    private static final String LOAN_AMORTIZATION_TYPE_KEY = "LOAN_AMORTIZATION_TYPE";
    private static final Short LOAN_MATURITY_PERIODCOUNT_KEY = 180;
    private static final String MERSMIN_IDENTIFIER_KEY = "MERSMIN_IDENTIFIER";

    public static Loan getLoan(Properties properties) {
        Loan loan = new Loan();
        loan.setAssumabilityIndicator(properties.getProperty(ASSUMABLITY_INDICATOR_KEY));
        loan.setLoanAmortizationType(properties.getProperty(LOAN_AMORTIZATION_TYPE_KEY));
        loan.setLoanDemandFeatureIndicator(properties.getProperty(LOAN_DEMAND_FEATURE_INDICATOR_KEY));
        loan.setLoanIdentifier(properties.getProperty(LOAN_IDENTIFIER_KEY));
        loan.setLoanInterestOnlyIndicator(properties.getProperty(LOAN_INTEREST_ONLY_INDICATOR_KEY));
        loan.setLoanMaturityPeriodCount(LOAN_MATURITY_PERIODCOUNT_KEY);
        loan.setLoanMaturityPeriodType(properties.getProperty(LOAN_MATURITY_PERIODTYPE_KEY));
        loan.setLoanPartialPaymentAllowedIndicator(properties.getProperty(LOAN_PARTIAL_PAYMENTALLOWED_INDICATOR_KEY));
        loan.setLoanPrepaymentPenaltyIndicator(properties.getProperty(LOAN_PREPAYMENT_PENALTY_INDICATOR_KEY));
        loan.setLoanPurposeType(properties.getProperty(LOAN_PURPOSE_TYPE_KEY));
        loan.setMortgageType(properties.getProperty(MORTGAGE_TYPE_KEY));
        loan.setMERSMINIdentifier(properties.getProperty(MERSMIN_IDENTIFIER_KEY));
        return loan;
    }
}
