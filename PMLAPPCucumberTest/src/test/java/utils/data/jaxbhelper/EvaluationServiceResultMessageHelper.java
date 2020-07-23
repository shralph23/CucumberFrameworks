package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.EvaluationServiceResultMessage;

public class EvaluationServiceResultMessageHelper {

    private static final String EVALUATION_SERVICE_RESULT_MESSAGE_CATEGORYTYPE_KEY = "EVALUATION_SERVICE_RESULT_MESSAGE_CATEGORYTYEP";
    private static final String EVALUATION_RESULT_MESSAGE_TYPE_KEY = "EVALUATION_RESULT_MESSAGE_TYPE";
    private static final String EVALUATION_REQUEST_MESSAGE_TEXT_KEY = "EVALUATION_REQUEST_MESSAGE_TEXT";
    private static final String EVALUATION_REQUEST_MESSAGE_SECTIONNAME_KEY = "EVALUATION_REQUEST_MESSAGE_SECTIONNAME";
    private static final String EVALUATION_REQUEST_MESSAGE_IDENTIFIER_KEY = "EVALUATION_REQUEST_MESSAGE_IDENTIFIER";
    private static final String EVALUATION_REQUEST_DECISION_DESCRIPTOR_KEY = "EVALUATION_REQUEST_DECISION_DESCRIPTOR";

    public static EvaluationServiceResultMessage getEvaluationServiceResultMessage(Properties properties) {
        EvaluationServiceResultMessage evaluationServiceResultMessage = new EvaluationServiceResultMessage();
        evaluationServiceResultMessage.setEvaluationResultDecisionDescription(
                properties.getProperty(EVALUATION_REQUEST_DECISION_DESCRIPTOR_KEY));
        evaluationServiceResultMessage.setEvaluationResultMessageIdentifier(
                properties.getProperty(EVALUATION_REQUEST_MESSAGE_IDENTIFIER_KEY));
        evaluationServiceResultMessage.setEvaluationResultMessageSectionName(
                properties.getProperty(EVALUATION_REQUEST_MESSAGE_SECTIONNAME_KEY));
        evaluationServiceResultMessage.setEvaluationResultMessageSectionType(
                properties.getProperty(EVALUATION_REQUEST_MESSAGE_SECTIONNAME_KEY));
        evaluationServiceResultMessage
                .setEvaluationResultMessageText(properties.getProperty(EVALUATION_REQUEST_MESSAGE_TEXT_KEY));
        evaluationServiceResultMessage
                .setEvaluationResultMessageType(properties.getProperty(EVALUATION_RESULT_MESSAGE_TYPE_KEY));
        evaluationServiceResultMessage.setEvaluationServiceResultMessageCategoryType(
                properties.getProperty(EVALUATION_SERVICE_RESULT_MESSAGE_CATEGORYTYPE_KEY));
        return evaluationServiceResultMessage;
    }
}
