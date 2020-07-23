package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.IntegratedDisclosureSectionSummaryContainer;
import com.freddiemac.datamanager.jaxb.IntegratedDisclosureSectionSummaryContainers;

public class IntegratedDisclosureSectionSummaryContainersHelper {

    public static IntegratedDisclosureSectionSummaryContainers getIntegratedDisclosureSectionSummaryContainers(Properties properties) {
        IntegratedDisclosureSectionSummaryContainers integratedDisclosureSectionSummaryContainers = new IntegratedDisclosureSectionSummaryContainers();
        List<IntegratedDisclosureSectionSummaryContainer> integratedDisclosureSectionSummaryContainersList = integratedDisclosureSectionSummaryContainers
                .getIntegratedDisclosureSectionSummaryContainer();
        IntegratedDisclosureSectionSummaryContainer integratedDisclosureSectionSummaryContainer = IntegratedDisclosureSectionSummaryContainerHelper
                .getIntegratedDisclosureSectionSummaryContainer(properties);
        integratedDisclosureSectionSummaryContainersList.add(integratedDisclosureSectionSummaryContainer);
        return integratedDisclosureSectionSummaryContainers;
    }
}
