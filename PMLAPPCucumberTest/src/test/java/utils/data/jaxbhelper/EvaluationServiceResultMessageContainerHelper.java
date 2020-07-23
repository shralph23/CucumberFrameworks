package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.EvaluationServiceResultMessageContainer;

public class EvaluationServiceResultMessageContainerHelper {

    public static EvaluationServiceResultMessageContainer getEvaluationServiceResultMessageContainer(
            Properties properties) {
        EvaluationServiceResultMessageContainer evaluationServiceResultMessageContainer = new EvaluationServiceResultMessageContainer();
        evaluationServiceResultMessageContainer.setEvaluationServiceResultMessage(
                EvaluationServiceResultMessageHelper.getEvaluationServiceResultMessage(properties));
        return evaluationServiceResultMessageContainer;
    }
}
