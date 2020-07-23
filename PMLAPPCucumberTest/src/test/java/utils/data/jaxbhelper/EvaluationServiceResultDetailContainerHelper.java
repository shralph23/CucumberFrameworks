package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.EvaluationServiceResultDetailContainer;

public class EvaluationServiceResultDetailContainerHelper {

    public static EvaluationServiceResultDetailContainer getEvaluationServiceResultDetailContainer(
            Properties properties) {
        EvaluationServiceResultDetailContainer evaluationServiceResultDetailContainer = new EvaluationServiceResultDetailContainer();
        evaluationServiceResultDetailContainer.setEvaluationServiceResultDetail(
                EvaluationServiceResultDetailHelper.getEvaluationServiceResultDetail(properties));
        evaluationServiceResultDetailContainer.setEvaluationServiceResultMessageContainers(
                EvaluationServiceResultMessageContainersHelper.getEvaluationServiceResultMessageContainers(properties));
        return evaluationServiceResultDetailContainer;
    }
}
