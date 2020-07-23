package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransactionContainer;

import utils.datageneration.payloads.PropertiesUtils;

public class PrimaryMarketLoanSubmissionTransactionContainerHelper {

    public static PrimaryMarketLoanSubmissionTransactionContainer getPrimaryMarketLoanSubmissionTransactionContainer(
            Properties properties) {
        PrimaryMarketLoanSubmissionTransactionContainer primaryMarketLoanSubmissionTransactionContainer = new PrimaryMarketLoanSubmissionTransactionContainer();

        String sourceSystem = PropertiesUtils.getPayloadType(properties);
        if (sourceSystem.equalsIgnoreCase("LCAE")) {
            setPayloadContainersforLCAE(primaryMarketLoanSubmissionTransactionContainer, properties);
        } else if (sourceSystem.equalsIgnoreCase("LCLA")) {
            setPayloadContainersforLCLA(primaryMarketLoanSubmissionTransactionContainer, properties);
        } else if (sourceSystem.equalsIgnoreCase("LPA")) {
            setPayloadContainersforLPA(primaryMarketLoanSubmissionTransactionContainer, properties);
        } else if (sourceSystem.equalsIgnoreCase("LQA")) {
            setPayloadContainersforLQA(primaryMarketLoanSubmissionTransactionContainer, properties);
        } else {
            setPayloadForAllContainers(primaryMarketLoanSubmissionTransactionContainer, properties);
        }

        return primaryMarketLoanSubmissionTransactionContainer;
    }

    /**
     * Setting the Payload type that is required for generating the payload XML when the request is sent for LQA Setting
     * up first the common containers along with the unique LQA containers.
     * 
     */
    public static PrimaryMarketLoanSubmissionTransactionContainer setPayloadContainersforLQA(
            PrimaryMarketLoanSubmissionTransactionContainer primaryMarketLoanSubmissionTransactionContainer,
            Properties properties) {
        setPayloadCommonContainers(primaryMarketLoanSubmissionTransactionContainer, properties);
        primaryMarketLoanSubmissionTransactionContainer.setRealEstateProject(null);
        primaryMarketLoanSubmissionTransactionContainer
                .setPropertyValuation(PropertyValuationHelper.getPropertyValuation(properties));
        primaryMarketLoanSubmissionTransactionContainer.setProgram(null);
        primaryMarketLoanSubmissionTransactionContainer.setProductDefinition(null);
        primaryMarketLoanSubmissionTransactionContainer.setLoanPropertyCollateral(null);
        primaryMarketLoanSubmissionTransactionContainer
                .setLoanOrigination(LoanOriginationHelper.getLoanOrignation(properties));
        primaryMarketLoanSubmissionTransactionContainer.setLoanCreditRiskAssessment(null);
        primaryMarketLoanSubmissionTransactionContainer.setLoanAllBorrowerSummary(null);
        primaryMarketLoanSubmissionTransactionContainer
                .setLoanAcquisition(LoanAcquisitionHelper.getLoanAcquisition(properties));
        primaryMarketLoanSubmissionTransactionContainer.setLoan(LoanHelper.getLoan(properties));
        primaryMarketLoanSubmissionTransactionContainer.setAppraisal(AppraisalHelper.getAppraisal(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setLoanUnderwritingCase(LoanUnderwritingCaseHelper.getLoanUnderwritingCase(properties));
        return primaryMarketLoanSubmissionTransactionContainer;
    }

    /**
     * Setting the Payload type that is required for generating the payload XML when the request is sent for LPA Setting
     * up first the common containers along with the unique LPA containers.
     * 
     */
    public static PrimaryMarketLoanSubmissionTransactionContainer setPayloadContainersforLPA(
            PrimaryMarketLoanSubmissionTransactionContainer primaryMarketLoanSubmissionTransactionContainer,
            Properties properties) {
        setPayloadCommonContainers(primaryMarketLoanSubmissionTransactionContainer, properties);
        primaryMarketLoanSubmissionTransactionContainer
                .setLoanUnderwritingCase(LoanUnderwritingCaseHelper.getLoanUnderwritingCase(properties));
        primaryMarketLoanSubmissionTransactionContainer.setPrimaryMarketLoanSubmissionNonBorrowerContainers(
                PrimaryMarketLoanSubmissionNonBorrowerContainersHelpers
                        .getPrimaryMarketLoanSubmissionNonBorrowerContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setPrimaryMarketLoanSubmissionPartyRoleContainers(PrimaryMarketLoanSubmissionPartyRoleContainersHelper
                        .getPrimaryMarketLoanSubmissionPartyRoleContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer.setEvaluationServiceContainers(
                EvaluationServiceContainersHelper.getEvaluationServiceContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer.setPrimaryMarketLoanSubmissionPropertyAddressContainers(
                PrimaryMarketLoanSubmissionPropertyAddressContainersHelper
                        .getPrimaryMarketLoanSubmissionPropertyAddressContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer.setAppraisal(AppraisalHelper.getAppraisal(properties));
        return primaryMarketLoanSubmissionTransactionContainer;
    }

    /**
     * Setting the Payload type that is required for generating the payload XML when the request is sent for LLCA
     * Setting up first the common containers along with the unique LLCA containers.
     * 
     */
    public static PrimaryMarketLoanSubmissionTransactionContainer setPayloadContainersforLCLA(
            PrimaryMarketLoanSubmissionTransactionContainer primaryMarketLoanSubmissionTransactionContainer,
            Properties properties) {
        setPayloadCommonContainers(primaryMarketLoanSubmissionTransactionContainer, properties);
        primaryMarketLoanSubmissionTransactionContainer.setPrimaryMarketLoanSubmissionDocumentGroupContainers(
                PrimaryMarketLoanSubmissionDocumentGroupContainersHelpers
                        .getPrimaryMarketLoanSubmissionDocumentGroupContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setPropertyValuation(PropertyValuationHelper.getPropertyValuation(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setLoanSettlement(LoanSettlementHelper.getLoanSettlement(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setLoanProjectedCashFlows(LoanProjectedCashFlowsHelper.getLoanProjectedCashFlows(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setLoanAcquisition(LoanAcquisitionHelper.getLoanAcquisition(properties));
        primaryMarketLoanSubmissionTransactionContainer.setLoan(LoanHelper.getLoan(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setLateChargeRules(LateChargeRulesHelper.getLateChargeRules(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setIntegratedDisclosure(IntegratedDisclosureHelper.getIntegratedDisclosure(properties));
        primaryMarketLoanSubmissionTransactionContainer.setEvaluationServiceContainers(
                EvaluationServiceContainersHelper.getEvaluationServiceContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setCashToCloseItems(CashToCloseItemsHelper.getCashToCloseItems(properties));
        primaryMarketLoanSubmissionTransactionContainer.setBuydown(BuydownHelper.getBuydown(properties));
        primaryMarketLoanSubmissionTransactionContainer.setAppraisal(AppraisalHelper.getAppraisal(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setLoanUnderwritingCase(LoanUnderwritingCaseHelper.getLoanUnderwritingCase(properties));
        return primaryMarketLoanSubmissionTransactionContainer;
    }

    /**
     * Setting the Payload type that is required for generating the payload XML when the request is sent for LCAE
     * Setting up first the common containers along with the unique LCAE containers.
     * 
     */
    public static PrimaryMarketLoanSubmissionTransactionContainer setPayloadContainersforLCAE(
            PrimaryMarketLoanSubmissionTransactionContainer primaryMarketLoanSubmissionTransactionContainer,
            Properties properties) {
        setPayloadCommonContainers(primaryMarketLoanSubmissionTransactionContainer, properties);
        primaryMarketLoanSubmissionTransactionContainer.setEvaluationServiceContainers(
                EvaluationServiceContainersHelper.getEvaluationServiceContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer.setLoan(LoanHelper.getLoan(properties));
        primaryMarketLoanSubmissionTransactionContainer.setPrimaryMarketLoanSubmissionPropertyAddressContainers(
                PrimaryMarketLoanSubmissionPropertyAddressContainersHelper
                        .getPrimaryMarketLoanSubmissionPropertyAddressContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer.setAppraisal(AppraisalHelper.getAppraisal(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setPrimaryMarketLoanSubmissionCollateralRiskAssessmentContainers(
                        PrimaryMarketLoanSubmissionCollateralRiskAssessmentContainersHelper
                                .getPrimaryMarketLoanSubmissionCollateralRiskAssessmentContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setPrimaryMarketLoanSubmissionContractContainers(PrimaryMarketLoanSubmissionContractContainersHelper
                        .getPrimaryMarketLoanSubmissionContractContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer.setBuydown(BuydownHelper.getBuydown(properties));
        return primaryMarketLoanSubmissionTransactionContainer;
    }

    /**
     * Setting the Payload type that is required for generating the payload XML when the request is sent anything other
     * than the four defined source system
     * 
     * Setting up first the common containers along with the unique LCAE containers.
     * 
     */
    public static PrimaryMarketLoanSubmissionTransactionContainer setPayloadForAllContainers(
            PrimaryMarketLoanSubmissionTransactionContainer primaryMarketLoanSubmissionTransactionContainer,
            Properties properties) {
        setPayloadCommonContainers(primaryMarketLoanSubmissionTransactionContainer, properties);
        primaryMarketLoanSubmissionTransactionContainer
                .setPrimaryMarketLoanSubmissionContractContainers(PrimaryMarketLoanSubmissionContractContainersHelper
                        .getPrimaryMarketLoanSubmissionContractContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setPrimaryMarketLoanSubmissionCollateralRiskAssessmentContainers(
                        PrimaryMarketLoanSubmissionCollateralRiskAssessmentContainersHelper
                                .getPrimaryMarketLoanSubmissionCollateralRiskAssessmentContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer.setRealEstateProject(null);
        primaryMarketLoanSubmissionTransactionContainer
                .setPropertyValuation(PropertyValuationHelper.getPropertyValuation(properties));
        primaryMarketLoanSubmissionTransactionContainer.setProgram(null);
        primaryMarketLoanSubmissionTransactionContainer.setProductDefinition(null);
        primaryMarketLoanSubmissionTransactionContainer.setLoanPropertyCollateral(null);
        primaryMarketLoanSubmissionTransactionContainer
                .setLoanOrigination(LoanOriginationHelper.getLoanOrignation(properties));
        primaryMarketLoanSubmissionTransactionContainer.setLoanCreditRiskAssessment(null);
        primaryMarketLoanSubmissionTransactionContainer.setLoanAllBorrowerSummary(null);
        primaryMarketLoanSubmissionTransactionContainer
                .setLoanUnderwritingCase(LoanUnderwritingCaseHelper.getLoanUnderwritingCase(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setPrimaryMarketLoanSubmissionPartyRoleContainers(PrimaryMarketLoanSubmissionPartyRoleContainersHelper
                        .getPrimaryMarketLoanSubmissionPartyRoleContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer.setPrimaryMarketLoanSubmissionNonBorrowerContainers(
                PrimaryMarketLoanSubmissionNonBorrowerContainersHelpers
                        .getPrimaryMarketLoanSubmissionNonBorrowerContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer.setPrimaryMarketLoanSubmissionPropertyAddressContainers(
                PrimaryMarketLoanSubmissionPropertyAddressContainersHelper
                        .getPrimaryMarketLoanSubmissionPropertyAddressContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer.setAppraisal(AppraisalHelper.getAppraisal(properties));
        primaryMarketLoanSubmissionTransactionContainer.setPrimaryMarketLoanSubmissionDocumentGroupContainers(
                PrimaryMarketLoanSubmissionDocumentGroupContainersHelpers
                        .getPrimaryMarketLoanSubmissionDocumentGroupContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setLoanSettlement(LoanSettlementHelper.getLoanSettlement(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setLoanProjectedCashFlows(LoanProjectedCashFlowsHelper.getLoanProjectedCashFlows(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setLoanAcquisition(LoanAcquisitionHelper.getLoanAcquisition(properties));
        primaryMarketLoanSubmissionTransactionContainer.setLoan(LoanHelper.getLoan(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setLateChargeRules(LateChargeRulesHelper.getLateChargeRules(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setIntegratedDisclosure(IntegratedDisclosureHelper.getIntegratedDisclosure(properties));
        primaryMarketLoanSubmissionTransactionContainer.setEvaluationServiceContainers(
                EvaluationServiceContainersHelper.getEvaluationServiceContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setCashToCloseItems(CashToCloseItemsHelper.getCashToCloseItems(properties));
        primaryMarketLoanSubmissionTransactionContainer.setBuydown(BuydownHelper.getBuydown(properties));
        return primaryMarketLoanSubmissionTransactionContainer;
    }

    /**
     * Setting the Payload which is common for all the common containers.
     */
    private static PrimaryMarketLoanSubmissionTransactionContainer setPayloadCommonContainers(
            PrimaryMarketLoanSubmissionTransactionContainer primaryMarketLoanSubmissionTransactionContainer,
            Properties properties) {
        primaryMarketLoanSubmissionTransactionContainer
                .setIntegratedDisclosureSectionSummaryContainers(IntegratedDisclosureSectionSummaryContainersHelper
                        .getIntegratedDisclosureSectionSummaryContainers(properties));
        primaryMarketLoanSubmissionTransactionContainer.setLoanDocument(LoanDocumentHelper.getLoanDocument(properties));
        primaryMarketLoanSubmissionTransactionContainer.setPrimaryMarketLoanSubmissionTransaction(
                PrimaryMarketLoanSubmissionTransactionHelper.getPrimaryMarketLoanSubmissionTransaction(properties));
        primaryMarketLoanSubmissionTransactionContainer
                .setPrimaryMarketLoanSubmissionPartyRoleContainers(PrimaryMarketLoanSubmissionPartyRoleContainersHelper
                        .getPrimaryMarketLoanSubmissionPartyRoleContainers(properties));
        return primaryMarketLoanSubmissionTransactionContainer;

    }
}
