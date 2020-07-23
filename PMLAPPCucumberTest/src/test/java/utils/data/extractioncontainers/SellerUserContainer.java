package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.SellerUser;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class SellerUserContainer implements ResultSetExtractor<List<SellerUserContainer>> {
    private String sellerUserIdentifier;
    private int eventId;

    public SellerUserContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getSellerUserIdentifier() {
        return sellerUserIdentifier;
    }

    public void setSellerUserIdentifier(String sellerUserIdentifier) {
        this.sellerUserIdentifier = sellerUserIdentifier;
    }

    @Override
    public boolean equals(Object xmlSellerUserContainersObj) {
        SellerUserContainer dbSlrUser = this;
        SellerUser xmlSlrUser = (SellerUser) xmlSellerUserContainersObj;
        if (xmlSlrUser == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbSlrUser.getEventId() + "\n");
            if (dbSlrUser.getSellerUserIdentifier() != null && xmlSlrUser.getSellerUserIdentifier() != null) {
                if (!dbSlrUser.getSellerUserIdentifier().equals(xmlSlrUser.getSellerUserIdentifier())) {
                    GlobalHooks.getScenario().write(
                            "SellerUserIdentifier mismatch. Expected Value is " + dbSlrUser.getSellerUserIdentifier()
                                    + " but actual value is " + xmlSlrUser.getSellerUserIdentifier());
                    return false;
                } else {
                    sb.append("SellerUserIdentifier in DB: " + dbSlrUser.getSellerUserIdentifier()
                            + " SellerUserIdentifier in XML: " + xmlSlrUser.getSellerUserIdentifier() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario().write(sb + "SellerUser Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    public List<SellerUserContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<SellerUserContainer> results = new ArrayList<>();
        while (rs.next()) {
            SellerUserContainer sellerUser = new SellerUserContainer();
            sellerUser.setEventId(rs.getInt("ID_EVNT"));
            sellerUser.setSellerUserIdentifier(rs.getString("ID_SLR_USER"));
            results.add(sellerUser);
        }
        return results;
    }

    @Override
    public String toString() {
        return "SellerUserContainer [sellerUserIdentifier=" + sellerUserIdentifier + ", eventId=" + eventId + "]";
    }
}
