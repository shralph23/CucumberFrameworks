package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.LoanUnderwritingDecision;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class LoanUnderwritingDecisionContainer implements ResultSetExtractor<List<LoanUnderwritingDecisionContainer>> {

	private String loanProspectorCreditRiskClassificationDescription;
	private String automatedUnderwritingRecommendationDescription;
	private int eventId;
	private int index = 0;

	public LoanUnderwritingDecisionContainer() {

	}

	public int  getIndex(){
		int finalIndex = index;
		index++;
		return finalIndex;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getLoanProspectorCreditRiskClassificationDescription() {
		return loanProspectorCreditRiskClassificationDescription;
	}

	public void setLoanProspectorCreditRiskClassificationDescription(
			String loanProspectorCreditRiskClassificationDescription) {
		this.loanProspectorCreditRiskClassificationDescription = loanProspectorCreditRiskClassificationDescription;
	}

	public String getAutomatedUnderwritingRecommendationDescription() {
		return automatedUnderwritingRecommendationDescription;
	}

	public void setAutomatedUnderwritingRecommendationDescription(
			String automatedUnderwritingRecommendationDescription) {
		this.automatedUnderwritingRecommendationDescription = automatedUnderwritingRecommendationDescription;
	}

	@Override
	public boolean equals(Object xmlLoanUnderwritingDecisionContainersObj) {
		LoanUnderwritingDecision xmlLoanUnderwritingDecisionContainers = (LoanUnderwritingDecision) xmlLoanUnderwritingDecisionContainersObj;
		if (xmlLoanUnderwritingDecisionContainers == null) {
			return false;
		} else {
			StringBuilder sb = new StringBuilder();
			int recordsCounter = 0;
			sb.append("Event= " + this.getEventId() + "\n");
			if (xmlLoanUnderwritingDecisionContainers.getLoanProspectorCreditRiskClassificationDescription() != null
					&& this.getLoanProspectorCreditRiskClassificationDescription() != null) {
				if (!xmlLoanUnderwritingDecisionContainers.getLoanProspectorCreditRiskClassificationDescription()
						.equals(this.getLoanProspectorCreditRiskClassificationDescription())) {
					GlobalHooks.getScenario()
							.write("LoanProspectorCreditRiskClassificationDescription mismatch. Expected Value is "
									+ this.getLoanProspectorCreditRiskClassificationDescription()
									+ " but actual value is " + xmlLoanUnderwritingDecisionContainers
											.getLoanProspectorCreditRiskClassificationDescription());
					return false;
				} else {
					sb.append("LoanProspectorCreditRiskClassificationDescription in DB: "
							+ this.getLoanProspectorCreditRiskClassificationDescription()
							+ " LoanProspectorCreditRiskClassificationDescription in XML: "
							+ xmlLoanUnderwritingDecisionContainers.getLoanProspectorCreditRiskClassificationDescription() + "\n");
					recordsCounter++;
				}
			}

			if (xmlLoanUnderwritingDecisionContainers.getAutomatedUnderwritingRecommendationDescription() != null
					&& this.getAutomatedUnderwritingRecommendationDescription() != null) {
				if (!xmlLoanUnderwritingDecisionContainers.getAutomatedUnderwritingRecommendationDescription()
						.equals(this.getAutomatedUnderwritingRecommendationDescription())) {
					GlobalHooks.getScenario()
							.write("AutomatedUnderwritingRecommendationDescription mismatch. Expected Value is "
									+ this.getAutomatedUnderwritingRecommendationDescription() + " but actual value is "
									+ xmlLoanUnderwritingDecisionContainers
											.getAutomatedUnderwritingRecommendationDescription());
					return false;
				} else {
					sb.append("AutomatedUnderwritingRecommendationDescription in DB: "
							+ this.getAutomatedUnderwritingRecommendationDescription()
							+ " AutomatedUnderwritingRecommendationDescription in XML: "
							+ xmlLoanUnderwritingDecisionContainers.getAutomatedUnderwritingRecommendationDescription() + "\n");
					recordsCounter++;
				}
			}
			sb.append(TestConstants.REPORT_SEPERATOR);
			GlobalHooks.getScenario()
					.write(sb + "LoanUnderwritingDecision Match. Records validated in the section " + recordsCounter);
			return true;
		}
	}

	@Override
	public List<LoanUnderwritingDecisionContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<LoanUnderwritingDecisionContainer> results = new ArrayList<>();
		while (rs.next()) {
			this.setAutomatedUnderwritingRecommendationDescription(rs.getString("DESC_ATOMTD_UW_RCMDTN"));
			this.setEventId(rs.getInt("ID_EVNT"));
			results.add(this);
		}
		return results;
	}

	@Override
	public String toString() {
		return "LoanUnderwritingDecisionContainer [loanProspectorCreditRiskClassificationDescription="
				+ loanProspectorCreditRiskClassificationDescription
				+ ", automatedUnderwritingRecommendationDescription=" + automatedUnderwritingRecommendationDescription
				+ ", eventId=" + eventId + "]";
	}

}
