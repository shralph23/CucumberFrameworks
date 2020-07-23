package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.EvaluationServiceContainer;
import com.freddiemac.datamanager.jaxb.EvaluationServiceContainers;

public class EvaluationServiceContainersHelper {

    public static EvaluationServiceContainers getEvaluationServiceContainers(Properties properties) {
        EvaluationServiceContainers evaluationServiceContainers = new EvaluationServiceContainers();
        List<EvaluationServiceContainer> evaluationServiceContainerList = evaluationServiceContainers
                .getEvaluationServiceContainer();
        EvaluationServiceContainer evaluationServiceContainer = EvaluationServiceContainerHelper
                .getEvaluationServiceContainer(properties);
        evaluationServiceContainerList.add(evaluationServiceContainer);
        return evaluationServiceContainers;
    }
}
