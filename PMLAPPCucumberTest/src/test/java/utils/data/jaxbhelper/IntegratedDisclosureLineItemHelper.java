package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.IntegratedDisclosureLineItem;

public class IntegratedDisclosureLineItemHelper {

    private static final String REQUIRED_SERVICE_PROVIDER_IDENTIFIER_KEY = "REQUIRED_SERVICE_PROVIDER_IDENTIFIER_KEY";
    private static final String REQUIRED_PROVIDER_OF_SERVICE_INDICATOR_KEY = "REQUIRED_PROVIDER_OF_SERVICE_INDICATOR_KEY";
    private static final String REGULATION_ZPOINTS_AND_FEES_INDICATOR_KEY = "REGULATION_ZPOINTS_AND_FEES_INDICATOR_KEY";
    private static final String PAYMENT_INCLUDED_IN_JURISDICTION_HIGH_COST_INDICATOR_KEY = "PAYMENT_INCLUDED_IN_JURISDICTION_HIGH_COST_INDICATOR_KEY";
    private static final String PAYMENT_INCLUDED_IN_APR_INDICATOR_KEY = "PAYMENT_INCLUDED_IN_APR_INDICATOR_KEY";
    private static final String PAYMENT_FINANCED_INDICATOR_KEY = "PAYMENT_FINANCED_INDICATOR_KEY";
    private static final String LOAN_IDENTIFIER_KEY = "LOAN_IDENTIFIER_KEY";
    private static final String INTEGRATED_DISCLOSURE_SUB_SECTION_TYPE_KEY = "INTEGRATED_DISCLOSURE_SUB_SECTION_TYPE_KEY";
    private static final String INTEGRATED_DISCLOSURE_SECTION_TYPE_KEY = "INTEGRATED_DISCLOSURE_SECTION_TYPE_KEY";
    private static final String INTEGRATED_DISCLOSURELINE_NUMBER_VALUE_KEY = "INTEGRATED_DISCLOSURELINE_NUMBER_VALUE_KEY";
    private static final String BORROWERE_CHOSEN_PROVIDER_INDICATOR_KEY = "BORROWERE_CHOSEN_PROVIDER_INDICATOR_KEY";

    public static IntegratedDisclosureLineItem getIntegratedDisclosureLineItem(Properties properties) {
        IntegratedDisclosureLineItem integratedDisclosureLineItem = new IntegratedDisclosureLineItem();
        integratedDisclosureLineItem
                .setBorrowerChosenProviderIndicator(properties.getProperty(BORROWERE_CHOSEN_PROVIDER_INDICATOR_KEY));
        integratedDisclosureLineItem.setIntegratedDisclosureLineNumberValue(
                properties.getProperty(INTEGRATED_DISCLOSURELINE_NUMBER_VALUE_KEY));
        integratedDisclosureLineItem
                .setIntegratedDisclosureSectionType(properties.getProperty(INTEGRATED_DISCLOSURE_SECTION_TYPE_KEY));
        integratedDisclosureLineItem.setIntegratedDisclosureSubsectionType(
                properties.getProperty(INTEGRATED_DISCLOSURE_SUB_SECTION_TYPE_KEY));
        integratedDisclosureLineItem.setLoanIdentifier(properties.getProperty(LOAN_IDENTIFIER_KEY));
        integratedDisclosureLineItem
                .setPaymentFinancedIndicator(properties.getProperty(PAYMENT_FINANCED_INDICATOR_KEY));
        integratedDisclosureLineItem
                .setPaymentIncludedInAPRIndicator(properties.getProperty(PAYMENT_INCLUDED_IN_APR_INDICATOR_KEY));
        integratedDisclosureLineItem.setPaymentIncludedInJurisdictionHighCostIndicator(
                properties.getProperty(PAYMENT_INCLUDED_IN_JURISDICTION_HIGH_COST_INDICATOR_KEY));
        integratedDisclosureLineItem.setRegulationZPointsAndFeesIndicator(
                properties.getProperty(REGULATION_ZPOINTS_AND_FEES_INDICATOR_KEY));
        integratedDisclosureLineItem.setRequiredProviderOfServiceIndicator(
                properties.getProperty(REQUIRED_PROVIDER_OF_SERVICE_INDICATOR_KEY));
        integratedDisclosureLineItem
                .setRequiredServiceProviderIdentifier(properties.getProperty(REQUIRED_SERVICE_PROVIDER_IDENTIFIER_KEY));
        return integratedDisclosureLineItem;
    }
}
