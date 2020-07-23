package utils.data.jaxbhelper;

import java.math.BigInteger;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.Document;

public class DocumentHelper {

    private static final String DOCUMENT_COMMENT_TEXT_KEY = "DOCUMENT_COMMENT_TEXT";
    private static final String DOCUMENT_FILE_TYPE_KEY = "DOCUMENT_FILE_TYPE";
    private static final String DOCUMENT_FORM_IDENTIFIER_KEY = "DOCUMENT_FORM_IDENTIFIER";
    private static final String DOCUMENT_GROUP_IDENTIFIER_KEY = "DOCUMENT_GROUP_IDENTIFIER";
    private static final int DOCUMENT_IDENTIFIER_KEY = 0;
    private static final String DOCUMENT_NAME_KEY = "DOCUMENT_NAME";
    private static final String DOCUMENT_TEXT_KEY = "DOCUMENT_TEXT";
    private static final Short DOCUMENT_PAGE_COUNT_KEY = 4096;
    private static final String DOCUMNET_RECORDATION_PROCESSING_TYPE_KEY = "DOCUMNET_RECORDATION_PROCESSING_TYPE";
    private static final String DOCUMENT_SIGNATURE_REQUIRED_INDICATOR_KEY = "DOCUMENT_SIGNATURE_REQUIRED_INDICATOR";
    private static final String DOCUMENT_TYPE_KEY = "DOCUMENT_TYPE";
    private static final String DOCUMNET_CUSTODIAN_IDENTOFIER_KEY = "DOCUMNET_CUSTODIAN_IDENTOFIER";

    public static Document getDocument(Properties properties) {
        Document document = new Document();
        document.setDocumentCommentText(properties.getProperty(DOCUMENT_COMMENT_TEXT_KEY));
        document.setDocumentCustodianIdentifier(properties.getProperty(DOCUMNET_CUSTODIAN_IDENTOFIER_KEY));
        document.setDocumentFileType(properties.getProperty(DOCUMENT_FILE_TYPE_KEY));
        document.setDocumentFormIdentifier(properties.getProperty(DOCUMENT_FORM_IDENTIFIER_KEY));
        document.setDocumentGroupIdentifier(properties.getProperty(DOCUMENT_GROUP_IDENTIFIER_KEY));
        document.setDocumentIdentifier(BigInteger.valueOf(DOCUMENT_IDENTIFIER_KEY));
        document.setDocumentName(properties.getProperty(DOCUMENT_NAME_KEY));
        document.setDocumentPageCount(DOCUMENT_PAGE_COUNT_KEY);
        document.setDocumentRecordationProcessingType(properties.getProperty(DOCUMNET_RECORDATION_PROCESSING_TYPE_KEY));
        document.setDocumentSignatureRequiredIndicator(
                properties.getProperty(DOCUMENT_SIGNATURE_REQUIRED_INDICATOR_KEY));
        document.setDocumentText(properties.getProperty(DOCUMENT_TEXT_KEY));
        document.setDocumentType(properties.getProperty(DOCUMENT_TYPE_KEY));
        return document;
    }
}
