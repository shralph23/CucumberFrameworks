package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.Loan;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class LoanContainer implements ResultSetExtractor<List<LoanContainer>> {
    private String assumabilityIndicator;
    private String loanAmortizationType;
    private String loanDemandFeatureIndicator;
    private String loanIdentifier;
    private String loanInterestOnlyIndicator;
    private String loanMaturityPeriodCount;
    private String loanMaturityPeriodType;
    private String loanPartialPaymentAllowedIndicator;
    private String loanPrepaymentPenaltyIndicator;
    private String loanPurposeType;
    private String mERSMINIdentifier;
    private String mortgageType;
    private int eventId;

    public LoanContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getAssumabilityIndicator() {
        return assumabilityIndicator;
    }

    public void setAssumabilityIndicator(String assumabilityIndicator) {
        this.assumabilityIndicator = assumabilityIndicator;
    }

    public String getLoanAmortizationType() {
        return loanAmortizationType;
    }

    public void setLoanAmortizationType(String loanAmortizationType) {
        this.loanAmortizationType = loanAmortizationType;
    }

    public String getLoanDemandFeatureIndicator() {
        return loanDemandFeatureIndicator;
    }

    public void setLoanDemandFeatureIndicator(String loanDemandFeatureIndicator) {
        this.loanDemandFeatureIndicator = loanDemandFeatureIndicator;
    }

    public String getLoanIdentifier() {
        return loanIdentifier;
    }

    public void setLoanIdentifier(String loanIdentifier) {
        this.loanIdentifier = loanIdentifier;
    }

    public String getLoanInterestOnlyIndicator() {
        return loanInterestOnlyIndicator;
    }

    public void setLoanInterestOnlyIndicator(String loanInterestOnlyIndicator) {
        this.loanInterestOnlyIndicator = loanInterestOnlyIndicator;
    }

    public String getLoanMaturityPeriodCount() {
        return loanMaturityPeriodCount;
    }

    public void setLoanMaturityPeriodCount(String loanMaturityPeriodCount) {
        this.loanMaturityPeriodCount = loanMaturityPeriodCount;
    }

    public String getLoanMaturityPeriodType() {
        return loanMaturityPeriodType;
    }

    public void setLoanMaturityPeriodType(String loanMaturityPeriodType) {
        this.loanMaturityPeriodType = loanMaturityPeriodType;
    }

    public String getLoanPartialPaymentAllowedIndicator() {
        return loanPartialPaymentAllowedIndicator;
    }

    public void setLoanPartialPaymentAllowedIndicator(String loanPartialPaymentAllowedIndicator) {
        this.loanPartialPaymentAllowedIndicator = loanPartialPaymentAllowedIndicator;
    }

    public String getLoanPrepaymentPenaltyIndicator() {
        return loanPrepaymentPenaltyIndicator;
    }

    public void setLoanPrepaymentPenaltyIndicator(String loanPrepaymentPenaltyIndicator) {
        this.loanPrepaymentPenaltyIndicator = loanPrepaymentPenaltyIndicator;
    }

    public String getLoanPurposeType() {
        return loanPurposeType;
    }

    public void setLoanPurposeType(String loanPurposeType) {
        this.loanPurposeType = loanPurposeType;
    }

    public String getMERSMINIdentifier() {
        return mERSMINIdentifier;
    }

    public void setMERSMINIdentifier(String mERSMINIdentifier) {
        this.mERSMINIdentifier = mERSMINIdentifier;
    }

    public String getMortgageType() {
        return mortgageType;
    }

    public void setMortgageType(String mortgageType) {
        this.mortgageType = mortgageType;
    }

    @Override
    public boolean equals(Object xmlLoanContainersObj) {
        LoanContainer dbLoanContainers = this;
        Loan xmlLoanContainers = (Loan) xmlLoanContainersObj;
        if (xmlLoanContainers == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbLoanContainers.getEventId() + "\n");
            if (dbLoanContainers.getAssumabilityIndicator() != null
                    && xmlLoanContainers.getAssumabilityIndicator() != null) {
                if (!dbLoanContainers.getAssumabilityIndicator().equals(xmlLoanContainers.getAssumabilityIndicator())) {
                    GlobalHooks.getScenario().write("AssumabilityIndicator mismatch. Expected Value is "
                            + dbLoanContainers.getAssumabilityIndicator() + " but actual value is "
                            + xmlLoanContainers.getAssumabilityIndicator());
                    return false;
                } else {
                    sb.append("AssumabilityIndicator in DB: " + dbLoanContainers.getAssumabilityIndicator()
                            + " AssumabilityIndicator in XML: " + xmlLoanContainers.getAssumabilityIndicator() + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanContainers.getLoanAmortizationType() != null
                    && xmlLoanContainers.getLoanAmortizationType() != null) {
                if (!dbLoanContainers.getLoanAmortizationType().equals(xmlLoanContainers.getLoanAmortizationType())) {
                    GlobalHooks.getScenario().write("LoanAmortizationType mismatch. Expected Value is "
                            + dbLoanContainers.getLoanAmortizationType() + " but actual value is "
                            + xmlLoanContainers.getLoanAmortizationType());
                    return false;
                } else {
                    sb.append("LoanAmortizationType in DB: " + dbLoanContainers.getLoanAmortizationType()
                            + " LoanAmortizationType in XML: " + xmlLoanContainers.getLoanAmortizationType() + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanContainers.getLoanDemandFeatureIndicator() != null
                    && xmlLoanContainers.getLoanDemandFeatureIndicator() != null) {
                if (!dbLoanContainers.getLoanDemandFeatureIndicator()
                        .equals(xmlLoanContainers.getLoanDemandFeatureIndicator())) {
                    GlobalHooks.getScenario().write("LoanDemandFeatureIndicator mismatch. Expected Value is "
                            + dbLoanContainers.getLoanDemandFeatureIndicator() + " but actual value is "
                            + xmlLoanContainers.getLoanDemandFeatureIndicator());
                    return false;
                } else {
                    sb.append("LoanDemandFeatureIndicator in DB: " + dbLoanContainers.getLoanDemandFeatureIndicator()
                            + " LoanDemandFeatureIndicator in XML: " + xmlLoanContainers.getLoanDemandFeatureIndicator()
                            + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanContainers.getLoanIdentifier() != null && xmlLoanContainers.getLoanIdentifier() != null) {
                if (!dbLoanContainers.getLoanIdentifier().equals(xmlLoanContainers.getLoanIdentifier())) {
                    GlobalHooks.getScenario()
                            .write("LoanIdentifier mismatch. Expected Value is " + dbLoanContainers.getLoanIdentifier()
                                    + " but actual value is " + xmlLoanContainers.getLoanIdentifier());
                    return false;
                } else {
                    sb.append("LoanIdentifier in DB: " + dbLoanContainers.getLoanIdentifier()
                            + " LoanIdentifier in XML: " + xmlLoanContainers.getLoanIdentifier() + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanContainers.getLoanInterestOnlyIndicator() != null
                    && xmlLoanContainers.getLoanInterestOnlyIndicator() != null) {
                if (!dbLoanContainers.getLoanInterestOnlyIndicator()
                        .equals(xmlLoanContainers.getLoanInterestOnlyIndicator())) {
                    GlobalHooks.getScenario().write("LoanInterestOnlyIndicator mismatch. Expected Value is "
                            + dbLoanContainers.getLoanInterestOnlyIndicator() + " but actual value is "
                            + xmlLoanContainers.getLoanInterestOnlyIndicator());
                    return false;
                } else {
                    sb.append("LoanInterestOnlyIndicator in DB: " + dbLoanContainers.getLoanInterestOnlyIndicator()
                            + " LoanInterestOnlyIndicator in XML: " + xmlLoanContainers.getLoanInterestOnlyIndicator()
                            + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanContainers.getLoanMaturityPeriodCount() != null
                    && xmlLoanContainers.getLoanMaturityPeriodCount() != null) {
                if (!dbLoanContainers.getLoanMaturityPeriodCount()
                        .equals(xmlLoanContainers.getLoanMaturityPeriodCount().toString())) {
                    GlobalHooks.getScenario().write("LoanMaturityPeriodCount mismatch. Expected Value is "
                            + dbLoanContainers.getLoanMaturityPeriodCount() + " but actual value is "
                            + xmlLoanContainers.getLoanMaturityPeriodCount());
                    return false;
                } else {
                    sb.append("LoanMaturityPeriodCount in DB: " + dbLoanContainers.getLoanMaturityPeriodCount()
                            + " LoanMaturityPeriodCount in XML: " + xmlLoanContainers.getLoanMaturityPeriodCount()
                            + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanContainers.getLoanMaturityPeriodType() != null
                    && xmlLoanContainers.getLoanMaturityPeriodType() != null) {
                if (!dbLoanContainers.getLoanMaturityPeriodType()
                        .equals(xmlLoanContainers.getLoanMaturityPeriodType())) {
                    GlobalHooks.getScenario().write("LoanMaturityPeriodType mismatch. Expected Value is "
                            + dbLoanContainers.getLoanMaturityPeriodType() + " but actual value is "
                            + xmlLoanContainers.getLoanMaturityPeriodType());
                    return false;
                } else {
                    sb.append("LoanMaturityPeriodType in DB: " + dbLoanContainers.getLoanMaturityPeriodType()
                            + " LoanMaturityPeriodType in XML: " + xmlLoanContainers.getLoanMaturityPeriodType()
                            + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanContainers.getLoanPartialPaymentAllowedIndicator() != null
                    && xmlLoanContainers.getLoanPartialPaymentAllowedIndicator() != null) {
                if (!dbLoanContainers.getLoanPartialPaymentAllowedIndicator()
                        .equals(xmlLoanContainers.getLoanPartialPaymentAllowedIndicator())) {
                    GlobalHooks.getScenario().write("LoanPartialPaymentAllowedIndicator mismatch. Expected Value is "
                            + dbLoanContainers.getLoanPartialPaymentAllowedIndicator() + " but actual value is "
                            + xmlLoanContainers.getLoanPartialPaymentAllowedIndicator());
                    return false;
                } else {
                    sb.append("LoanPartialPaymentAllowedIndicator in DB: "
                            + dbLoanContainers.getLoanPartialPaymentAllowedIndicator()
                            + " LoanPartialPaymentAllowedIndicator in XML: "
                            + xmlLoanContainers.getLoanPartialPaymentAllowedIndicator() + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanContainers.getLoanPrepaymentPenaltyIndicator() != null
                    && xmlLoanContainers.getLoanPrepaymentPenaltyIndicator() != null) {
                if (!dbLoanContainers.getLoanPrepaymentPenaltyIndicator()
                        .equals(xmlLoanContainers.getLoanPrepaymentPenaltyIndicator())) {
                    GlobalHooks.getScenario().write("LoanPrepaymentPenaltyIndicator mismatch. Expected Value is "
                            + dbLoanContainers.getLoanPrepaymentPenaltyIndicator() + " but actual value is "
                            + xmlLoanContainers.getLoanPrepaymentPenaltyIndicator());
                    return false;
                } else {
                    sb.append("LoanPrepaymentPenaltyIndicator in DB: "
                            + dbLoanContainers.getLoanPrepaymentPenaltyIndicator()
                            + " LoanPrepaymentPenaltyIndicator in XML: "
                            + xmlLoanContainers.getLoanPrepaymentPenaltyIndicator() + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanContainers.getLoanPurposeType() != null && xmlLoanContainers.getLoanPurposeType() != null) {
                if (!dbLoanContainers.getLoanPurposeType().equals(xmlLoanContainers.getLoanPurposeType())) {
                    GlobalHooks.getScenario().write(
                            "LoanPurposeType mismatch. Expected Value is " + dbLoanContainers.getLoanPurposeType()
                                    + " but actual value is " + xmlLoanContainers.getLoanPurposeType());
                    return false;
                } else {
                    sb.append("LoanPurposeType in DB: " + dbLoanContainers.getLoanPurposeType()
                            + " LoanPurposeType in XML: " + xmlLoanContainers.getLoanPurposeType() + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanContainers.getMERSMINIdentifier() != null && xmlLoanContainers.getMERSMINIdentifier() != null) {
                if (!dbLoanContainers.getMERSMINIdentifier().equals(xmlLoanContainers.getMERSMINIdentifier())) {
                    GlobalHooks.getScenario().write(
                            "MERSMINIdentifier mismatch. Expected Value is " + dbLoanContainers.getMERSMINIdentifier()
                                    + " but actual value is " + xmlLoanContainers.getMERSMINIdentifier());
                    return false;
                } else {
                    sb.append("MERSMINIdentifier in DB: " + dbLoanContainers.getMERSMINIdentifier()
                            + " MERSMINIdentifier in XML: " + xmlLoanContainers.getMERSMINIdentifier() + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanContainers.getMortgageType() != null && xmlLoanContainers.getMortgageType() != null) {
                if (!dbLoanContainers.getMortgageType().equals(xmlLoanContainers.getMortgageType())) {
                    GlobalHooks.getScenario()
                            .write("MortgageType mismatch. Expected Value is " + dbLoanContainers.getMortgageType()
                                    + " but actual value is " + xmlLoanContainers.getMortgageType());
                    return false;
                } else {
                    sb.append("MortgageType in DB: " + dbLoanContainers.getMortgageType() + " MortgageType in XML: "
                            + xmlLoanContainers.getMortgageType() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario().write(sb + "Loan Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<LoanContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<LoanContainer> results = new ArrayList<>();
        while (rs.next()) {
            LoanContainer loan = new LoanContainer();
            loan.setAssumabilityIndicator(rs.getString("IND_ASMBLTY"));
            loan.setLoanAmortizationType(rs.getString("NAME_LOAN_AMTN_TYPE"));
            loan.setLoanDemandFeatureIndicator(rs.getString("IND_LOAN_DMND_FTR"));
            loan.setLoanIdentifier(rs.getString("ID_PML_SUBMN_LINK"));
            loan.setLoanInterestOnlyIndicator(rs.getString("IND_LOAN_IO"));
            loan.setLoanMaturityPeriodCount(rs.getInt("CNT_LOAN_MTY_PER") + "");
            loan.setLoanMaturityPeriodType(rs.getString("NAME_LOAN_MTY_PER_TYPE"));
            loan.setLoanPartialPaymentAllowedIndicator(rs.getString("IND_LOAN_PRTL_PAYMT_ALWD"));
            loan.setLoanPrepaymentPenaltyIndicator(rs.getString("IND_LOAN_PPMT_PNLTY"));
            loan.setLoanPurposeType(rs.getString("NAME_LOAN_PURP_TYPE"));
            loan.setMERSMINIdentifier(rs.getString("ID_MERS_MIN"));
            loan.setMortgageType(rs.getString("NAME_MRTG_TYPE"));
            loan.setEventId(rs.getInt("ID_EVNT"));
            results.add(loan);
        }
        return results;
    }

    @Override
    public String toString() {
        return "LoanContainer [assumabilityIndicator=" + assumabilityIndicator + ", loanAmortizationType="
                + loanAmortizationType + ", loanDemandFeatureIndicator=" + loanDemandFeatureIndicator
                + ", loanIdentifier=" + loanIdentifier + ", loanInterestOnlyIndicator=" + loanInterestOnlyIndicator
                + ", loanMaturityPeriodCount=" + loanMaturityPeriodCount + ", loanMaturityPeriodType="
                + loanMaturityPeriodType + ", loanPartialPaymentAllowedIndicator=" + loanPartialPaymentAllowedIndicator
                + ", loanPrepaymentPenaltyIndicator=" + loanPrepaymentPenaltyIndicator + ", loanPurposeType="
                + loanPurposeType + ", mERSMINIdentifier=" + mERSMINIdentifier + ", mortgageType=" + mortgageType
                + ", eventId=" + eventId + "]";
    }

}
