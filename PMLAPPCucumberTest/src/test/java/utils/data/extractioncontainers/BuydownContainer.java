package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.Buydown;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class BuydownContainer implements ResultSetExtractor<List<BuydownContainer>> {
    private String buydownTemporarySubsidyIndicator;
    private int eventId;

    public BuydownContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getBuydownTemporarySubsidyIndicator() {
        return buydownTemporarySubsidyIndicator;
    }

    public void setBuydownTemporarySubsidyIndicator(String buydownTemporarySubsidyIndicator) {
        this.buydownTemporarySubsidyIndicator = buydownTemporarySubsidyIndicator;
    }

    @Override
    public boolean equals(Object xmlBuydownContainersObj) {
        BuydownContainer dbBuydownContainers = this;
        Buydown xmlBuydownContainers = (Buydown) xmlBuydownContainersObj;
        if (xmlBuydownContainers == null) {
            GlobalHooks.getScenario().write("Event= " + dbBuydownContainers.getEventId()
                    + "\n Buydown Match. Records validated in the section 1 - Null container on payload");
            return dbBuydownContainers.getBuydownTemporarySubsidyIndicator() == null;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbBuydownContainers.getEventId() + "\n");
            if (dbBuydownContainers.getBuydownTemporarySubsidyIndicator() != null
                    && xmlBuydownContainers.getBuydownTemporarySubsidyIndicator() != null) {
                if (!dbBuydownContainers.getBuydownTemporarySubsidyIndicator()
                        .equals(xmlBuydownContainers.getBuydownTemporarySubsidyIndicator())) {
                    GlobalHooks.getScenario().write("BuydownTemporarySubsidyIndicator mismatch. Expected Value is "
                            + dbBuydownContainers.getBuydownTemporarySubsidyIndicator() + " but actual value is "
                            + xmlBuydownContainers.getBuydownTemporarySubsidyIndicator());
                    return false;
                } else {
                    sb.append("BuydownTemporarySubsidyIndicator in DB: "
                            + dbBuydownContainers.getBuydownTemporarySubsidyIndicator()
                            + " BuydownTemporarySubsidyIndicator in XML: "
                            + xmlBuydownContainers.getBuydownTemporarySubsidyIndicator() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            if (recordsCounter == 0) {
                return true;
            } else {
                GlobalHooks.getScenario().write(sb + "Buydown Match. Records validated in the section " + recordsCounter);
                return true;
            }
        }
    }

    @Override
    public List<BuydownContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<BuydownContainer> results = new ArrayList<>();
        while (rs.next()) {
            BuydownContainer buydown = new BuydownContainer();
            buydown.setEventId(rs.getInt("ID_EVNT"));
            buydown.setBuydownTemporarySubsidyIndicator(rs.getString("IND_BD_TEMP_SUBDY"));
            results.add(buydown);
        }
        return results;
    }

    @Override
    public String toString() {
        return "BuydownContainer [buydownTemporarySubsidyIndicator=" + buydownTemporarySubsidyIndicator + ", eventId="
                + eventId + "]";
    }
}
