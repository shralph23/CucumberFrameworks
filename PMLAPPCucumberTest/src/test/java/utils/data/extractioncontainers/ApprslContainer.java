package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.Appraisal;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class ApprslContainer implements ResultSetExtractor<List<ApprslContainer>> {
    private String appraiserFileIdentifier;
    private int eventId;

    public ApprslContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getAppraiserFileIdentifier() {
        return appraiserFileIdentifier;
    }

    public void setAppraiserFileIdentifier(String appraiserFileIdentifier) {
        this.appraiserFileIdentifier = appraiserFileIdentifier;
    }

    @Override
    public boolean equals(Object xmlAppraisalContainersObj) {
        ApprslContainer dbAppraisalContainers = this;
        Appraisal xmlAppraisalContainers = (Appraisal) xmlAppraisalContainersObj;
        if (xmlAppraisalContainers == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbAppraisalContainers.getEventId() + "\n");
            if (dbAppraisalContainers.getAppraiserFileIdentifier() != null
                    && xmlAppraisalContainers.getAppraiserFileIdentifier() != null) {
                if (!dbAppraisalContainers.getAppraiserFileIdentifier()
                        .equals(xmlAppraisalContainers.getAppraiserFileIdentifier())) {
                    GlobalHooks.getScenario().write("AppraiserFileIdentifier mismatch. Expected Value is "
                            + dbAppraisalContainers.getAppraiserFileIdentifier() + " but actual value is "
                            + xmlAppraisalContainers.getAppraiserFileIdentifier());
                    return false;
                } else {
                    sb.append("AppraiserFileIdentifier in DB: " + dbAppraisalContainers.getAppraiserFileIdentifier()
                            + " AppraiserFileIdentifier in XML: " + xmlAppraisalContainers.getAppraiserFileIdentifier()
                            + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario().write(sb + "Appraisal Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<ApprslContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<ApprslContainer> results = new ArrayList<>();
        while (rs.next()) {
            ApprslContainer apprsl = new ApprslContainer();
            apprsl.setEventId(rs.getInt("ID_EVNT"));
            apprsl.setAppraiserFileIdentifier(rs.getString("ID_APPRSL_DOC_FILE"));
            results.add(apprsl);
        }
        return results;
    }

    @Override
    public String toString() {
        return "ApprslContainer [appraiserFileIdentifier=" + appraiserFileIdentifier + ", eventId=" + eventId + "]";
    }
}
