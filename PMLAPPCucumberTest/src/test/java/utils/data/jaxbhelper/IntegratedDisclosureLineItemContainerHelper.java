package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.IntegratedDisclosureLineItemContainer;

public class IntegratedDisclosureLineItemContainerHelper {

    public static IntegratedDisclosureLineItemContainer getIntegratedDisclosureLineItemContainer(
            Properties properties) {
        IntegratedDisclosureLineItemContainer integratedDisclosureLineItemContainer = new IntegratedDisclosureLineItemContainer();
        integratedDisclosureLineItemContainer
                .setClosingAdjustmentItem(ClosingAdjustmentItemHelper.getClosingAdjustmentItem(properties));
        integratedDisclosureLineItemContainer.setIntegratedDisclosureLineItem(
                IntegratedDisclosureLineItemHelper.getIntegratedDisclosureLineItem(properties));
        integratedDisclosureLineItemContainer.setIntegratedDisclosureSectionSummary(
                IntegratedDisclosureSectionSummaryHelper.getIntegratedDisclosureSectionSummary(properties));
        integratedDisclosureLineItemContainer.setIntegratedDisclosureSubsection(
                IntegratedDisclosureSubsectionHelper.getIntegratedDisclosureSubsection(properties));
        return integratedDisclosureLineItemContainer;
    }
}
