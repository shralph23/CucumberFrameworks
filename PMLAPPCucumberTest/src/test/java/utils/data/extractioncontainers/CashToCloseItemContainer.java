package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.CashToCloseItem;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class CashToCloseItemContainer implements ResultSetExtractor<List<CashToCloseItemContainer>> {
    private String integratedDisclosureCashToCloseItemAmountChangedIndicator;
    private String integratedDisclosureCashToCloseItemChangeDescription;
    private Double integratedDisclosureCashToCloseItemEstimatedAmount;
    private Double integratedDisclosureCashToCloseItemFinalAmount;
    private String integratedDisclosureCashToCloseItemPaymentType;
    private String integratedDisclosureCashToCloseItemType;
    private String loanIdentifier;
    private String loanSettlementDate;
    private int eventId;

    public CashToCloseItemContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getIntegratedDisclosureCashToCloseItemAmountChangedIndicator() {
        return integratedDisclosureCashToCloseItemAmountChangedIndicator;
    }

    public void setIntegratedDisclosureCashToCloseItemAmountChangedIndicator(
            String integratedDisclosureCashToCloseItemAmountChangedIndicator) {
        this.integratedDisclosureCashToCloseItemAmountChangedIndicator = integratedDisclosureCashToCloseItemAmountChangedIndicator;
    }

    public String getIntegratedDisclosureCashToCloseItemChangeDescription() {
        return integratedDisclosureCashToCloseItemChangeDescription;
    }

    public void setIntegratedDisclosureCashToCloseItemChangeDescription(
            String integratedDisclosureCashToCloseItemChangeDescription) {
        this.integratedDisclosureCashToCloseItemChangeDescription = integratedDisclosureCashToCloseItemChangeDescription;
    }

    public Double getIntegratedDisclosureCashToCloseItemEstimatedAmount() {
        return integratedDisclosureCashToCloseItemEstimatedAmount;
    }

    public void setIntegratedDisclosureCashToCloseItemEstimatedAmount(
            Double integratedDisclosureCashToCloseItemEstimatedAmount) {
        this.integratedDisclosureCashToCloseItemEstimatedAmount = integratedDisclosureCashToCloseItemEstimatedAmount;
    }

    public Double getIntegratedDisclosureCashToCloseItemFinalAmount() {
        return integratedDisclosureCashToCloseItemFinalAmount;
    }

    public void setIntegratedDisclosureCashToCloseItemFinalAmount(
            Double integratedDisclosureCashToCloseItemFinalAmount) {
        this.integratedDisclosureCashToCloseItemFinalAmount = integratedDisclosureCashToCloseItemFinalAmount;
    }

    public String getIntegratedDisclosureCashToCloseItemPaymentType() {
        return integratedDisclosureCashToCloseItemPaymentType;
    }

    public void setIntegratedDisclosureCashToCloseItemPaymentType(
            String integratedDisclosureCashToCloseItemPaymentType) {
        this.integratedDisclosureCashToCloseItemPaymentType = integratedDisclosureCashToCloseItemPaymentType;
    }

    public String getIntegratedDisclosureCashToCloseItemType() {
        return integratedDisclosureCashToCloseItemType;
    }

    public void setIntegratedDisclosureCashToCloseItemType(String integratedDisclosureCashToCloseItemType) {
        this.integratedDisclosureCashToCloseItemType = integratedDisclosureCashToCloseItemType;
    }

    public String getLoanIdentifier() {
        return loanIdentifier;
    }

    public void setLoanIdentifier(String loanIdentifier) {
        this.loanIdentifier = loanIdentifier;
    }

    public String getLoanSettlementDate() {
        return loanSettlementDate;
    }

    public void setLoanSettlementDate(String loanSettlementDate) {
        this.loanSettlementDate = loanSettlementDate;
    }

    @Override
    public boolean equals(Object xmlCashToCloseItemContainersObj) {
        CashToCloseItemContainer dbCashToCloseItemContainers = this;
        CashToCloseItem xmlCashToCloseItemContainers = (CashToCloseItem) xmlCashToCloseItemContainersObj;
        if (xmlCashToCloseItemContainersObj == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbCashToCloseItemContainers.getEventId() + "\n");
            if (dbCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemPaymentType() != null
                    && xmlCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemPaymentType() != null) {
                if (!dbCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemPaymentType()
                        .equals(xmlCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemPaymentType())) {
                    GlobalHooks.getScenario()
                            .write("IntegratedDisclosureCashToCloseItemPaymentType mismatch. Expected Value is "
                                    + dbCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemPaymentType()
                                    + " but actual value is "
                                    + xmlCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemPaymentType());
                    return false;
                } else {
                    sb.append("IntegratedDisclosureCashToCloseItemPaymentType in DB: "
                            + dbCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemPaymentType()
                            + " IntegratedDisclosureCashToCloseItemPaymentType in XML: "
                            + xmlCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemPaymentType() + "\n");
                    recordsCounter++;
                }
            }

            if (dbCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemType() != null
                    && xmlCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemType() != null) {
                if (!dbCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemType()
                        .equals(xmlCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemType())) {
                    GlobalHooks.getScenario().write("IntegratedDisclosureCashToCloseItemType mismatch. Expected Value is "
                            + dbCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemType()
                            + " but actual value is "
                            + xmlCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemType());
                    return false;
                } else {
                    sb.append("IntegratedDisclosureCashToCloseItemType in DB: "
                            + dbCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemType()
                            + " IntegratedDisclosureCashToCloseItemType in XML: "
                            + xmlCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemType() + "\n");
                    recordsCounter++;
                }
            }

            if (dbCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemEstimatedAmount() != null
                    && xmlCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemEstimatedAmount() != null) {
                String dbIntegratedCashToCloseEstimatedAmount = TestConstants.decFormat
                        .format(Double.valueOf(dbCashToCloseItemContainers
                                .getIntegratedDisclosureCashToCloseItemEstimatedAmount().doubleValue()));
                String xmlIntegratedCashToCloseEstimatedAmount = TestConstants.decFormat
                        .format(Double.valueOf(xmlCashToCloseItemContainers
                                .getIntegratedDisclosureCashToCloseItemEstimatedAmount().doubleValue()));
                if (!(dbIntegratedCashToCloseEstimatedAmount).equals(xmlIntegratedCashToCloseEstimatedAmount)) {
                    GlobalHooks.getScenario()
                            .write("IntegratedDisclosureCashToCloseItemEstimatedAmount mismatch. Expected Value is "
                                    + dbIntegratedCashToCloseEstimatedAmount + " but actual value is "
                                    + xmlIntegratedCashToCloseEstimatedAmount);
                    return false;
                } else {
                    sb.append("IntegratedDisclosureCashToCloseItemEstimatedAmount in DB: "
                            + dbIntegratedCashToCloseEstimatedAmount
                            + " IntegratedDisclosureCashToCloseItemEstimatedAmount in XML: "
                            + xmlIntegratedCashToCloseEstimatedAmount + "\n");
                    recordsCounter++;
                }
            }

            if (dbCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemFinalAmount() != null
                    && xmlCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemFinalAmount() != null) {
                String dbIntegratedCashToCloseItemFinalAmount = TestConstants.decFormat.format(Double.valueOf(
                        dbCashToCloseItemContainers.getIntegratedDisclosureCashToCloseItemFinalAmount().doubleValue()));
                String xmlIntegratedCashToCloseItemFinalAmount = TestConstants.decFormat
                        .format(Double.valueOf(xmlCashToCloseItemContainers
                                .getIntegratedDisclosureCashToCloseItemFinalAmount().doubleValue()));
                if (!(dbIntegratedCashToCloseItemFinalAmount).equals(xmlIntegratedCashToCloseItemFinalAmount)) {
                    GlobalHooks.getScenario()
                            .write("IntegratedDisclosureCashToCloseItemFinalAmount mismatch. Expected Value is "
                                    + dbIntegratedCashToCloseItemFinalAmount + " but actual value is "
                                    + xmlIntegratedCashToCloseItemFinalAmount);
                    return false;
                } else {
                    sb.append("IntegratedDisclosureCashToCloseItemFinalAmount in DB: "
                            + dbIntegratedCashToCloseItemFinalAmount
                            + " IntegratedDisclosureCashToCloseItemFinalAmount in XML: "
                            + xmlIntegratedCashToCloseItemFinalAmount + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario()
                    .write(sb + "CashToCloseItem Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<CashToCloseItemContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<CashToCloseItemContainer> results = new ArrayList<>();
        while (rs.next()) {
            CashToCloseItemContainer cashToCloseItem = new CashToCloseItemContainer();
            cashToCloseItem.setIntegratedDisclosureCashToCloseItemType(rs.getString("CD_CASH_TO_CLOS_ITEM"));
            cashToCloseItem.setIntegratedDisclosureCashToCloseItemEstimatedAmount(rs.getDouble("AMT_ESTD"));
            cashToCloseItem.setIntegratedDisclosureCashToCloseItemFinalAmount(rs.getDouble("AMT_FNL"));
            cashToCloseItem.setIntegratedDisclosureCashToCloseItemPaymentType(rs.getString("CD_PAYMT"));
            cashToCloseItem.setEventId(rs.getInt("ID_EVNT"));
            results.add(cashToCloseItem);
        }
        return results;
    }

    @Override
    public String toString() {
        return "CashToCloseItemContainer [integratedDisclosureCashToCloseItemEstimatedAmount="
                + integratedDisclosureCashToCloseItemEstimatedAmount
                + ", integratedDisclosureCashToCloseItemFinalAmount=" + integratedDisclosureCashToCloseItemFinalAmount
                + ", integratedDisclosureCashToCloseItemPaymentType=" + integratedDisclosureCashToCloseItemPaymentType
                + ", integratedDisclosureCashToCloseItemType=" + integratedDisclosureCashToCloseItemType + ", eventId="
                + eventId + "]";
    }

}
