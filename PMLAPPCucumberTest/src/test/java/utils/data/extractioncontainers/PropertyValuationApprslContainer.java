package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.PropertyValuation;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class PropertyValuationApprslContainer implements ResultSetExtractor<List<PropertyValuationApprslContainer>> {
    private String propertyValuationFormType;
    private int eventId;

    public PropertyValuationApprslContainer() {

    }

    public String getPropertyValuationFormType() {
        return propertyValuationFormType;
    }

    public void setPropertyValuationFormType(String propertyValuationFormType) {
        this.propertyValuationFormType = propertyValuationFormType;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public boolean equals(Object xmlPropertyValuationApprslContainerObj) {
        PropertyValuationApprslContainer dbPropValApprsl = this;
        PropertyValuation xmlPropValApprsl = (PropertyValuation) xmlPropertyValuationApprslContainerObj;
        if (xmlPropValApprsl == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbPropValApprsl.getEventId() + "\n");
            if (dbPropValApprsl.getPropertyValuationFormType() != null
                    && xmlPropValApprsl.getPropertyValuationFormType() != null) {
                if (!dbPropValApprsl.getPropertyValuationFormType()
                        .equals(xmlPropValApprsl.getPropertyValuationFormType())) {
                    GlobalHooks.getScenario().write("PropertyValuationFormType mismatch. Expected Value is "
                            + dbPropValApprsl.getPropertyValuationFormType() + " but actual value is "
                            + xmlPropValApprsl.getPropertyValuationFormType());
                    return false;
                } else {
                    sb.append("PropertyValuationFormType in DB: " + dbPropValApprsl.getPropertyValuationFormType()
                            + " PropertyValuationFormType in XML: " + xmlPropValApprsl.getPropertyValuationFormType()
                            + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            if (recordsCounter == 0) {
                return true;
            } else {
                GlobalHooks.getScenario().write(
                        sb + "PropertyValuationApprsl Match. Records validated in the section " + recordsCounter);
                return true;
            }

        }
    }

    @Override
    public List<PropertyValuationApprslContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<PropertyValuationApprslContainer> results = new ArrayList<>();
        while (rs.next()) {
            PropertyValuationApprslContainer propertyValuationApprsl = new PropertyValuationApprslContainer();
            propertyValuationApprsl.setEventId(rs.getInt("ID_EVNT"));
            propertyValuationApprsl.setPropertyValuationFormType(rs.getString("CD_PPTY_VALUTN_FORM"));
            results.add(propertyValuationApprsl);
        }
        return results;
    }

    @Override
    public String toString() {
        return "PropertyValuationApprslContainer [propertyValuationFormType=" + propertyValuationFormType + ", eventId="
                + eventId + "]";
    }
}
