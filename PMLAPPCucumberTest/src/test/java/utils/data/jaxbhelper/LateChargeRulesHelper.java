package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.LateChargeRule;
import com.freddiemac.datamanager.jaxb.LateChargeRules;

import utils.datageneration.payloads.PropertiesUtils;
import utils.generic.TestConstants;

public class LateChargeRulesHelper {

    public static LateChargeRules getLateChargeRules(Properties properties) {
        LateChargeRules lateChargeRules = new LateChargeRules();
        List<LateChargeRule> lateChargeRulesList = lateChargeRules.getLateChargeRule();
        if (!PropertiesUtils.getContainerToBeRemoved(properties).equals(TestConstants.LATE_CHARGE_RULE)) {
            LateChargeRule lateChargeRule = LateChargeRuleHelper.getLateChargeRule(properties);
            lateChargeRulesList.add(lateChargeRule);
        }
        return lateChargeRules;
    }

}
