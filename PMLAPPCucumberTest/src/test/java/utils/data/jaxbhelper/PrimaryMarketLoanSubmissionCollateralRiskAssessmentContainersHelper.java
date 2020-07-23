package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionCollateralRiskAssessmentContainer;
import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionCollateralRiskAssessmentContainers;

import utils.datageneration.payloads.PropertiesUtils;
import utils.generic.TestConstants;

public class PrimaryMarketLoanSubmissionCollateralRiskAssessmentContainersHelper {

    public static PrimaryMarketLoanSubmissionCollateralRiskAssessmentContainers getPrimaryMarketLoanSubmissionCollateralRiskAssessmentContainers(
            Properties properties) {
        PrimaryMarketLoanSubmissionCollateralRiskAssessmentContainers primaryMarketLoanSubmissionCollateralRiskAssessmentContainers = new PrimaryMarketLoanSubmissionCollateralRiskAssessmentContainers();
        List<PrimaryMarketLoanSubmissionCollateralRiskAssessmentContainer> primaryMarketLoanSubmissionCollateralRiskAssessmentContainerList = primaryMarketLoanSubmissionCollateralRiskAssessmentContainers
                .getPrimaryMarketLoanSubmissionCollateralRiskAssessmentContainer();
        if (!PropertiesUtils.getContainerToBeRemoved(properties).equals(TestConstants.LOAN_COLLATERAL_RISK_ASSESSMENT)) {
            PrimaryMarketLoanSubmissionCollateralRiskAssessmentContainer primaryMarketLoanSubmissionCollateralRiskAssessmentContainer = PrimaryMarketLoanSubmissionCollateralRiskAssessmentContainerHelper
                    .getPrimaryMarketLoanSubmissionCollateralRiskAssessmentContainer(properties);
            primaryMarketLoanSubmissionCollateralRiskAssessmentContainerList
                    .add(primaryMarketLoanSubmissionCollateralRiskAssessmentContainer);
        }
        return primaryMarketLoanSubmissionCollateralRiskAssessmentContainers;
    }

}
