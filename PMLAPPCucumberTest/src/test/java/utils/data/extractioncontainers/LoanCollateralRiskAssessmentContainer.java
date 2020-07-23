package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.LoanCollateralRiskAssessment;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class LoanCollateralRiskAssessmentContainer
        implements ResultSetExtractor<List<LoanCollateralRiskAssessmentContainer>> {

    private String loanScopeType;
    private String ltvSourceType;
    private Double ltvRatioPercent;
    private int eventId;

    public LoanCollateralRiskAssessmentContainer() {

    }

    public String getLoanScopeType() {
        return loanScopeType;
    }

    public void setLoanScopeType(String loanScopeType) {
        this.loanScopeType = loanScopeType;
    }

    public String getLtvSourceType() {
        return ltvSourceType;
    }

    public void setLtvSourceType(String ltvSourceType) {
        this.ltvSourceType = ltvSourceType;
    }

    public Double getLtvRatioPercent() {
        return ltvRatioPercent;
    }

    public void setLtvRatioPercent(Double ltvRatioPercent) {
        this.ltvRatioPercent = ltvRatioPercent;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public boolean equals(Object xmlCollateralRiskAssessmentContainersObj) {
        LoanCollateralRiskAssessmentContainer dbCollateralRiskAssessmentContainers = this;
        LoanCollateralRiskAssessment xmlCollateralRiskAssessmentContainers = (LoanCollateralRiskAssessment) xmlCollateralRiskAssessmentContainersObj;
        if (xmlCollateralRiskAssessmentContainers == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbCollateralRiskAssessmentContainers.getEventId() + "\n");
            if (dbCollateralRiskAssessmentContainers.getLoanScopeType() != null
                    && xmlCollateralRiskAssessmentContainers.getLoanScopeType() != null) {
                if (!dbCollateralRiskAssessmentContainers.getLoanScopeType()
                        .equals(xmlCollateralRiskAssessmentContainers.getLoanScopeType())) {
                    GlobalHooks.getScenario().write("LoanScopeType mismatch. Expected Value is "
                            + dbCollateralRiskAssessmentContainers.getLoanScopeType() + " but actual value is "
                            + xmlCollateralRiskAssessmentContainers.getLoanScopeType());
                    return false;
                } else {
                    sb.append("LoanScopeType in DB: " + dbCollateralRiskAssessmentContainers.getLoanScopeType()
                            + " LoanScopeType in XML: " + xmlCollateralRiskAssessmentContainers.getLoanScopeType()
                            + "\n");
                    recordsCounter++;
                }
            }

            if (dbCollateralRiskAssessmentContainers.getLtvSourceType() != null
                    && xmlCollateralRiskAssessmentContainers.getLTVSourceType() != null) {
                if (!dbCollateralRiskAssessmentContainers.getLtvSourceType()
                        .equals(xmlCollateralRiskAssessmentContainers.getLTVSourceType())) {
                    GlobalHooks.getScenario().write("LtvSourceType mismatch. Expected Value is "
                            + dbCollateralRiskAssessmentContainers.getLtvSourceType() + " but actual value is "
                            + xmlCollateralRiskAssessmentContainers.getLTVSourceType());
                    return false;
                } else {
                    sb.append("LtvSourceType in DB: " + dbCollateralRiskAssessmentContainers.getLtvSourceType()
                            + " LtvSourceType in XML: " + xmlCollateralRiskAssessmentContainers.getLTVSourceType()
                            + "\n");
                    recordsCounter++;
                }
            }

            if (dbCollateralRiskAssessmentContainers.getLtvRatioPercent() != null
                    && xmlCollateralRiskAssessmentContainers.getLTVRatioPercent() != null) {
                String dbLtvRatioPercent = TestConstants.decFormat.format(
                        Double.valueOf(dbCollateralRiskAssessmentContainers.getLtvRatioPercent().doubleValue()));
                String xmlLtvRatioPercent = TestConstants.decFormat.format(
                        Double.valueOf(xmlCollateralRiskAssessmentContainers.getLTVRatioPercent().doubleValue()));
                if (!(dbLtvRatioPercent).equals(xmlLtvRatioPercent)) {
                    GlobalHooks.getScenario().write("LtvRatioPercent mismatch. Expected Value is " + dbLtvRatioPercent
                            + " but actual value is " + xmlLtvRatioPercent);
                    return false;
                } else {
                    sb.append("LtvRatioPercent in DB: " + dbLtvRatioPercent + " LtvRatioPercent in XML: "
                            + xmlLtvRatioPercent + "\n");
                    recordsCounter++;
                }
            }

            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario().write(
                    sb + "CollateralRiskAssessmentContainer Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<LoanCollateralRiskAssessmentContainer> extractData(ResultSet rs)
            throws SQLException, DataAccessException {
        List<LoanCollateralRiskAssessmentContainer> results = new ArrayList<>();
        while (rs.next()) {
            this.setLoanScopeType(rs.getString("NAME_LOAN_SCP_TYPE"));
            this.setLtvSourceType(rs.getString("NAME_LTV_SRCE_TYPE"));
            this.setLtvRatioPercent(rs.getDouble("PCT_LTV_RATIO"));
            this.setEventId(rs.getInt("ID_EVNT"));
            results.add(this);
        }
        return results;
    }

    @Override
    public String toString() {
        return "LoanCollateralRiskAssessmentContainer [loanScopeType=" + loanScopeType + ", ltvSourceType="
                + ltvSourceType + ", ltvRatioPercent=" + ltvRatioPercent + ", eventId=" + eventId + "]";
    }

}
