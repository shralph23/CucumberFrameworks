package utils.data.jaxbhelper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.Appraisal;

import utils.datageneration.payloads.PropertiesUtils;
import utils.generic.TestConstants;

public class AppraisalHelperForAppraisalContainers {

    private static final String SUPERVISOR_APPRAISAL_IDENTIFIER_KEY = "SUPERVISOR_APPRAISAL_IDENTIFIER";
    private static final int PROPERTY_VALUATION_SEQUENCE_NUMBER_KEY = 0;
    private static final String PROPERTY_IDENTIFIER_KEY = "PROPERTY_IDENTIFIER";
    private static final double PROPERTY_FORECAST_SALE_PRICE_AMOUNT_KEY = 0;

    private static final String PROPERTY_APPRAISED_VALUE_AMOUNT_KEY = "PROPERTY_APPRAISED_VALUE_AMOUNT";
    private static final String GREATEST_PURCHASE_CERTAINTY_APPRAISAL_IDENTIFIER_KEY = "GREATEST_PURCHASE_CERTAINTY_APPRAISAL_IDENTIFIER";
    private static final String APPRAISAL_IDENTIFIER_KEY = "APPRAISAL_IDENTIFIER";
    private static final String APPRAISER_FILE_IDENTIFIER_KEY = "APPRAISER_FILE_IDENTIFIER";
    private static final String APPRAISAL_INSPECTION_PROPERTY_TYPE_KEY = "APPRAISAL_INSPECTION_PROPERTY_TYPE";
    private static final String APPRAISAL_DOCUMENT_TYPE_KEY = "APPRAISAL_DOCUMENT_TYPE";
    private static final String APPRAISAL_COMPANY_IDENTIFIER_KEY = "APPRAISAL_COMPANY_IDENTIFIER";
    private static final String UCDP_STATUS_KEY = "UCDP_STATUS";
    private static final String LOAN_COLLATERAL_ADVISOR_SUBMISSION_DATE_TIME_KEY = "LOAN_COLLATERAL_ADVISOR_SUBMISSION_DATE_TIME";

    public static Appraisal getAppraisalforAppraisalContainers(Properties properties) {
        Appraisal appraisalForAppraisalContainers = new Appraisal();
        if (!PropertiesUtils.getContainerToBeRemoved(properties).equals(TestConstants.APPRAISAL)) {
            appraisalForAppraisalContainers
                    .setAppraisalCompanyIdentifier(properties.getProperty(APPRAISAL_COMPANY_IDENTIFIER_KEY));
            appraisalForAppraisalContainers
                    .setAppraisalDocumentType(PropertiesUtils.getStringValue(properties, APPRAISAL_DOCUMENT_TYPE_KEY));
            appraisalForAppraisalContainers
                    .setAppraisalInspectionPropertyType(properties.getProperty(APPRAISAL_INSPECTION_PROPERTY_TYPE_KEY));
            appraisalForAppraisalContainers
                    .setAppraiserFileIdentifier(properties.getProperty(APPRAISER_FILE_IDENTIFIER_KEY));
            appraisalForAppraisalContainers.setAppraiserIdentifier(properties.getProperty(APPRAISAL_IDENTIFIER_KEY));
            appraisalForAppraisalContainers.setGreaterPurchaseCertaintyAppraisalIdentifier(
                    properties.getProperty(GREATEST_PURCHASE_CERTAINTY_APPRAISAL_IDENTIFIER_KEY));
            appraisalForAppraisalContainers.setLoanCollateralAdvisorSubmissionDatetime(
                    PropertiesUtils.getDateTimeValue(properties, LOAN_COLLATERAL_ADVISOR_SUBMISSION_DATE_TIME_KEY));
            appraisalForAppraisalContainers.setPropertyAppraisedValueAmount(
                    PropertiesUtils.getBigDecimalValue(properties, PROPERTY_APPRAISED_VALUE_AMOUNT_KEY));
            appraisalForAppraisalContainers
                    .setPropertyForecastSalePriceAmount(BigDecimal.valueOf(PROPERTY_FORECAST_SALE_PRICE_AMOUNT_KEY));
            appraisalForAppraisalContainers.setPropertyIdentifier(properties.getProperty(PROPERTY_IDENTIFIER_KEY));
            appraisalForAppraisalContainers
                    .setPropertyValuationSequenceNumber(BigInteger.valueOf(PROPERTY_VALUATION_SEQUENCE_NUMBER_KEY));
            appraisalForAppraisalContainers.setSupervisoryAppraiserIdentifier(
                    PropertiesUtils.getStringValue(properties, SUPERVISOR_APPRAISAL_IDENTIFIER_KEY));
            appraisalForAppraisalContainers.setUCDPStatus(PropertiesUtils.getStringValue(properties, UCDP_STATUS_KEY));
        }
        return appraisalForAppraisalContainers;
    }
}
