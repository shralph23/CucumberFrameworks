package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionTransaction;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class PrimaryMarketLoanSubmissionTransactionContainer
        implements ResultSetExtractor<List<PrimaryMarketLoanSubmissionTransactionContainer>> {
    private String primaryMarketLoanSubmissionLinkId;
    private String primaryMarketLoanSourceSubmissionTransactionId;
    private String mortgageInsuranceRequiredIndicator;
    private int eventId;

    public PrimaryMarketLoanSubmissionTransactionContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getPrimaryMarketLoanSubmissionLinkId() {
        return primaryMarketLoanSubmissionLinkId;
    }

    public void setPrimaryMarketLoanSubmissionLinkId(String primaryMarketLoanSubmissionLinkId) {
        this.primaryMarketLoanSubmissionLinkId = primaryMarketLoanSubmissionLinkId;
    }

    public String getPrimaryMarketLoanSourceSubmissionTransactionId() {
        return primaryMarketLoanSourceSubmissionTransactionId;
    }

    public void setPrimaryMarketLoanSourceSubmissionTransactionId(
            String primaryMarketLoanSourceSubmissionTransactionId) {
        this.primaryMarketLoanSourceSubmissionTransactionId = primaryMarketLoanSourceSubmissionTransactionId;
    }

    public String getMortgageInsuranceRequiredIndicator() {
        return mortgageInsuranceRequiredIndicator;
    }

    public void setMortgageInsuranceRequiredIndicator(String mortgageInsuranceRequiredIndicator) {
        this.mortgageInsuranceRequiredIndicator = mortgageInsuranceRequiredIndicator;
    }

    @Override
    public boolean equals(Object xmlPrimaryMarketLoanSubmissionTransactionContainersObj) {
        PrimaryMarketLoanSubmissionTransactionContainer dbPrimaryMarketLoanSubmissionTransactionContainers = this;
        PrimaryMarketLoanSubmissionTransaction xmlPrimaryMarketLoanSubmissionTransactionContainers = (PrimaryMarketLoanSubmissionTransaction) xmlPrimaryMarketLoanSubmissionTransactionContainersObj;
        if (xmlPrimaryMarketLoanSubmissionTransactionContainers == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbPrimaryMarketLoanSubmissionTransactionContainers.getEventId() + "\n");
            if (dbPrimaryMarketLoanSubmissionTransactionContainers.getMortgageInsuranceRequiredIndicator() != null
                    && xmlPrimaryMarketLoanSubmissionTransactionContainers
                            .getMortgageInsuranceRequiredIndicator() != null) {
                if (!dbPrimaryMarketLoanSubmissionTransactionContainers.getMortgageInsuranceRequiredIndicator().equals(
                        xmlPrimaryMarketLoanSubmissionTransactionContainers.getMortgageInsuranceRequiredIndicator())) {
                    GlobalHooks.getScenario().write("MortgageInsuranceRequiredIndicator mismatch. Expected Value is "
                            + dbPrimaryMarketLoanSubmissionTransactionContainers.getMortgageInsuranceRequiredIndicator()
                            + " but actual value is " + xmlPrimaryMarketLoanSubmissionTransactionContainers
                                    .getMortgageInsuranceRequiredIndicator());
                    return false;
                } else {
                    sb.append("MortgageInsuranceRequiredIndicator in DB: "
                            + dbPrimaryMarketLoanSubmissionTransactionContainers.getMortgageInsuranceRequiredIndicator()
                            + " MortgageInsuranceRequiredIndicator in XML: "
                            + xmlPrimaryMarketLoanSubmissionTransactionContainers
                                    .getMortgageInsuranceRequiredIndicator()
                            + "\n");
                    recordsCounter++;
                }
            }

            if (dbPrimaryMarketLoanSubmissionTransactionContainers
                    .getPrimaryMarketLoanSourceSubmissionTransactionId() != null
                    && xmlPrimaryMarketLoanSubmissionTransactionContainers
                            .getPrimaryMarketLoanSourceSubmissionTransactionIdentifier() != null) {
                if (!dbPrimaryMarketLoanSubmissionTransactionContainers
                        .getPrimaryMarketLoanSourceSubmissionTransactionId()
                        .equals(xmlPrimaryMarketLoanSubmissionTransactionContainers
                                .getPrimaryMarketLoanSourceSubmissionTransactionIdentifier())) {
                    GlobalHooks.getScenario()
                            .write("PrimaryMarketLoanSourceSubmissionTransactionId mismatch. Expected Value is "
                                    + dbPrimaryMarketLoanSubmissionTransactionContainers
                                            .getPrimaryMarketLoanSourceSubmissionTransactionId()
                                    + " but actual value is " + xmlPrimaryMarketLoanSubmissionTransactionContainers
                                            .getPrimaryMarketLoanSourceSubmissionTransactionIdentifier());
                    return false;
                } else {
                    sb.append("PrimaryMarketLoanSourceSubmissionTransactionId in DB: "
                            + dbPrimaryMarketLoanSubmissionTransactionContainers
                                    .getPrimaryMarketLoanSourceSubmissionTransactionId()
                            + " PrimaryMarketLoanSourceSubmissionTransactionId in XML: "
                            + xmlPrimaryMarketLoanSubmissionTransactionContainers
                                    .getPrimaryMarketLoanSourceSubmissionTransactionIdentifier()
                            + "\n");
                    recordsCounter++;
                }
            }

            if (dbPrimaryMarketLoanSubmissionTransactionContainers.getPrimaryMarketLoanSubmissionLinkId() != null
                    && xmlPrimaryMarketLoanSubmissionTransactionContainers
                            .getPrimaryMarketLoanSubmissionLinkIdentifier() != null) {
                if (!dbPrimaryMarketLoanSubmissionTransactionContainers.getPrimaryMarketLoanSubmissionLinkId()
                        .equals(xmlPrimaryMarketLoanSubmissionTransactionContainers
                                .getPrimaryMarketLoanSubmissionLinkIdentifier())) {
                    GlobalHooks.getScenario().write("PrimaryMarketLoanSubmissionLinkId mismatch. Expected Value is "
                            + dbPrimaryMarketLoanSubmissionTransactionContainers.getPrimaryMarketLoanSubmissionLinkId()
                            + " but actual value is " + xmlPrimaryMarketLoanSubmissionTransactionContainers
                                    .getPrimaryMarketLoanSubmissionLinkIdentifier());
                    return false;
                } else {
                    sb.append("PrimaryMarketLoanSubmissionLinkId in DB: "
                            + dbPrimaryMarketLoanSubmissionTransactionContainers.getPrimaryMarketLoanSubmissionLinkId()
                            + " PrimaryMarketLoanSubmissionLinkId in XML: "
                            + xmlPrimaryMarketLoanSubmissionTransactionContainers
                                    .getPrimaryMarketLoanSubmissionLinkIdentifier()
                            + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario()
                    .write(sb + "PrimaryMarketLoanSubmissionTransaction Match. Records validated in the section "
                            + recordsCounter);
            return true;
        }
    }

    @Override
    public List<PrimaryMarketLoanSubmissionTransactionContainer> extractData(ResultSet rs)
            throws SQLException, DataAccessException {
        List<PrimaryMarketLoanSubmissionTransactionContainer> results = new ArrayList<>();
        while (rs.next()) {
            PrimaryMarketLoanSubmissionTransactionContainer primaryMarketLoanSubmissionTransaction = new PrimaryMarketLoanSubmissionTransactionContainer();
            primaryMarketLoanSubmissionTransaction.setMortgageInsuranceRequiredIndicator(rs.getString("IND_MI_REQD"));
            primaryMarketLoanSubmissionTransaction
                    .setPrimaryMarketLoanSourceSubmissionTransactionId(rs.getString("ID_PML_SRCE_SUBMN_TRANS"));
            primaryMarketLoanSubmissionTransaction
                    .setPrimaryMarketLoanSubmissionLinkId(rs.getString("ID_PML_SUBMN_LINK"));
            primaryMarketLoanSubmissionTransaction.setEventId(rs.getInt("ID_EVNT"));
            results.add(primaryMarketLoanSubmissionTransaction);
        }
        return results;
    }

    @Override
    public String toString() {
        return "PrimaryMarketLoanSubmissionTransaction [primaryMarketLoanSubmissionLinkId="
                + primaryMarketLoanSubmissionLinkId + ", primaryMarketLoanSourceSubmissionTransactionId="
                + primaryMarketLoanSourceSubmissionTransactionId + ", mortgageInsuranceRequiredIndicator="
                + mortgageInsuranceRequiredIndicator + ", eventId=" + eventId + "]";
    }

}
