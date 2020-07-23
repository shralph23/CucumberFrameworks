package com.freddiemac.datamanager.ws.dao.resultset.extractors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.ws.constants.SRSConstants;
import com.freddiemac.datamanager.ws.util.CollectionUtils;


public class SubmnLinkBorrExtractor implements ResultSetExtractor< Map< String, ArrayList< String > > >
{

   @Override
   public Map< String, ArrayList< String > > extractData( ResultSet rs ) throws SQLException, DataAccessException
   {
      String idPmlSubmnLink = null;
      String nbrTxpyrIdtn = null;
      Map< String, ArrayList< String > > taxPayerIdentifiersDB = new HashMap< String, ArrayList< String > >();

      while( rs.next() ) {
         idPmlSubmnLink = rs.getString( SRSConstants.ID_PML_SUBMN_LINK );
         nbrTxpyrIdtn = rs.getString( SRSConstants.NBR_TXPYR_IDTN );
         List< String > existingNbrTxpyrIdtns = taxPayerIdentifiersDB.get( idPmlSubmnLink );

         if( CollectionUtils.doesCollectionContainsValue( existingNbrTxpyrIdtns ) ) {
            existingNbrTxpyrIdtns.add( nbrTxpyrIdtn );
         }
         else {
            ArrayList< String > newNbrTxpyrIdtns = new ArrayList< String >();
            newNbrTxpyrIdtns.add( nbrTxpyrIdtn );
            taxPayerIdentifiersDB.put( idPmlSubmnLink, newNbrTxpyrIdtns );
         }

      }
      return taxPayerIdentifiersDB;
   }

}
