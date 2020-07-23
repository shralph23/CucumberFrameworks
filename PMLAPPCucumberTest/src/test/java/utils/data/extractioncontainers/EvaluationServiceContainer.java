package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.EvaluationService;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class EvaluationServiceContainer implements ResultSetExtractor<List<EvaluationServiceContainer>> {
    private String evaluationResultMessageSourceType;
    private String evaluationServiceIdentifier;
    private String evaluationServiceCategoryType;
    private String evaluationServiceConclusionDescription;
    private int eventId;

    public EvaluationServiceContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEvaluationResultMessageSourceType() {
        return evaluationResultMessageSourceType;
    }

    public void setEvaluationResultMessageSourceType(String evaluationResultMessageSourceType) {
        this.evaluationResultMessageSourceType = evaluationResultMessageSourceType;
    }

    public String getEvaluationServiceIdentifier() {
        return evaluationServiceIdentifier;
    }

    public void setEvaluationServiceIdentifier(String evaluationServiceIdentifier) {
        this.evaluationServiceIdentifier = evaluationServiceIdentifier;
    }

    public String getEvaluationServiceCategoryType() {
        return evaluationServiceCategoryType;
    }

    public void setEvaluationServiceCategoryType(String evaluationServiceCategoryType) {
        this.evaluationServiceCategoryType = evaluationServiceCategoryType;
    }

    public String getEvaluationServiceConclusionDescription() {
        return evaluationServiceConclusionDescription;
    }

    public void setEvaluationServiceConclusionDescription(String evaluationServiceConclusionDescription) {
        this.evaluationServiceConclusionDescription = evaluationServiceConclusionDescription;
    }

    @Override
    public boolean equals(Object xmlEvalSrvcContainersObj) {
        EvaluationServiceContainer dbEvalSrvcContainers = this;
        EvaluationService xmlEvalSrvcContainers = (EvaluationService) xmlEvalSrvcContainersObj;
        if (xmlEvalSrvcContainers == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbEvalSrvcContainers.getEventId() + "\n");
            if (dbEvalSrvcContainers.getEvaluationServiceIdentifier() != null
                    && xmlEvalSrvcContainers.getEvaluationServiceIdentifier() != null) {
                if (!dbEvalSrvcContainers.getEvaluationServiceIdentifier()
                        .equals(xmlEvalSrvcContainers.getEvaluationServiceIdentifier())) {
                    GlobalHooks.getScenario().write("EvaluationServiceIdentifier mismatch. Expected Value is "
                            + dbEvalSrvcContainers.getEvaluationServiceIdentifier() + " but actual value is "
                            + xmlEvalSrvcContainers.getEvaluationServiceIdentifier());
                    return false;
                } else {
                    sb.append("EvaluationServiceIdentifier in DB: "
                            + dbEvalSrvcContainers.getEvaluationServiceIdentifier()
                            + " EvaluationServiceIdentifier in XML: "
                            + xmlEvalSrvcContainers.getEvaluationServiceIdentifier() + "\n");
                    recordsCounter++;
                }
            }

            if (dbEvalSrvcContainers.getEvaluationResultMessageSourceType() != null
                    && xmlEvalSrvcContainers.getEvaluationResultMessageSourceType() != null) {
                if (!dbEvalSrvcContainers.getEvaluationResultMessageSourceType()
                        .equals(xmlEvalSrvcContainers.getEvaluationResultMessageSourceType())) {
                    GlobalHooks.getScenario().write("EvaluationResultMessageSourceType mismatch. Expected Value is "
                            + dbEvalSrvcContainers.getEvaluationResultMessageSourceType() + " but actual value is "
                            + xmlEvalSrvcContainers.getEvaluationResultMessageSourceType());
                    return false;
                } else {
                    sb.append("EvaluationResultMessageSourceType in DB: "
                            + dbEvalSrvcContainers.getEvaluationResultMessageSourceType()
                            + " getEvaluationResultMessageSourceType in XML: "
                            + xmlEvalSrvcContainers.getEvaluationResultMessageSourceType() + "\n");
                    recordsCounter++;
                }
            }

            if (dbEvalSrvcContainers.getEvaluationServiceCategoryType() != null
                    && xmlEvalSrvcContainers.getEvaluationServiceCategoryType() != null) {
                if (!dbEvalSrvcContainers.getEvaluationServiceCategoryType()
                        .equals(xmlEvalSrvcContainers.getEvaluationServiceCategoryType())) {
                    GlobalHooks.getScenario().write("EvaluationServiceCategoryType mismatch. Expected Value is "
                            + dbEvalSrvcContainers.getEvaluationServiceCategoryType() + " but actual value is "
                            + xmlEvalSrvcContainers.getEvaluationServiceCategoryType());
                    return false;
                } else {
                    sb.append("EvaluationServiceCategoryType in DB: "
                            + dbEvalSrvcContainers.getEvaluationServiceCategoryType()
                            + " EvaluationServiceCategoryType in XML: "
                            + xmlEvalSrvcContainers.getEvaluationServiceCategoryType() + "\n");
                    recordsCounter++;
                }
            }

            if (dbEvalSrvcContainers.getEvaluationServiceConclusionDescription() != null
                    && xmlEvalSrvcContainers.getEvaluationServiceConclusionDescription() != null) {
                if (!dbEvalSrvcContainers.getEvaluationServiceConclusionDescription()
                        .equals(xmlEvalSrvcContainers.getEvaluationServiceConclusionDescription())) {
                    GlobalHooks.getScenario().write("EvaluationServiceConclusionDescription mismatch. Expected Value is "
                            + dbEvalSrvcContainers.getEvaluationServiceConclusionDescription() + " but actual value is "
                            + xmlEvalSrvcContainers.getEvaluationServiceConclusionDescription());
                    return false;
                } else {
                    sb.append("EvaluationServiceConclusionDescription in DB: "
                            + dbEvalSrvcContainers.getEvaluationServiceConclusionDescription()
                            + " EvaluationServiceConclusionDescription in XML: "
                            + xmlEvalSrvcContainers.getEvaluationServiceConclusionDescription() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario()
                    .write(sb + "EvaluationService Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<EvaluationServiceContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<EvaluationServiceContainer> results = new ArrayList<>();
        while (rs.next()) {
            EvaluationServiceContainer evaluationService = new EvaluationServiceContainer();
            evaluationService.setEvaluationResultMessageSourceType(rs.getString("NAME_EVAL_RSLT_MSG_SRCE_TYPE"));
            evaluationService.setEvaluationServiceCategoryType(rs.getString("NAME_EVAL_SVC_CAT"));
            evaluationService.setEvaluationServiceConclusionDescription(rs.getString("DESC_EVAL_SVC_CNCLSN"));
            evaluationService.setEvaluationServiceIdentifier(rs.getString("ID_EVAL_SVC"));
            evaluationService.setEventId(rs.getInt("ID_EVNT"));
            results.add(evaluationService);
        }
        return results;
    }

    @Override
    public String toString() {
        return "EvaluationServiceContainer [evaluationResultMessageSourceType=" + evaluationResultMessageSourceType
                + ", evaluationServiceIdentifier=" + evaluationServiceIdentifier + ", evaluationServiceCategoryType="
                + evaluationServiceCategoryType + ", evaluationServiceConclusionDescription="
                + evaluationServiceConclusionDescription + ", eventId=" + eventId + "]";
    }

}
