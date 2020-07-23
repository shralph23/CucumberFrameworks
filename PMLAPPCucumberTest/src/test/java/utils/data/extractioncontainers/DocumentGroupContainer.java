package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.DocumentGroup;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class DocumentGroupContainer implements ResultSetExtractor<List<DocumentGroupContainer>> {
    private String documentGroupType;
    private String documentRequirementSatisfiedType;
    private int eventId;

    public DocumentGroupContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getDocumentGroupType() {
        return documentGroupType;
    }

    public void setDocumentGroupType(String documentGroupType) {
        this.documentGroupType = documentGroupType;
    }

    public String getDocumentRequirementSatisfiedType() {
        return documentRequirementSatisfiedType;
    }

    public void setDocumentRequirementSatisfiedType(String documentRequirementSatisfiedType) {
        this.documentRequirementSatisfiedType = documentRequirementSatisfiedType;
    }

    @Override
    public boolean equals(Object xmlDocumentGroupContainersObj) {
        DocumentGroupContainer dbDocumentGroupContainers = this;
        DocumentGroup xmlDocumentGroupContainers = (DocumentGroup) xmlDocumentGroupContainersObj;
        if (xmlDocumentGroupContainers == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbDocumentGroupContainers.getEventId() + "\n");
            if (dbDocumentGroupContainers.getDocumentGroupType() != null
                    && xmlDocumentGroupContainers.getDocumentGroupType() != null) {
                if (!dbDocumentGroupContainers.getDocumentGroupType()
                        .equals(xmlDocumentGroupContainers.getDocumentGroupType())) {
                    GlobalHooks.getScenario().write("DocumentGroupType mismatch. Expected Value is "
                            + dbDocumentGroupContainers.getDocumentGroupType() + " but actual value is "
                            + xmlDocumentGroupContainers.getDocumentGroupType());
                    return false;
                } else {
                    sb.append("DocumentGroupType in DB: " + dbDocumentGroupContainers.getDocumentGroupType()
                            + " DocumentGroupType in XML: " + xmlDocumentGroupContainers.getDocumentGroupType() + "\n");
                    recordsCounter++;
                }
            }

            if (dbDocumentGroupContainers.getDocumentRequirementSatisfiedType() != null
                    && xmlDocumentGroupContainers.getDocumentRequirementSatisfiedType() != null) {
                if (!dbDocumentGroupContainers.getDocumentRequirementSatisfiedType()
                        .equals(xmlDocumentGroupContainers.getDocumentRequirementSatisfiedType())) {
                    GlobalHooks.getScenario().write("DocumentRequirementSatisfiedType mismatch. Expected Value is "
                            + dbDocumentGroupContainers.getDocumentRequirementSatisfiedType() + " but actual value is "
                            + xmlDocumentGroupContainers.getDocumentRequirementSatisfiedType());
                    return false;
                } else {
                    sb.append("DocumentRequirementSatisfiedType in DB: "
                            + dbDocumentGroupContainers.getDocumentRequirementSatisfiedType()
                            + " DocumentRequirementSatisfiedType in XML: "
                            + xmlDocumentGroupContainers.getDocumentRequirementSatisfiedType() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario().write(sb + "DocumentGroup Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<DocumentGroupContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<DocumentGroupContainer> results = new ArrayList<>();
        while (rs.next()) {
            DocumentGroupContainer documentGroup = new DocumentGroupContainer();
            documentGroup.setDocumentGroupType(rs.getString("NAME_DOC_GRP_TYPE"));
            documentGroup.setDocumentRequirementSatisfiedType(rs.getString("NAME_DOC_REQ_STSFD_TYPE"));
            documentGroup.setEventId(rs.getInt("ID_EVNT"));
            results.add(documentGroup);
        }
        return results;
    }

    @Override
    public String toString() {
        return "DocumentGroupContainer [documentGroupType=" + documentGroupType + ", documentRequirementSatisfiedType="
                + documentRequirementSatisfiedType + ", eventId=" + eventId + "]";
    }
}
