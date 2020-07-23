package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.EvaluationServiceResultMessage;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class EvaluationServiceResultMessageContainer
        implements ResultSetExtractor<List<EvaluationServiceResultMessageContainer>> {
    private String evaluationResultMessageIdentifier;
    private String evaluationServiceResultMessageCategoryType;
    private String evaluationResultDecisionDescription;
    private String evaluationResultMessageText;
    private String evaluationResultMessageType;
    private String evaluationResultMessageSectionType;
    private String evaluationResultMessageSectionName;
    private int eventId;

    public EvaluationServiceResultMessageContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEvaluationResultMessageIdentifier() {
        return evaluationResultMessageIdentifier;
    }

    public void setEvaluationResultMessageIdentifier(String evaluationResultMessageIdentifier) {
        this.evaluationResultMessageIdentifier = evaluationResultMessageIdentifier;
    }

    public String getEvaluationServiceResultMessageCategoryType() {
        return evaluationServiceResultMessageCategoryType;
    }

    public void setEvaluationServiceResultMessageCategoryType(String evaluationServiceResultMessageCategoryType) {
        this.evaluationServiceResultMessageCategoryType = evaluationServiceResultMessageCategoryType;
    }

    public String getEvaluationResultDecisionDescription() {
        return evaluationResultDecisionDescription;
    }

    public void setEvaluationResultDecisionDescription(String evaluationResultDecisionDescription) {
        this.evaluationResultDecisionDescription = evaluationResultDecisionDescription;
    }

    public String getEvaluationResultMessageText() {
        return evaluationResultMessageText;
    }

    public void setEvaluationResultMessageText(String evaluationResultMessageText) {
        this.evaluationResultMessageText = evaluationResultMessageText;
    }

    public String getEvaluationResultMessageType() {
        return evaluationResultMessageType;
    }

    public void setEvaluationResultMessageType(String evaluationResultMessageType) {
        this.evaluationResultMessageType = evaluationResultMessageType;
    }

    public String getEvaluationResultMessageSectionType() {
        return evaluationResultMessageSectionType;
    }

    public void setEvaluationResultMessageSectionType(String evaluationResultMessageSectionType) {
        this.evaluationResultMessageSectionType = evaluationResultMessageSectionType;
    }

    public String getEvaluationResultMessageSectionName() {
        return evaluationResultMessageSectionName;
    }

    public void setEvaluationResultMessageSectionName(String evaluationResultMessageSectionName) {
        this.evaluationResultMessageSectionName = evaluationResultMessageSectionName;
    }

    @Override
    public boolean equals(Object xmlEvalMsgContainersObj) {
        EvaluationServiceResultMessageContainer dbEvalMsgContainers = this;
        EvaluationServiceResultMessage xmlEvalMsgContainers = (EvaluationServiceResultMessage) xmlEvalMsgContainersObj;
        if (xmlEvalMsgContainers == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbEvalMsgContainers.getEventId() + "\n");

            if (dbEvalMsgContainers.getEvaluationResultMessageIdentifier() != null
                    && xmlEvalMsgContainers.getEvaluationResultMessageIdentifier() != null) {
                if (!dbEvalMsgContainers.getEvaluationResultMessageIdentifier()
                        .equals(xmlEvalMsgContainers.getEvaluationResultMessageIdentifier())) {
                    GlobalHooks.getScenario().write("EvaluationResultMessageIdentifier mismatch. Expected Value is "
                            + dbEvalMsgContainers.getEvaluationResultMessageIdentifier() + " but actual value is "
                            + xmlEvalMsgContainers.getEvaluationResultMessageIdentifier());
                    return false;
                } else {
                    sb.append("EvaluationResultMessageIdentifier in DB: "
                            + dbEvalMsgContainers.getEvaluationResultMessageIdentifier()
                            + " EvaluationResultMessageIdentifier in XML: "
                            + xmlEvalMsgContainers.getEvaluationResultMessageIdentifier() + "\n");
                    recordsCounter++;
                }
            }

            if (dbEvalMsgContainers.getEvaluationResultMessageSectionName() != null
                    && xmlEvalMsgContainers.getEvaluationResultMessageSectionName() != null) {
                if (!dbEvalMsgContainers.getEvaluationResultMessageSectionName()
                        .equals(xmlEvalMsgContainers.getEvaluationResultMessageSectionName())) {
                    GlobalHooks.getScenario().write("EvaluationResultMessageSectionName mismatch. Expected Value is "
                            + dbEvalMsgContainers.getEvaluationResultMessageSectionName() + " but actual value is "
                            + xmlEvalMsgContainers.getEvaluationResultMessageSectionName());
                    return false;
                } else {
                    sb.append("EvaluationResultMessageSectionName in DB: "
                            + dbEvalMsgContainers.getEvaluationResultMessageSectionName()
                            + " EvaluationResultMessageSectionName in XML: "
                            + xmlEvalMsgContainers.getEvaluationResultMessageSectionName() + "\n");
                    recordsCounter++;
                }
            }

            if (dbEvalMsgContainers.getEvaluationResultMessageSectionType() != null
                    && xmlEvalMsgContainers.getEvaluationResultMessageSectionType() != null) {
                if (!dbEvalMsgContainers.getEvaluationResultMessageSectionType()
                        .equals(xmlEvalMsgContainers.getEvaluationResultMessageSectionType())) {
                    GlobalHooks.getScenario().write("EvaluationResultMessageSectionType mismatch. Expected Value is "
                            + dbEvalMsgContainers.getEvaluationResultMessageSectionType() + " but actual value is "
                            + xmlEvalMsgContainers.getEvaluationResultMessageSectionType());
                    return false;
                } else {
                    sb.append("EvaluationResultMessageSectionType in DB: "
                            + dbEvalMsgContainers.getEvaluationResultMessageSectionType()
                            + " EvaluationResultMessageSectionType in XML: "
                            + xmlEvalMsgContainers.getEvaluationResultMessageSectionType() + "\n");
                    recordsCounter++;
                }
            }

            if (dbEvalMsgContainers.getEvaluationResultMessageText() != null
                    && xmlEvalMsgContainers.getEvaluationResultMessageText() != null) {
                if (!dbEvalMsgContainers.getEvaluationResultMessageText()
                        .equals(xmlEvalMsgContainers.getEvaluationResultMessageText())) {
                    GlobalHooks.getScenario().write("EvaluationResultMessageText mismatch. Expected Value is "
                            + dbEvalMsgContainers.getEvaluationResultMessageText() + " but actual value is "
                            + xmlEvalMsgContainers.getEvaluationResultMessageText());
                    return false;
                } else {
                    sb.append(
                            "EvaluationResultMessageText in DB: " + dbEvalMsgContainers.getEvaluationResultMessageText()
                                    + " EvaluationResultMessageText in XML: "
                                    + xmlEvalMsgContainers.getEvaluationResultMessageText() + "\n");
                    recordsCounter++;
                }
            }
            if (dbEvalMsgContainers.getEvaluationResultMessageType() != null
                    && xmlEvalMsgContainers.getEvaluationResultMessageType() != null) {
                if (!dbEvalMsgContainers.getEvaluationResultMessageType()
                        .equals(xmlEvalMsgContainers.getEvaluationResultMessageType())) {
                    GlobalHooks.getScenario().write("EvaluationResultMessageType mismatch. Expected Value is "
                            + dbEvalMsgContainers.getEvaluationResultMessageType() + " but actual value is "
                            + xmlEvalMsgContainers.getEvaluationResultMessageType());
                    return false;
                } else {
                    sb.append(
                            "EvaluationResultMessageType in DB: " + dbEvalMsgContainers.getEvaluationResultMessageType()
                                    + " EvaluationResultMessageType in XML: "
                                    + xmlEvalMsgContainers.getEvaluationResultMessageType() + "\n");
                    recordsCounter++;
                }
            }

            if (dbEvalMsgContainers.getEvaluationServiceResultMessageCategoryType() != null
                    && xmlEvalMsgContainers.getEvaluationServiceResultMessageCategoryType() != null) {
                if (!dbEvalMsgContainers.getEvaluationServiceResultMessageCategoryType()
                        .equals(xmlEvalMsgContainers.getEvaluationServiceResultMessageCategoryType())) {
                    GlobalHooks.getScenario().write("EvaluationServiceResultMessageCategoryType mismatch. Expected Value is "
                            + dbEvalMsgContainers.getEvaluationServiceResultMessageCategoryType()
                            + " but actual value is "
                            + xmlEvalMsgContainers.getEvaluationServiceResultMessageCategoryType());
                    return false;
                } else {
                    sb.append("EvaluationServiceResultMessageCategoryType in DB: "
                            + dbEvalMsgContainers.getEvaluationServiceResultMessageCategoryType()
                            + " EvaluationServiceResultMessageCategoryType in XML: "
                            + xmlEvalMsgContainers.getEvaluationServiceResultMessageCategoryType() + "\n");
                    recordsCounter++;
                }
            }

            if (dbEvalMsgContainers.getEvaluationResultDecisionDescription() != null
                    && xmlEvalMsgContainers.getEvaluationResultDecisionDescription() != null) {
                if (!dbEvalMsgContainers.getEvaluationResultDecisionDescription()
                        .equals(xmlEvalMsgContainers.getEvaluationResultDecisionDescription())) {
                    GlobalHooks.getScenario().write("EvaluationResultDecisionDescription mismatch. Expected Value is "
                            + dbEvalMsgContainers.getEvaluationResultDecisionDescription() + " but actual value is "
                            + xmlEvalMsgContainers.getEvaluationResultDecisionDescription());
                    return false;
                } else {
                    sb.append("EvaluationResultDecisionDescription in DB: "
                            + dbEvalMsgContainers.getEvaluationResultDecisionDescription()
                            + " EvaluationResultDecisionDescription in XML: "
                            + xmlEvalMsgContainers.getEvaluationResultDecisionDescription() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario().write(
                    sb + "EvaluationServiceResultMessage Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<EvaluationServiceResultMessageContainer> extractData(ResultSet rs)
            throws SQLException, DataAccessException {
        List<EvaluationServiceResultMessageContainer> results = new ArrayList<>();
        while (rs.next()) {
            EvaluationServiceResultMessageContainer evaluationServiceResultMessage = new EvaluationServiceResultMessageContainer();
            evaluationServiceResultMessage.setEvaluationResultMessageIdentifier(rs.getString("ID_EVAL_RSLT_MSG"));
            evaluationServiceResultMessage
                    .setEvaluationResultDecisionDescription(rs.getString("DESC_EVAL_RSLT_MSG_DCSN"));
            evaluationServiceResultMessage
                    .setEvaluationResultMessageSectionName(rs.getString("NAME_EVAL_RSLT_MSG_SECT"));
            evaluationServiceResultMessage.setEvaluationResultMessageSectionType(rs.getString("CD_EVAL_RSLT_MSG_SECT"));
            evaluationServiceResultMessage.setEvaluationResultMessageText(rs.getString("TEXT_EVAL_RSLT_MSG"));
            evaluationServiceResultMessage.setEvaluationResultMessageType(rs.getString("CD_EVAL_RSLT_MSG"));
            evaluationServiceResultMessage
                    .setEvaluationServiceResultMessageCategoryType(rs.getString("NAME_EVAL_RSLT_MSG_CAT_TYPE"));
            evaluationServiceResultMessage.setEventId(rs.getInt("ID_EVNT"));
            results.add(evaluationServiceResultMessage);
        }
        return results;
    }

    @Override
    public String toString() {
        return "EvaluationServiceResultMessageContainer [evaluationResultMessageIdentifier="
                + evaluationResultMessageIdentifier + ", evaluationServiceResultMessageCategoryType="
                + evaluationServiceResultMessageCategoryType + ", evaluationResultDecisionDescription="
                + evaluationResultDecisionDescription + ", evaluationResultMessageText=" + evaluationResultMessageText
                + ", evaluationResultMessageType=" + evaluationResultMessageType
                + ", evaluationResultMessageSectionType=" + evaluationResultMessageSectionType
                + ", evaluationResultMessageSectionName=" + evaluationResultMessageSectionName + ", eventId=" + eventId
                + "]";
    }

}
