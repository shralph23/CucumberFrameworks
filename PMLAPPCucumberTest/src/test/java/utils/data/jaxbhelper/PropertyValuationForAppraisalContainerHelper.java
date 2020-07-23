package utils.data.jaxbhelper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PropertyValuation;

public class PropertyValuationForAppraisalContainerHelper {

    private static final String APPRAISAL_ALTERNATIVE_PILOT_TYPE_KEY = "APPRAISAL_ALTERNATIVE_PILOT_TYPE";
    private static final double LAND_VALUE_AMOUNT_KEY = 0;
    private static final String PROPERTY_IDENTIFIER_KEY = "PROPERTY_IDENTIFIER";
    private static final String PROPERTY_OVERALL_CONDITION_TYPE_KEY = "PROPERTY_OVERALL_CONDITION_TYPE";
    private static final String PROPERTY_OVERALL_RATING_DESCRIPTION_KEY = "PROPERTY_OVERALL_RATING_DESCRIPTION";
    private static final short PROPERTY_VALUATION_AGES_DAYS_COUNT_KEY = 4096;
    private static final double PROPERTY_VALUATION_AMOUNT_KEY = 0;
    private static final String PROPERTY_VALUATION_COMMENT_TEXT_KEY = "PROPERTY_VALUATION_COMMENT_TEXT";
    private static final String PROPERTY_VALUATION_CONDITIONAL_CONCLUSION_TYPE_KEY = "PROPERTY_VALUATION_CONDITIONAL_CONCLUSION_TYPE";
    private static final String PROPERTY_VALUATION_CONDITION_DESCRIPTION_KEY = "PROPERTY_VALUATION_CONDITION_DESCRIPTION";
    private static final String PROPERTY_VALUATION_CONDITION_TYPE_KEY = "PROPERTY_VALUATION_CONDITION_TYPE";
    private static final String PROPERTY_VALUATION_FORM_TYPE_KEY = "PROPERTY_VALUATION_FORM_TYPE";
    private static final String PROPERTY_VALUATION_FORM_VERSION_IDENTIFIER_KEY = "PROPERTY_VALUATION_FORM_VERSION_IDENTIFIER";
    private static final String PROPERTY_VALUATION_METHOD_TYPE_KEY = "PROPERTY_VALUATION_METHOD_TYPE";
    private static final int PROPERTY_VALUATION_SEQUENCE_NUMBER_KEY = 0;
    private static final String PROPERTY_VALUATION_SERVICE_TYPE_KEY = "PROPERTY_VALUATION_SERVICE_TYPE";
    private static final String PROPERTY_VALUATION_TYPE_KEY = "PROPERTY_VALUATION_TYPE";
    private static final String RECOMMENDED_INSPECTION_TYPE_KEY = "RECOMMENDED_INSPECTION_TYPE";
    private static final double REPLACEMENT_VALUE_AMOUNT_KEY = 0;
    private static final double STRUCTURE_VALUE_AMOUNT_KEY = 0;
    private static final String VALUATION_ADDENDUM_TEXT_KEY = "VALUATION_ADDENDUM_TEXT";

    public static PropertyValuation getPropertyValuation(Properties properties) {
        PropertyValuation propertyValuation = new PropertyValuation();
        propertyValuation
                .setAppraisalAlternativePilotType(properties.getProperty(APPRAISAL_ALTERNATIVE_PILOT_TYPE_KEY));
        propertyValuation.setLandValueAmount(BigDecimal.valueOf(LAND_VALUE_AMOUNT_KEY));
        propertyValuation.setPropertyIdentifier(properties.getProperty(PROPERTY_IDENTIFIER_KEY));
        propertyValuation.setPropertyOverallConditionType(properties.getProperty(PROPERTY_OVERALL_CONDITION_TYPE_KEY));
        propertyValuation
                .setPropertyOverallRatingDescription(properties.getProperty(PROPERTY_OVERALL_RATING_DESCRIPTION_KEY));
        propertyValuation.setPropertyValuationAgeDaysCount(PROPERTY_VALUATION_AGES_DAYS_COUNT_KEY);
        propertyValuation.setPropertyValuationAmount(BigDecimal.valueOf(PROPERTY_VALUATION_AMOUNT_KEY));
        propertyValuation.setPropertyValuationCommentText(properties.getProperty(PROPERTY_VALUATION_COMMENT_TEXT_KEY));
        propertyValuation.setPropertyValuationConditionalConclusionType(
                properties.getProperty(PROPERTY_VALUATION_CONDITIONAL_CONCLUSION_TYPE_KEY));
        propertyValuation.setPropertyValuationConditionDescription(
                properties.getProperty(PROPERTY_VALUATION_CONDITION_DESCRIPTION_KEY));
        propertyValuation
                .setPropertyValuationConditionType(properties.getProperty(PROPERTY_VALUATION_CONDITION_TYPE_KEY));
        propertyValuation.setPropertyValuationEffectiveDateTime(new Date());
        propertyValuation.setPropertyValuationFormType(properties.getProperty(PROPERTY_VALUATION_FORM_TYPE_KEY));
        propertyValuation.setPropertyValuationFormVersionIdentifier(
                properties.getProperty(PROPERTY_VALUATION_FORM_VERSION_IDENTIFIER_KEY));
        propertyValuation.setPropertyValuationMethodType(properties.getProperty(PROPERTY_VALUATION_METHOD_TYPE_KEY));
        propertyValuation
                .setPropertyValuationSequenceNumber(BigInteger.valueOf(PROPERTY_VALUATION_SEQUENCE_NUMBER_KEY));
        propertyValuation.setPropertyValuationServiceType(properties.getProperty(PROPERTY_VALUATION_SERVICE_TYPE_KEY));
        propertyValuation.setPropertyValuationType(properties.getProperty(PROPERTY_VALUATION_TYPE_KEY));
        propertyValuation.setRecommendedInspectionType(properties.getProperty(RECOMMENDED_INSPECTION_TYPE_KEY));
        propertyValuation.setReplacementValueAmount(BigDecimal.valueOf(REPLACEMENT_VALUE_AMOUNT_KEY));
        propertyValuation.setStructureValueAmount(BigDecimal.valueOf(STRUCTURE_VALUE_AMOUNT_KEY));
        propertyValuation.setValuationAddendumText(properties.getProperty(VALUATION_ADDENDUM_TEXT_KEY));
        return propertyValuation;
    }
}
