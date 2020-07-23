package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.LateChargeRule;

import utils.datageneration.payloads.PropertiesUtils;

public class LateChargeRuleHelper {

    private static final String LOAN_CHARGE_GRACE_PERIOD_COUNT_KEY = "LOAN_CHARGE_GRACE_PERIOD_COUNT";
    private static final String LOAN_LATE_CHARGE_AMOUNT_KEY = "LOAN_LATE_CHARGE_AMOUNT";
    private static final String LOAN_LATE_CHARGE_RATE_KEY = "LOAN_LATE_CHARGE_RATE";
    private static final String LATE_CHARGE_RULE_SEQUENCE_NUMBER_KEY = "LATE_CHARGE_RULE_SEQUENCE_NUMBER";
    private static final String LATE_CHARGE_MINIMUM_AMOUNT_KEY = "LATE_CHARGE_MINIMUM_AMOUNT";
    private static final String LATE_CHARGE_MAXIMUM_AMOUNT_KEY = "LATE_CHARGE_MAXIMUM_AMOUNT";
    private static final String LOAN_IDENTIFIER_KEY = "LOAN_IDENTIFIER";
    private static final String LATE_CHARGE_TYPE_KEY = "LATE_CHARGE_TYPE";

    public static LateChargeRule getLateChargeRule(Properties properties) {
        LateChargeRule lateChargeRule = new LateChargeRule();
        lateChargeRule.setLateChargeMaximumAmount(
                PropertiesUtils.getBigDecimalValue(properties, LATE_CHARGE_MAXIMUM_AMOUNT_KEY));
        lateChargeRule.setLateChargeMinimumAmount(
                PropertiesUtils.getBigDecimalValue(properties, LATE_CHARGE_MINIMUM_AMOUNT_KEY));
        lateChargeRule.setLateChargeRuleSequenceNumber(
                PropertiesUtils.getBigIntegerValue(properties, LATE_CHARGE_RULE_SEQUENCE_NUMBER_KEY));
        lateChargeRule.setLoanLateChargeRate(PropertiesUtils.getBigDecimalValue(properties, LOAN_LATE_CHARGE_RATE_KEY));
        lateChargeRule.setLateChargeType(PropertiesUtils.getStringValue(properties, LATE_CHARGE_TYPE_KEY));
        lateChargeRule.setLoanIdentifier(PropertiesUtils.getStringValue(properties, LOAN_IDENTIFIER_KEY));
        lateChargeRule
                .setLoanLateChargeAmount(PropertiesUtils.getBigDecimalValue(properties, LOAN_LATE_CHARGE_AMOUNT_KEY));
        lateChargeRule.setLoanLateChargeGracePeriodCount(
                PropertiesUtils.getShortValue(properties, LOAN_CHARGE_GRACE_PERIOD_COUNT_KEY));
        return lateChargeRule;
    }
}
