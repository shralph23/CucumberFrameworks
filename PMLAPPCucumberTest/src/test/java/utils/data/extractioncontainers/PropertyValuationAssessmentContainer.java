package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.PropertyValuationAssessment;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class PropertyValuationAssessmentContainer
        implements ResultSetExtractor<List<PropertyValuationAssessmentContainer>> {
    private Double AppraisalReportQualityScoreNumber;
    private Double PropertyValuationAlignmentScoreNumber;
    private int eventId;

    public PropertyValuationAssessmentContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Double getAppraisalReportQualityScoreNumber() {
        return AppraisalReportQualityScoreNumber;
    }

    public void setAppraisalReportQualityScoreNumber(Double appraisalReportQualityScoreNumber) {
        AppraisalReportQualityScoreNumber = appraisalReportQualityScoreNumber;
    }

    public Double getPropertyValuationAlignmentScoreNumber() {
        return PropertyValuationAlignmentScoreNumber;
    }

    public void setPropertyValuationAlignmentScoreNumber(Double propertyValuationAlignmentScoreNumber) {
        PropertyValuationAlignmentScoreNumber = propertyValuationAlignmentScoreNumber;
    }

    @Override
    public boolean equals(Object xmlPropertyValuationAssessmentContainers) {
        PropertyValuationAssessmentContainer dbpropValAssessment = this;
        PropertyValuationAssessment xmlpropValAssessment = (PropertyValuationAssessment) xmlPropertyValuationAssessmentContainers;
        if (xmlpropValAssessment == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbpropValAssessment.getEventId() + "\n");
            if (dbpropValAssessment.getAppraisalReportQualityScoreNumber() != null
                    && xmlpropValAssessment.getFreddieMacAppraisalQualityScoreNumber() != null) {
                String dbAppraisalReportQualityScoreNumber = TestConstants.decFormat.format(
                        Double.valueOf(dbpropValAssessment.getAppraisalReportQualityScoreNumber().doubleValue()));
                String xmlAppraisalReportQualityScoreNumber = TestConstants.decFormat.format(
                        Double.valueOf(xmlpropValAssessment.getFreddieMacAppraisalQualityScoreNumber().doubleValue()));
                if (!dbAppraisalReportQualityScoreNumber.equals(xmlAppraisalReportQualityScoreNumber)) {
                    GlobalHooks.getScenario().write("AppraisalReportQualityScoreNumber mismatch. Expected Value is "
                            + xmlAppraisalReportQualityScoreNumber + " but actual value is "
                            + dbAppraisalReportQualityScoreNumber);
                    return false;
                } else {
                    sb.append("AppraisalReportQualityScoreNumber in DB: " + dbAppraisalReportQualityScoreNumber
                            + " AppraisalReportQualityScoreNumber in XML: " + xmlAppraisalReportQualityScoreNumber
                            + "\n");
                    recordsCounter++;
                }
            }

            if (dbpropValAssessment.getPropertyValuationAlignmentScoreNumber() != null
                    && xmlpropValAssessment.getPropertyValuationAlignmentScoreNumber() != null) {
                String dbPropertyValuationAlignmentScoreNumber = TestConstants.decFormat.format(
                        Double.valueOf(dbpropValAssessment.getPropertyValuationAlignmentScoreNumber().doubleValue()));
                String xmlPropertyValuationAlignmentScoreNumber = TestConstants.decFormat.format(
                        Double.valueOf(xmlpropValAssessment.getPropertyValuationAlignmentScoreNumber().doubleValue()));
                if (!dbPropertyValuationAlignmentScoreNumber.equals(xmlPropertyValuationAlignmentScoreNumber)) {
                    GlobalHooks.getScenario().write("PropertyValuationAlignmentScoreNumber mismatch. Expected Value is "
                            + dbPropertyValuationAlignmentScoreNumber + " but actual value is "
                            + xmlPropertyValuationAlignmentScoreNumber);
                    return false;
                } else {
                    sb.append("PropertyValuationAlignmentScoreNumber in DB: " + dbPropertyValuationAlignmentScoreNumber
                            + " PropertyValuationAlignmentScoreNumber in XML: "
                            + xmlPropertyValuationAlignmentScoreNumber + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario().write(
                    sb + "PropertyValuationAssessment Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<PropertyValuationAssessmentContainer> extractData(ResultSet rs)
            throws SQLException, DataAccessException {
        List<PropertyValuationAssessmentContainer> results = new ArrayList<>();
        while (rs.next()) {
            PropertyValuationAssessmentContainer propertyValuationAssessment = new PropertyValuationAssessmentContainer();
            propertyValuationAssessment.setAppraisalReportQualityScoreNumber(rs.getDouble("NBR_FM_APPRSL_QUAL_SCR"));
            propertyValuationAssessment
                    .setPropertyValuationAlignmentScoreNumber(rs.getDouble("NBR_PPTY_VALUTN_ALGNMT_SCR"));
            propertyValuationAssessment.setEventId(rs.getInt("ID_EVNT"));
            results.add(propertyValuationAssessment);
        }
        return results;
    }

    @Override
    public String toString() {
        return "PropertyValuationAssessmentContainer [AppraisalReportQualityScoreNumber="
                + AppraisalReportQualityScoreNumber + ", PropertyValuationAlignmentScoreNumber="
                + PropertyValuationAlignmentScoreNumber + ", eventId=" + eventId + "]";
    }
}
