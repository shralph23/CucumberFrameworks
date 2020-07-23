package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.EvaluationServiceResultDetailContainer;
import com.freddiemac.datamanager.jaxb.EvaluationServiceResultDetailContainers;

public class EvaluationServiceResultDetailContainersHelper {

    public static EvaluationServiceResultDetailContainers getEvaluationServiceForResultsDetailsContainer(
            Properties properties) {
        EvaluationServiceResultDetailContainers evaluationServiceResultDetailContainers = new EvaluationServiceResultDetailContainers();
        List<EvaluationServiceResultDetailContainer> evaluationServiceResultDetailContainersList = evaluationServiceResultDetailContainers
                .getEvaluationServiceResultDetailContainer();
        EvaluationServiceResultDetailContainer evaluationServiceResultDetailContainer = EvaluationServiceResultDetailContainerHelper
                .getEvaluationServiceResultDetailContainer(properties);
        evaluationServiceResultDetailContainersList.add(evaluationServiceResultDetailContainer);
        return evaluationServiceResultDetailContainers;
    }

}
