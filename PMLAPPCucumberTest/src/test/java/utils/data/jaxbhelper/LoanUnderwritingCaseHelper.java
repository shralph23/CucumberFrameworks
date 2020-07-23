package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.LoanUnderwritingCase;

public class LoanUnderwritingCaseHelper {

    private static final String LOAN_IDENTIFIER_KEY = "LOAN_IDENTIFIER";
    private static final String LOAN_UNDERWRITING_CASE_IDENTIFIER_KEY = "LOAN_UNDERWRITING_CASE_IDENTIFIER";
    private static final String AUTOMATED_UNDERWRITING_SYSTEM_TYPE_KEY = "AUTOMATED_UNDERWRITING_SYSTEM_TYPE";

    public static LoanUnderwritingCase getLoanUnderwritingCase(Properties properties) {
        LoanUnderwritingCase loanUnderwritingCase = new LoanUnderwritingCase();
        loanUnderwritingCase
                .setLoanUnderwritingCaseIdentifier(properties.getProperty(LOAN_UNDERWRITING_CASE_IDENTIFIER_KEY));
        loanUnderwritingCase.setLoanIdentifier(properties.getProperty(LOAN_IDENTIFIER_KEY));
        loanUnderwritingCase
                .setAutomatedUnderwritingSystemType(properties.getProperty(AUTOMATED_UNDERWRITING_SYSTEM_TYPE_KEY));
        return loanUnderwritingCase;
    }
}
