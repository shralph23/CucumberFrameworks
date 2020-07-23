package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.LateChargeRule;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class LateChargeRuleContainer implements ResultSetExtractor<List<LateChargeRuleContainer>> {
    private Double loanLateChargeAmount;
    private String lateChargeType;
    private String loanLateChargeGracePeriodCount;
    private Double loanLateChargeRate;
    private int eventId;

    public LateChargeRuleContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Double getLoanLateChargeAmount() {
        return loanLateChargeAmount;
    }

    public void setLoanLateChargeAmount(Double loanLateChargeAmount) {
        this.loanLateChargeAmount = loanLateChargeAmount;
    }

    public String getLateChargeType() {
        return lateChargeType;
    }

    public void setLateChargeType(String lateChargeType) {
        this.lateChargeType = lateChargeType;
    }

    public String getLoanLateChargeGracePeriodCount() {
        return loanLateChargeGracePeriodCount;
    }

    public void setLoanLateChargeGracePeriodCount(String loanLateChargeGracePeriodCount) {
        this.loanLateChargeGracePeriodCount = loanLateChargeGracePeriodCount;
    }

    public Double getLoanLateChargeRate() {
        return loanLateChargeRate;
    }

    public void setLoanLateChargeRate(Double loanLateChargeRate) {
        this.loanLateChargeRate = loanLateChargeRate;
    }

    @Override
    public boolean equals(Object xmlLateChargeRuleObj) {
        LateChargeRuleContainer dbLateChargeRule = this;
        LateChargeRule xmlLateChargeRule = (LateChargeRule) xmlLateChargeRuleObj;
        if (xmlLateChargeRule == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbLateChargeRule.getEventId() + "\n");
            if (dbLateChargeRule.getLoanLateChargeAmount() != null
                    && xmlLateChargeRule.getLoanLateChargeAmount() != null) {
                String dbLoanLateChargeAmount = TestConstants.decFormat
                        .format(Double.valueOf(dbLateChargeRule.getLoanLateChargeAmount().doubleValue()));
                String xmlLoanLateChargeAmount = TestConstants.decFormat
                        .format(Double.valueOf(xmlLateChargeRule.getLoanLateChargeAmount().doubleValue()));
                if (!(dbLoanLateChargeAmount).equals(xmlLoanLateChargeAmount)) {
                    GlobalHooks.getScenario().write("LoanLateChargeAmount mismatch. Expected Value is "
                            + dbLoanLateChargeAmount + " but actual value is " + xmlLoanLateChargeAmount);
                    return false;
                } else {
                    sb.append("LoanLateChargeAmount in DB: " + dbLoanLateChargeAmount + " LoanLateChargeAmount in XML: "
                            + xmlLoanLateChargeAmount + "\n");
                    recordsCounter++;
                }
            }

            if (dbLateChargeRule.getLoanLateChargeRate() != null && xmlLateChargeRule.getLoanLateChargeRate() != null) {
                String dbLoanLateChargeRate = TestConstants.decFormat
                        .format(Double.valueOf(dbLateChargeRule.getLoanLateChargeRate().doubleValue()));
                String xmlLoanLateChargeRate = TestConstants.decFormat
                        .format(Double.valueOf(xmlLateChargeRule.getLoanLateChargeRate().doubleValue()));
                if (!(dbLoanLateChargeRate).equals(xmlLoanLateChargeRate)) {
                    GlobalHooks.getScenario().write("LoanLateChargeRate mismatch. Expected Value is " + dbLoanLateChargeRate
                            + " but actual value is " + xmlLoanLateChargeRate);
                    return false;
                } else {
                    sb.append("LoanLateChargeRate in DB: " + dbLoanLateChargeRate + " LoanLateChargeRate in XML: "
                            + xmlLoanLateChargeRate + "\n");
                    recordsCounter++;
                }
            }

            if (dbLateChargeRule.getLoanLateChargeGracePeriodCount() != null
                    && xmlLateChargeRule.getLoanLateChargeGracePeriodCount() != null) {
                if (!dbLateChargeRule.getLoanLateChargeGracePeriodCount()
                        .equals(xmlLateChargeRule.getLoanLateChargeGracePeriodCount().toString())) {
                    GlobalHooks.getScenario().write("LoanLateChargeGracePeriodCount mismatch. Expected Value is "
                            + dbLateChargeRule.getLoanLateChargeGracePeriodCount() + " but actual value is "
                            + xmlLateChargeRule.getLoanLateChargeGracePeriodCount());
                    return false;
                } else {
                    sb.append("LoanLateChargeGracePeriodCount in DB: "
                            + dbLateChargeRule.getLoanLateChargeGracePeriodCount()
                            + " LoanLateChargeGracePeriodCount in XML: "
                            + xmlLateChargeRule.getLoanLateChargeGracePeriodCount() + "\n");
                    recordsCounter++;
                }
            }

            if (dbLateChargeRule.getLateChargeType() != null && xmlLateChargeRule.getLateChargeType() != null) {
                if (!dbLateChargeRule.getLateChargeType().equals(xmlLateChargeRule.getLateChargeType())) {
                    GlobalHooks.getScenario()
                            .write("LateChargeType mismatch. Expected Value is " + dbLateChargeRule.getLateChargeType()
                                    + " but actual value is " + xmlLateChargeRule.getLateChargeType());
                    return false;
                } else {
                    sb.append("LateChargeType in DB: " + dbLateChargeRule.getLateChargeType()
                            + " LateChargeType in XML: " + xmlLateChargeRule.getLateChargeType() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario().write(sb + "LateChargeRule Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<LateChargeRuleContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<LateChargeRuleContainer> results = new ArrayList<>();
        while (rs.next()) {
            LateChargeRuleContainer lateChargeRule = new LateChargeRuleContainer();
            lateChargeRule.setLoanLateChargeAmount(rs.getDouble("AMT_LOAN_LATE_CHRG"));
            lateChargeRule.setLoanLateChargeRate(rs.getDouble("RATE_LOAN_LATE_CHRG"));
            lateChargeRule.setLoanLateChargeGracePeriodCount(rs.getString("CNT_LOAN_LATE_CHRG_GRC_PER"));
            lateChargeRule.setLateChargeType(rs.getString("CD_LATE_CHRG"));
            lateChargeRule.setEventId(rs.getInt("ID_EVNT"));
            results.add(lateChargeRule);
        }
        return results;
    }

    @Override
    public String toString() {
        return "LateChargeRuleContainer [loanLateChargeAmount=" + loanLateChargeAmount + ", lateChargeType="
                + lateChargeType + ", loanLateChargeGracePeriodCount=" + loanLateChargeGracePeriodCount
                + ", loanLateChargeRate=" + loanLateChargeRate + ", eventId=" + eventId + "]";
    }
}
