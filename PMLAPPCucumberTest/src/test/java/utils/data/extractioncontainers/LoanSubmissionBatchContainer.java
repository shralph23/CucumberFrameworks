package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.LoanSubmissionBatch;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class LoanSubmissionBatchContainer implements ResultSetExtractor<List<LoanSubmissionBatchContainer>> {

    private String sourceBatchIdentifier;
    private String sourceSystemType;
    private String batchSubmissionDatetime;
    private int eventId;

    public LoanSubmissionBatchContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getSourceBatchIdentifier() {
        return sourceBatchIdentifier;
    }

    public void setSourceBatchIdentifier(String sourceBatchIdentifier) {
        this.sourceBatchIdentifier = sourceBatchIdentifier;
    }

    public String getSourceSystemType() {
        return sourceSystemType;
    }

    public void setSourceSystemType(String sourceSystemType) {
        this.sourceSystemType = sourceSystemType;
    }

    public String getBatchSubmissionDatetime() {
        return batchSubmissionDatetime;
    }

    public void setBatchSubmissionDatetime(String batchSubmissionDatetime) {
        this.batchSubmissionDatetime = batchSubmissionDatetime;
    }

    @Override
    public boolean equals(Object xmlLoanSubmissionBatchContainersObj) {
        LoanSubmissionBatchContainer dbLoanSubmissionBatchContainers = this;
        LoanSubmissionBatch xmlLoanSubmissionBatchContainers = (LoanSubmissionBatch) xmlLoanSubmissionBatchContainersObj;
        if (xmlLoanSubmissionBatchContainers == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbLoanSubmissionBatchContainers.getEventId() + "\n");
            if (dbLoanSubmissionBatchContainers.getSourceBatchIdentifier() != null
                    && xmlLoanSubmissionBatchContainers.getSourceBatchIdentifier() != null) {
                if (!dbLoanSubmissionBatchContainers.getSourceBatchIdentifier()
                        .equals(xmlLoanSubmissionBatchContainers.getSourceBatchIdentifier())) {
                    GlobalHooks.getScenario().write("SourceBatchIdentifier mismatch. Expected Value is "
                            + dbLoanSubmissionBatchContainers.getSourceBatchIdentifier() + " but actual value is "
                            + dbLoanSubmissionBatchContainers.getSourceBatchIdentifier());
                    return false;
                } else {
                    sb.append(
                            "SourceBatchIdentifier in DB: " + dbLoanSubmissionBatchContainers.getSourceBatchIdentifier()
                                    + " SourceBatchIdentifier in XML: "
                                    + xmlLoanSubmissionBatchContainers.getSourceBatchIdentifier() + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanSubmissionBatchContainers.getSourceSystemType() != null
                    && xmlLoanSubmissionBatchContainers.getSourceSystemType() != null) {
                if (!dbLoanSubmissionBatchContainers.getSourceSystemType()
                        .equals(xmlLoanSubmissionBatchContainers.getSourceSystemType())) {
                    GlobalHooks.getScenario().write("SourceSystemType mismatch. Expected Value is "
                            + dbLoanSubmissionBatchContainers.getSourceSystemType() + " but actual value is "
                            + xmlLoanSubmissionBatchContainers.getSourceSystemType());
                    return false;
                } else {
                    sb.append("SourceSystemType in DB: " + dbLoanSubmissionBatchContainers.getSourceSystemType()
                            + " SourceSystemType in XML: " + xmlLoanSubmissionBatchContainers.getSourceSystemType()
                            + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario()
                    .write(sb + "LoanSubmissionBatch Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<LoanSubmissionBatchContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<LoanSubmissionBatchContainer> results = new ArrayList<>();
        while (rs.next()) {
            LoanSubmissionBatchContainer loanSubmissionBatch = new LoanSubmissionBatchContainer();
            loanSubmissionBatch.setSourceBatchIdentifier(rs.getString("ID_SRCE_BCH"));
            loanSubmissionBatch.setSourceSystemType(rs.getString("CD_SRCE_SYST"));
            loanSubmissionBatch.setEventId(rs.getInt("ID_EVNT"));
            results.add(loanSubmissionBatch);
        }
        return results;
    }

    @Override
    public String toString() {
        return "LoanSubmissionBatchContainer [sourceBatchIdentifier=" + sourceBatchIdentifier + ", sourceSystemType="
                + sourceSystemType + ", eventId=" + eventId + "]";
    }
}
