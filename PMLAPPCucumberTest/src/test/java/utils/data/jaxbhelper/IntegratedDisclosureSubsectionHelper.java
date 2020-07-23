package utils.data.jaxbhelper;

import java.math.BigDecimal;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.IntegratedDisclosureSubsection;

public class IntegratedDisclosureSubsectionHelper {

    private static final String LOAN_IDENTIFIER_KEY = "LOAN_IDENTIFIER";
    private static final String INTEGRATED_DISCLOSURE_SUB_SECTION_TYPE_KEY = "INTEGRATED_DISCLOSURE_SUB_SECTION_TYPE";
    private static final double INTEGRATED_DISCLOSURE_SUB_SECTION_TOTAL_AMOUNT_KEY = 0;
    private static final String INTEGRATED_DISCLOSURE_SECTION_TYPE_KEY = "INTEGRATED_DISCLOSURE_SECTION_TYPE";

    public static IntegratedDisclosureSubsection getIntegratedDisclosureSubsection(Properties properties) {
        IntegratedDisclosureSubsection integratedDisclosureSubsection = new IntegratedDisclosureSubsection();
        integratedDisclosureSubsection
                .setIntegratedDisclosureSectionType(properties.getProperty(INTEGRATED_DISCLOSURE_SECTION_TYPE_KEY));
        integratedDisclosureSubsection.setIntegratedDisclosureSubsectionTotalAmount(
                BigDecimal.valueOf(INTEGRATED_DISCLOSURE_SUB_SECTION_TOTAL_AMOUNT_KEY));
        integratedDisclosureSubsection.setIntegratedDisclosureSubsectionType(
                properties.getProperty(INTEGRATED_DISCLOSURE_SUB_SECTION_TYPE_KEY));
        integratedDisclosureSubsection.setLoanIdentifier(properties.getProperty(LOAN_IDENTIFIER_KEY));
        return integratedDisclosureSubsection;
    }
}
