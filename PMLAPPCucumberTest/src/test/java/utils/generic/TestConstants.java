package utils.generic;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class TestConstants {

    public static final String REPORT_SEPERATOR = " -------------------------------------------------------------------------------------------------------------\n";

    public static final String HIBERNATE_PERSISTENCE_UNIT = "pmlappjpacucumber";

    public static final DecimalFormat decFormat = new DecimalFormat("0.######");
    public static final SimpleDateFormat dtf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss.0");
    public static final SimpleDateFormat dateTimeParser = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");

    // PMLAPP Constants
    public static final String LENDER_LN_ID = "TEST_LenderLnId";
    public static final String APPRAISAL_CONTAINER = "APPRAISAL_CONTAINER";
    public static final String APPRAISAL_CONTAINERS = "APPRAISAL_CONTAINERS";
    public static final String APPRAISAL = "APPRAISAL";
    public static final String CASH_TO_CLOSE = "CASH_TO_CLOSE";
    public static final String DOCUMENT_GROUP = "DOCUMENT_GROUP";
    public static final String LATE_CHARGE_RULE = "LATE_CHARGE_RULE";
    public static final String LOAN_PURCHASE_CONTRACT = "LOAN_PURCHASE_CONTRACT";
    public static final String PARTY_ROLE = "PARTY_ROLE";
    public static final String LOAN_COLLATERAL_RISK_ASSESSMENT = "LOAN_COLLATERAL_RISK_ASSESSMENT";
    public static final String PRIMARY_MARKET_LOAN_SUBMISSION_CONTRACT_CONTAINER = "PRIMARY_MARKET_LOAN_SUBMISSION_CONTRACT_CONTAINER";
    public static final String PRIMARY_MARKET_LOAN_SUBMISSION_DOCUMENT_GROUP_CONTAINER = "PRIMARY_MARKET_LOAN_SUBMISSION_DOCUMENT_GROUP_CONTAINER";
    public static final String PRIMARY_MARKET_LOAN_SUBMISSION_DOCUMENT_GROUP_CONTAINERS = "PRIMARY_MARKET_LOAN_SUBMISSION_DOCUMENT_GROUP_CONTAINERS";
    public static final String PRIMARY_MARKET_LOAN_SUBMISSION_PARTY_ROLE_CONTAINER = "PRIMARY_MARKET_LOAN_SUBMISSION_PARTY_ROLE_CONTAINER";
    public static final String PRIMARY_MARKET_LOAN_SUBMISSION_PARTY_ROLE_CONTAINERS = "PRIMARY_MARKET_LOAN_SUBMISSION_PARTY_ROLE_CONTAINERS";
    public static final String PRIMARY_MARKET_LOAN_SUBMISSION_PROPERTY_ADDRESS_CONTAINER = "PRIMARY_MARKET_LOAN_SUBMISSION_PROPERTY_ADDRESS_CONTAINER";
    public static final String PRIMARY_MARKET_LOAN_SUBMISSION_PROPERTY_ADDRESS_CONTAINERS = "PRIMARY_MARKET_LOAN_SUBMISSION_PROPERTY_ADDRESS_CONTAINERS";
    public static final String PROPERTY_VALUATION_ASSESSMENT = "PROPERTY_VALUATION_ASSESSMENT";

}
