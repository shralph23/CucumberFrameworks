package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.EvaluationService;

public class EvaluationServiceHelper {

    private static final String EVALUATION_SERVICE_CONCLUSION_DESCRIPTION_KEY = "EVALUATION_SERVICE_CONCLUSION_DESCRIPTION";
    private static final String EVALUATION_SERVICE_CATEGORY_TYPE_KEY = "EVALUATION_SERVICE_CATEGORY_TYPE";
    private static final String EVALUATION_SERVICE_IDENTIFIER_KEY = "EVALUATION_SERVICE_IDENTIFIER";
    private static final String EVALUATION_RESULT_MESSAGES_SOURCE_TYPE_KEY = "EVALUATION_RESULT_MESSAGES_SOURCE_TYPE";

    public static EvaluationService getEvaluationService(Properties properties) {
        EvaluationService evaluationService = new EvaluationService();
        evaluationService.setEvaluationResultMessageSourceType(
                properties.getProperty(EVALUATION_RESULT_MESSAGES_SOURCE_TYPE_KEY));
        evaluationService.setEvaluationServiceIdentifier(properties.getProperty(EVALUATION_SERVICE_IDENTIFIER_KEY));
        evaluationService
                .setEvaluationServiceCategoryType(properties.getProperty(EVALUATION_SERVICE_CATEGORY_TYPE_KEY));
        evaluationService.setEvaluationServiceConclusionDescription(
                properties.getProperty(EVALUATION_SERVICE_CONCLUSION_DESCRIPTION_KEY));
        return evaluationService;
    }
}
