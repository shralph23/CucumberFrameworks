package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.LoanDocument;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class LoanDocumentContainer implements ResultSetExtractor<List<LoanDocumentContainer>> {
    private String applicationInputProcessingMethodType;
    private String loanDocumentIdentifier;
    private String loanDocumentType;
    private String loanIdentifier;
    private String eventId;

    public LoanDocumentContainer() {

    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getApplicationInputProcessingMethodType() {
        return applicationInputProcessingMethodType;
    }

    public void setApplicationInputProcessingMethodType(String applicationInputProcessingMethodType) {
        this.applicationInputProcessingMethodType = applicationInputProcessingMethodType;
    }

    public String getLoanDocumentIdentifier() {
        return loanDocumentIdentifier;
    }

    public void setLoanDocumentIdentifier(String loanDocumentIdentifier) {
        this.loanDocumentIdentifier = loanDocumentIdentifier;
    }

    public String getLoanDocumentType() {
        return loanDocumentType;
    }

    public void setLoanDocumentType(String loanDocumentType) {
        this.loanDocumentType = loanDocumentType;
    }

    public String getLoanIdentifier() {
        return loanIdentifier;
    }

    public void setLoanIdentifier(String loanIdentifier) {
        this.loanIdentifier = loanIdentifier;
    }

    @Override
    public boolean equals(Object xmlLoanDocumentContainersObj) {
        LoanDocumentContainer dbLoanDocumentContainers = this;
        LoanDocument xmlLoanDocumentContainers = (LoanDocument) xmlLoanDocumentContainersObj;
        if (xmlLoanDocumentContainers == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbLoanDocumentContainers.getEventId() + "\n");
            if (dbLoanDocumentContainers.getApplicationInputProcessingMethodType() != null
                    && xmlLoanDocumentContainers.getApplicationInputProcessingMethodType() != null) {
                if (!dbLoanDocumentContainers.getApplicationInputProcessingMethodType()
                        .equals(xmlLoanDocumentContainers.getApplicationInputProcessingMethodType())) {
                    GlobalHooks.getScenario().write("ApplicationInputProcessingMethodType mismatch. Expected Value is "
                            + dbLoanDocumentContainers.getApplicationInputProcessingMethodType()
                            + " but actual value is "
                            + xmlLoanDocumentContainers.getApplicationInputProcessingMethodType());
                    return false;
                } else {
                    sb.append("ApplicationInputProcessingMethodType in DB: "
                            + dbLoanDocumentContainers.getApplicationInputProcessingMethodType()
                            + " ApplicationInputProcessingMethodType in XML: "
                            + xmlLoanDocumentContainers.getApplicationInputProcessingMethodType() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario().write(sb + "LoanDocument Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<LoanDocumentContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<LoanDocumentContainer> results = new ArrayList<>();
        while (rs.next()) {
            LoanDocumentContainer loanDocument = new LoanDocumentContainer();
            loanDocument.setEventId(rs.getString("ID_EVNT"));
            loanDocument.setApplicationInputProcessingMethodType(rs.getString("CD_PRCSG_METH"));
            results.add(loanDocument);
        }
        return results;
    }

    @Override
    public String toString() {
        return "LoanDocumentContainer [applicationInputProcessingMethodType=" + applicationInputProcessingMethodType
                + ", eventId=" + eventId + "]";
    }

}
