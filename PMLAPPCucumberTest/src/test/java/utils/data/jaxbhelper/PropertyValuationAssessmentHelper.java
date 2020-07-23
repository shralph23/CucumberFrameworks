package utils.data.jaxbhelper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PropertyValuationAssessment;

import utils.datageneration.payloads.PropertiesUtils;
import utils.generic.TestConstants;

public class PropertyValuationAssessmentHelper {

	private static final String APPRAISAL_ALTERNATIVES_STATUS_TYPES_KEY = "APPRAISAL_ALTERNATIVES_STATUS_TYPES";
	private static final String APPRAISAL_DECISION_TYPE_KEY = "APPRAISAL_DECISION_TYPE";
	private static final String APPRAISAL_REPORT_QUALITY_SCORE_CONFIDENCE_LEVEL_TYPE_KEY = "APPRAISAL_REPORT_QUALITY_SCORE_CONFIDENCE_LEVEL_TYPE";
	private static final double APPRAISAL_REPORT_QUALITY_SCORE_NUMBER_KEY = 0;
	private static final String APPRAISAL_VALUATION_ACCURACY_SCORE_CONFIDENCE_LEVEL_TYPE_KEY = "APPRAISAL_VALUATION_ACCURACY_SCORE_CONFIDENCE_LEVEL_TYPE";
	private static final double APPRAISAL_VALUATION_ACCURACY_SCORE__NUMBER_KEY = 0;
	private static final String FREDDIE_MAC_APPRAISAL_QUALITY_SCORE_NUMBER_KEY = "FREDDIE_MAC_APPRAISAL_QUALITY_SCORE_NUMBER";
	private static final String HOME_VALUE_EXPLORER_CONFIDENCE_LEVEL_TYPE_KEY = "HOME_VALUE_EXPLORER_CONFIDENCE_LEVEL_TYPE";
	private static final double HOME_VALUE_EXPLORER_FORCAST_STANDARD_DEVIATION_RATE_KEY = 0;
	private static final double HOME_VALUE_EXPLORER_MAXIMUM_VALUE_AMOUNT_KEY = 0;
	private static final double HOME_VALUE_EXPLORER_MID_POINT_ESTIMATED_AMOUNT = 0;
	private static final double HOME_VALUE_EXPLORER_MINIMUM_VALUE_AMOUNT_KEY = 0;
	private static final String HOME_VALUE_EXPLORER_OPTIONS_TYPE_KEY = "HOME_VALUE_EXPLORER_OPTIONS_TYPE";
	private static final String PROPERTY_IDENTIFIER_KEY = "PROPERTY_IDENTIFIER";
	private static final String PROPERTY_VALUATION_ALIGNMENT_SCORE_NUMBER_KEY = "PROPERTY_VALUATION_ALIGNMENT_SCORE_NUMBER";
	private static final int PROPERTY_VALUATION_ASSESSMENT_SEQUENCE_NUMBER_KEY = 0;
	private static final int PROPERTY_VALUATION_SEQUENCE_NUMBER_KEY = 0;
	private static final String PROPERTY_VALUATION_INDICATOR_KEY = "PROPERTY_VALUATION_INDICATOR";
	private static final String PROPERTY_VALUATION_EFFECTIVE_DATE_TIME_KEY = "PROPERTY_VALUATION_EFFECTIVE_DATE_TIME";
	private static final String PROPERTY_VALUATION_EXPIRATION_DATE_TIME_KEY = "PROPERTY_VALUATION_EXPIRATION_DATE_TIME";

	public static PropertyValuationAssessment getPropertyValuationAssessment(Properties properties) {
		PropertyValuationAssessment propertyValuationAssessment = new PropertyValuationAssessment();
		if (!PropertiesUtils.getContainerToBeRemoved(properties).equals(TestConstants.PROPERTY_VALUATION_ASSESSMENT)) {
			propertyValuationAssessment
					.setAppraisalAlternativeStatusType(properties.getProperty(APPRAISAL_ALTERNATIVES_STATUS_TYPES_KEY));
			propertyValuationAssessment.setAppraisalDecisionType(properties.getProperty(APPRAISAL_DECISION_TYPE_KEY));
			propertyValuationAssessment.setAppraisalReportQualityScoreConfidenceLevelType(
					properties.getProperty(APPRAISAL_REPORT_QUALITY_SCORE_CONFIDENCE_LEVEL_TYPE_KEY));
			propertyValuationAssessment.setAppraisalReportQualityScoreNumber(
					BigDecimal.valueOf(APPRAISAL_REPORT_QUALITY_SCORE_NUMBER_KEY));
			propertyValuationAssessment.setAppraisalValuationAccuracyScoreConfidenceLevelType(
					properties.getProperty(APPRAISAL_VALUATION_ACCURACY_SCORE_CONFIDENCE_LEVEL_TYPE_KEY));
			propertyValuationAssessment.setAppraisalValuationAccuracyScoreNumber(
					BigDecimal.valueOf(APPRAISAL_VALUATION_ACCURACY_SCORE__NUMBER_KEY));
			propertyValuationAssessment.setFreddieMacAppraisalQualityScoreNumber(
					PropertiesUtils.getBigDecimalValue(properties, FREDDIE_MAC_APPRAISAL_QUALITY_SCORE_NUMBER_KEY));
			propertyValuationAssessment.setHomeValueExplorerConfidenceLevelType(
					properties.getProperty(HOME_VALUE_EXPLORER_CONFIDENCE_LEVEL_TYPE_KEY));
			propertyValuationAssessment.setHomeValueExplorerForecastStandardDeviationRate(
					BigDecimal.valueOf(HOME_VALUE_EXPLORER_FORCAST_STANDARD_DEVIATION_RATE_KEY));
			propertyValuationAssessment.setHomeValueExplorerMaximumValueAmount(
					BigDecimal.valueOf(HOME_VALUE_EXPLORER_MAXIMUM_VALUE_AMOUNT_KEY));
			propertyValuationAssessment.setHomeValueExplorerMidPointValueEstimateAmount(
					BigDecimal.valueOf(HOME_VALUE_EXPLORER_MID_POINT_ESTIMATED_AMOUNT));
			propertyValuationAssessment.setHomeValueExplorerMinimumValueAmount(
					BigDecimal.valueOf(HOME_VALUE_EXPLORER_MINIMUM_VALUE_AMOUNT_KEY));
			propertyValuationAssessment
					.setHomeValueExplorerOptionType(properties.getProperty(HOME_VALUE_EXPLORER_OPTIONS_TYPE_KEY));
			propertyValuationAssessment.setPropertyIdentifier(properties.getProperty(PROPERTY_IDENTIFIER_KEY));
			propertyValuationAssessment.setPropertyValuationAlignmentScoreNumber(
					PropertiesUtils.getBigDecimalValue(properties, PROPERTY_VALUATION_ALIGNMENT_SCORE_NUMBER_KEY));
			propertyValuationAssessment.setPropertyValuationAssessmentSequenceNumber(
					BigInteger.valueOf(PROPERTY_VALUATION_ASSESSMENT_SEQUENCE_NUMBER_KEY));
			propertyValuationAssessment.setPropertyValuationEffectiveDateTime(
					PropertiesUtils.getDateTimeValue(properties, PROPERTY_VALUATION_EFFECTIVE_DATE_TIME_KEY));
			propertyValuationAssessment.setPropertyValuationExpirationDateTime(
					PropertiesUtils.getDateTimeValue(properties, PROPERTY_VALUATION_EXPIRATION_DATE_TIME_KEY));
			propertyValuationAssessment
					.setPropertyValuationSequenceNumber(BigInteger.valueOf(PROPERTY_VALUATION_SEQUENCE_NUMBER_KEY));
			propertyValuationAssessment
					.setPropertyValuationValidIndicator(properties.getProperty(PROPERTY_VALUATION_INDICATOR_KEY));
		}
		return propertyValuationAssessment;

	}
}
