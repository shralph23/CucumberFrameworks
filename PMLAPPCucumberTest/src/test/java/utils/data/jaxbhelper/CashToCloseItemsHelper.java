package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.CashToCloseItem;
import com.freddiemac.datamanager.jaxb.CashToCloseItems;

import utils.datageneration.payloads.PropertiesUtils;
import utils.generic.TestConstants;

public class CashToCloseItemsHelper {

    public static CashToCloseItems getCashToCloseItems(Properties properties) {
        CashToCloseItems cashToCloseItems = new CashToCloseItems();
        List<CashToCloseItem> cashToCloseItemsList = cashToCloseItems.getCashToCloseItem();
        if (!PropertiesUtils.getContainerToBeRemoved(properties).equals(TestConstants.CASH_TO_CLOSE)) {
            CashToCloseItem cashToCloseItemForFirstContainer = CashToCloseItemHelper
                    .getCashToCloseItemForFirstContainer(properties);
            cashToCloseItemsList.add(cashToCloseItemForFirstContainer);
        }
        return cashToCloseItems;
    }
}
