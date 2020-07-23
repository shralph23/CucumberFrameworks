package utils.data.jaxbhelper;

import java.math.BigDecimal;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.IntegratedDisclosureSubsectionPayment;

public class IntegratedDisclosureSubsectionPaymentHelper {

    private static final String LOAN_IDENTIFIER_KEY = "LOAN_IDENTIFIER";
    private static final String INTEGRATED_DISCLOSURE_SUBSECTION_TYPE_KEY = "INTEGRATED_DISCLOSURE_SUBSECTION_TYPE";
    private static final String INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENT_TIMING_TYPE_KEY = "INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENT_TIMING_TYPE";
    private static final double INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENT_AMOUNT_KEY = 0;
    private static final String INTEGRATED_DISCLOSURE_SUBSECTION_PAID_BY_TYPE_KEY = "INTEGRATED_DISCLOSURE_SUBSECTION_PAID_BY_TYPE";
    private static final String INTEGRATED_DISCLOSURE_SECTION_TYPE = "INTEGRATED_DISCLOSURE_SECTION_TYPE";

    public static IntegratedDisclosureSubsectionPayment getIntegratedDisclosureSubsectionPayment(
            Properties properties) {
        IntegratedDisclosureSubsectionPayment integratedDisclosureSubsectionPayment = new IntegratedDisclosureSubsectionPayment();
        integratedDisclosureSubsectionPayment
                .setIntegratedDisclosureSectionType(properties.getProperty(INTEGRATED_DISCLOSURE_SECTION_TYPE));
        integratedDisclosureSubsectionPayment.setIntegratedDisclosureSubsectionPaidByType(
                properties.getProperty(INTEGRATED_DISCLOSURE_SUBSECTION_PAID_BY_TYPE_KEY));
        integratedDisclosureSubsectionPayment.setIntegratedDisclosureSubsectionPaymentAmount(
                BigDecimal.valueOf(INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENT_AMOUNT_KEY));
        integratedDisclosureSubsectionPayment.setIntegratedDisclosureSubsectionPaymentTimingType(
                properties.getProperty(INTEGRATED_DISCLOSURE_SUBSECTION_PAYMENT_TIMING_TYPE_KEY));
        integratedDisclosureSubsectionPayment.setIntegratedDisclosureSubsectionType(
                properties.getProperty(INTEGRATED_DISCLOSURE_SUBSECTION_TYPE_KEY));
        integratedDisclosureSubsectionPayment.setLoanIdentifier(properties.getProperty(LOAN_IDENTIFIER_KEY));
        return integratedDisclosureSubsectionPayment;
    }
}
