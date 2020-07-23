package utils.data.jaxbhelper;

import java.math.BigInteger;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.DocumentStatus;

public class DocumentStatusHelper {

    private static String DOCUMENT_STATUS_TYPE_KEY = "DOCUMENT_STATUS_TYPE";
    private static int DOCUMENT_IDENTIFIER_KEY = 0;

    public static DocumentStatus getDocumentStatus(Properties properties) {
        DocumentStatus documentStatus = new DocumentStatus();
        documentStatus.setDocumentIdentifier(BigInteger.valueOf(DOCUMENT_IDENTIFIER_KEY));
        documentStatus.setDocumentStatusType(properties.getProperty(DOCUMENT_STATUS_TYPE_KEY));
        return documentStatus;
    }
}
