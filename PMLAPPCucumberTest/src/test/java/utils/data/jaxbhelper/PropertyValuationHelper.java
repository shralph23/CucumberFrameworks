package utils.data.jaxbhelper;

import java.math.BigDecimal;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PropertyValuation;

import utils.datageneration.payloads.PropertiesUtils;

public class PropertyValuationHelper {

    private static final long PROPERT_VALUATION_AMOUNT = 999;
    private static final String PROPERTY_VALUATION_EFFECTIVE_DATE_TIME_KEY = "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME";

    public static PropertyValuation getPropertyValuation(Properties properties) {
        PropertyValuation propertyValuation = new PropertyValuation();
        propertyValuation.setPropertyValuationAmount(BigDecimal.valueOf(PROPERT_VALUATION_AMOUNT));
        propertyValuation.setPropertyValuationEffectiveDateTime(
                PropertiesUtils.getDateTimeValue(properties, PROPERTY_VALUATION_EFFECTIVE_DATE_TIME_KEY));
        return propertyValuation;
    }
}
