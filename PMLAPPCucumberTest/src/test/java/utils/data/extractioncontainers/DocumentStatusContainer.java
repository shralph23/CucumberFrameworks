package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.DocumentStatus;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class DocumentStatusContainer implements ResultSetExtractor<List<DocumentStatusContainer>> {
    private String documentStatusType;
    private int eventId;

    public DocumentStatusContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getDocumentStatusType() {
        return documentStatusType;
    }

    public void setDocumentStatusType(String documentStatusType) {
        this.documentStatusType = documentStatusType;
    }

    @Override
    public boolean equals(Object xmlDocumentStatusObj) {
        DocumentStatusContainer dbDocumentStatus = this;
        DocumentStatus xmldocumentStatus = (DocumentStatus) xmlDocumentStatusObj;
        if (xmldocumentStatus == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbDocumentStatus.getEventId() + "\n");

            if (dbDocumentStatus.getDocumentStatusType() != null && xmldocumentStatus.getDocumentStatusType() != null) {
                if (!dbDocumentStatus.getDocumentStatusType().equals(xmldocumentStatus.getDocumentStatusType())) {
                    GlobalHooks.getScenario().write(
                            "DocumentStatusType mismatch. Expected Value is " + dbDocumentStatus.getDocumentStatusType()
                                    + " but actual value is " + xmldocumentStatus.getDocumentStatusType());
                    return false;
                } else {
                    sb.append("DocumentStatusType in DB: " + dbDocumentStatus.getDocumentStatusType()
                            + " DocumentStatusType in XML: " + xmldocumentStatus.getDocumentStatusType() + "\n");
                    recordsCounter++;
                }
            }

            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario().write(sb + "DocumentStatus Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<DocumentStatusContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<DocumentStatusContainer> results = new ArrayList<>();
        while (rs.next()) {
            DocumentStatusContainer documentStatus = new DocumentStatusContainer();
            documentStatus.setDocumentStatusType(rs.getString("NAME_DOC_STS_TYPE"));
            documentStatus.setEventId(rs.getInt("ID_EVNT"));
            results.add(documentStatus);
        }
        return results;
    }

    @Override
    public String toString() {
        return "DocumentStatusContainer [documentStatusType=" + documentStatusType + ", eventId=" + eventId + "]";
    }
}
