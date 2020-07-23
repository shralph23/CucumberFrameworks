package utils.data.jaxbhelper;

import java.math.BigDecimal;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.IntegratedDisclosureSectionSummary;

public class IntegratedDisclosureSectionSummaryHelper {

	private static final String	LOAN_IDENTIFIER_KEY = "LOAN_IDENTIFIER";
	private static final double	LENDER_CREDIT_TOLERANCE_CURE_AMOUNT_KEY = 0;
	private static final String	INTEGRATED_DISCLOSURE_SECTION_TYPE_KEY = "INTEGRATED_DISCLOSURE_SECTION_TYPE";
	private static final double	INTEGRATED_DISCLOSURE_SECTION_TOTAL_AMOUNT_KEY = 0;

	public static IntegratedDisclosureSectionSummary getIntegratedDisclosureSectionSummary(Properties properties) {
		IntegratedDisclosureSectionSummary integratedDisclosureSectionSummary = new IntegratedDisclosureSectionSummary();
		integratedDisclosureSectionSummary.setIntegratedDisclosureSectionTotalAmount(BigDecimal.valueOf(INTEGRATED_DISCLOSURE_SECTION_TOTAL_AMOUNT_KEY));
		integratedDisclosureSectionSummary.setIntegratedDisclosureSectionType(properties.getProperty(INTEGRATED_DISCLOSURE_SECTION_TYPE_KEY));
		integratedDisclosureSectionSummary.setLenderCreditToleranceCureAmount(BigDecimal.valueOf(LENDER_CREDIT_TOLERANCE_CURE_AMOUNT_KEY));
		integratedDisclosureSectionSummary.setLoanIdentifier(properties.getProperty(LOAN_IDENTIFIER_KEY));
		return integratedDisclosureSectionSummary;
	}
}
