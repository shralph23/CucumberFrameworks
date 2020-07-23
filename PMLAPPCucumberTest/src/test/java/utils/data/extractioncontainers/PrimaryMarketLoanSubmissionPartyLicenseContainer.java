package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionPartyLicense;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class PrimaryMarketLoanSubmissionPartyLicenseContainer
        implements ResultSetExtractor<List<PrimaryMarketLoanSubmissionPartyLicenseContainer>> {

    private String licenseIdentifier;
    private int eventId;

    public PrimaryMarketLoanSubmissionPartyLicenseContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getLicenseIdentifier() {
        return licenseIdentifier;
    }

    public void setLicenseIdentifier(String licenseIdentifier) {
        this.licenseIdentifier = licenseIdentifier;
    }

    @Override
    public boolean equals(Object xmlPartyLicenseContainersObj) {
        PrimaryMarketLoanSubmissionPartyLicenseContainer dbPartyLicenseContainers = this;
        PrimaryMarketLoanSubmissionPartyLicense xmlPartyLicenseContainers = (PrimaryMarketLoanSubmissionPartyLicense) xmlPartyLicenseContainersObj;
        if (xmlPartyLicenseContainersObj == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbPartyLicenseContainers.getEventId() + "\n");
            if (dbPartyLicenseContainers.getLicenseIdentifier() != null
                    && xmlPartyLicenseContainers.getLicenseIdentifier() != null) {
                if (!dbPartyLicenseContainers.getLicenseIdentifier()
                        .equals(xmlPartyLicenseContainers.getLicenseIdentifier())) {
                    GlobalHooks.getScenario().write("LicenseIdentifier mismatch. Expected Value is "
                            + dbPartyLicenseContainers.getLicenseIdentifier() + " but actual value is "
                            + xmlPartyLicenseContainers.getLicenseIdentifier());
                    return false;
                } else {
                    sb.append("LicenseIdentifier in DB: " + dbPartyLicenseContainers.getLicenseIdentifier()
                            + " LicenseIdentifier in XML: " + xmlPartyLicenseContainers.getLicenseIdentifier() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario()
                    .write(sb + "PrimaryMarketLoanSubmissionPartyLicense Match. Records validated in the section "
                            + recordsCounter);
            return true;
        }
    }

    @Override
    public List<PrimaryMarketLoanSubmissionPartyLicenseContainer> extractData(ResultSet rs)
            throws SQLException, DataAccessException {
        List<PrimaryMarketLoanSubmissionPartyLicenseContainer> results = new ArrayList<>();
        while (rs.next()) {
            PrimaryMarketLoanSubmissionPartyLicenseContainer primaryMarketLoanSubmissionPartyLicense = new PrimaryMarketLoanSubmissionPartyLicenseContainer();
            primaryMarketLoanSubmissionPartyLicense.setLicenseIdentifier(rs.getString("ID_LICNS"));
            primaryMarketLoanSubmissionPartyLicense.setEventId(rs.getInt("ID_EVNT"));
            results.add(primaryMarketLoanSubmissionPartyLicense);
        }
        return results;
    }

    @Override
    public String toString() {
        return "PrimaryMarketLoanSubmissionPartyLicenseContainer [licenseIdentifier=" + licenseIdentifier + ", eventId="
                + eventId + "]";
    }
}
