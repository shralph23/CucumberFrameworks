package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.IntegratedDisclosure;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class IntegratedDisclosureContainer implements ResultSetExtractor<List<IntegratedDisclosureContainer>> {
    private String integratedDisclosureIssuedDate;
    private String loanIdentifier;
    private int eventId;

    public IntegratedDisclosureContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getIntegratedDisclosureIssuedDate() {
        return integratedDisclosureIssuedDate;
    }

    public void setIntegratedDisclosureIssuedDate(String integratedDisclosureIssuedDate) {
        this.integratedDisclosureIssuedDate = integratedDisclosureIssuedDate;
    }

    public String getLoanIdentifier() {
        return loanIdentifier;
    }

    public void setLoanIdentifier(String loanIdentifier) {
        this.loanIdentifier = loanIdentifier;
    }

    @Override
    public boolean equals(Object xmlIntegratedDisclosureContainersObj) {
        IntegratedDisclosureContainer dbIntegratedDisclosure = this;
        IntegratedDisclosure xmlIntegratedDisclosure = (IntegratedDisclosure) xmlIntegratedDisclosureContainersObj;
        if (xmlIntegratedDisclosure == null) {
            GlobalHooks.getScenario().write("Event= " + dbIntegratedDisclosure.getEventId()
                    + "\n IntegratedDisclosure Match. Records validated in the section 1 - Null container on payload - "
                    + dbIntegratedDisclosure.toString());
            // TODO: review how to validate loanIdentifier
            return dbIntegratedDisclosure.getIntegratedDisclosureIssuedDate() == null;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbIntegratedDisclosure.getEventId() + "\n");
            if (dbIntegratedDisclosure.getIntegratedDisclosureIssuedDate() != null
                    && xmlIntegratedDisclosure.getIntegratedDisclosureIssuedDate() != null) {
                if (!dbIntegratedDisclosure.getIntegratedDisclosureIssuedDate()
                        .equals(xmlIntegratedDisclosure.getIntegratedDisclosureIssuedDate())) {
                    GlobalHooks.getScenario().write("IntegratedDisclosureIssuedDate mismatch. Expected Value is "
                            + dbIntegratedDisclosure.getIntegratedDisclosureIssuedDate() + " but actual value is "
                            + xmlIntegratedDisclosure.getIntegratedDisclosureIssuedDate());
                    return false;
                } else {
                    sb.append("IntegratedDisclosureIssuedDate in DB: "
                            + dbIntegratedDisclosure.getIntegratedDisclosureIssuedDate()
                            + " IntegratedDisclosureIssuedDate in XML: "
                            + xmlIntegratedDisclosure.getIntegratedDisclosureIssuedDate() + "\n");
                    recordsCounter++;
                }
            }

            if (dbIntegratedDisclosure.getLoanIdentifier() != null
                    && xmlIntegratedDisclosure.getLoanIdentifier() != null) {
                if (!dbIntegratedDisclosure.getLoanIdentifier().equals(xmlIntegratedDisclosure.getLoanIdentifier())) {
                    GlobalHooks.getScenario().write(
                            "LoanIdentifier mismatch. Expected Value is " + dbIntegratedDisclosure.getLoanIdentifier()
                                    + " but actual value is " + xmlIntegratedDisclosure.getLoanIdentifier());
                    return false;
                } else {
                    sb.append("LoanIdentifier in DB: " + dbIntegratedDisclosure.getLoanIdentifier()
                            + " LoanIdentifier in XML: " + xmlIntegratedDisclosure.getLoanIdentifier() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            if (recordsCounter == 0) {
                return true;
            } else {
                GlobalHooks.getScenario()
                        .write(sb + "IntegratedDisclosure Match. Records validated in the section " + recordsCounter);
                return true;
            }
        }
    }

    @Override
    public List<IntegratedDisclosureContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<IntegratedDisclosureContainer> results = new ArrayList<>();
        while (rs.next()) {
            IntegratedDisclosureContainer integratedDisclosure = new IntegratedDisclosureContainer();
            integratedDisclosure.setIntegratedDisclosureIssuedDate(rs.getString("DT_INTGRTD_DSCLR_ISUD"));
            integratedDisclosure.setLoanIdentifier(rs.getString("ID_PML_SUBMN_LINK"));
            integratedDisclosure.setEventId(rs.getInt("ID_EVNT"));
            results.add(integratedDisclosure);
        }
        return results;
    }

    @Override
    public String toString() {
        return "IntegratedDisclosureContainer [integratedDisclosureIssuedDate=" + integratedDisclosureIssuedDate
                + ", loanIdentifier=" + loanIdentifier + ", eventId=" + eventId + "]";
    }
}
