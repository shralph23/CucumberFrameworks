package utils.db;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import featuredefinition.utils.StepsUtils;

@Repository
@Qualifier("PmlTestDao")
public class PmlTestDao {

    private static final Logger logger = Logger.getLogger(StepsUtils.class);

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<ResultSetExtractor> getResultsFrmDB(String sql, String slsId, ResultSetExtractor resultObj) {
        MapSqlParameterSource sqlParams = new MapSqlParameterSource();
        sqlParams.addValue("idety", slsId);
        logger.debug("Slsid (idety) for query -> " + slsId);
        return (List<ResultSetExtractor>) namedParameterJdbcTemplate.query(sql, sqlParams, resultObj);
    }
}