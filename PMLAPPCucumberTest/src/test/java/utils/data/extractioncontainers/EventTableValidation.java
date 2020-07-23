package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EventTableValidation implements ResultSetExtractor<List<EventTableValidation>> {
	
	private String eventStatusType;

	public String getEventStatusType() {
		return eventStatusType;
	}

	public void setEventStatusType(String eventStatusType) {
		this.eventStatusType = eventStatusType;
	}

	@Override
	public List<EventTableValidation> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<EventTableValidation> results = new ArrayList<>();
		while (rs.next()) {
			this.setEventStatusType(rs.getString("NAME_EVNT_PROCSS_STS_TYPE"));
			results.add(this);
		}
		return results;
	}
}
