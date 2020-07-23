package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.AppraisalContainer;
import com.freddiemac.datamanager.jaxb.AppraisalContainers;

import utils.datageneration.payloads.PropertiesUtils;
import utils.generic.TestConstants;

public class AppraisalContainersHelper {

    public static AppraisalContainers getAppraisalContainers(Properties properties) {
        AppraisalContainers appraisalContainers = new AppraisalContainers();
        List<AppraisalContainer> appraisalContainersList = appraisalContainers.getAppraisalContainer();
        if (!PropertiesUtils.getContainerToBeRemoved(properties).equals(TestConstants.APPRAISAL_CONTAINERS)) {
            AppraisalContainer appraisalContainer = AppraisalContainerHelper.getAppraisalContainer(properties);
            appraisalContainersList.add(appraisalContainer);
        }
        return appraisalContainers;
    }
}
