package utils.data.jaxbhelper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.LoanProjectedCashFlow;

import utils.datageneration.payloads.PropertiesUtils;

public class LoanProjectedCashFlowHelper {

    /**
     * Values for first Container
     */
    private static final String PROJECTED_PAYMENT_CALCULATION_PERIOD_STARTNUMBER_KEY = "PROJECTED_PAYMENT_CALCULATION_PERIOD_STARTNUMBER";
    private static final String PROJECTED_PAYMENT_CALCULATION_PERIOD_END_NUMBER_KEY = "PROJECTED_PAYMENT_CALCULATION_PERIOD_END_NUMBER";
    private static final String PROJECTED_MINIMUM_TOTAL_PAYMENT_AMOUNT_KEY = "PROJECTED_MINIMUM_TOTAL_PAYMENT_AMOUNT";
    private static final String PROJECTED_MINIMUM_PRINCIPAL_AND_INTEREST_PAYMENT_AMOUNT_KEY = "PROJECTED_MINIMUM_PRINCIPAL_AND_INTEREST_PAYMENT_AMOUNT";
    private static final String LOAN_PROJECTED_MAXIMUM_TOTAL_PAYMENT_AMOUNT_KEY = "LOAN_PROJECTED_MAXIMUM_TOTAL_PAYMENT_AMOUNT";
    private static final String LOAN_PROJECTED_MAXIMUM_PRINCIPAL_AND_INTEREST_PAYMENT_AMOUNT_KEY = "LOAN_PROJECTED_MAXIMUM_TOTAL_PAYMENT_AMOUNT";
    private static final String LOAN_PROJECTED_ESCROW_PAYMENT_AMOUNT_KEY = "LOAN_PROJECTED_ESCROW_PAYMENT_AMOUNT";
    private static final String LOAN_PROJECTED_CASH_FLOW_SEQUENCE_NUMBER_KEY = "LOAN_PROJECTED_CASH_FLOW_SEQUENCE_NUMBER";
    private static final String LOAN_PROJECT_MI_PAYMENT_AMOUNT_KEY = "LOAN_PROJECT_MI_PAYMENT_AMOUNT";
    private static final String PROJECTED_PAYMENT_FREQUENCY_TYPE_KEY = "PROJECTED_PAYMENT_FREQUENCY_TYPE";
    private static final String PROJECTED_PAYMENT_CALCULATION_PERIOD_TERMTYPE_KEY = "PROJECTED_PAYMENT_CALCULATION_PERIOD_TERMTYPE";

    /**
     * Values for Second Container
     */
    private static final int PROJECTED_PAYMENT_CALCULATION_PERIOD_STARTNUMBER_SECOND_CONTAINER_KEY = 99;
    private static final int PROJECTED_PAYMENT_CALCULATION_PERIOD_END_NUMBER_SECOND_CONTAINER_KEY = 99;
    private static final double PROJECTED_MINIMUM_TOTAL_PAYMENT_AMOUNT_SECOND_CONTAINER_KEY = 99.99;
    private static final double PROJECTED_MINIMUM_PRINCIPAL_AND_INTEREST_PAYMENT_AMOUNT_SECOND_CONTAINER_KEY = 99.99;
    private static final double LOAN_PROJECTED_MAXIMUM_TOTAL_PAYMENT_AMOUNT_SECOND_CONTAINER_KEY = 99.99;
    private static final double LOAN_PROJECTED_MAXIMUM_PRINCIPAL_AND_INTEREST_PAYMENT_AMOUNT_SECOND_CONTAINER_KEY = 99.99;
    private static final double LOAN_PROJECTED_ESCROW_PAYMENT_AMOUNT_SECOND_CONTAINER_KEY = 99.99;
    private static final int LOAN_PROJECTED_CASH_FLOW_SEQUENCE_NUMBER_SECOND_CONTAINER_KEY = 999;
    private static final double LOAN_PROJECT_MI_PAYMENT_SECOND_CONTAINER_AMOUNT = 99.99;
    private static final String PROJECTED_PAYMENT_FREQUENCY_TYPE_SECOND_CONTAINER_KEY = "PROJECTED_PAYMENT_FREQUENCY_TYPE";
    private static final String PROJECTED_PAYMENT_CALCULATION_PERIOD_TERMTYPE_SECOND_CONTAINER_KEY = "PROJECTED_PAYMENT_CALCULATION_PERIOD_TERMTYPE";

    /**
     * Values for Third Container
     */
    private static final double PROJECTED_MINIMUM_PRINCIPAL_AND_INTEREST_PAYMENT_AMOUNT_THIRD_CONTAINER_KEY = 99.99;

    public static LoanProjectedCashFlow getLoanProjectedCashFlowForFirstContainer(Properties properties) {
        LoanProjectedCashFlow loanProjectedCashFlow = new LoanProjectedCashFlow();
        loanProjectedCashFlow.setLoanProjectedCashFlowSequenceNumber(
                PropertiesUtils.getBigIntegerValue(properties, LOAN_PROJECTED_CASH_FLOW_SEQUENCE_NUMBER_KEY));
        loanProjectedCashFlow.setLoanProjectedEscrowPaymentAmount(
                PropertiesUtils.getBigDecimalValue(properties, LOAN_PROJECTED_ESCROW_PAYMENT_AMOUNT_KEY));
        loanProjectedCashFlow.setLoanProjectedMaximumPrincipalAndInterestPaymentAmount(PropertiesUtils
                .getBigDecimalValue(properties, LOAN_PROJECTED_MAXIMUM_PRINCIPAL_AND_INTEREST_PAYMENT_AMOUNT_KEY));
        loanProjectedCashFlow.setLoanProjectedMaximumTotalPaymentAmount(
                PropertiesUtils.getBigDecimalValue(properties, LOAN_PROJECTED_MAXIMUM_TOTAL_PAYMENT_AMOUNT_KEY));
        loanProjectedCashFlow.setLoanProjectedMIPaymentAmount(
                PropertiesUtils.getBigDecimalValue(properties, LOAN_PROJECT_MI_PAYMENT_AMOUNT_KEY));
        loanProjectedCashFlow.setLoanProjectedMinimumPrincipalAndInterestPaymentAmount(PropertiesUtils
                .getBigDecimalValue(properties, PROJECTED_MINIMUM_PRINCIPAL_AND_INTEREST_PAYMENT_AMOUNT_KEY));
        loanProjectedCashFlow.setLoanProjectedMinimumTotalPaymentAmount(
                PropertiesUtils.getBigDecimalValue(properties, PROJECTED_MINIMUM_TOTAL_PAYMENT_AMOUNT_KEY));
        loanProjectedCashFlow.setProjectedPaymentCalculationPeriodTermType(
                properties.getProperty(PROJECTED_PAYMENT_CALCULATION_PERIOD_TERMTYPE_KEY));
        loanProjectedCashFlow
                .setProjectedPaymentFrequencyType(properties.getProperty(PROJECTED_PAYMENT_FREQUENCY_TYPE_KEY));
        loanProjectedCashFlow.setProjectedPaymentCalculationPeriodEndNumber(
                PropertiesUtils.getBigIntegerValue(properties, PROJECTED_PAYMENT_CALCULATION_PERIOD_END_NUMBER_KEY));
        loanProjectedCashFlow.setProjectedPaymentCalculationPeriodStartNumber(
                PropertiesUtils.getBigIntegerValue(properties, PROJECTED_PAYMENT_CALCULATION_PERIOD_STARTNUMBER_KEY));
        return loanProjectedCashFlow;
    }

    // TODO : review if needed and why default values for a container have to be hardcoded
    @SuppressWarnings("unused")
	private static LoanProjectedCashFlow getLoanProjectedCashFlowForSecondContainer(Properties properties) {
        LoanProjectedCashFlow loanProjectedCashFlow = new LoanProjectedCashFlow();
        loanProjectedCashFlow.setLoanProjectedCashFlowSequenceNumber(
                BigInteger.valueOf(LOAN_PROJECTED_CASH_FLOW_SEQUENCE_NUMBER_SECOND_CONTAINER_KEY));
        loanProjectedCashFlow.setLoanProjectedEscrowPaymentAmount(
                BigDecimal.valueOf(LOAN_PROJECTED_ESCROW_PAYMENT_AMOUNT_SECOND_CONTAINER_KEY));
        loanProjectedCashFlow.setLoanProjectedMaximumPrincipalAndInterestPaymentAmount(
                BigDecimal.valueOf(LOAN_PROJECTED_MAXIMUM_PRINCIPAL_AND_INTEREST_PAYMENT_AMOUNT_SECOND_CONTAINER_KEY));
        loanProjectedCashFlow.setLoanProjectedMaximumTotalPaymentAmount(
                BigDecimal.valueOf(LOAN_PROJECTED_MAXIMUM_TOTAL_PAYMENT_AMOUNT_SECOND_CONTAINER_KEY));
        loanProjectedCashFlow
                .setLoanProjectedMIPaymentAmount(BigDecimal.valueOf(LOAN_PROJECT_MI_PAYMENT_SECOND_CONTAINER_AMOUNT));
        loanProjectedCashFlow.setLoanProjectedMinimumPrincipalAndInterestPaymentAmount(
                BigDecimal.valueOf(PROJECTED_MINIMUM_PRINCIPAL_AND_INTEREST_PAYMENT_AMOUNT_SECOND_CONTAINER_KEY));
        loanProjectedCashFlow.setLoanProjectedMinimumTotalPaymentAmount(
                BigDecimal.valueOf(PROJECTED_MINIMUM_TOTAL_PAYMENT_AMOUNT_SECOND_CONTAINER_KEY));
        loanProjectedCashFlow.setProjectedPaymentCalculationPeriodTermType(
                properties.getProperty(PROJECTED_PAYMENT_CALCULATION_PERIOD_TERMTYPE_SECOND_CONTAINER_KEY));
        loanProjectedCashFlow.setProjectedPaymentFrequencyType(
                properties.getProperty(PROJECTED_PAYMENT_FREQUENCY_TYPE_SECOND_CONTAINER_KEY));
        loanProjectedCashFlow.setProjectedPaymentCalculationPeriodEndNumber(
                BigInteger.valueOf(PROJECTED_PAYMENT_CALCULATION_PERIOD_END_NUMBER_SECOND_CONTAINER_KEY));
        loanProjectedCashFlow.setProjectedPaymentCalculationPeriodStartNumber(
                BigInteger.valueOf(PROJECTED_PAYMENT_CALCULATION_PERIOD_STARTNUMBER_SECOND_CONTAINER_KEY));
        return loanProjectedCashFlow;
    }

    // TODO : review if needed and why default values for a container have to be hardcoded
    @SuppressWarnings("unused")
	private static LoanProjectedCashFlow getLoanProjectedCashFlowForThirdContainer() {
        LoanProjectedCashFlow loanProjectedCashFlow = new LoanProjectedCashFlow();
        loanProjectedCashFlow.setLoanProjectedMinimumPrincipalAndInterestPaymentAmount(
                BigDecimal.valueOf(PROJECTED_MINIMUM_PRINCIPAL_AND_INTEREST_PAYMENT_AMOUNT_THIRD_CONTAINER_KEY));
        return loanProjectedCashFlow;
    }
}
