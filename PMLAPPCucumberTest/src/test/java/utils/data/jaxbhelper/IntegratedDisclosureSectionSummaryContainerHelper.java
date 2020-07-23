package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.IntegratedDisclosureSectionSummaryContainer;
import com.freddiemac.datamanager.jaxb.IntegratedDisclosureSubsectionContainer;
import com.freddiemac.datamanager.jaxb.IntegratedDisclosureSubsectionContainers;

public class IntegratedDisclosureSectionSummaryContainerHelper {

    public static IntegratedDisclosureSectionSummaryContainer getIntegratedDisclosureSectionSummaryContainer(
            Properties properties) {
        IntegratedDisclosureSectionSummaryContainer integratedDisclosureSectionSummaryContainer = new IntegratedDisclosureSectionSummaryContainer();
        integratedDisclosureSectionSummaryContainer.setIntegratedDisclosureSectionSummary(
                IntegratedDisclosureSectionSummaryHelper.getIntegratedDisclosureSectionSummary(properties));
        integratedDisclosureSectionSummaryContainer
                .setIntegratedDisclosureSubsectionContainers(getIntegratedDisclosureSubsectionContainers(properties));
        return integratedDisclosureSectionSummaryContainer;
    }

    private static IntegratedDisclosureSubsectionContainers getIntegratedDisclosureSubsectionContainers(
            Properties properties) {
        IntegratedDisclosureSubsectionContainers integratedDisclosureSubsectionContainers = new IntegratedDisclosureSubsectionContainers();
        List<IntegratedDisclosureSubsectionContainer> integratedDisclosureSubsectionContainersList = integratedDisclosureSubsectionContainers
                .getIntegratedDisclosureSubsectionContainer();
        IntegratedDisclosureSubsectionContainer integratedDisclosureSubsectionContainer = IntegratedDisclosureSubsectionContainerHelper
                .getIntegratedDisclosureSubsectionContainer(properties);
        integratedDisclosureSubsectionContainersList.add(integratedDisclosureSubsectionContainer);
        return integratedDisclosureSubsectionContainers;
    }
}
