package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.IntegratedDisclosure;

public class IntegratedDisclosureHelper {

    private static final String LOAN_IDENTIFIER_KEY = "LOAN_IDENTIFIER_KEY";

    public static IntegratedDisclosure getIntegratedDisclosure(Properties properties) {
        IntegratedDisclosure integrationDisclosure = new IntegratedDisclosure();
        integrationDisclosure.setLoanIdentifier(properties.getProperty(LOAN_IDENTIFIER_KEY));
        return integrationDisclosure;
    }
}
