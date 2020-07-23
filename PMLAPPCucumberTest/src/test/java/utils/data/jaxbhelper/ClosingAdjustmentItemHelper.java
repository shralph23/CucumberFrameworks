package utils.data.jaxbhelper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.ClosingAdjustmentItem;

public class ClosingAdjustmentItemHelper {

    private static final String LOAN_IDENTIFIER_KEY = "LOAN_IDENTIFIER";
    private static final String INTEGRATED_DISCLOSURE_LINE_NUMBER_VALUE_KEY = "INTEGRATED_DISCLOSURE_LINE_NUMBER_VALUE";
    private static final String CLOSING_ADJUSTMENT_ITEM_TYPE_DESCRIPTION_KEY = "CLOSING_ADJUSTMENT_ITEM_TYPE_DESCRIPTION";
    private static final String CLOSING_ADJUSTMENT_ITEM_TYPE_KEY = "CLOSING_ADJUSTMENT_ITEM_TYPE";
    private static final int CLOSING_ADJUSTMENT_ITEM_SEQUENCE_NUMBER_KEY = 0;
    private static final String CLOSING_ADJUSTMENT_ITEM_PAID_OUTSIDE_OF_CLOSING_INDICATOR_KEY = "CLOSING_ADJUSTMENT_ITEM_PAID_OUTSIDE_OF_CLOSING_INDICATOR";
    private static final String CLOSING_ADJUSTMENT_ITEM_PAID_BY_TYPE_KEY = "CLOSING_ADJUSTMENT_ITEM_PAID_BY_TYPE_KEY";
    private static final String CLOSING_ADJUSTMENT_ITEM_PAID_BY_PARTY_IDENTIFIER_KEY = "CLOSING_ADJUSTMENT_ITEM_PAID_BY_PARTY_IDENTIFIER";
    private static final String CLOSING_ADJUSTMENT_ITEM_DISPLAY_LABEL_TEXT_KEY = "CLOSING_ADJUSTMENT_ITEM_DISPLAY_LABEL_TEXT";
    private static final double CLOSING_ADJUSTMENT_ITEM__AMOUNT_KEY = 0;

    public static ClosingAdjustmentItem getClosingAdjustmentItem(Properties properties) {
        ClosingAdjustmentItem closingAdjustmentItem = new ClosingAdjustmentItem();
        closingAdjustmentItem.setClosingAdjustmentItemAmount(BigDecimal.valueOf(CLOSING_ADJUSTMENT_ITEM__AMOUNT_KEY));
        closingAdjustmentItem.setClosingAdjustmentItemDisplayLabelText(
                properties.getProperty(CLOSING_ADJUSTMENT_ITEM_DISPLAY_LABEL_TEXT_KEY));
        closingAdjustmentItem.setClosingAdjustmentItemPaidByPartyIdentifier(
                properties.getProperty(CLOSING_ADJUSTMENT_ITEM_PAID_BY_PARTY_IDENTIFIER_KEY));
        closingAdjustmentItem
                .setClosingAdjustmentItemPaidByType(properties.getProperty(CLOSING_ADJUSTMENT_ITEM_PAID_BY_TYPE_KEY));
        closingAdjustmentItem.setClosingAdjustmentItemPaidOutsideOfClosingIndicator(
                properties.getProperty(CLOSING_ADJUSTMENT_ITEM_PAID_OUTSIDE_OF_CLOSING_INDICATOR_KEY));
        closingAdjustmentItem.setClosingAdjustmentItemSequenceNumber(
                BigInteger.valueOf(CLOSING_ADJUSTMENT_ITEM_SEQUENCE_NUMBER_KEY));
        closingAdjustmentItem.setClosingAdjustmentItemType(properties.getProperty(CLOSING_ADJUSTMENT_ITEM_TYPE_KEY));
        closingAdjustmentItem.setClosingAdjustmentItemTypeDescription(
                properties.getProperty(CLOSING_ADJUSTMENT_ITEM_TYPE_DESCRIPTION_KEY));
        closingAdjustmentItem.setIntegratedDisclosureLineNumberValue(
                properties.getProperty(INTEGRATED_DISCLOSURE_LINE_NUMBER_VALUE_KEY));
        closingAdjustmentItem.setLoanIdentifier(properties.getProperty(LOAN_IDENTIFIER_KEY));
        return closingAdjustmentItem;
    }

}
