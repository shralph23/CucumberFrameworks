package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.DocumentGroup;

import utils.datageneration.payloads.PropertiesUtils;
import utils.generic.TestConstants;

public class DocumentGroupHelper {

    private static final String DOCUMENT_REQUIREMENT_SATISFIED_TYPE_KEY = "DOCUMENT_REQUIREMENT_SATISFIED_TYPE";
    private static final String DOCUMENT_GROUP_TYPE_KEY = "DOCUMENT_GROUP_TYPE";

    public static DocumentGroup getDocumentGroup(Properties properties) {
        DocumentGroup documentGroup = new DocumentGroup();
        if (!PropertiesUtils.getContainerToBeRemoved(properties).equals(TestConstants.DOCUMENT_GROUP)) {
            documentGroup.setDocumentGroupType(PropertiesUtils.getStringValue(properties, DOCUMENT_GROUP_TYPE_KEY));
            documentGroup.setDocumentRequirementSatisfiedType(
                    PropertiesUtils.getStringValue(properties, DOCUMENT_REQUIREMENT_SATISFIED_TYPE_KEY));
        }
        return documentGroup;
    }
}
