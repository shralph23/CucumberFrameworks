package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.EvaluationServiceResultMessageContainer;
import com.freddiemac.datamanager.jaxb.EvaluationServiceResultMessageContainers;

public class EvaluationServiceResultMessageContainersHelper {

    public static EvaluationServiceResultMessageContainers getEvaluationServiceResultMessageContainers(
            Properties properties) {
        EvaluationServiceResultMessageContainers evaluationServiceResultMessageContainers = new EvaluationServiceResultMessageContainers();
        List<EvaluationServiceResultMessageContainer> evaluationServiceResultMessageContainersList = evaluationServiceResultMessageContainers
                .getEvaluationServiceResultMessageContainer();
        EvaluationServiceResultMessageContainer evaluationServiceResultMessageContainer = EvaluationServiceResultMessageContainerHelper
                .getEvaluationServiceResultMessageContainer(properties);
        evaluationServiceResultMessageContainersList.add(evaluationServiceResultMessageContainer);
        return evaluationServiceResultMessageContainers;
    }

}
