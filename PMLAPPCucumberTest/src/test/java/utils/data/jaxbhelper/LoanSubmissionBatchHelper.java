package utils.data.jaxbhelper;

import java.util.Date;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.LoanSubmissionBatch;

import utils.datageneration.payloads.PropertiesUtils;

public class LoanSubmissionBatchHelper {
    private static final String SOURCE_BATCH_IDENTIFIER_KEY = "SOURCE_BATCH_IDENTIFIER";

    public static LoanSubmissionBatch getLoanSubmissionBatch(Properties properties) {
        LoanSubmissionBatch loanSubmissionBatch = new LoanSubmissionBatch();
        loanSubmissionBatch.setBatchSubmissionDatetime(new Date());
        loanSubmissionBatch.setSourceBatchIdentifier(properties.getProperty(SOURCE_BATCH_IDENTIFIER_KEY));
        loanSubmissionBatch.setSourceSystemType(PropertiesUtils.getPayloadType(properties));
        return loanSubmissionBatch;
    }
}
