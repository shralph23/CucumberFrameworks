package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.LoanPurchaseContract;

import utils.datageneration.payloads.PropertiesUtils;

public class LoanPurchaseContractHelper {

    private static final String LOAN_PURCHASE_CONTRACT_IDENTIFIER_KEY = "LOAN_PURCHASE_CONTRACT_IDENTIFIER";
    private static final String CONTRACT_LEVEL_TYPE_KEY = "CONTRACT_LEVEL_TYPE";

    public static LoanPurchaseContract getLoanPurchaseContract(Properties properties) {
        LoanPurchaseContract loanPurchaseContract = new LoanPurchaseContract();
        loanPurchaseContract.setContractLevelType(PropertiesUtils.getStringValue(properties, CONTRACT_LEVEL_TYPE_KEY));
        loanPurchaseContract.setLoanPurchaseContractIdentifier(
                PropertiesUtils.getStringValue(properties, LOAN_PURCHASE_CONTRACT_IDENTIFIER_KEY));
        return loanPurchaseContract;
    }
}
