package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.IntegratedDisclosureSubsectionPaymentContainer;
import com.freddiemac.datamanager.jaxb.IntegratedDisclosureSubsectionPaymentContainers;

public class IntegratedDisclosureSubsectionPaymentContainersHelper {

    public static IntegratedDisclosureSubsectionPaymentContainers getIntegratedDisclosureSubsectionPaymentContainers(
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
