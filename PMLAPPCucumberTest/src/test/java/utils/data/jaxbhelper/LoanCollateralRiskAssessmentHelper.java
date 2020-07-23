package utils.data.jaxbhelper;

import java.util.Date;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.LoanCollateralRiskAssessment;

import utils.datageneration.payloads.PropertiesUtils;

public class LoanCollateralRiskAssessmentHelper {

    private static final String LTV_RATIO_PERCENT_KEY = "LTV_RATIO_PERCENT";
    private static final String TOTAL_LOAN_COST_PERCENT_KEY = "TOTAL_LOAN_COST_PERCENT";
    private static final String PROPERTY_VALUATION_SEQUENCE_NUMBER_KEY = "PROPERTY_VALUATION_SEQUENCE_NUMBER";
    private static final String PROPERTY_POOL_IDENTIFIER_KEY = "PROPERTY_POOL_IDENTIFIER";
    private static final String PROPERTY_IDENTIFIER_KEY = "PROPERTY_IDENTIFIER_FOR_RISK_ASSMT";
    private static final String LTV_SOURCE_TYPE_KEY = "LTV_SOURCE_TYPE";
    private static final String LTV_EVENT_TYPE_KEY = "LTV_EVENT_TYPE";
    private static final String LTV_CALCULATION_TYPE_KEY = "LTV_CALCULATION_TYPE";
    private static final String LOAN_SCOPE_TYPE_KEY = "LOAN_SCOPE_TYPE";
    private static final String LOAN_IDENTIFIER_KEY = "LOAN_IDENTIFIER";
    private static final String LOAN_COLLATERAL_RISK_ASSESSEMENT_DESCRIPTION_KEY = "LOAN_COLLATERAL_RISK_ASSESSEMENT_DESCRIPTION";

    public static LoanCollateralRiskAssessment getLoanCollateralRiskAssessment(Properties properties) {
        LoanCollateralRiskAssessment loanCollateralRiskAssessment = new LoanCollateralRiskAssessment();
        loanCollateralRiskAssessment.setLoanCollateralRiskAssessmentDescription(
                PropertiesUtils.getStringValue(properties, LOAN_COLLATERAL_RISK_ASSESSEMENT_DESCRIPTION_KEY));
        loanCollateralRiskAssessment.setLoanIdentifier(PropertiesUtils.getStringValue(properties, LOAN_IDENTIFIER_KEY));
        loanCollateralRiskAssessment.setLoanScopeType(properties.getProperty(LOAN_SCOPE_TYPE_KEY));
        loanCollateralRiskAssessment
                .setLTVCalculationType(PropertiesUtils.getStringValue(properties, LTV_CALCULATION_TYPE_KEY));
        loanCollateralRiskAssessment.setLTVEventType(PropertiesUtils.getStringValue(properties, LTV_EVENT_TYPE_KEY));
        loanCollateralRiskAssessment
                .setLTVRatioPercent(PropertiesUtils.getBigDecimalValue(properties, LTV_RATIO_PERCENT_KEY));
        loanCollateralRiskAssessment.setLTVSourceType(PropertiesUtils.getStringValue(properties, LTV_SOURCE_TYPE_KEY));
        loanCollateralRiskAssessment
                .setPropertyIdentifier(PropertiesUtils.getStringValue(properties, PROPERTY_IDENTIFIER_KEY));
        loanCollateralRiskAssessment.setPropertyPoolIdentifier(
                PropertiesUtils.getBigIntegerValue(properties, PROPERTY_POOL_IDENTIFIER_KEY));
        loanCollateralRiskAssessment.setPropertyValuationEffectiveDate(new Date());
        loanCollateralRiskAssessment.setPropertyValuationSequenceNumber(
                PropertiesUtils.getBigIntegerValue(properties, PROPERTY_VALUATION_SEQUENCE_NUMBER_KEY));
        loanCollateralRiskAssessment
                .setTotalLoanToCostPercent(PropertiesUtils.getBigDecimalValue(properties, TOTAL_LOAN_COST_PERCENT_KEY));
        return loanCollateralRiskAssessment;
    }
}
