package utils.data.jaxbhelper;

import java.math.BigDecimal;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.CashToCloseItem;

import utils.datageneration.payloads.PropertiesUtils;

public class CashToCloseItemHelper {

    private static final String LOAN_IDENTIFIER_KEY = "LOAN_IDENTIFIER";
    private static final String INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_PAYMENT_TYPE_KEY = "INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_PAYMENT_TYPE";
    private static final String INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_TYPE_KEY = "INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_TYPE";
    private static final String INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_FINAL_AMOUNT_KEY = "INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_FINAL_AMOUNT";
    private static final String INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_ESTIMATED_AMOUNT_KEY = "INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_ESTIMATED_AMOUNT";
    private static final String INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_CHANGE_DESCRIPTION_KEY = "INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_CHANGE_DESCRIPTION_KEY";
    private static final String INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_AMOUNT_CHANGED_INDICATOR_KEY = "INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_AMOUNT_CHANGED_INDICATOR_KEY";

    private static final String LOAN_IDENTIFIER_FOR_SECOND_CONTAINER_KEY = "LOAN_IDENTIFIER_FOR_SECOND_CONTAINER";
    private static final String INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_PAYMENT_TYPEFOR_SECOND_CONTAINER_KEY = "INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_PAYMENT_TYPE_FOR_SECOND_CONTAINER";
    private static final String INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_TYPE_FOR_SECOND_CONTAINER_KEY = "INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_TYPE_FOR_SECOND_CONTAINER";
    private static final double INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_FINAL_AMOUNT_FOR_SECOND_CONTAINER_KEY = 88999.99;
    private static final double INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_ESTIMATED_AMOUNT_FOR_SECOND_CONTAINER_KEY = 999.99;
    private static final String INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_CHANGE_DESCRIPTION_FOR_SECOND_CONTAINER_KEY = "INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_CHANGE_DESCRIPTION_KEY_TYPE_FOR_SECOND_CONTAINER";
    private static final String INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_AMOUNT_CHANGED_INDICATOR_FOR_SECOND_CONTAINER_KEY = "INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_AMOUNT_CHANGED_INDICATOR_KEY_TYPE_FOR_SECOND_CONTAINER";

    public static CashToCloseItem getCashToCloseItemForFirstContainer(Properties properties) {
        CashToCloseItem cashToCloseItem = new CashToCloseItem();
        cashToCloseItem.setIntegratedDisclosureCashToCloseItemAmountChangedIndicator(PropertiesUtils
                .getStringValue(properties, INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_AMOUNT_CHANGED_INDICATOR_KEY));
        cashToCloseItem.setIntegratedDisclosureCashToCloseItemChangeDescription(PropertiesUtils
                .getStringValue(properties, INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_CHANGE_DESCRIPTION_KEY));
        cashToCloseItem.setIntegratedDisclosureCashToCloseItemEstimatedAmount(PropertiesUtils
                .getBigDecimalValue(properties, INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_ESTIMATED_AMOUNT_KEY));
        cashToCloseItem.setIntegratedDisclosureCashToCloseItemFinalAmount(PropertiesUtils.getBigDecimalValue(properties,
                INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_FINAL_AMOUNT_KEY));
        cashToCloseItem.setIntegratedDisclosureCashToCloseItemPaymentType(
                PropertiesUtils.getStringValue(properties, INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_PAYMENT_TYPE_KEY));
        cashToCloseItem.setIntegratedDisclosureCashToCloseItemType(
                PropertiesUtils.getStringValue(properties, INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_TYPE_KEY));
        cashToCloseItem.setLoanIdentifier(PropertiesUtils.getStringValue(properties, LOAN_IDENTIFIER_KEY));
        return cashToCloseItem;
    }

    // TODO : review if needed and why default values for a container have to be hardcoded
    @SuppressWarnings("unused")
	private static CashToCloseItem getCashToCloseItemForSecondContainer(Properties properties) {
        CashToCloseItem cashToCloseItem = new CashToCloseItem();
        cashToCloseItem.setIntegratedDisclosureCashToCloseItemAmountChangedIndicator(properties
                .getProperty(INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_AMOUNT_CHANGED_INDICATOR_FOR_SECOND_CONTAINER_KEY));
        cashToCloseItem.setIntegratedDisclosureCashToCloseItemChangeDescription(properties
                .getProperty(INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_CHANGE_DESCRIPTION_FOR_SECOND_CONTAINER_KEY));
        cashToCloseItem.setIntegratedDisclosureCashToCloseItemEstimatedAmount(
                BigDecimal.valueOf(INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_ESTIMATED_AMOUNT_FOR_SECOND_CONTAINER_KEY));
        cashToCloseItem.setIntegratedDisclosureCashToCloseItemFinalAmount(
                BigDecimal.valueOf(INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_FINAL_AMOUNT_FOR_SECOND_CONTAINER_KEY));
        cashToCloseItem.setIntegratedDisclosureCashToCloseItemPaymentType(
                properties.getProperty(INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_PAYMENT_TYPEFOR_SECOND_CONTAINER_KEY));
        cashToCloseItem.setIntegratedDisclosureCashToCloseItemType(
                properties.getProperty(INTEGRATED_DISCLOSURE_CASHTOCLOSE_ITEM_TYPE_FOR_SECOND_CONTAINER_KEY));
        cashToCloseItem.setLoanIdentifier(properties.getProperty(LOAN_IDENTIFIER_FOR_SECOND_CONTAINER_KEY));
        return cashToCloseItem;
    }
}
