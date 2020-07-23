package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.LoanUnderwritingCase;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class LoanUnderwritingCaseContainer implements ResultSetExtractor<List<LoanUnderwritingCaseContainer>> {
    private String automatedUnderwritingSystemType;
    private String loanIdentifier;
    private String loanUnderwritingCaseIdentifier;
    private int eventId;

    public LoanUnderwritingCaseContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getAutomatedUnderwritingSystemType() {
        return automatedUnderwritingSystemType;
    }

    public void setAutomatedUnderwritingSystemType(String automatedUnderwritingSystemType) {
        this.automatedUnderwritingSystemType = automatedUnderwritingSystemType;
    }

    public String getLoanIdentifier() {
        return loanIdentifier;
    }

    public void setLoanIdentifier(String loanIdentifier) {
        this.loanIdentifier = loanIdentifier;
    }

    public String getLoanUnderwritingCaseIdentifier() {
        return loanUnderwritingCaseIdentifier;
    }

    public void setLoanUnderwritingCaseIdentifier(String loanUnderwritingCaseIdentifier) {
        this.loanUnderwritingCaseIdentifier = loanUnderwritingCaseIdentifier;
    }

    @Override
    public boolean equals(Object xmlLoanUnderwritingCaseContainersObj) {
        LoanUnderwritingCaseContainer dbLoanUnderwritingCaseContainers = this;
        LoanUnderwritingCase xmlLoanUnderwritingCaseContainers = (LoanUnderwritingCase) xmlLoanUnderwritingCaseContainersObj;
        if (xmlLoanUnderwritingCaseContainers == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbLoanUnderwritingCaseContainers.getEventId() + "\n");
            if (dbLoanUnderwritingCaseContainers.getAutomatedUnderwritingSystemType() != null
                    && xmlLoanUnderwritingCaseContainers.getAutomatedUnderwritingSystemType() != null) {
                if (!dbLoanUnderwritingCaseContainers.getAutomatedUnderwritingSystemType()
                        .equals(xmlLoanUnderwritingCaseContainers.getAutomatedUnderwritingSystemType())) {
                    GlobalHooks.getScenario().write("AutomatedUnderwritingSystemType mismatch. Expected Value is "
                            + dbLoanUnderwritingCaseContainers.getAutomatedUnderwritingSystemType()
                            + " but actual value is "
                            + xmlLoanUnderwritingCaseContainers.getAutomatedUnderwritingSystemType());
                    return false;
                } else {
                    sb.append("AutomatedUnderwritingSystemType in DB: "
                            + dbLoanUnderwritingCaseContainers.getAutomatedUnderwritingSystemType()
                            + " AutomatedUnderwritingSystemType in XML: "
                            + xmlLoanUnderwritingCaseContainers.getAutomatedUnderwritingSystemType() + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanUnderwritingCaseContainers.getLoanUnderwritingCaseIdentifier() != null
                    && xmlLoanUnderwritingCaseContainers.getLoanUnderwritingCaseIdentifier() != null) {
                if (!dbLoanUnderwritingCaseContainers.getLoanUnderwritingCaseIdentifier()
                        .equals(xmlLoanUnderwritingCaseContainers.getLoanUnderwritingCaseIdentifier())) {
                    GlobalHooks.getScenario().write("LoanUnderwritingCaseContainer mismatch. Expected Value is "
                            + dbLoanUnderwritingCaseContainers.getLoanUnderwritingCaseIdentifier()
                            + " but actual value is "
                            + xmlLoanUnderwritingCaseContainers.getLoanUnderwritingCaseIdentifier());
                    return false;
                } else {
                    sb.append("LoanUnderwritingCaseContainer in DB: "
                            + dbLoanUnderwritingCaseContainers.getLoanUnderwritingCaseIdentifier()
                            + " LoanUnderwritingCaseContainer in XML: "
                            + xmlLoanUnderwritingCaseContainers.getLoanUnderwritingCaseIdentifier() + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanUnderwritingCaseContainers.getLoanIdentifier() != null
                    && xmlLoanUnderwritingCaseContainers.getLoanIdentifier() != null) {
                if (!dbLoanUnderwritingCaseContainers.getLoanIdentifier()
                        .equals(xmlLoanUnderwritingCaseContainers.getLoanIdentifier())) {
                    GlobalHooks.getScenario().write("LoanIdentifier mismatch. Expected Value is "
                            + dbLoanUnderwritingCaseContainers.getLoanIdentifier() + " but actual value is "
                            + xmlLoanUnderwritingCaseContainers.getLoanIdentifier());

                    return false;
                } else {
                    sb.append("LoanIdentifier in DB: " + dbLoanUnderwritingCaseContainers.getLoanIdentifier()
                            + " LoanIdentifier in XML: " + xmlLoanUnderwritingCaseContainers.getLoanIdentifier()
                            + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario()
                    .write(sb + "LoanUnderwritingCase Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<LoanUnderwritingCaseContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<LoanUnderwritingCaseContainer> results = new ArrayList<>();
        while (rs.next()) {
            LoanUnderwritingCaseContainer loanUnderwritingCase = new LoanUnderwritingCaseContainer();
            loanUnderwritingCase.setAutomatedUnderwritingSystemType(rs.getString("NAME_AUS_TYPE"));
            loanUnderwritingCase.setLoanUnderwritingCaseIdentifier(rs.getString("ID_LOAN_UW_CASE"));
            loanUnderwritingCase.setLoanIdentifier(rs.getString("ID_PML_SUBMN_LINK"));
            loanUnderwritingCase.setEventId(rs.getInt("ID_EVNT"));
            results.add(loanUnderwritingCase);
        }
        return results;
    }

    @Override
    public String toString() {
        return "LoanUnderwritingCase [automatedUnderwritingSystemType=" + automatedUnderwritingSystemType
                + ", loanUnderwritingCaseIdentifier=" + loanUnderwritingCaseIdentifier + ", eventId=" + eventId + "]";
    }
}
