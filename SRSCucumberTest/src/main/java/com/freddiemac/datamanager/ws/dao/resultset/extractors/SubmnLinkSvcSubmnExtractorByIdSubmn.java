package com.freddiemac.datamanager.ws.dao.resultset.extractors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.ws.constants.SRSConstants;

public class SubmnLinkSvcSubmnExtractorByIdSubmn implements ResultSetExtractor<Map<String, String>>
{

   @Override
   public Map< String, String > extractData( ResultSet rs ) throws SQLException
   {
      String idSubmn;
      String idPmlSubmnLink;
      
      Map< String, String > idSubmnSLIDMap = new HashMap< >();
      
      while(rs.next()){
         idPmlSubmnLink = rs.getString( SRSConstants.ID_PML_SUBMN_LINK );
         idSubmn = rs.getString( SRSConstants.ID_SUBMN );
         
         idSubmnSLIDMap.put( idSubmn, idPmlSubmnLink );
         
      }     
      return idSubmnSLIDMap;
   }
/*
   @Override
   public Map< String, List< SubmnLinkSvcSubmnExtractorByIdSubmn > > extractData( ResultSet rs ) throws SQLException, DataAccessException
   {
     SubmnLinkSvcSubmnTest submnLinkSvcSubmn;
     String idPmlSubmnLink = null;
    
     Map< String, List< SubmnLinkSvcSubmnExtractorByIdSubmn > > submnLinkSvcSubmnDB = new HashMap<String, List< SubmnLinkSvcSubmnExtractorByIdSubmn > >();
     
     while(rs.next()) {
        submnLinkSvcSubmn = new SubmnLinkSvcSubmnTest();
        
        idPmlSubmnLink = rs.getString( SRSConstants.ID_PML_SUBMN_LINK );
        
        submnLinkSvcSubmn.setIdSubmn( rs.getLong( SRSConstants.ID_SUBMN ) );
        
        submnLinkSvcSubmn.setIdApprslDocFile( rs.getString( SRSConstants.ID_APPRSL_DOC_FILE ) );
        submnLinkSvcSubmn.setIdApprslDocFileMtch( SRSConstants.ID_APPRSL_DOC_FILE_MTCH );
        
        submnLinkSvcSubmn.setIdLoanUwCase( SRSConstants.ID_LOAN_UW_CASE );
        submnLinkSvcSubmn.setIdLoanUwCaseMtch( SRSConstants.ID_LOAN_UW_CASE_MTCH );
        
        submnLinkSvcSubmn.setNameAusType( SRSConstants.NAME_AUS_TYPE );
        submnLinkSvcSubmn.setNameAusTypeMtch( SRSConstants.NAME_AUS_TYPE_MTCH );
           
        submnLinkSvcSubmn.setIdMersMin( SRSConstants.ID_MERS_MIN );
        submnLinkSvcSubmn.setIdMersMinMtch( SRSConstants.ID_MERS_MIN_MTCH );
        
        submnLinkSvcSubmn.setIdLendrLoan( SRSConstants.ID_LENDR_LOAN );
        submnLinkSvcSubmn.setIdLendrLoanMtch( SRSConstants.ID_LENDR_LOAN_MTCH );
        
        submnLinkSvcSubmn.setIdPrty( SRSConstants.ID_PRTY );
        submnLinkSvcSubmn.setIdPrtyMtch( SRSConstants.ID_PRTY_MTCH );
        
        submnLinkSvcSubmn.setNamePrtyRoleType( SRSConstants.NAME_PRTY_ROLE_TYPE );
        submnLinkSvcSubmn.setNamePrtyRoleTypeMtch( SRSConstants.NAME_PRTY_ROLE_TYPE_MTCH );
        
        submnLinkSvcSubmn.setIdDoc( SRSConstants.ID_DOC );
        
        submnLinkSvcSubmn.setIdPmlSrceSubmnTrans( SRSConstants.ID_PML_SRCE_SUBMN_TRANS );
        
        submnLinkSvcSubmn.setIdFmLoan( SRSConstants.ID_FM_LOAN );
        
        submnLinkSvcSubmn.setTextStdzdPptyAddrLi( SRSConstants.TEXT_STDZD_PPTY_ADDR_LI );
        submnLinkSvcSubmn.setTextStdzdPptyAddrLiMtch( SRSConstants.TEXT_STDZD_PPTY_ADDR_LI_MTCH );
        
        submnLinkSvcSubmn.setTextStdzdPptyAddrLi( SRSConstants.TEXT_STDZD_PPTY_ADDR_LI );
        submnLinkSvcSubmn.setTextStdzdPptyAddrLiMtch( SRSConstants.TEXT_STDZD_PPTY_ADDR_LI_MTCH );
        
        submnLinkSvcSubmn.setNameStdzdPptyCity( SRSConstants.NAME_STDZD_PPTY_CITY );
        submnLinkSvcSubmn.setNameStdzdPptyCityMtch( SRSConstants.NAME_STDZD_PPTY_CITY_MTCH );
        
        submnLinkSvcSubmn.setStreetPrimeNumberText( SRSConstants.NBR_TEXT_STRT_PRIM );
        
        submnLinkSvcSubmn.setFipsStateAlphaCode( FIPSStateAlphaCode.valueOf( SRSConstants.CD_STDZD_PPTY_FIPS_ST_ALPHA ) );
        
        submnLinkSvcSubmn.setPostalCode( SRSConstants.CD_STDZD_PPTY_PSTL );
        
        submnLinkSvcSubmn.setPostalCodeMtch( SRSConstants.CD_STDZD_PPTY_PSTL_MTCH );
        
        submnLinkSvcSubmn.setIdPmlSubmnLink( SRSConstants.ID_PML_SUBMN_LINK );
        
        
        List< SubmnLinkSvcSubmnTest > existingsubmnLinkSvcSubmns = submnLinkSvcSubmnDB.get( idPmlSubmnLink );
        
        if( CollectionUtils.doesCollectionContainsValue( existingsubmnLinkSvcSubmns ) ) {
           existingsubmnLinkSvcSubmns.add( submnLinkSvcSubmn );
        }
        else {
           List< SubmnLinkSvcSubmnTest > newSubmnLinkSvcSubmns = new ArrayList< SubmnLinkSvcSubmnTest >();
           newSubmnLinkSvcSubmns.add( submnLinkSvcSubmn );
           submnLinkSvcSubmnDB.put( idPmlSubmnLink, newSubmnLinkSvcSubmns );
        }
        
     }
      
      return submnLinkSvcSubmnDB;
   }
*/
   
   
}
