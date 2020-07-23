package utils.data.jaxbhelper;

import java.math.BigDecimal;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.LoanSettlement;

public class LoanSettlementHelper {

    private static final String LOAN_IDENTIFIER_KEY = "LOAN_IDENTIFIER";
    private static final double CASHTO_BORROWERAT_CLOSING_MOUNT_KEY = 189.76;

    public static LoanSettlement getLoanSettlement(Properties properties) {
        LoanSettlement loanSettlement = new LoanSettlement();
        loanSettlement.setCashToBorrowerAtClosingAmount(BigDecimal.valueOf(CASHTO_BORROWERAT_CLOSING_MOUNT_KEY));
        loanSettlement.setLoanIdentifier(properties.getProperty(LOAN_IDENTIFIER_KEY));
        return loanSettlement;
    }
}
