package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.Document;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class DocumentContainer implements ResultSetExtractor<List<DocumentContainer>> {
    private String documentType;
    private int eventId;

    public DocumentContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @Override
    public boolean equals(Object xmlDocumentObj) {
        DocumentContainer dbDocument = this;
        Document xmlDocument = (Document) xmlDocumentObj;
        if (xmlDocument == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbDocument.getEventId() + "\n");

            if (dbDocument.getDocumentType() != null && xmlDocument.getDocumentType() != null) {
                if (!dbDocument.getDocumentType().equals(xmlDocument.getDocumentType())) {
                    GlobalHooks.getScenario().write("DocumentType mismatch. Expected Value is "
                            + dbDocument.getDocumentType() + " but actual value is " + xmlDocument.getDocumentType());
                    return false;
                } else {
                    sb.append("DocumentType in DB: " + dbDocument.getDocumentType() + " DocumentType in XML: "
                            + xmlDocument.getDocumentType() + "\n");
                    recordsCounter++;
                }
            }

            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario().write(sb + "Document Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<DocumentContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<DocumentContainer> results = new ArrayList<>();
        while (rs.next()) {
            DocumentContainer document = new DocumentContainer();
            document.setDocumentType(rs.getString("NAME_DOC_TYPE"));
            document.setEventId(rs.getInt("ID_EVNT"));
            results.add(document);
        }
        return results;
    }

    @Override
    public String toString() {
        return "DocumentContainer [documentType=" + documentType + ", eventId=" + eventId + "]";
    }
}
