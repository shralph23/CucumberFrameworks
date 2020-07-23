package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class MetaData implements ResultSetExtractor<List<MetaData>> {

	private DateTime dateCreate;
	private DateTime dateLastUpdate;
	private String iDCreate;
	private String iDLastUpdate;
	private int eventId;

	public MetaData() {

	}

	public DateTime getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(DateTime dateCreate) {
		this.dateCreate = dateCreate;
	}

	public DateTime getDateLastUpdate() {
		return dateLastUpdate;
	}

	public void setDateLastUpdate(DateTime dateLastUpdate) {
		this.dateLastUpdate = dateLastUpdate;
	}

	public String getIDCreate() {
		return iDCreate;
	}

	public void setIDCreate(String iDCreate) {
		this.iDCreate = iDCreate;
	}

	public String getIDLastUpdate() {
		return iDLastUpdate;
	}

	public void setIDLastUpdate(String iDLastUpdate) {
		this.iDLastUpdate = iDLastUpdate;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public static boolean validateMetaData(MetaData[] dbMetaDataContainers) {
		StringBuilder sb = new StringBuilder();
		for (int a = 0; a < dbMetaDataContainers.length; a++) {
			sb.append("Event= " + dbMetaDataContainers[a].getEventId() + "\n");
			if (dbMetaDataContainers[a].getDateCreate() == null) {
				GlobalHooks.getScenario().write("MetaData error - DateCreate NULL");
				return false;
			}

			if (dbMetaDataContainers[a].getDateLastUpdate() == null) {
				GlobalHooks.getScenario().write("MetaData error - DateLastUpdate NULL");
				return false;
			}

			if (dbMetaDataContainers[a].getIDCreate() == null) {
				GlobalHooks.getScenario().write("MetaData error - IDCreate NULL");
				return false;
			}

			if (dbMetaDataContainers[a].getIDLastUpdate() == null) {
				GlobalHooks.getScenario().write("MetaData error - IDLastUpdate NULL");
				return false;
			}
			sb.append("DateCreate in DB: " + dbMetaDataContainers[a].getDateCreate() + "\nDateLastUpdate in DB: "
					+ dbMetaDataContainers[a].getDateLastUpdate() + "\nIDCreate in DB: "
					+ dbMetaDataContainers[a].getIDCreate() + "\nIDLastUpdate in DB: "
					+ dbMetaDataContainers[a].getIDLastUpdate() + "\n");
		}
		sb.append(TestConstants.REPORT_SEPERATOR);
		GlobalHooks.getScenario().write(sb + "MetaData Validated ");
		return true;
	}

	@Override
	public List<MetaData> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<MetaData> results = new ArrayList<>();
		while (rs.next()) {
			MetaData result = new MetaData();
			result.setDateCreate(new DateTime(rs.getDate("DTTM_CREATE")));
			result.setDateLastUpdate(new DateTime(rs.getDate("DTTM_LST_UPDT")));
			result.setIDCreate(rs.getString("ID_CREATE"));
			result.setIDLastUpdate(rs.getString("ID_LST_UPDT"));
			result.setEventId(rs.getInt("ID_EVNT"));
			results.add(result);
		}
		return results;
	}

	@Override
	public String toString() {
		return "MetaData [dateCreate=" + dateCreate + ", dateLastUpdate=" + dateLastUpdate + ", iDCreate=" + iDCreate
				+ ", iDLastUpdate=" + iDLastUpdate + ", eventId=" + eventId + "]";
	}

}
