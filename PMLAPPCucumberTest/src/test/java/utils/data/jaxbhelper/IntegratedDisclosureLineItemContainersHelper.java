package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.IntegratedDisclosureLineItemContainer;
import com.freddiemac.datamanager.jaxb.IntegratedDisclosureLineItemContainers;

public class IntegratedDisclosureLineItemContainersHelper {

    public static IntegratedDisclosureLineItemContainers getIntegratedDisclosureLineItemContainers(
            Properties properties) {
        IntegratedDisclosureLineItemContainers integratedDisclosureLineItemContainers = new IntegratedDisclosureLineItemContainers();
        List<IntegratedDisclosureLineItemContainer> integratedDisclosureLineItemContainersList = integratedDisclosureLineItemContainers
                .getIntegratedDisclosureLineItemContainer();
        IntegratedDisclosureLineItemContainer integratedDisclosureLineItemContainer = IntegratedDisclosureLineItemContainerHelper
                .getIntegratedDisclosureLineItemContainer(properties);
        integratedDisclosureLineItemContainersList.add(integratedDisclosureLineItemContainer);
        return integratedDisclosureLineItemContainers;
    }
}
