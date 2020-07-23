package utils.data.jaxbhelper;

import java.math.BigInteger;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.EvaluationServiceResultDetail;

public class EvaluationServiceResultDetailHelper {

    private static final String EVALUATION_SERVICE_CATEGORY_TYPE_KEY = "EVALUATION_SERVICE_CATEGORY_TYPE_KEY";
    private static final String EVALUATION_CATEGORY_NAME_KEY = "EVALUATION_CATEGORY_NAME_KEY";
    private static final String EVALUATION_RESULT_DECISION_DESCRIPTION_KEY = "EVALUATION_RESULT_DECISION_DESCRIPTION_KEY";
    private static final int EAVALUATION_RESULT_SEQUENCE_NUMBER = 1;

    public static EvaluationServiceResultDetail getEvaluationServiceResultDetail(Properties properties) {
        EvaluationServiceResultDetail evaluationServiceResultDetail = new EvaluationServiceResultDetail();
        evaluationServiceResultDetail.setEvaluationResultDecisionDescription(
                properties.getProperty(EVALUATION_RESULT_DECISION_DESCRIPTION_KEY));
        evaluationServiceResultDetail
                .setEvaluationServiceCategoryName(properties.getProperty(EVALUATION_CATEGORY_NAME_KEY));
        evaluationServiceResultDetail
                .setEvaluationServiceCategoryType(properties.getProperty(EVALUATION_SERVICE_CATEGORY_TYPE_KEY));
        evaluationServiceResultDetail
                .setEvaluationResultSequenceNumber(BigInteger.valueOf(EAVALUATION_RESULT_SEQUENCE_NUMBER));
        return evaluationServiceResultDetail;
    }
}
