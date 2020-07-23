package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.IntegratedDisclosureSubsectionContainer;
import com.freddiemac.datamanager.jaxb.IntegratedDisclosureSubsectionPaymentContainer;
import com.freddiemac.datamanager.jaxb.IntegratedDisclosureSubsectionPaymentContainers;

public class IntegratedDisclosureSubsectionContainerHelper {

    public static IntegratedDisclosureSubsectionContainer getIntegratedDisclosureSubsectionContainer(
            Properties properties) {
        IntegratedDisclosureSubsectionContainer integratedDisclosureSubsectionContainer = new IntegratedDisclosureSubsectionContainer();
        integratedDisclosureSubsectionContainer.setIntegratedDisclosureSectionSummary(
                IntegratedDisclosureSectionSummaryHelper.getIntegratedDisclosureSectionSummary(properties));
        integratedDisclosureSubsectionContainer.setIntegratedDisclosureSubsection(
                IntegratedDisclosureSubsectionHelper.getIntegratedDisclosureSubsection(properties));
        integratedDisclosureSubsectionContainer.setIntegratedDisclosureSubsectionPaymentContainers(
                getIntegratedDisclosureSubsectionPaymentContainers(properties));
        integratedDisclosureSubsectionContainer.setIntegratedDisclosureLineItemContainers(
                IntegratedDisclosureLineItemContainersHelper.getIntegratedDisclosureLineItemContainers(properties));
        return integratedDisclosureSubsectionContainer;
    }

    private static IntegratedDisclosureSubsectionPaymentContainers getIntegratedDisclosureSubsectionPaymentContainers(
            Properties properties) {
        IntegratedDisclosureSubsectionPaymentContainers integratedDisclosureSubsectionPaymentContainers = new IntegratedDisclosureSubsectionPaymentContainers();
        List<IntegratedDisclosureSubsectionPaymentContainer> integratedDisclosureSubsectionPaymentContainersList = integratedDisclosureSubsectionPaymentContainers
                .getIntegratedDisclosureSubsectionPaymentContainer();
        IntegratedDisclosureSubsectionPaymentContainer integratedDisclosureSubsectionPaymentContainer = IntegratedDisclosureSubsectionPaymentContainerHelper
                .getIntegratedDisclosureSubsectionPaymentContainer(properties);
        integratedDisclosureSubsectionPaymentContainersList.add(integratedDisclosureSubsectionPaymentContainer);
        return integratedDisclosureSubsectionPaymentContainers;
    }
}
