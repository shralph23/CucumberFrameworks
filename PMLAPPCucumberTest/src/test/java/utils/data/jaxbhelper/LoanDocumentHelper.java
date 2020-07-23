package utils.data.jaxbhelper;

import java.math.BigInteger;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.LoanDocument;

import utils.datageneration.payloads.PropertiesUtils;

public class LoanDocumentHelper {

    private static final String APPLICATION_INPUT_PROCESSING_METHOD_TYPE_KEY = "APPLICATION_INPUT_PROCESSING_METHOD_TYPE";
    private static final String LOAN_DOCUMENT_TYPE_KEY = "LOAN_DOCUMENT_TYPE";
    private static final String LOAN_IDENTIFIER_KEY = "LOAN_IDENTIFIER";
    private static final int LOAN_DOCUMENT_IDENTIFIER_KEY = 9;

    public static LoanDocument getLoanDocument(Properties properties) {
        LoanDocument loanDocumnent = new LoanDocument();
        loanDocumnent.setApplicationInputProcessingMethodType(
                PropertiesUtils.getStringValue(properties, APPLICATION_INPUT_PROCESSING_METHOD_TYPE_KEY));
        loanDocumnent.setLoanDocumentType(PropertiesUtils.getStringValue(properties, LOAN_DOCUMENT_TYPE_KEY));
        loanDocumnent.setLoanDocumentIdentifier(BigInteger.valueOf(LOAN_DOCUMENT_IDENTIFIER_KEY));
        loanDocumnent.setLoanIdentifier(PropertiesUtils.getStringValue(properties, LOAN_IDENTIFIER_KEY));
        return loanDocumnent;
    }
}
