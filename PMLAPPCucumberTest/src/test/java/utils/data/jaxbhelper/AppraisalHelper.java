package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.Appraisal;

public class AppraisalHelper {
    private static final String APPRAISAL_IDENTIFIER_KEY = "APPRAISAL_IDENTIFIER";
    private static final String APPRAISAL_FILE_IDENTIFIER_KEY = "APPRAISAL_FILE_IDENTIFIER";

    public static Appraisal getAppraisal(Properties properties) {
        Appraisal appraisal = new Appraisal();
        appraisal.setAppraisalIdentifier(properties.getProperty(APPRAISAL_FILE_IDENTIFIER_KEY));
        appraisal.setAppraiserFileIdentifier(properties.getProperty(APPRAISAL_IDENTIFIER_KEY));
        return appraisal;
    }
}
