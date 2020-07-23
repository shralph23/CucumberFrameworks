package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.Buydown;

public class BuydownHelper {
    private static final String BUYDOWN_TEMPORARY_SUBSIDY_INDICATOR_KEY = "BUYDOWN_TEMPORARY_SUBSIDY_INDICATOR";

    public static Buydown getBuydown(Properties properties) {
        Buydown buydown = new Buydown();
        buydown.setBuydownTemporarySubsidyIndicator(properties.getProperty(BUYDOWN_TEMPORARY_SUBSIDY_INDICATOR_KEY));
        return buydown;
    }
}
