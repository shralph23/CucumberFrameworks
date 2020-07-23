package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.LoanProjectedCashFlow;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class LoanProjectedCashFlowContainer implements ResultSetExtractor<List<LoanProjectedCashFlowContainer>> {

    private int loanProjectedCashFlowSequenceNumber;
    private Double loanProjectedEscrowPaymentAmount;
    private Double loanProjectedMaximumPrincipalAndInterestPaymentAmount;
    private Double loanProjectedMaximumTotalPaymentAmount;
    private Double loanProjectedMIPaymentAmount;
    private Double loanProjectedMinimumPrincipalAndInterestPaymentAmount;
    private Double loanProjectedMinimumTotalPaymentAmount;
    private String projectedPaymentCalculationPeriodTermType;
    private String projectedPaymentFrequencyType;
    private String projectedPaymentCalculationPeriodEndNumber;
    private String projectedPaymentCalculationPeriodStartNumber;
    private int eventId;

    public LoanProjectedCashFlowContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getLoanProjectedCashFlowSequenceNumber() {
        return loanProjectedCashFlowSequenceNumber;
    }

    public void setLoanProjectedCashFlowSequenceNumber(int loanProjectedCashFlowSequenceNumber) {
        this.loanProjectedCashFlowSequenceNumber = loanProjectedCashFlowSequenceNumber;
    }

    public Double getLoanProjectedEscrowPaymentAmount() {
        return loanProjectedEscrowPaymentAmount;
    }

    public void setLoanProjectedEscrowPaymentAmount(Double loanProjectedEscrowPaymentAmount) {
        this.loanProjectedEscrowPaymentAmount = loanProjectedEscrowPaymentAmount;
    }

    public Double getLoanProjectedMaximumPrincipalAndInterestPaymentAmount() {
        return loanProjectedMaximumPrincipalAndInterestPaymentAmount;
    }

    public void setLoanProjectedMaximumPrincipalAndInterestPaymentAmount(
            Double loanProjectedMaximumPrincipalAndInterestPaymentAmount) {
        this.loanProjectedMaximumPrincipalAndInterestPaymentAmount = loanProjectedMaximumPrincipalAndInterestPaymentAmount;
    }

    public Double getLoanProjectedMaximumTotalPaymentAmount() {
        return loanProjectedMaximumTotalPaymentAmount;
    }

    public void setLoanProjectedMaximumTotalPaymentAmount(Double loanProjectedMaximumTotalPaymentAmount) {
        this.loanProjectedMaximumTotalPaymentAmount = loanProjectedMaximumTotalPaymentAmount;
    }

    public Double getLoanProjectedMIPaymentAmount() {
        return loanProjectedMIPaymentAmount;
    }

    public void setLoanProjectedMIPaymentAmount(Double loanProjectedMIPaymentAmount) {
        this.loanProjectedMIPaymentAmount = loanProjectedMIPaymentAmount;
    }

    public Double getLoanProjectedMinimumPrincipalAndInterestPaymentAmount() {
        return loanProjectedMinimumPrincipalAndInterestPaymentAmount;
    }

    public void setLoanProjectedMinimumPrincipalAndInterestPaymentAmount(
            Double loanProjectedMinimumPrincipalAndInterestPaymentAmount) {
        this.loanProjectedMinimumPrincipalAndInterestPaymentAmount = loanProjectedMinimumPrincipalAndInterestPaymentAmount;
    }

    public Double getLoanProjectedMinimumTotalPaymentAmount() {
        return loanProjectedMinimumTotalPaymentAmount;
    }

    public void setLoanProjectedMinimumTotalPaymentAmount(Double loanProjectedMinimumTotalPaymentAmount) {
        this.loanProjectedMinimumTotalPaymentAmount = loanProjectedMinimumTotalPaymentAmount;
    }

    public String getProjectedPaymentCalculationPeriodTermType() {
        return projectedPaymentCalculationPeriodTermType;
    }

    public void setProjectedPaymentCalculationPeriodTermType(String projectedPaymentCalculationPeriodTermType) {
        this.projectedPaymentCalculationPeriodTermType = projectedPaymentCalculationPeriodTermType;
    }

    public String getProjectedPaymentFrequencyType() {
        return projectedPaymentFrequencyType;
    }

    public void setProjectedPaymentFrequencyType(String projectedPaymentFrequencyType) {
        this.projectedPaymentFrequencyType = projectedPaymentFrequencyType;
    }

    public String getProjectedPaymentCalculationPeriodEndNumber() {
        return projectedPaymentCalculationPeriodEndNumber;
    }

    public void setProjectedPaymentCalculationPeriodEndNumber(String projectedPaymentCalculationPeriodEndNumber) {
        this.projectedPaymentCalculationPeriodEndNumber = projectedPaymentCalculationPeriodEndNumber;
    }

    public String getProjectedPaymentCalculationPeriodStartNumber() {
        return projectedPaymentCalculationPeriodStartNumber;
    }

    public void setProjectedPaymentCalculationPeriodStartNumber(String projectedPaymentCalculationPeriodStartNumber) {
        this.projectedPaymentCalculationPeriodStartNumber = projectedPaymentCalculationPeriodStartNumber;
    }

    @Override
    public boolean equals(Object xmlLoanProjectedCashFlowContainersObj) {
        LoanProjectedCashFlowContainer dbLoanProjectedCashFlowContainers = this;
        LoanProjectedCashFlow xmlLoanProjectedCashFlowContainers = (LoanProjectedCashFlow) xmlLoanProjectedCashFlowContainersObj;
        if (xmlLoanProjectedCashFlowContainers == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbLoanProjectedCashFlowContainers.getEventId() + "\n");

            if (Integer.valueOf(dbLoanProjectedCashFlowContainers.getLoanProjectedCashFlowSequenceNumber()) != null
                    && (xmlLoanProjectedCashFlowContainers.getLoanProjectedCashFlowSequenceNumber()) != null) {
                if (!(xmlLoanProjectedCashFlowContainers.getLoanProjectedCashFlowSequenceNumber().toString()).equals(
                        Integer.valueOf(dbLoanProjectedCashFlowContainers.getLoanProjectedCashFlowSequenceNumber())
                                .toString())) {
                    GlobalHooks.getScenario().write("LoanProjectedCashFlowSequenceNumber mismatch. Expected Value is "
                            + dbLoanProjectedCashFlowContainers.getLoanProjectedCashFlowSequenceNumber()
                            + " but actual value is "
                            + xmlLoanProjectedCashFlowContainers.getLoanProjectedCashFlowSequenceNumber());
                    return false;
                } else {
                    sb.append("LoanProjectedCashFlowSequenceNumber in DB: "
                            + dbLoanProjectedCashFlowContainers.getLoanProjectedCashFlowSequenceNumber()
                            + " LoanProjectedCashFlowSequenceNumber in XML: "
                            + xmlLoanProjectedCashFlowContainers.getLoanProjectedCashFlowSequenceNumber() + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanProjectedCashFlowContainers.getLoanProjectedEscrowPaymentAmount() != null
                    && xmlLoanProjectedCashFlowContainers.getLoanProjectedEscrowPaymentAmount() != null) {
                String dbLoanProjectedEscrowPaymentAmount = TestConstants.decFormat.format(Double.valueOf(
                        dbLoanProjectedCashFlowContainers.getLoanProjectedEscrowPaymentAmount().doubleValue()));
                String xmlLoanProjectedEscrowPaymentAmount = TestConstants.decFormat.format(Double.valueOf(
                        xmlLoanProjectedCashFlowContainers.getLoanProjectedEscrowPaymentAmount().doubleValue()));
                if (!(dbLoanProjectedEscrowPaymentAmount).equals(xmlLoanProjectedEscrowPaymentAmount)) {
                    GlobalHooks.getScenario().write("LoanProjectedEscrowPaymentAmount mismatch. Expected Value is "
                            + dbLoanProjectedEscrowPaymentAmount + " but actual value is "
                            + xmlLoanProjectedEscrowPaymentAmount);
                    return false;
                } else {
                    sb.append("LoanProjectedEscrowPaymentAmount in DB: " + dbLoanProjectedEscrowPaymentAmount
                            + " LoanProjectedEscrowPaymentAmount in XML: " + xmlLoanProjectedEscrowPaymentAmount
                            + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanProjectedCashFlowContainers.getLoanProjectedMaximumPrincipalAndInterestPaymentAmount() != null
                    && xmlLoanProjectedCashFlowContainers
                            .getLoanProjectedMaximumPrincipalAndInterestPaymentAmount() != null) {
                String dbLoanProjectedMaximumPrincipalAndInterestPaymentAmount = TestConstants.decFormat
                        .format(Double.valueOf(dbLoanProjectedCashFlowContainers
                                .getLoanProjectedMaximumPrincipalAndInterestPaymentAmount().doubleValue()));
                String xmlLoanProjectedMaximumPrincipalAndInterestPaymentAmount = TestConstants.decFormat
                        .format(Double.valueOf(xmlLoanProjectedCashFlowContainers
                                .getLoanProjectedMaximumPrincipalAndInterestPaymentAmount().doubleValue()));
                if (!(dbLoanProjectedMaximumPrincipalAndInterestPaymentAmount)
                        .equals(xmlLoanProjectedMaximumPrincipalAndInterestPaymentAmount)) {
                    GlobalHooks.getScenario()
                            .write("LoanProjectedMaximumPrincipalAndInterestPaymentAmount mismatch. Expected Value is "
                                    + dbLoanProjectedMaximumPrincipalAndInterestPaymentAmount + " but actual value is "
                                    + xmlLoanProjectedMaximumPrincipalAndInterestPaymentAmount);
                    return false;
                } else {
                    sb.append("LoanProjectedMaximumPrincipalAndInterestPaymentAmount in DB: "
                            + dbLoanProjectedMaximumPrincipalAndInterestPaymentAmount
                            + " LoanProjectedMaximumPrincipalAndInterestPaymentAmount in XML: "
                            + xmlLoanProjectedMaximumPrincipalAndInterestPaymentAmount + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanProjectedCashFlowContainers.getLoanProjectedMaximumTotalPaymentAmount() != null
                    && xmlLoanProjectedCashFlowContainers.getLoanProjectedMaximumTotalPaymentAmount() != null) {
                String dbLoanProjectedMaximumTotalPaymentAmount = TestConstants.decFormat.format(Double.valueOf(
                        dbLoanProjectedCashFlowContainers.getLoanProjectedMaximumTotalPaymentAmount().doubleValue()));
                String xmlLoanProjectedMaximumTotalPaymentAmount = TestConstants.decFormat.format(Double.valueOf(
                        xmlLoanProjectedCashFlowContainers.getLoanProjectedMaximumTotalPaymentAmount().doubleValue()));
                if (!(dbLoanProjectedMaximumTotalPaymentAmount).equals(xmlLoanProjectedMaximumTotalPaymentAmount)) {
                    GlobalHooks.getScenario().write("LoanProjectedMaximumTotalPaymentAmount mismatch. Expected Value is "
                            + dbLoanProjectedMaximumTotalPaymentAmount + " but actual value is "
                            + xmlLoanProjectedMaximumTotalPaymentAmount);
                    return false;
                } else {
                    sb.append(
                            "LoanProjectedMaximumTotalPaymentAmount in DB: " + dbLoanProjectedMaximumTotalPaymentAmount
                                    + " LoanProjectedMaximumTotalPaymentAmount in XML: "
                                    + xmlLoanProjectedMaximumTotalPaymentAmount + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanProjectedCashFlowContainers.getLoanProjectedMinimumPrincipalAndInterestPaymentAmount() != null
                    && xmlLoanProjectedCashFlowContainers
                            .getLoanProjectedMinimumPrincipalAndInterestPaymentAmount() != null) {
                String dbLoanProjectedMinimumPrincipalAndInterestPaymentAmount = TestConstants.decFormat
                        .format(Double.valueOf(dbLoanProjectedCashFlowContainers
                                .getLoanProjectedMinimumPrincipalAndInterestPaymentAmount().doubleValue()));
                String xmlLoanProjectedMinimumPrincipalAndInterestPaymentAmount = TestConstants.decFormat
                        .format(Double.valueOf(xmlLoanProjectedCashFlowContainers
                                .getLoanProjectedMinimumPrincipalAndInterestPaymentAmount().doubleValue()));
                if (!(dbLoanProjectedMinimumPrincipalAndInterestPaymentAmount)
                        .equals(xmlLoanProjectedMinimumPrincipalAndInterestPaymentAmount)) {
                    GlobalHooks.getScenario()
                            .write("LoanProjectedMinimumPrincipalAndInterestPaymentAmount mismatch. Expected Value is "
                                    + dbLoanProjectedMinimumPrincipalAndInterestPaymentAmount + " but actual value is "
                                    + xmlLoanProjectedMinimumPrincipalAndInterestPaymentAmount);
                    return false;
                } else {
                    sb.append("LoanProjectedMinimumPrincipalAndInterestPaymentAmount in DB: "
                            + dbLoanProjectedMinimumPrincipalAndInterestPaymentAmount
                            + " LoanProjectedMinimumPrincipalAndInterestPaymentAmount in XML: "
                            + xmlLoanProjectedMinimumPrincipalAndInterestPaymentAmount + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanProjectedCashFlowContainers.getLoanProjectedMinimumTotalPaymentAmount() != null
                    && xmlLoanProjectedCashFlowContainers.getLoanProjectedMinimumTotalPaymentAmount() != null) {
                String dbLoanProjectedMinimumTotalPaymentAmount = TestConstants.decFormat.format(Double.valueOf(
                        dbLoanProjectedCashFlowContainers.getLoanProjectedMinimumTotalPaymentAmount().doubleValue()));
                String xmlLoanProjectedMinimumTotalPaymentAmount = TestConstants.decFormat.format(Double.valueOf(
                        xmlLoanProjectedCashFlowContainers.getLoanProjectedMinimumTotalPaymentAmount().doubleValue()));
                if (!(dbLoanProjectedMinimumTotalPaymentAmount).equals(xmlLoanProjectedMinimumTotalPaymentAmount)) {
                    GlobalHooks.getScenario().write("LoanProjectedMinimumTotalPaymentAmount mismatch. Expected Value is "
                            + dbLoanProjectedMinimumTotalPaymentAmount + " but actual value is "
                            + xmlLoanProjectedMinimumTotalPaymentAmount);
                    return false;
                } else {
                    sb.append(
                            "LoanProjectedMinimumTotalPaymentAmount in DB: " + dbLoanProjectedMinimumTotalPaymentAmount
                                    + " LoanProjectedMinimumTotalPaymentAmount in XML: "
                                    + xmlLoanProjectedMinimumTotalPaymentAmount + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanProjectedCashFlowContainers.getLoanProjectedMIPaymentAmount() != null
                    && xmlLoanProjectedCashFlowContainers.getLoanProjectedMIPaymentAmount() != null) {
                String dbLoanProjectedMIPaymentAmount = TestConstants.decFormat.format(Double
                        .valueOf(dbLoanProjectedCashFlowContainers.getLoanProjectedMIPaymentAmount().doubleValue()));
                String xmlLoanProjectedMIPaymentAmount = TestConstants.decFormat.format(Double
                        .valueOf(xmlLoanProjectedCashFlowContainers.getLoanProjectedMIPaymentAmount().doubleValue()));
                if (!(dbLoanProjectedMIPaymentAmount).equals(xmlLoanProjectedMIPaymentAmount)) {
                    GlobalHooks.getScenario().write(
                            "LoanProjectedMIPaymentAmount mismatch. Expected Value is " + dbLoanProjectedMIPaymentAmount
                                    + " but actual value is " + xmlLoanProjectedMIPaymentAmount);
                    return false;
                } else {
                    sb.append("LoanProjectedMIPaymentAmount in DB: " + dbLoanProjectedMIPaymentAmount
                            + " LoanProjectedMIPaymentAmount in XML: " + xmlLoanProjectedMIPaymentAmount + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodEndNumber() != null
                    && xmlLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodEndNumber() != null) {
                if (!dbLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodEndNumber()
                        .equals(xmlLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodEndNumber()
                                .toString())) {
                    GlobalHooks.getScenario().write("ProjectedPaymentCalculationPeriodEndNumber mismatch. Expected Value is "
                            + dbLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodEndNumber()
                            + " but actual value is "
                            + xmlLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodEndNumber());
                    return false;
                } else {
                    sb.append("ProjectedPaymentCalculationPeriodEndNumber in DB: "
                            + dbLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodEndNumber()
                            + " ProjectedPaymentCalculationPeriodEndNumber in XML: "
                            + xmlLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodEndNumber()
                            + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodStartNumber() != null
                    && xmlLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodStartNumber() != null) {
                if (!dbLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodStartNumber()
                        .equals(xmlLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodStartNumber()
                                .toString())) {
                    GlobalHooks.getScenario()
                            .write("ProjectedPaymentCalculationPeriodStartNumber mismatch. Expected Value is "
                                    + dbLoanProjectedCashFlowContainers
                                            .getProjectedPaymentCalculationPeriodStartNumber()
                                    + " but actual value is " + xmlLoanProjectedCashFlowContainers
                                            .getProjectedPaymentCalculationPeriodStartNumber());
                    return false;
                } else {
                    sb.append("ProjectedPaymentCalculationPeriodStartNumber in DB: "
                            + dbLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodStartNumber()
                            + " ProjectedPaymentCalculationPeriodStartNumber in XML: "
                            + xmlLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodStartNumber()
                            + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodTermType() != null
                    && xmlLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodTermType() != null) {
                if (!dbLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodTermType()
                        .equals(xmlLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodTermType())) {
                    GlobalHooks.getScenario().write("ProjectedPaymentCalculationPeriodTermType mismatch. Expected Value is "
                            + dbLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodTermType()
                            + " but actual value is "
                            + xmlLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodTermType());
                    return false;
                } else {
                    sb.append("ProjectedPaymentCalculationPeriodTermType in DB: "
                            + dbLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodTermType()
                            + " ProjectedPaymentCalculationPeriodTermType in XML: "
                            + xmlLoanProjectedCashFlowContainers.getProjectedPaymentCalculationPeriodTermType() + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanProjectedCashFlowContainers.getProjectedPaymentFrequencyType() != null
                    && xmlLoanProjectedCashFlowContainers.getProjectedPaymentFrequencyType() != null) {
                if (!dbLoanProjectedCashFlowContainers.getProjectedPaymentFrequencyType()
                        .equals(xmlLoanProjectedCashFlowContainers.getProjectedPaymentFrequencyType())) {
                    GlobalHooks.getScenario().write("ProjectedPaymentFrequencyType mismatch. Expected Value is "
                            + dbLoanProjectedCashFlowContainers.getProjectedPaymentFrequencyType()
                            + " but actual value is "
                            + xmlLoanProjectedCashFlowContainers.getProjectedPaymentFrequencyType());
                    return false;
                } else {
                    sb.append("ProjectedPaymentFrequencyType in DB: "
                            + dbLoanProjectedCashFlowContainers.getProjectedPaymentFrequencyType()
                            + " ProjectedPaymentFrequencyType in XML: "
                            + xmlLoanProjectedCashFlowContainers.getProjectedPaymentFrequencyType() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario()
                    .write(sb + "LoanProjectedCashFlow Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<LoanProjectedCashFlowContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<LoanProjectedCashFlowContainer> results = new ArrayList<>();
        while (rs.next()) {
            LoanProjectedCashFlowContainer loanProjectedCashFlow = new LoanProjectedCashFlowContainer();
            loanProjectedCashFlow.setLoanProjectedCashFlowSequenceNumber(rs.getInt("NBR_LOAN_PRJTD_CF_SEQ"));
            loanProjectedCashFlow.setLoanProjectedEscrowPaymentAmount(rs.getDouble("AMT_LOAN_PRJTD_ESCRW_PAYMT"));
            loanProjectedCashFlow.setLoanProjectedMaximumPrincipalAndInterestPaymentAmount(
                    rs.getDouble("AMT_LOAN_PRJTD_MAX_PI_PAYMT"));
            loanProjectedCashFlow
                    .setLoanProjectedMaximumTotalPaymentAmount(rs.getDouble("AMT_LOAN_PRJTD_MAX_TOT_PAYMT"));
            loanProjectedCashFlow.setLoanProjectedMIPaymentAmount(rs.getDouble("AMT_LOAN_PRJTD_MI_PAYMT"));
            loanProjectedCashFlow.setLoanProjectedMinimumPrincipalAndInterestPaymentAmount(
                    rs.getDouble("AMT_LOAN_PRJTD_MINM_PI_PAYMT"));
            loanProjectedCashFlow
                    .setLoanProjectedMinimumTotalPaymentAmount(rs.getDouble("AMT_LOAN_PRJTD_MINM_TOT_PAYMT"));
            loanProjectedCashFlow
                    .setProjectedPaymentCalculationPeriodEndNumber(rs.getString("NBR_PRJTD_PAYMT_CALCTN_PER_END"));
            loanProjectedCashFlow
                    .setProjectedPaymentCalculationPeriodStartNumber(rs.getString("NBR_PRJTD_PAYMT_CALCTN_PER_START"));
            loanProjectedCashFlow
                    .setProjectedPaymentCalculationPeriodTermType(rs.getString("CD_PRJTD_PAYMT_CALCTN_PER_TERM"));
            loanProjectedCashFlow.setProjectedPaymentFrequencyType(rs.getString("CD_PRJTD_PAYMT_FREQ"));
            loanProjectedCashFlow.setEventId(rs.getInt("ID_EVNT"));
            results.add(loanProjectedCashFlow);
        }
        return results;
    }

    @Override
    public String toString() {
        return "LoanProjectedCashFlowContainer [loanProjectedCashFlowSequenceNumber="
                + loanProjectedCashFlowSequenceNumber + ", loanProjectedEscrowPaymentAmount="
                + loanProjectedEscrowPaymentAmount + ", loanProjectedMaximumPrincipalAndInterestPaymentAmount="
                + loanProjectedMaximumPrincipalAndInterestPaymentAmount + ", loanProjectedMaximumTotalPaymentAmount="
                + loanProjectedMaximumTotalPaymentAmount + ", loanProjectedMIPaymentAmount="
                + loanProjectedMIPaymentAmount + ", loanProjectedMinimumPrincipalAndInterestPaymentAmount="
                + loanProjectedMinimumPrincipalAndInterestPaymentAmount + ", loanProjectedMinimumTotalPaymentAmount="
                + loanProjectedMinimumTotalPaymentAmount + ", projectedPaymentCalculationPeriodTermType="
                + projectedPaymentCalculationPeriodTermType + ", projectedPaymentFrequencyType="
                + projectedPaymentFrequencyType + ", projectedPaymentCalculationPeriodEndNumber="
                + projectedPaymentCalculationPeriodEndNumber + ", projectedPaymentCalculationPeriodStartNumber="
                + projectedPaymentCalculationPeriodStartNumber + ", eventId=" + eventId + "]";
    }

}
