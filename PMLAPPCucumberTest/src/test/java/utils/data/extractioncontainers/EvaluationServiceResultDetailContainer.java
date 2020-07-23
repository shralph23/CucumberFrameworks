package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.EvaluationServiceResultDetail;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class EvaluationServiceResultDetailContainer
        implements ResultSetExtractor<List<EvaluationServiceResultDetailContainer>> {
    private String evaluationResultSequenceNumber;
    private String evaluationServiceCategoryType;
    private String evaluationServiceCategoryName;
    private String evaluationResultDecisionDescription;
    private int eventId;

    public EvaluationServiceResultDetailContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEvaluationResultSequenceNumber() {
        return evaluationResultSequenceNumber;
    }

    public void setEvaluationResultSequenceNumber(String evaluationResultSequenceNumber) {
        this.evaluationResultSequenceNumber = evaluationResultSequenceNumber;
    }

    public String getEvaluationServiceCategoryType() {
        return evaluationServiceCategoryType;
    }

    public void setEvaluationServiceCategoryType(String evaluationServiceCategoryType) {
        this.evaluationServiceCategoryType = evaluationServiceCategoryType;
    }

    public String getEvaluationServiceCategoryName() {
        return evaluationServiceCategoryName;
    }

    public void setEvaluationServiceCategoryName(String evaluationServiceCategoryName) {
        this.evaluationServiceCategoryName = evaluationServiceCategoryName;
    }

    public String getEvaluationResultDecisionDescription() {
        return evaluationResultDecisionDescription;
    }

    public void setEvaluationResultDecisionDescription(String evaluationResultDecisionDescription) {
        this.evaluationResultDecisionDescription = evaluationResultDecisionDescription;
    }

    @Override
    public boolean equals(Object xmlEvalSrvcResDetContainersObj) {
        EvaluationServiceResultDetailContainer dbEvalSrvcResDetContainers = this;
        EvaluationServiceResultDetail xmlEvalSrvcResDetContainers = (EvaluationServiceResultDetail) xmlEvalSrvcResDetContainersObj;
        if (xmlEvalSrvcResDetContainers == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbEvalSrvcResDetContainers.getEventId() + "\n");
            if (dbEvalSrvcResDetContainers.getEvaluationResultSequenceNumber() != null
                    && xmlEvalSrvcResDetContainers.getEvaluationResultSequenceNumber() != null) {
                if (!dbEvalSrvcResDetContainers.getEvaluationResultSequenceNumber()
                        .equals(xmlEvalSrvcResDetContainers.getEvaluationResultSequenceNumber().toString())) {
                    GlobalHooks.getScenario().write("EvaluationResultSequenceNumber mismatch. Expected Value is "
                            + dbEvalSrvcResDetContainers.getEvaluationResultSequenceNumber() + " but actual value is "
                            + xmlEvalSrvcResDetContainers.getEvaluationResultSequenceNumber());
                    return false;
                } else {
                    sb.append("EvaluationResultSequenceNumber in DB: "
                            + dbEvalSrvcResDetContainers.getEvaluationResultSequenceNumber()
                            + " EvaluationResultSequenceNumber in XML: "
                            + xmlEvalSrvcResDetContainers.getEvaluationResultSequenceNumber() + "\n");
                    recordsCounter++;
                }
            }

            if (dbEvalSrvcResDetContainers.getEvaluationServiceCategoryType() != null
                    && xmlEvalSrvcResDetContainers.getEvaluationServiceCategoryType() != null) {
                if (!dbEvalSrvcResDetContainers.getEvaluationServiceCategoryType()
                        .equals(xmlEvalSrvcResDetContainers.getEvaluationServiceCategoryType())) {
                    GlobalHooks.getScenario().write("EvaluationServiceCategoryType mismatch. Expected Value is "
                            + dbEvalSrvcResDetContainers.getEvaluationServiceCategoryType() + " but actual value is "
                            + xmlEvalSrvcResDetContainers.getEvaluationServiceCategoryType());
                    return false;
                } else {
                    sb.append("EvaluationServiceCategoryType in DB: "
                            + dbEvalSrvcResDetContainers.getEvaluationServiceCategoryType()
                            + " EvaluationServiceCategoryType in XML: "
                            + xmlEvalSrvcResDetContainers.getEvaluationServiceCategoryType() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario().write(
                    sb + "EvaluationServiceResultDetail Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<EvaluationServiceResultDetailContainer> extractData(ResultSet rs)
            throws SQLException, DataAccessException {
        List<EvaluationServiceResultDetailContainer> results = new ArrayList<>();
        while (rs.next()) {
            EvaluationServiceResultDetailContainer evaluationServiceResultDetail = new EvaluationServiceResultDetailContainer();
            evaluationServiceResultDetail.setEvaluationResultSequenceNumber(rs.getString("NBR_EVAL_RSLT_SEQ"));
            evaluationServiceResultDetail.setEvaluationServiceCategoryType(rs.getString("CD_EVAL_RSLT_CAT"));
            evaluationServiceResultDetail.setEventId(rs.getInt("ID_EVNT"));
            results.add(evaluationServiceResultDetail);
        }
        return results;
    }

    @Override
    public String toString() {
        return "EvaluationServiceResultDetailContainer [evaluationResultSequenceNumber="
                + evaluationResultSequenceNumber + ", evaluationServiceCategoryType=" + evaluationServiceCategoryType
                + ", eventId=" + eventId + "]";
    }

}
