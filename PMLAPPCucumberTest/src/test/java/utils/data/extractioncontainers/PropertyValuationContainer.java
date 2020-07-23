package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.PropertyValuation;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class PropertyValuationContainer implements ResultSetExtractor<List<PropertyValuationContainer>> {
    private DateTime propertyValuationEffectiveDateTime;
    private String eventId;

    public PropertyValuationContainer() {

    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public DateTime getPropertyValuationEffectiveDateTime() {
        return propertyValuationEffectiveDateTime;
    }

    public void setPropertyValuationEffectiveDateTime(DateTime propertyValuationEffectiveDateTime) {
        this.propertyValuationEffectiveDateTime = propertyValuationEffectiveDateTime;
    }

    @Override
    public boolean equals(Object xmlPropertyValuationObj) {
        PropertyValuationContainer dbPropVal = this;
        PropertyValuation xmlPropVal = (PropertyValuation) xmlPropertyValuationObj;
        if (xmlPropVal == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbPropVal.getEventId() + "\n");
            if (dbPropVal.getPropertyValuationEffectiveDateTime() != null
                    && xmlPropVal.getPropertyValuationEffectiveDateTime() != null) {
                if (!TestConstants.dtf.format(dbPropVal.getPropertyValuationEffectiveDateTime().toDate())
                        .equals(TestConstants.dtf.format(xmlPropVal.getPropertyValuationEffectiveDateTime()))) {
                    GlobalHooks.getScenario().write("PropertyValuationEffectiveDateTime mismatch. Expected Value is "
                            + TestConstants.dtf.format(dbPropVal.getPropertyValuationEffectiveDateTime().toDate())
                            + " but actual value is "
                            + TestConstants.dtf.format(xmlPropVal.getPropertyValuationEffectiveDateTime()));
                    return false;
                } else {
                    sb.append("PropertyValuationEffectiveDateTime in DB: "
                            + TestConstants.dtf.format(dbPropVal.getPropertyValuationEffectiveDateTime().toDate())
                            + " PropertyValuationEffectiveDateTime in XML: "
                            + TestConstants.dtf.format(xmlPropVal.getPropertyValuationEffectiveDateTime()) + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario()
                    .write(sb + "PropertyValuation Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<PropertyValuationContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<PropertyValuationContainer> results = new ArrayList<>();
        while (rs.next()) {
            PropertyValuationContainer propertyValuation = new PropertyValuationContainer();
            propertyValuation.setEventId(rs.getString("ID_EVNT"));
            propertyValuation.setPropertyValuationEffectiveDateTime(new DateTime(rs.getDate("DTTM_PPTY_VALUTN_EFF")));
            results.add(propertyValuation);
        }
        return results;
    }

    @Override
    public String toString() {
        return "PropertyValuationContainer [propertyValuationEffectiveDateTime=" + propertyValuationEffectiveDateTime
                + ", eventId=" + eventId + "]";
    }

}
