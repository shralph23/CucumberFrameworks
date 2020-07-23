package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.PartyRole;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class PartyRoleContainer implements ResultSetExtractor<List<PartyRoleContainer>> {
    private String partyIdentifier;
    private String partyRoleType;
    private int eventId;

    public PartyRoleContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getPartyIdentifier() {
        return partyIdentifier;
    }

    public void setPartyIdentifier(String partyIdentifier) {
        this.partyIdentifier = partyIdentifier;
    }

    public String getPartyRoleType() {
        return partyRoleType;
    }

    public void setPartyRoleType(String partyRoleType) {
        this.partyRoleType = partyRoleType;
    }

    @Override
    public boolean equals(Object xmlPartyRoleContainersObj) {
        PartyRoleContainer dbPartyRoleContainers = this;
        PartyRole xmlPartyRoleContainers = (PartyRole) xmlPartyRoleContainersObj;
        if (xmlPartyRoleContainersObj == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + this.getEventId() + "\n");
            if (dbPartyRoleContainers.getPartyIdentifier() != null
                    && xmlPartyRoleContainers.getPartyIdentifier() != null) {
                if (!dbPartyRoleContainers.getPartyIdentifier().equals(xmlPartyRoleContainers.getPartyIdentifier())) {
                    GlobalHooks.getScenario().write(
                            "PartyIdentifier mismatch. Expected Value is " + dbPartyRoleContainers.getPartyIdentifier()
                                    + " but actual value is " + xmlPartyRoleContainers.getPartyIdentifier());
                    return false;
                } else {
                    sb.append("PartyIdentifier in DB: " + dbPartyRoleContainers.getPartyIdentifier()
                            + " PartyIdentifier in XML: " + xmlPartyRoleContainers.getPartyIdentifier() + "\n");
                    recordsCounter++;
                }
            }

            if (dbPartyRoleContainers.getPartyRoleType() != null && xmlPartyRoleContainers.getPartyRoleType() != null) {
                if (!dbPartyRoleContainers.getPartyRoleType().equals(xmlPartyRoleContainers.getPartyRoleType())) {
                    GlobalHooks.getScenario().write(
                            "PartyRoleType mismatch. Expected Value is " + dbPartyRoleContainers.getPartyRoleType()
                                    + " but actual value is " + xmlPartyRoleContainers.getPartyRoleType());
                    return false;
                } else {
                    sb.append("PartyRoleType in DB: " + dbPartyRoleContainers.getPartyRoleType()
                            + " PartyRoleType in XML: " + xmlPartyRoleContainers.getPartyRoleType() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario().write(sb + "PartyRole Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<PartyRoleContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<PartyRoleContainer> results = new ArrayList<>();
        while (rs.next()) {
            this.setPartyIdentifier(rs.getString("ID_PRTY"));
            this.setPartyRoleType(rs.getString("NAME_PRTY_ROLE_TYPE"));
            this.setEventId(rs.getInt("ID_EVNT"));
            results.add(this);
        }
        return results;
    }

    @Override
    public String toString() {
        return "PartyRoleContainer [partyIdentifier=" + partyIdentifier + ", partyRoleType=" + partyRoleType
                + ", eventId=" + eventId + "]";
    }

}
