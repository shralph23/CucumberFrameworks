package com.freddiemac.datamanager.ws.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.freddiemac.datamanager.ws.constants.SRSConstants;
import com.freddiemac.datamanager.ws.dao.dto.SubmnLinkSvcSubmn;
import com.freddiemac.datamanager.ws.dao.resultset.extractors.SubmnLinkBorrExtractor;
import com.freddiemac.datamanager.ws.dao.resultset.extractors.SubmnLinkSvcSubmnExtractorByIdSubmn;
import com.freddiemac.datamanager.ws.dao.resultset.extractors.SubmnLinkSvcSubmnQueryExtractor;

@Repository
@Qualifier( "SRSDao" )
public class SRSDao
{
   @Resource( name = "SLSJDBCTemplate" )
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
   
   private static final Logger LOGGER = LoggerFactory.getLogger( SRSDao.class );

   public Map< String, ArrayList< String > > getPossibleBorrowersBySLID( List<String> slids )
   {

      MapSqlParameterSource sqlParams = new MapSqlParameterSource();
      sqlParams.addValue( SRSConstants.ID_PML_SUBMN_LINK, slids );

      return namedParameterJdbcTemplate.query( SRSConstants.SUBMN_LINK_BORR_QUERY,sqlParams, new SubmnLinkBorrExtractor() );

   }

   public List< SubmnLinkSvcSubmn > getPossibleSvcSubmissionsByCollectionKeys( Map< String, Set< String > > keys,
         String queryString )
   {

      MapSqlParameterSource submissionParams = DAOUtilis.generateQueriesParameters( keys );
      
      List< SubmnLinkSvcSubmn > submissions = namedParameterJdbcTemplate.query( queryString, submissionParams, new SubmnLinkSvcSubmnQueryExtractor() );

      LOGGER.info( "Matches from the Database -> {}", submissions);
    
      return submissions;

   }
   
   public Map< String, String > getSLIDByID_SUBMN( List<String> idSubmns )
   {

      MapSqlParameterSource sqlParams = new MapSqlParameterSource();
      sqlParams.addValue( SRSConstants.ID_SUBMN, idSubmns );

      return namedParameterJdbcTemplate.query( SRSConstants.ID_SUBMN_FROM_SUBMN_LINK_SVC_SUBMN_QUERY,sqlParams, new SubmnLinkSvcSubmnExtractorByIdSubmn() );

   }
}
