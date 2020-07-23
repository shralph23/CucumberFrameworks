package utils.data.validation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.junit.Assert;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionBatchContainer;

import utils.data.extractioncontainers.AddressContainer;
import utils.data.extractioncontainers.AppraisalContainer;
import utils.data.extractioncontainers.ApprslContainer;
import utils.data.extractioncontainers.BuydownContainer;
import utils.data.extractioncontainers.CashToCloseItemContainer;
import utils.data.extractioncontainers.ContractContainer;
import utils.data.extractioncontainers.DocumentContainer;
import utils.data.extractioncontainers.DocumentGroupContainer;
import utils.data.extractioncontainers.DocumentStatusContainer;
import utils.data.extractioncontainers.EvaluationServiceContainer;
import utils.data.extractioncontainers.EvaluationServiceResultDetailContainer;
import utils.data.extractioncontainers.EvaluationServiceResultMessageContainer;
import utils.data.extractioncontainers.IntegratedDisclosureContainer;
import utils.data.extractioncontainers.LateChargeRuleContainer;
import utils.data.extractioncontainers.LoanAcquisitionContainer;
import utils.data.extractioncontainers.LoanCollateralRiskAssessmentContainer;
import utils.data.extractioncontainers.LoanContainer;
import utils.data.extractioncontainers.LoanDocumentContainer;
import utils.data.extractioncontainers.LoanOriginationContainer;
import utils.data.extractioncontainers.LoanProjectedCashFlowContainer;
import utils.data.extractioncontainers.PartyRoleContainer;
import utils.data.extractioncontainers.PrimaryMarketLoanSubmissionPartyLicenseContainer;
import utils.data.extractioncontainers.PrimaryMarketLoanSubmissionTransactionContainer;
import utils.data.extractioncontainers.PropertyValuationApprslContainer;
import utils.data.extractioncontainers.PropertyValuationAssessmentContainer;
import utils.data.extractioncontainers.PropertyValuationContainer;
import utils.data.extractioncontainers.SellerAccountContainer;
import utils.data.extractioncontainers.SellerUserContainer;
import utils.db.DatabaseQueries;
import utils.db.PmlTestDao;

public class PayloadValidation {

    private static void validatePartyRoleContainers(String slsId, PmlTestDao dao,
            com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransactionContainer p) {
        // PartyRole
        List<com.freddiemac.datamanager.jaxb.PartyRole> partyRoleList = new ArrayList<>();
        if (p.getPrimaryMarketLoanSubmissionPartyRoleContainers() != null) {
            p.getPrimaryMarketLoanSubmissionPartyRoleContainers().getPrimaryMarketLoanSubmissionPartyRoleContainer()
                    .forEach(e -> partyRoleList.add(e.getPartyRole()));
        }
        if (p.getPrimaryMarketLoanSubmissionNonBorrowerContainers() != null) {
            p.getPrimaryMarketLoanSubmissionNonBorrowerContainers().getPrimaryMarketLoanSubmissionNonBorrowerContainer()
                    .forEach(e -> {
                        // Don't add the party containers that are the same from other containers
                        if (partyRoleList.stream()
                                .noneMatch(pe -> pe.getPartyIdentifier().equals(e.getPartyRole().getPartyIdentifier())
                                        && pe.getPartyRoleType().equals(e.getPartyRole().getPartyRoleType()))) {
                            partyRoleList.add(e.getPartyRole());
                        }
                    });
        }
        Assert.assertTrue("PartyRole is not equal", ContainerValidation.validateContainers(slsId, dao,
                new PartyRoleContainer(), DatabaseQueries.PARTY_ROLE_QUERY, partyRoleList));
    }

    private static void validateEvaluationServiceResultDetailContainers(String slsId, PmlTestDao dao,
            com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransactionContainer p) {
        // EvaluationServiceResultDetail
        List<com.freddiemac.datamanager.jaxb.EvaluationServiceResultDetail> evaluationServiceResultDetailList = new ArrayList<>();
        if (p.getEvaluationServiceContainers() != null) {
            p.getEvaluationServiceContainers().getEvaluationServiceContainer().forEach(e -> {
                e.getEvaluationServiceResultDetailContainers().getEvaluationServiceResultDetailContainer()
                        .forEach(es -> {
                            evaluationServiceResultDetailList.add(es.getEvaluationServiceResultDetail());
                        });
            });
        }
        Assert.assertTrue("EvaluationServiceResultDetails is not equal",
                ContainerValidation.validateContainers(slsId, dao, new EvaluationServiceResultDetailContainer(),
                        DatabaseQueries.EVALUATION_SERVICE_RESULT_DETAIL_QUERY, evaluationServiceResultDetailList));
    }

    private static void validateAddressContainers(String slsId, PmlTestDao dao,
            com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransactionContainer p) {
        // Address
        List<com.freddiemac.datamanager.jaxb.Address> addressList = new ArrayList<>();
        if (p.getPrimaryMarketLoanSubmissionPropertyAddressContainers() != null) {
            p.getPrimaryMarketLoanSubmissionPropertyAddressContainers()
                    .getPrimaryMarketLoanSubmissionPropertyAddressContainer()
                    .forEach(e -> addressList.add(e.getAddress()));
        }
        Assert.assertTrue("AddressContainers is not equal",
                ContainerValidation.validateContainers(slsId, dao, new AddressContainer(),
                        DatabaseQueries.PRIMARY_MARKET_LOAN_SUBMISSION_PROPERTY_ADDRESS_QUERY, addressList));
    }

    private static void validateEvaluationServiceContainers(String slsId, PmlTestDao dao,
            com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransactionContainer p) {
        // EvaluationService
        List<com.freddiemac.datamanager.jaxb.EvaluationService> evaluationServiceList = new ArrayList<>();
        if (p.getEvaluationServiceContainers() != null) {
            p.getEvaluationServiceContainers().getEvaluationServiceContainer().forEach(e -> {
                evaluationServiceList.add(e.getEvaluationService());
            });
        }
        Assert.assertTrue("EvaluationServices is not equal", ContainerValidation.validateContainers(slsId, dao,
                new EvaluationServiceContainer(), DatabaseQueries.EVALUATION_SERVICE_QUERY, evaluationServiceList));
    }

    private static void validateDocumentGroupContainers(String slsId, PmlTestDao dao,
            com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransactionContainer p) {
        // DocumentGroup
        List<com.freddiemac.datamanager.jaxb.DocumentGroup> documentGroupList = new ArrayList<>();
        if (p.getPrimaryMarketLoanSubmissionDocumentGroupContainers() != null) {
            p.getPrimaryMarketLoanSubmissionDocumentGroupContainers()
                    .getPrimaryMarketLoanSubmissionDocumentGroupContainer()
                    .forEach(e -> documentGroupList.add(e.getDocumentGroup()));
        }
        Assert.assertTrue("DocumentGroup is not equal", ContainerValidation.validateContainers(slsId, dao,
                new DocumentGroupContainer(), DatabaseQueries.DOCUMENT_GROUP_QUERY, documentGroupList));
    }

    private static void validatePropertyValuationAssessmentContainers(String slsId, PmlTestDao dao,
            com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransactionContainer p) {
        // PropertyValuationAssessment
        List<com.freddiemac.datamanager.jaxb.PropertyValuationAssessment> propertyValuationAssessmentList = new ArrayList<>();
        p.getPrimaryMarketLoanSubmissionPropertyAddressContainers()
                .getPrimaryMarketLoanSubmissionPropertyAddressContainer().forEach(e -> {
                    e.getAppraisalContainers().getAppraisalContainer().forEach(es -> {
                        propertyValuationAssessmentList.add(es.getPropertyValuationAssessment());
                    });
                });
        Assert.assertTrue("PropertyValuationAssessmentAppraisalContainer is not equal",
                ContainerValidation.validateContainers(slsId, dao, new PropertyValuationAssessmentContainer(),
                        DatabaseQueries.PROPERTY_VALUATION_ASSESSMENT_APPRAISAL_QUERY,
                        propertyValuationAssessmentList));
    }

    private static void validatePropertyValuationApprslContainers(String slsId, PmlTestDao dao,
            com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransactionContainer p) {
        // PropertyValuation
        List<com.freddiemac.datamanager.jaxb.PropertyValuation> propertyValuationList = new ArrayList<>();
        p.getPrimaryMarketLoanSubmissionPropertyAddressContainers()
                .getPrimaryMarketLoanSubmissionPropertyAddressContainer().forEach(e -> {
                    e.getAppraisalContainers().getAppraisalContainer().forEach(es -> {
                        propertyValuationList.add(es.getPropertyValuation());
                    });
                });
        Assert.assertTrue("PropertyValuationApprslContainer is not equal",
                ContainerValidation.validateContainers(slsId, dao, new PropertyValuationApprslContainer(),
                        DatabaseQueries.PROPERTY_VALUATION_APPRAISAL_QUERY, propertyValuationList));
    }

    private static void validateAppraisalContainers(String slsId, PmlTestDao dao,
            com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransactionContainer p) {
        // Appraisal
        List<com.freddiemac.datamanager.jaxb.Appraisal> appraisalList = new ArrayList<>();
        p.getPrimaryMarketLoanSubmissionPropertyAddressContainers()
                .getPrimaryMarketLoanSubmissionPropertyAddressContainer().forEach(e -> {
                    e.getAppraisalContainers().getAppraisalContainer().forEach(es -> {
                        appraisalList.add(es.getAppraisal());
                    });
                });
        Assert.assertTrue("AppraisalContainers is not equal", ContainerValidation.validateContainers(slsId, dao,
                new AppraisalContainer(), DatabaseQueries.APPRSL_QUERY, appraisalList));
    }

    private static void validateLateChargeRuleContainers(String slsId, PmlTestDao dao,
            com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransactionContainer p) {
        // LateChargeRule
        List<com.freddiemac.datamanager.jaxb.LateChargeRule> lateChargeRuleList = new ArrayList<>();
        if (p.getLateChargeRules() != null) {
            lateChargeRuleList.addAll(p.getLateChargeRules().getLateChargeRule());
        }
        Assert.assertTrue("LateChargeRule is not equal", ContainerValidation.validateContainers(slsId, dao,
                new LateChargeRuleContainer(), DatabaseQueries.lATE_CHARGE_RULE_QUERY, lateChargeRuleList));
    }

    private static void validateCashToCloseItemContainers(String slsId, PmlTestDao dao,
            com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransactionContainer p) {
        // CashToCloseItem
        List<com.freddiemac.datamanager.jaxb.CashToCloseItem> cashToCloseItemList = new ArrayList<>();
        if (p.getCashToCloseItems() != null) {
            cashToCloseItemList.addAll(p.getCashToCloseItems().getCashToCloseItem());
        }
        Assert.assertTrue("CashToCloseItem is not equal", ContainerValidation.validateContainers(slsId, dao,
                new CashToCloseItemContainer(), DatabaseQueries.CASH_TO_CLOSE_ITEM_QUERY, cashToCloseItemList));
    }

    private static void validateCommonContainers(String slsId, PmlTestDao dao,
            com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransactionContainer p,
            JAXBElement<PrimaryMarketLoanSubmissionBatchContainer> pmlBatchContainer) {
        Assert.assertTrue("LoanDocumentContainer is not equal",
                ContainerValidation.validateContainers(slsId, dao, new LoanDocumentContainer(),
                        DatabaseQueries.PRIMARY_MARKET_LOAN_SUBMISSION_TRANSACTION_QUERY, p.getLoanDocument()));
        Assert.assertTrue("AppraisalContainer is not equal",
                ContainerValidation.validateContainers(slsId, dao, new ApprslContainer(),
                        DatabaseQueries.PRIMARY_MARKET_LOAN_SUBMISSION_TRANSACTION_QUERY, p.getAppraisal()));
        Assert.assertTrue("PrimaryMarketLoanSubmissionTransactionContainer is not equal",
                ContainerValidation.validateContainers(slsId, dao,
                        new PrimaryMarketLoanSubmissionTransactionContainer(),
                        DatabaseQueries.PRIMARY_MARKET_LOAN_SUBMISSION_TRANSACTION_QUERY,
                        p.getPrimaryMarketLoanSubmissionTransaction()));
        validatePartyRoleContainers(slsId, dao, p);
        Assert.assertTrue("MetaData is not validated", ContainerValidation.validateMetaDataContainer(slsId, dao));
        Assert.assertTrue("SellerAccount is not equal",
                ContainerValidation.validateContainers(slsId, dao, new SellerAccountContainer(),
                        DatabaseQueries.SELLER_ACCOUNT_QUERY, pmlBatchContainer.getValue().getSellerAccount()));
        Assert.assertTrue("SellerUser is not equal",
                ContainerValidation.validateContainers(slsId, dao, new SellerUserContainer(),
                        DatabaseQueries.SELLER_USER_QUERY, pmlBatchContainer.getValue().getSellerUser()));

        // EvaluationServiceResultMessage
        List<com.freddiemac.datamanager.jaxb.EvaluationServiceResultMessage> evaluationServiceResultMessageList = new ArrayList<>();
        if (p.getEvaluationServiceContainers() != null) {
            p.getEvaluationServiceContainers().getEvaluationServiceContainer().forEach(e -> {
                e.getEvaluationServiceResultDetailContainers().getEvaluationServiceResultDetailContainer()
                        .forEach(es -> {
                            es.getEvaluationServiceResultMessageContainers()
                                    .getEvaluationServiceResultMessageContainer().forEach(esm -> {
                                        evaluationServiceResultMessageList.add(esm.getEvaluationServiceResultMessage());
                                    });
                        });
            });
        }
        Assert.assertTrue("EvaluationResultMessages is not equal",
                ContainerValidation.validateContainers(slsId, dao, new EvaluationServiceResultMessageContainer(),
                        DatabaseQueries.EVALUATION_SERVICE_RESULT_MESSAGE_QUERY, evaluationServiceResultMessageList));

        // PrimaryMarketLoanSubmissionPartyLicense
        List<com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionPartyLicense> pmlLicenseContainerList = new ArrayList<>();
        p.getPrimaryMarketLoanSubmissionPartyRoleContainers().getPrimaryMarketLoanSubmissionPartyRoleContainer()
                .forEach(e -> {
                    e.getPrimaryMarketLoanSubmissionPartyLicenseContainers()
                            .getPrimaryMarketLoanSubmissionPartyLicenseContainer().forEach(es -> {
                                pmlLicenseContainerList.add(es.getPrimaryMarketLoanSubmissionPartyLicense());
                            });
                    ;
                });
        Assert.assertTrue("PrimaryMarketLoanSubmissionPartyLicense is not equal",
                ContainerValidation.validateContainers(slsId, dao,
                        new PrimaryMarketLoanSubmissionPartyLicenseContainer(), DatabaseQueries.PARTY_LICENSE_QUERY,
                        pmlLicenseContainerList));

    }

    public static void validateLCLA(String slsId, PmlTestDao dao,
            JAXBElement<PrimaryMarketLoanSubmissionBatchContainer> pmlBatchContainer) {
        com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransactionContainer p = pmlBatchContainer.getValue()
                .getPrimaryMarketLoanSubmissionTransactionContainer();

        Assert.assertTrue("LoanContainer is not equal", ContainerValidation.validateContainers(slsId, dao,
                new LoanContainer(), DatabaseQueries.PRIMARY_MARKET_LOAN_SUBMISSION_TRANSACTION_QUERY, p.getLoan()));
        Assert.assertTrue("BuydownContainer is not equal",
                ContainerValidation.validateContainers(slsId, dao, new BuydownContainer(),
                        DatabaseQueries.PRIMARY_MARKET_LOAN_SUBMISSION_TRANSACTION_QUERY, p.getBuydown()));
        Assert.assertTrue("IntegratedDisclosureContainer is not equal",
                ContainerValidation.validateContainers(slsId, dao, new IntegratedDisclosureContainer(),
                        DatabaseQueries.PRIMARY_MARKET_LOAN_SUBMISSION_TRANSACTION_QUERY, p.getIntegratedDisclosure()));
        Assert.assertTrue("LoanAcquisitionContainer is not equal",
                ContainerValidation.validateContainers(slsId, dao, new LoanAcquisitionContainer(),
                        DatabaseQueries.PRIMARY_MARKET_LOAN_SUBMISSION_TRANSACTION_QUERY, p.getLoanAcquisition()));
        Assert.assertTrue("LoanProjectedCashFlow is not equal",
                ContainerValidation.validateContainers(slsId, dao, new LoanProjectedCashFlowContainer(),
                        DatabaseQueries.LOAN_PROJECTED_CASH_FLOW_QUERY,
                        p.getLoanProjectedCashFlows().getLoanProjectedCashFlow()));
        Assert.assertTrue("PropertyValuationContainers is not equal", ContainerValidation.validateContainers(slsId, dao,
                new PropertyValuationContainer(), DatabaseQueries.PROPERTY_VALUATION_QUERY, p.getPropertyValuation()));
        validateCommonContainers(slsId, dao, p, pmlBatchContainer);
        validateEvaluationServiceContainers(slsId, dao, p);
        validateEvaluationServiceResultDetailContainers(slsId, dao, p);
        validateCashToCloseItemContainers(slsId, dao, p);
        validateLateChargeRuleContainers(slsId, dao, p);
        validateDocumentGroupContainers(slsId, dao, p);

        // DocumentStatus
        List<com.freddiemac.datamanager.jaxb.DocumentStatus> documentStatusList = new ArrayList<>();
        p.getPrimaryMarketLoanSubmissionDocumentGroupContainers().getPrimaryMarketLoanSubmissionDocumentGroupContainer()
                .forEach(e -> {
                    e.getPrimaryMarketLoanSubmissionDocumentDetailContainers()
                            .getPrimaryMarketLoanSubmissionDocumentDetailContainer().forEach(es -> {
                                documentStatusList.add(es.getDocumentStatus());
                            });
                });
        Assert.assertTrue("DocumentStatus is not equal", ContainerValidation.validateContainers(slsId, dao,
                new DocumentStatusContainer(), DatabaseQueries.DOCUMENT_DETAIL_QUERY, documentStatusList));

        // Document
        List<com.freddiemac.datamanager.jaxb.Document> documentList = new ArrayList<>();
        p.getPrimaryMarketLoanSubmissionDocumentGroupContainers().getPrimaryMarketLoanSubmissionDocumentGroupContainer()
                .forEach(e -> {
                    e.getPrimaryMarketLoanSubmissionDocumentDetailContainers()
                            .getPrimaryMarketLoanSubmissionDocumentDetailContainer().forEach(es -> {
                                documentList.add(es.getDocument());
                            });
                });
        Assert.assertTrue("Document is not equal", ContainerValidation.validateContainers(slsId, dao,
                new DocumentContainer(), DatabaseQueries.DOCUMENT_DETAIL_QUERY, documentList));
    }

    public static void validateLQA(String slsId, PmlTestDao dao,
            JAXBElement<PrimaryMarketLoanSubmissionBatchContainer> pmlBatchContainer) {
        com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransactionContainer p = pmlBatchContainer.getValue()
                .getPrimaryMarketLoanSubmissionTransactionContainer();

        Assert.assertTrue("LoanContainer is not equal", ContainerValidation.validateContainers(slsId, dao,
                new LoanContainer(), DatabaseQueries.PRIMARY_MARKET_LOAN_SUBMISSION_TRANSACTION_QUERY, p.getLoan()));
        // TODO : review interaction between DB
        Assert.assertTrue("BuydownContainer is not equal",
                ContainerValidation.validateContainers(slsId, dao, new BuydownContainer(),
                        DatabaseQueries.PRIMARY_MARKET_LOAN_SUBMISSION_TRANSACTION_QUERY, p.getBuydown()));
        // TODO : review interaction between DB, perhaps similar situation than BuydownContainer
        Assert.assertTrue("IntegratedDisclosureContainer is not equal",
                ContainerValidation.validateContainers(slsId, dao, new IntegratedDisclosureContainer(),
                        DatabaseQueries.PRIMARY_MARKET_LOAN_SUBMISSION_TRANSACTION_QUERY, p.getIntegratedDisclosure()));
        Assert.assertTrue("LoanAcquisitionContainer is not equal",
                ContainerValidation.validateContainers(slsId, dao, new LoanAcquisitionContainer(),
                        DatabaseQueries.PRIMARY_MARKET_LOAN_SUBMISSION_TRANSACTION_QUERY, p.getLoanAcquisition()));
        Assert.assertTrue("PropertyValuationContainers is not equal", ContainerValidation.validateContainers(slsId, dao,
                new PropertyValuationContainer(), DatabaseQueries.PROPERTY_VALUATION_QUERY, p.getPropertyValuation()));
        Assert.assertTrue("LoanOriginationContainer is not equal",
                ContainerValidation.validateContainers(slsId, dao, new LoanOriginationContainer(),
                        DatabaseQueries.PRIMARY_MARKET_LOAN_SUBMISSION_TRANSACTION_QUERY, p.getLoanOrigination()));
        validateCommonContainers(slsId, dao, p, pmlBatchContainer);
        validateEvaluationServiceContainers(slsId, dao, p);
        validateEvaluationServiceResultDetailContainers(slsId, dao, p);
        validateCashToCloseItemContainers(slsId, dao, p);
        validateDocumentGroupContainers(slsId, dao, p);
        validateLateChargeRuleContainers(slsId, dao, p);
        validateAddressContainers(slsId, dao, p);
    }

    public static void validateLCAE(String slsId, PmlTestDao dao,
            JAXBElement<PrimaryMarketLoanSubmissionBatchContainer> pmlBatchContainer) {
        com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransactionContainer p = pmlBatchContainer.getValue()
                .getPrimaryMarketLoanSubmissionTransactionContainer();

        Assert.assertTrue("LoanContainer is not equal", ContainerValidation.validateContainers(slsId, dao,
                new LoanContainer(), DatabaseQueries.PRIMARY_MARKET_LOAN_SUBMISSION_TRANSACTION_QUERY, p.getLoan()));
        Assert.assertTrue("BuydownContainer is not equal",
                ContainerValidation.validateContainers(slsId, dao, new BuydownContainer(),
                        DatabaseQueries.PRIMARY_MARKET_LOAN_SUBMISSION_TRANSACTION_QUERY, p.getBuydown()));
        validateCommonContainers(slsId, dao, p, pmlBatchContainer);
        validateEvaluationServiceContainers(slsId, dao, p);
        validateAddressContainers(slsId, dao, p);
        validateEvaluationServiceResultDetailContainers(slsId, dao, p);
        validateAppraisalContainers(slsId, dao, p);
        validatePropertyValuationApprslContainers(slsId, dao, p);
        validatePropertyValuationAssessmentContainers(slsId, dao, p);

        // LoanCollateralRiskAssessment
        List<com.freddiemac.datamanager.jaxb.LoanCollateralRiskAssessment> loanCollateralRiskAssessmentList = new ArrayList<>();
        p.getPrimaryMarketLoanSubmissionCollateralRiskAssessmentContainers()
                .getPrimaryMarketLoanSubmissionCollateralRiskAssessmentContainer()
                .forEach(e -> loanCollateralRiskAssessmentList.add(e.getLoanCollateralRiskAssessment()));
        Assert.assertTrue("LoanCollateralRiskAssessmentContainer is not equal",
                ContainerValidation.validateContainers(slsId, dao, new LoanCollateralRiskAssessmentContainer(),
                        DatabaseQueries.COLLATERAL_RISK_ASSESSMENT_CONTAINER_QUERY, loanCollateralRiskAssessmentList));

        // LoanCollateralRiskAssessment
        List<com.freddiemac.datamanager.jaxb.LoanPurchaseContract> loanPurchaseContractList = new ArrayList<>();
        p.getPrimaryMarketLoanSubmissionContractContainers().getPrimaryMarketLoanSubmissionContractContainer()
                .forEach(e -> loanPurchaseContractList.add(e.getLoanPurchaseContract()));
        Assert.assertTrue("LoanPurchaseContractContainer is not equal", ContainerValidation.validateContainers(slsId,
                dao, new ContractContainer(), DatabaseQueries.CONTRACT_CONTAINER_QUERY, loanPurchaseContractList));
    }

    public static void validateLPA(String slsId, PmlTestDao dao,
            JAXBElement<PrimaryMarketLoanSubmissionBatchContainer> pmlBatchContainer) {
        com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransactionContainer p = pmlBatchContainer.getValue()
                .getPrimaryMarketLoanSubmissionTransactionContainer();

        validateCommonContainers(slsId, dao, p, pmlBatchContainer);
        validateAddressContainers(slsId, dao, p);
        validateAppraisalContainers(slsId, dao, p);
        validatePropertyValuationApprslContainers(slsId, dao, p);
        validatePropertyValuationAssessmentContainers(slsId, dao, p);
    }
}
