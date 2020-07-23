package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.SellerAccount;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class SellerAccountContainer implements ResultSetExtractor<List<SellerAccountContainer>> {

    private String sellerAccountIdentifier;
    private String sellerName;
    private int eventId;

    public SellerAccountContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getSellerAccountIdentifier() {
        return sellerAccountIdentifier;
    }

    public void setSellerAccountIdentifier(String sellerAccountIdentifier) {
        this.sellerAccountIdentifier = sellerAccountIdentifier;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Override
    public boolean equals(Object xmlSellerAccountContainersObj) {
        SellerAccountContainer dbSlrAccount = this;
        SellerAccount xmlSlrAccount = (SellerAccount) xmlSellerAccountContainersObj;
        if (xmlSlrAccount == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbSlrAccount.getEventId() + "\n");
            if (dbSlrAccount.getSellerAccountIdentifier() != null
                    && xmlSlrAccount.getSellerAccountIdentifier() != null) {
                if (!dbSlrAccount.getSellerAccountIdentifier().equals(xmlSlrAccount.getSellerAccountIdentifier())) {
                    GlobalHooks.getScenario().write("SellerAccountIdentifier mismatch. Expected Value is "
                            + dbSlrAccount.getSellerAccountIdentifier() + " but actual value is "
                            + xmlSlrAccount.getSellerAccountIdentifier());
                    return false;
                } else {
                    sb.append("SellerAccountIdentifier in DB: " + dbSlrAccount.getSellerAccountIdentifier()
                            + " SellerAccountIdentifier in XML: " + xmlSlrAccount.getSellerAccountIdentifier() + "\n");
                    recordsCounter++;
                }
            }

            if (dbSlrAccount.getSellerName() != null && xmlSlrAccount.getSellerName() != null) {
                if (!dbSlrAccount.getSellerName().equals(xmlSlrAccount.getSellerName())) {
                    GlobalHooks.getScenario().write("SellerName mismatch. Expected Value is " + dbSlrAccount.getSellerName()
                            + " but actual value is " + dbSlrAccount.getSellerName());
                    return false;
                } else {
                    sb.append("SellerNameIdentifier in DB: " + dbSlrAccount.getSellerName()
                            + " SellerNameIdentifier in XML: " + xmlSlrAccount.getSellerName() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario().write(sb + "SellerAccount Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<SellerAccountContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<SellerAccountContainer> results = new ArrayList<>();
        while (rs.next()) {
            SellerAccountContainer sellerAccount = new SellerAccountContainer();
            sellerAccount.setEventId(rs.getInt("ID_EVNT"));
            sellerAccount.setSellerName(rs.getString("NAME_SLR"));
            sellerAccount.setSellerAccountIdentifier(rs.getString("ID_SLR_ACCT"));
            results.add(sellerAccount);
        }
        return results;
    }

    @Override
    public String toString() {
        return "SellerAccountContainer [sellerAccountIdentifier=" + sellerAccountIdentifier + ", sellerName="
                + sellerName + ", eventId=" + eventId + "]";
    }
}
