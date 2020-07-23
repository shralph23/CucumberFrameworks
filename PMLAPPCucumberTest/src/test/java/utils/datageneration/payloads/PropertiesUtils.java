package utils.datageneration.payloads;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.freddiemac.sls.SLSAttributesType;

import utils.generic.TestConstants;

public class PropertiesUtils {
    private static String defaultPayloadFile = "src/main/resources/defaultPayloadValues.properties";
    private static final String CONTAINER_TO_BE_REMOVED = "CONTAINER_TO_BE_REMOVED";
    private static final String MESSAGE_IDENTIFIER = "MESSAGE_IDENTIFIER";
    private static final String SOURCE_SYSTEM = "SOURCE_SYSTEM";
    private static final Logger logger = Logger.getLogger(PropertiesUtils.class);

    public static Properties loadPropertiesFile() throws IOException {
        FileInputStream fileInput = new FileInputStream(new File(defaultPayloadFile));
        Properties properties = new Properties();
        properties.load(fileInput);
        return properties;
    }

    public static void modifyPropertiesfile(Properties properties, String attributeTag, String attributeValue)
            throws IOException {
        properties.put(attributeTag, attributeValue);
    }

    public static void setContainerToBeRemoved(Properties properties, String containerToBeRemoved) {
        properties.put(CONTAINER_TO_BE_REMOVED, containerToBeRemoved);
    }

    public static String getContainerToBeRemoved(Properties properties) {
        return (String) properties.get(CONTAINER_TO_BE_REMOVED);
    }

    public static String getPayloadType(Properties properties) {
        return (String) properties.get(SOURCE_SYSTEM);
    }

    public static void modifyUniqueValuesForPayload(String slsId, String sourceSystem, String messageId,
            Properties properties) {
        setContainerToBeRemoved(properties, "null");
        properties.put(MESSAGE_IDENTIFIER, messageId);
        properties.put(SOURCE_SYSTEM, sourceSystem);
        properties.put("ENTITY_IDENTIFIER", slsId);
        properties.put("PRIMARY_MARKET_LOAN_SUBMISSION_LINK_IDENTIFIER", slsId);
        properties.put("EVENT_IDENTIFIER", messageId);
        properties.put("PRIMARY_MARKET_LOAN_SOURCE_SUBMISSION_TRANSACTION_IDENTIFIER", messageId);
        properties.put("LOAN_IDENTIFIER", slsId);
    }

    public static void setSLSKeysForPayload(Properties properties, SLSAttributesType slsAttributesType) {
        properties.put("MERSMIN_IDENTIFIER", slsAttributesType.getMERSMINIdentifier());
        properties.put("APPRAISER_FILE_IDENTIFIER", slsAttributesType.getAppraisalIdentifier());
        properties.put("LOAN_UNDERWRITING_CASE_IDENTIFIER", slsAttributesType.getLoanUnderwritingCaseIdentifier());
        properties.put("AUTOMATED_UNDERWRITING_SYSTEM_TYPE", slsAttributesType.getAutomatedUnderwritingSystemType());
        properties.put("SELLER_LOAN_IDENTIFIER", TestConstants.LENDER_LN_ID);
    }

    public static void setLCAEPayloadSLSKeys(Properties properties, SLSAttributesType slsAttributesType) {
        properties.put("MERSMIN_IDENTIFIER", slsAttributesType.getMERSMINIdentifier());
        properties.put("APPRAISER_FILE_IDENTIFIER", slsAttributesType.getAppraisalIdentifier());
    }

    public static BigDecimal getBigDecimalValue(Properties properties, String propertyName) {
        return getNumericalValue(properties, propertyName);
    }

    public static Short getShortValue(Properties properties, String propertyName) {
        BigDecimal value = getNumericalValue(properties, propertyName);
        return value == null ? null : value.shortValue();
    }

    public static BigInteger getBigIntegerValue(Properties properties, String propertyName) {
        BigDecimal value = getNumericalValue(properties, propertyName);
        return value == null ? null : value.toBigInteger();
    }

    public static String getStringValue(Properties properties, String propertyName) {
        String input = properties.getProperty(propertyName);
        if (invalidProperty(input)) {
            return null;
        } else {
            return input;
        }
    }

    public static Date getDateTimeValue(Properties properties, String propertyName) {
        String input = properties.getProperty(propertyName);
        if (invalidProperty(input)) {
            return null;
        } else {
            Date dateTime = null;
            try {
                dateTime = TestConstants.dateTimeParser.parse(input);
            } catch (ParseException e) {
                logger.info("Date: '" + input + "' cannot be parsed in specific format:'"
                        + TestConstants.dateTimeParser.toPattern() + "'");
            }
            return dateTime;
        }
    }

    private static BigDecimal getNumericalValue(Properties properties, String propertyName) {
        String input = properties.getProperty(propertyName);
        if (invalidProperty(input)) {
            return null;
        } else if (input.equals("")) {
            return BigDecimal.ZERO;
        } else {
            Double inputDouble = Double.valueOf(input);
            return BigDecimal.valueOf(inputDouble);
        }
    }

    private static boolean invalidProperty(String input) {
        return input == null || input.equals("null");
    }

}
