package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.LoanPurchaseContract;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class ContractContainer implements ResultSetExtractor<List<ContractContainer>> {
    private String contractLevelType;
    private String loanPurchaseContractIdentifier;
    private int eventId;

    public ContractContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getContractLevelType() {
        return contractLevelType;
    }

    public void setContractLevelType(String contractLevelType) {
        this.contractLevelType = contractLevelType;
    }

    public String getLoanPurchaseContractIdentifier() {
        return loanPurchaseContractIdentifier;
    }

    public void setLoanPurchaseContractIdentifier(String loanPurchaseContractIdentifier) {
        this.loanPurchaseContractIdentifier = loanPurchaseContractIdentifier;
    }

    @Override
    public boolean equals(Object xmlContractContainerObj) {
        ContractContainer dbContractContainer = this;
        LoanPurchaseContract xmlContractContainer = (LoanPurchaseContract) xmlContractContainerObj;
        if (xmlContractContainer == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbContractContainer.getEventId() + "\n");
            if (dbContractContainer.getContractLevelType() != null
                    && xmlContractContainer.getContractLevelType() != null) {
                if (!dbContractContainer.getContractLevelType().equals(xmlContractContainer.getContractLevelType())) {
                    GlobalHooks.getScenario().write("ContractLevelType mismatch. Expected Value is "
                            + dbContractContainer.getContractLevelType() + " but actual value is "
                            + xmlContractContainer.getContractLevelType());
                    return false;
                } else {
                    sb.append("ContractLevelType in DB: " + dbContractContainer.getContractLevelType()
                            + " ContractLevelType in XML: " + xmlContractContainer.getContractLevelType() + "\n");
                    recordsCounter++;
                }
            }

            if (dbContractContainer.getLoanPurchaseContractIdentifier() != null
                    && xmlContractContainer.getLoanPurchaseContractIdentifier() != null) {
                if (!dbContractContainer.getLoanPurchaseContractIdentifier()
                        .equals(xmlContractContainer.getLoanPurchaseContractIdentifier())) {
                    GlobalHooks.getScenario().write("LoanPurchaseContractIdentifier mismatch. Expected Value is "
                            + dbContractContainer.getLoanPurchaseContractIdentifier() + " but actual value is "
                            + xmlContractContainer.getLoanPurchaseContractIdentifier());
                    return false;
                } else {
                    sb.append("LoanPurchaseContractIdentifier in DB: "
                            + dbContractContainer.getLoanPurchaseContractIdentifier()
                            + " LoanPurchaseContractIdentifier in XML: "
                            + xmlContractContainer.getLoanPurchaseContractIdentifier() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario()
                    .write(sb + "ContractContainer Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<ContractContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<ContractContainer> results = new ArrayList<>();
        while (rs.next()) {
            ContractContainer contract = new ContractContainer();
            contract.setEventId(rs.getInt("ID_EVNT"));
            contract.setContractLevelType(rs.getString("NAME_CONT_LVL_TYPE"));
            contract.setLoanPurchaseContractIdentifier(rs.getString("ID_PML_SUBMN_CONT"));
            results.add(contract);
        }
        return results;
    }

    @Override
    public String toString() {
        return "ContractContainer [contractLevelType=" + contractLevelType + ", loanPurchaseContractIdentifier="
                + loanPurchaseContractIdentifier + ", eventId=" + eventId + "]";
    }

}
