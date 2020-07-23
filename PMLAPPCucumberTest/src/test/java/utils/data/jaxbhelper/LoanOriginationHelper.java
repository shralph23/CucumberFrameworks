package utils.data.jaxbhelper;

import java.math.BigDecimal;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.LoanOrigination;

public class LoanOriginationHelper {

    private static final String LOAN_IDENTIFIER_KEY = "LOAN_IDENTIFIER";
    private static final double NOTE_AMOUNT_KEY = 166310.21;

    public static LoanOrigination getLoanOrignation(Properties properties) {
        LoanOrigination loanOrignation = new LoanOrigination();
        loanOrignation.setLoanIdentifier(properties.getProperty(LOAN_IDENTIFIER_KEY));
        loanOrignation.setNoteAmount(BigDecimal.valueOf(NOTE_AMOUNT_KEY));
        return loanOrignation;
    }
}
