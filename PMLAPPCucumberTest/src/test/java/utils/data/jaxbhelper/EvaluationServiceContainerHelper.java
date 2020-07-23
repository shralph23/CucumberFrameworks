package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.EvaluationServiceContainer;

public class EvaluationServiceContainerHelper {

    public static EvaluationServiceContainer getEvaluationServiceContainer(Properties properties) {
        EvaluationServiceContainer evaluationServiceContainer = new EvaluationServiceContainer();
        evaluationServiceContainer.setEvaluationService(EvaluationServiceHelper.getEvaluationService(properties));
        evaluationServiceContainer
                .setEvaluationServiceResultDetailContainers(EvaluationServiceResultDetailContainersHelper
                        .getEvaluationServiceForResultsDetailsContainer(properties));
        return evaluationServiceContainer;
    }
}
