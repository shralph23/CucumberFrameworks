package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.LoanAcquisition;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class LoanAcquisitionContainer implements ResultSetExtractor<List<LoanAcquisitionContainer>> {
    private String loanIdentifier;
    private String loanConformityType;
    private String sellerAccountIdentifier;
    private String sellerLoanIdentifier;
    private int eventId;

    public LoanAcquisitionContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getLoanIdentifier() {
        return loanIdentifier;
    }

    public void setLoanIdentifier(String loanIdentifier) {
        this.loanIdentifier = loanIdentifier;
    }

    public String getSellerAccountIdentifier() {
        return sellerAccountIdentifier;
    }

    public void setSellerAccountIdentifier(String sellerAccountIdentifier) {
        this.sellerAccountIdentifier = sellerAccountIdentifier;
    }

    public String getSellerLoanIdentifier() {
        return sellerLoanIdentifier;
    }

    public void setSellerLoanIdentifier(String sellerLoanIdentifier) {
        this.sellerLoanIdentifier = sellerLoanIdentifier;
    }

    public String getLoanConformityType() {
        return loanConformityType;
    }

    public void setLoanConformityType(String loanConformityType) {
        this.loanConformityType = loanConformityType;
    }

    @Override
    public boolean equals(Object xmlLoanAcquisitionContainersObj) {
        LoanAcquisitionContainer dbLoanAcquisitionContainers = this;
        LoanAcquisition xmlLoanAcquisitionContainers = (LoanAcquisition) xmlLoanAcquisitionContainersObj;
        if (xmlLoanAcquisitionContainers == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbLoanAcquisitionContainers.getEventId() + "\n");
            if (dbLoanAcquisitionContainers.getSellerLoanIdentifier() != null
                    && xmlLoanAcquisitionContainers.getSellerLoanIdentifier() != null) {
                if (!dbLoanAcquisitionContainers.getSellerLoanIdentifier()
                        .equals(xmlLoanAcquisitionContainers.getSellerLoanIdentifier())) {
                    GlobalHooks.getScenario().write("SellerLoanIdentifier mismatch. Expected Value is "
                            + dbLoanAcquisitionContainers.getSellerLoanIdentifier() + " but actual value is "
                            + xmlLoanAcquisitionContainers.getSellerLoanIdentifier());
                    return false;
                } else {
                    sb.append("SellerLoanIdentifier in DB: " + dbLoanAcquisitionContainers.getSellerLoanIdentifier()
                            + " SellerLoanIdentifier in XML: " + xmlLoanAcquisitionContainers.getSellerLoanIdentifier()
                            + "\n");
                    recordsCounter++;
                }
            }

            if (dbLoanAcquisitionContainers.getLoanIdentifier() != null
                    && xmlLoanAcquisitionContainers.getLoanIdentifier() != null) {
                if (!dbLoanAcquisitionContainers.getLoanIdentifier()
                        .equals(xmlLoanAcquisitionContainers.getLoanIdentifier())) {
                    GlobalHooks.getScenario().write("LoanIdentifier mismatch. Expected Value is "
                            + dbLoanAcquisitionContainers.getLoanIdentifier() + " but actual value is "
                            + xmlLoanAcquisitionContainers.getLoanIdentifier());
                    return false;
                } else {
                    sb.append("LoanIdentifier in DB: " + dbLoanAcquisitionContainers.getLoanIdentifier()
                            + " LoanIdentifier in XML: " + xmlLoanAcquisitionContainers.getLoanIdentifier() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            if (recordsCounter == 0) {
                return true;
            } else {
                GlobalHooks.getScenario()
                        .write(sb + "LoanAcquisition Match. Records validated in the section " + recordsCounter);
                return true;
            }
        }
    }

    @Override
    public List<LoanAcquisitionContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<LoanAcquisitionContainer> results = new ArrayList<>();
        while (rs.next()) {
            LoanAcquisitionContainer loanAcquisition = new LoanAcquisitionContainer();
            loanAcquisition.setEventId(rs.getInt("ID_EVNT"));
            loanAcquisition.setLoanIdentifier(rs.getString("ID_PML_SUBMN_LINK"));
            loanAcquisition.setSellerLoanIdentifier(rs.getString("ID_SLR_LOAN"));
            results.add(loanAcquisition);
        }
        return results;
    }

    @Override
    public String toString() {
        return "LoanAcquisitionContainer [loanIdentifier=" + loanIdentifier + ", sellerLoanIdentifier="
                + sellerLoanIdentifier + ", eventId=" + eventId + "]";
    }

}
