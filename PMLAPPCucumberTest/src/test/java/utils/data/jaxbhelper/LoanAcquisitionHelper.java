package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.LoanAcquisition;

public class LoanAcquisitionHelper {

    private static final String SELLER_LOAN_IDENTIFIER_KEY = "SELLER_LOAN_IDENTIFIER";
    private static final String SELLER_ACCOUNT_IDENTIFIER_KEY = "SELLER_ACCOUNT_IDENTIFIER";
    private static final String LOAN_IDENTIFIER_KEY = "LOAN_IDENTIFIER";

    public static LoanAcquisition getLoanAcquisition(Properties properties) {
        LoanAcquisition loanAcquisition = new LoanAcquisition();
        loanAcquisition.setLoanIdentifier(properties.getProperty(LOAN_IDENTIFIER_KEY));
        loanAcquisition.setSellerAccountIdentifier(properties.getProperty(SELLER_ACCOUNT_IDENTIFIER_KEY));
        loanAcquisition.setSellerLoanIdentifier(properties.getProperty(SELLER_LOAN_IDENTIFIER_KEY));
        return loanAcquisition;
    }
}
