package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.Appraisal;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class AppraisalContainer implements ResultSetExtractor<List<AppraisalContainer>> {
    private DateTime loanCollateralAdvisorSubmissionDatetime;
    private Double propertyAppraisedValueAmount;
    private String appraisalDocumentType;
    private DateTime propertyValuationEffectiveDate;
    private String ucdpStatus;
    private int eventId;

    public AppraisalContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public DateTime getLoanCollateralAdvisorSubmissionDatetime() {
        return loanCollateralAdvisorSubmissionDatetime;
    }

    public void setLoanCollateralAdvisorSubmissionDatetime(DateTime loanCollateralAdvisorSubmissionDatetime) {
        this.loanCollateralAdvisorSubmissionDatetime = loanCollateralAdvisorSubmissionDatetime;
    }

    public Double getPropertyAppraisedValueAmount() {
        return propertyAppraisedValueAmount;
    }

    public void setPropertyAppraisedValueAmount(Double propertyAppraisedValueAmount) {
        this.propertyAppraisedValueAmount = propertyAppraisedValueAmount;
    }

    public String getAppraisalDocumentType() {
        return appraisalDocumentType;
    }

    public void setAppraisalDocumentType(String appraisalDocumentType) {
        this.appraisalDocumentType = appraisalDocumentType;
    }

    public DateTime getPropertyValuationEffectiveDate() {
        return propertyValuationEffectiveDate;
    }

    public void setPropertyValuationEffectiveDate(DateTime propertyValuationEffectiveDate) {
        this.propertyValuationEffectiveDate = propertyValuationEffectiveDate;
    }

    public String getUcdpStatus() {
        return ucdpStatus;
    }

    public void setUcdpStatus(String ucdpStatus) {
        this.ucdpStatus = ucdpStatus;
    }

    @Override
    public boolean equals(Object xmlApprslContainersObj) {
        AppraisalContainer dbApprslContainers = this;
        Appraisal xmlApprslContainers = (Appraisal) xmlApprslContainersObj;
        if (xmlApprslContainers == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbApprslContainers.getEventId() + "\n");

            if (dbApprslContainers.getPropertyAppraisedValueAmount() != null
                    && xmlApprslContainers.getPropertyAppraisedValueAmount() != null) {
                String dbAppraisedValueAmount = TestConstants.decFormat
                        .format(Double.valueOf(dbApprslContainers.getPropertyAppraisedValueAmount().doubleValue()));
                String xmlAppraisedValueAmount = TestConstants.decFormat
                        .format(Double.valueOf(xmlApprslContainers.getPropertyAppraisedValueAmount().doubleValue()));
                if (!dbAppraisedValueAmount.equals(xmlAppraisedValueAmount)) {
                    GlobalHooks.getScenario().write("PropertyAppraisedValueAmount mismatch. Expected Value is "
                            + dbAppraisedValueAmount + " but actual value is " + xmlAppraisedValueAmount);
                    return false;
                } else {
                    sb.append("PropertyAppraisedValueAmount in DB: " + dbAppraisedValueAmount
                            + " PropertyAppraisedValueAmount in XML: " + xmlAppraisedValueAmount + "\n");
                    recordsCounter++;
                }
            }

            if (dbApprslContainers.getAppraisalDocumentType() != null
                    && xmlApprslContainers.getAppraisalDocumentType() != null) {
                if (!dbApprslContainers.getAppraisalDocumentType()
                        .equals(xmlApprslContainers.getAppraisalDocumentType())) {
                    GlobalHooks.getScenario().write("AppraisalDocumentType mismatch. Expected Value is "
                            + dbApprslContainers.getAppraisalDocumentType() + " but actual value is "
                            + dbApprslContainers.getAppraisalDocumentType());
                    return false;
                } else {
                    sb.append("AppraisalDocumentType in DB: " + dbApprslContainers.getAppraisalDocumentType()
                            + " AppraisalDocumentType in XML: " + xmlApprslContainers.getAppraisalDocumentType()
                            + "\n");
                    recordsCounter++;
                }
            }

            if (dbApprslContainers.getLoanCollateralAdvisorSubmissionDatetime() != null
                    && xmlApprslContainers.getLoanCollateralAdvisorSubmissionDatetime() != null) {
                if (!TestConstants.dtf.format(dbApprslContainers.getLoanCollateralAdvisorSubmissionDatetime().toDate())
                        .equals(TestConstants.dtf
                                .format(xmlApprslContainers.getLoanCollateralAdvisorSubmissionDatetime()))) {
                    GlobalHooks.getScenario().write("LoanCollateralAdvisorSubmissionDatetime mismatch. Expected Value is "
                            + TestConstants.dtf
                                    .format(dbApprslContainers.getLoanCollateralAdvisorSubmissionDatetime().toDate())
                            + " but actual value is "
                            + TestConstants.dtf.format(xmlApprslContainers.getLoanCollateralAdvisorSubmissionDatetime()));
                    return false;
                } else {
                    sb.append("LoanCollateralAdvisorSubmissionDatetime in DB: "
                            + TestConstants.dtf
                                    .format(dbApprslContainers.getLoanCollateralAdvisorSubmissionDatetime().toDate())
                            + " LoanCollateralAdvisorSubmissionDatetime in XML: "
                            + TestConstants.dtf.format(xmlApprslContainers.getLoanCollateralAdvisorSubmissionDatetime())
                            + "\n");
                    recordsCounter++;
                }
            }

            if (dbApprslContainers.getPropertyValuationEffectiveDate() != null
                    && xmlApprslContainers.getPropertyValuationEffectiveDate() != null) {
                if (!TestConstants.dtf.format(dbApprslContainers.getPropertyValuationEffectiveDate())
                        .equals(TestConstants.dtf.format(xmlApprslContainers.getPropertyValuationEffectiveDate()))) {
                    GlobalHooks.getScenario().write("PropertyValuationEffectiveDateTime mismatch. Expected Value is "
                            + TestConstants.dtf.format(this.getPropertyValuationEffectiveDate().toDate())
                            + " but actual value is "
                            + TestConstants.dtf.format(xmlApprslContainers.getPropertyValuationEffectiveDate()));
                    return false;
                } else {
                    sb.append("PropertyValuationEffectiveDateTime in DB: "
                            + TestConstants.dtf.format(dbApprslContainers.getPropertyValuationEffectiveDate().toDate())
                            + " PropertyValuationEffectiveDateTime in XML: "
                            + TestConstants.dtf.format(xmlApprslContainers.getPropertyValuationEffectiveDate()) + "\n");
                    recordsCounter++;
                }
            }

            if (dbApprslContainers.getUcdpStatus() != null && xmlApprslContainers.getUCDPStatus() != null) {
                if (!dbApprslContainers.getUcdpStatus().equals(xmlApprslContainers.getUCDPStatus())) {
                    GlobalHooks.getScenario()
                            .write("UcdpStatus mismatch. Expected Value is " + dbApprslContainers.getUcdpStatus()
                                    + " but actual value is " + xmlApprslContainers.getUCDPStatus());
                    return false;
                } else {
                    sb.append("UcdpStatus in DB: " + dbApprslContainers.getUcdpStatus() + " UcdpStatus in XML: "
                            + xmlApprslContainers.getUCDPStatus() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario().write(sb + "Apprsl Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<AppraisalContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<AppraisalContainer> results = new ArrayList<>();
        while (rs.next()) {
            AppraisalContainer appraisal = new AppraisalContainer();
            appraisal.setLoanCollateralAdvisorSubmissionDatetime(new DateTime(rs.getDate("DTTM_LCA_SUBMN")));
            appraisal.setPropertyValuationEffectiveDate(new DateTime(rs.getDate("DTTM_PPTY_VALUTN_EFF")));
            appraisal.setPropertyAppraisedValueAmount(rs.getDouble("AMT_PPTY_APPRSD_VAL"));
            appraisal.setAppraisalDocumentType(rs.getString("ID_APPRSL_DOC"));
            appraisal.setUcdpStatus(rs.getString("TEXT_UCDP_DOC_SCS_STS"));
            appraisal.setEventId(rs.getInt("ID_EVNT"));
            results.add(appraisal);
        }
        return results;
    }

    @Override
    public String toString() {
        return "AppraisalContainer [loanCollateralAdvisorSubmissionDatetime=" + loanCollateralAdvisorSubmissionDatetime
                + ", propertyAppraisedValueAmount=" + propertyAppraisedValueAmount + ", appraisalDocumentType="
                + appraisalDocumentType + ", propertyValuationEffectiveDate=" + propertyValuationEffectiveDate
                + ", ucdpStatus=" + ucdpStatus + ", eventId=" + eventId + "]";
    }
}
