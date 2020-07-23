package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.IntegratedDisclosureSubsectionPaymentContainer;

public class IntegratedDisclosureSubsectionPaymentContainerHelper {

    public static IntegratedDisclosureSubsectionPaymentContainer getIntegratedDisclosureSubsectionPaymentContainer(
            Properties properties) {
        IntegratedDisclosureSubsectionPaymentContainer integratedDisclosureSubsectionPaymentContainer = new IntegratedDisclosureSubsectionPaymentContainer();
        integratedDisclosureSubsectionPaymentContainer.setIntegratedDisclosureSectionSummary(
                IntegratedDisclosureSectionSummaryHelper.getIntegratedDisclosureSectionSummary(properties));
        integratedDisclosureSubsectionPaymentContainer.setIntegratedDisclosureSubsection(
                IntegratedDisclosureSubsectionHelper.getIntegratedDisclosureSubsection(properties));
        integratedDisclosureSubsectionPaymentContainer.setIntegratedDisclosureSubsectionPayment(
                IntegratedDisclosureSubsectionPaymentHelper.getIntegratedDisclosureSubsectionPayment(properties));
        return integratedDisclosureSubsectionPaymentContainer;
    }
}
