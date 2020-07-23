package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionCollateralRiskAssessmentContainer;

public class PrimaryMarketLoanSubmissionCollateralRiskAssessmentContainerHelper {

    public static PrimaryMarketLoanSubmissionCollateralRiskAssessmentContainer getPrimaryMarketLoanSubmissionCollateralRiskAssessmentContainer(
            Properties properties) {
        PrimaryMarketLoanSubmissionCollateralRiskAssessmentContainer primaryMarketLoanSubmissionCollateralRiskAssessmentContainer = new PrimaryMarketLoanSubmissionCollateralRiskAssessmentContainer();
        primaryMarketLoanSubmissionCollateralRiskAssessmentContainer.setLoanCollateralRiskAssessment(
                LoanCollateralRiskAssessmentHelper.getLoanCollateralRiskAssessment(properties));
        return primaryMarketLoanSubmissionCollateralRiskAssessmentContainer;
    }
}
