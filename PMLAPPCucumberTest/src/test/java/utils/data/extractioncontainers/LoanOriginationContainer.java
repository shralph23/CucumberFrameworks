package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.LoanOrigination;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class LoanOriginationContainer implements ResultSetExtractor<List<LoanOriginationContainer>> {
    private Double loanAPRRate;
    private String loanIdentifier;
    private String noteAmount;
    private Double noteRate;
    private int eventId;

    public LoanOriginationContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Double getLoanAPRRate() {
        return loanAPRRate;
    }

    public void setLoanAPRRate(Double loanAPRRate) {
        this.loanAPRRate = loanAPRRate;
    }

    public String getLoanIdentifier() {
        return loanIdentifier;
    }

    public void setLoanIdentifier(String loanIdentifier) {
        this.loanIdentifier = loanIdentifier;
    }

    public String getNoteAmount() {
        return noteAmount;
    }

    public void setNoteAmount(String noteAmount) {
        this.noteAmount = noteAmount;
    }

    public Double getNoteRate() {
        return noteRate;
    }

    public void setNoteRate(Double noteRate) {
        this.noteRate = noteRate;
    }

    @Override
    public boolean equals(Object xmlLoanOriginationContainersObj) {
        LoanOriginationContainer dbLoanOriginationContainers = this;
        LoanOrigination xmlLoanOriginationContainers = (LoanOrigination) xmlLoanOriginationContainersObj;
        if (xmlLoanOriginationContainers == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbLoanOriginationContainers.getEventId() + "\n");

            if (dbLoanOriginationContainers.getLoanIdentifier() != null
                    && xmlLoanOriginationContainers.getLoanIdentifier() != null) {
                if (!dbLoanOriginationContainers.getLoanIdentifier()
                        .equals(xmlLoanOriginationContainers.getLoanIdentifier())) {
                    GlobalHooks.getScenario().write("LoanIdentifier mismatch. Expected Value is "
                            + dbLoanOriginationContainers.getLoanIdentifier() + " but actual value is "
                            + xmlLoanOriginationContainers.getLoanIdentifier());
                    return false;
                } else {
                    sb.append("LoanIdentifier in DB: " + dbLoanOriginationContainers.getLoanIdentifier()
                            + " LoanIdentifier in XML: " + xmlLoanOriginationContainers.getLoanIdentifier() + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanOriginationContainers.getNoteAmount() != null
                    && xmlLoanOriginationContainers.getNoteAmount() != null) {
                if (!dbLoanOriginationContainers.getNoteAmount()
                        .equals(xmlLoanOriginationContainers.getNoteAmount().toString())) {
                    GlobalHooks.getScenario().write(
                            "NoteAmount mismatch. Expected Value is " + dbLoanOriginationContainers.getNoteAmount()
                                    + " but actual value is " + xmlLoanOriginationContainers.getNoteAmount());
                    return false;
                } else {
                    sb.append("NoteAmount in DB: " + dbLoanOriginationContainers.getNoteAmount()
                            + " NoteAmount in XML: " + xmlLoanOriginationContainers.getNoteAmount() + "\n");
                    recordsCounter++;
                }
            }

            sb.append(TestConstants.REPORT_SEPERATOR);
            if (recordsCounter == 0) {
                return true;
            } else {
                GlobalHooks.getScenario()
                        .write(sb + "LoanOrigination Match. Records validated in the section " + recordsCounter);
                return true;
            }
        }
    }

    @Override
    public List<LoanOriginationContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<LoanOriginationContainer> results = new ArrayList<>();
        while (rs.next()) {
            LoanOriginationContainer loanOrigination = new LoanOriginationContainer();
            loanOrigination.setLoanAPRRate(rs.getDouble("RATE_LOAN_APR"));
            loanOrigination.setLoanIdentifier(rs.getString("ID_PML_SUBMN_LINK"));
            loanOrigination.setNoteAmount(rs.getString("AMT_NOTE"));
            loanOrigination.setNoteRate(rs.getDouble("RATE_NT"));
            loanOrigination.setEventId(rs.getInt("ID_EVNT"));
            results.add(loanOrigination);
        }
        return results;
    }

    @Override
    public String toString() {
        return "LoanOrigination [loanAPRRate=" + loanAPRRate + ", loanIdentifier=" + loanIdentifier + ", noteAmount="
                + noteAmount + ", noteRate=" + noteRate + ", eventId=" + eventId + "]";
    }

}
