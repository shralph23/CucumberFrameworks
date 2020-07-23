package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.AppraisalContainer;

import utils.datageneration.payloads.PropertiesUtils;
import utils.generic.TestConstants;

public class AppraisalContainerHelper {

	public static AppraisalContainer getAppraisalContainer(Properties properties) {
		AppraisalContainer appraisalContainer = new AppraisalContainer();
		if (!PropertiesUtils.getContainerToBeRemoved(properties).equals(TestConstants.APPRAISAL_CONTAINER)) {
			appraisalContainer.setPropertyValuation(
					PropertyValuationForAppraisalContainerHelper.getPropertyValuation(properties));
			appraisalContainer.setPropertyValuationAssessment(
					PropertyValuationAssessmentHelper.getPropertyValuationAssessment(properties));
			appraisalContainer
					.setAppraisal(AppraisalHelperForAppraisalContainers.getAppraisalforAppraisalContainers(properties));
		}
		return appraisalContainer;
	}
}
