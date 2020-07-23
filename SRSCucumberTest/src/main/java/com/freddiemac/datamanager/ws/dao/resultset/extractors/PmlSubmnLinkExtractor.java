package com.freddiemac.datamanager.ws.dao.resultset.extractors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.ws.constants.SRSConstants;
import com.freddiemac.datamanager.ws.util.CollectionUtils;


public class PmlSubmnLinkExtractor implements ResultSetExtractor< List< String > >
{

   @Override
   public List< String > extractData( ResultSet rs ) throws SQLException, DataAccessException
   {
      List< String > idPmlSubmnLinks = new ArrayList<>();
      String idPmlSubmnLink = null;
      while( rs.next() ) {
         idPmlSubmnLink = rs.getString( SRSConstants.ID_PML_SUBMN_LINK );
         if(!CollectionUtils.itemExistsInCollection( idPmlSubmnLinks, idPmlSubmnLink )) {
            idPmlSubmnLinks.add( idPmlSubmnLink );
         }
      }
      return idPmlSubmnLinks;
   }

}
