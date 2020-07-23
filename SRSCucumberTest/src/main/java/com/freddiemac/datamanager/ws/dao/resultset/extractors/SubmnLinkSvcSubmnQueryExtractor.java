package com.freddiemac.datamanager.ws.dao.resultset.extractors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.ws.dao.dto.SubmnLinkSvcSubmn;

public class SubmnLinkSvcSubmnQueryExtractor implements ResultSetExtractor< List<SubmnLinkSvcSubmn> >
{

   long idSubmn;   
   String idPmlSubmnLink;    
   java.sql.Timestamp dttmSubmnRqst;   
   String nameSrceSyst;   
   String namePrtyRoleTypeMtch;
   String idPrtyMtch; 
   String nameStdzdPptyCityMtch;
   String cdStdzdPptyFipsStAlpha;
   String idApprslDocFileMtch;            
   String idLendrLoanMtch;                 
   String idLoanUwCaseMtch;              
   String idMersMinMtch;
   String nameAusTypeMtch;
   String cdStdzdPptyPstlMtch;
   String textStdzdPptyAddrLiMtch;      
   String textStdzdPptyAddrLiCnctntd;
   
   java.sql.Timestamp dttmCreate;     
   java.sql.Timestamp dttmLstUpdt;                   
   String idCreate;                          
   String idLstUpdt;
   
   @Override
   public List<SubmnLinkSvcSubmn> extractData( ResultSet rs ) throws SQLException 
   {

      List<SubmnLinkSvcSubmn> submnLinkSvcSubmns = new ArrayList<>();      

      while ( rs.next() ) {
         
         SubmnLinkSvcSubmn submnLinkSvcSubmn = createSubmnLinkSvcSubmn( rs );
         submnLinkSvcSubmns.add( submnLinkSvcSubmn );
         
      }
      
      return submnLinkSvcSubmns;
      
   }

   
   private SubmnLinkSvcSubmn createSubmnLinkSvcSubmn( ResultSet rs ) throws SQLException 
   {
      
      idSubmn = rs.getLong( "ID_SUBMN" );   
      idPmlSubmnLink = rs.getString("ID_PML_SUBMN_LINK");    
      dttmSubmnRqst = rs.getTimestamp("DTTM_SUBMN_RQST");   
      nameSrceSyst = rs.getString("NAME_SRCE_SYST");  
      namePrtyRoleTypeMtch = rs.getString("NAME_PRTY_ROLE_TYPE_MTCH");
      idPrtyMtch = rs.getString("ID_PRTY_MTCH");  
      nameStdzdPptyCityMtch = rs.getString( "NAME_STDZD_PPTY_CITY_MTCH" );
      cdStdzdPptyFipsStAlpha = rs.getString( "CD_STDZD_PPTY_FIPS_ST_ALPHA" );            
      idApprslDocFileMtch = rs.getString("ID_APPRSL_DOC_FILE_MTCH");            
      idLendrLoanMtch = rs.getString("ID_LENDR_LOAN_MTCH");                 
      idLoanUwCaseMtch = rs.getString("ID_LOAN_UW_CASE_MTCH");              
      idMersMinMtch = rs.getString("ID_MERS_MIN_MTCH");
      nameAusTypeMtch = rs.getString("NAME_AUS_TYPE_MTCH");
      cdStdzdPptyPstlMtch = rs.getString("CD_STDZD_PPTY_PSTL_MTCH");
      textStdzdPptyAddrLiMtch = rs.getString("TEXT_STDZD_PPTY_ADDR_LI_MTCH");      
      textStdzdPptyAddrLiCnctntd = rs.getString("TEXT_STDZD_PPTY_ADDR_LI_CNCTNTD");
      dttmCreate = rs.getTimestamp("DTTM_CREATE");     
      dttmLstUpdt = rs.getTimestamp("DTTM_LST_UPDT");                   
      idCreate = rs.getString("ID_CREATE");                          
      idLstUpdt = rs.getString("ID_LST_UPDT");
      
      return new SubmnLinkSvcSubmn( idSubmn, 
            idPmlSubmnLink, 
            dttmSubmnRqst, 
            nameSrceSyst, 
            namePrtyRoleTypeMtch, 
            idPrtyMtch, 
            nameStdzdPptyCityMtch,
            cdStdzdPptyFipsStAlpha,
            idApprslDocFileMtch, 
            idLendrLoanMtch, 
            idLoanUwCaseMtch, 
            idMersMinMtch, 
            nameAusTypeMtch, 
            cdStdzdPptyPstlMtch, 
            textStdzdPptyAddrLiMtch, 
            textStdzdPptyAddrLiCnctntd, 
            dttmCreate, 
            dttmLstUpdt, 
            idCreate, 
            idLstUpdt );
      
      
   }
   
}