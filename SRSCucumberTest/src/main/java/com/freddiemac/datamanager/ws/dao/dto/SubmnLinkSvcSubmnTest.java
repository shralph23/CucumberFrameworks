package com.freddiemac.datamanager.ws.dao.dto;

import java.sql.Timestamp;
import com.freddiemac.datamanager.ws.srs.enums.FIPSStateAlphaCode;

public class SubmnLinkSvcSubmnTest
{
   private long idSubmn;   
   private String cdStdzdPptyPstlMtch;            
   private String cdSubmnLinkSvcActnLgcy;   
   private int cntMdlSvcSubmn;
   private Timestamp dttmSubmnRqst;                   
   private String idApprslDocFile;                 
   private String idApprslDocFileMtch;            
   private String idCndtMtchRslt;
   private Long idDcsnMtchSubmn;                      
   private String idDoc;                             
   private String idFmLoan;                         
   private String idLendrLoan;                     
   private String idLendrLoanMtch;                 
   private String idLoanUwCase;                   
   private String idLoanUwCaseMtch;              
   private String idMersMin;                       
   private String idMersMinMtch;     
   private String idModelRqst;
   private String idMtchMdlVrsn;
   private String idPmlSrceSubmnTrans;            
   private String idPrty;    
   private String idPrtyMtch;    
   private String idSrceSubmn;
   private String idPmlSubmnLink;
   private String idPmlSubmnLinkOrigl;                  
   private String idSubmnRqst;       
   private String idValidtnRuleVrsn;
   private String indMtchErr;
   private String indRqstErr;
   private String indSubmnErr;
   private String nameAusType;                     
   private String nameAusTypeMtch;    
   private String nameCndtMtchType;
   private String namePrtyRoleType;
   private String namePrtyRoleTypeMtch;                
   private String nameSrceSyst;   
   private String nameSrceSystMtch;                             
   private String nameSubmtngSystShort;
   private String nameStdzdPptyCity;
   private String nameStdzdPptyCityMtch;
   private String textStdzdPptyAddrLi;
   private String textStdzdPptyAddrLiMtch;      
   private String textStdzdPptyAddrLiCnctntd;
   private String streetPrimeNumberText;
   private FIPSStateAlphaCode fipsStateAlphaCode;
   private String postalCode;
   private String postalCodeMtch;

   
   private Timestamp dttmRqstPrcsgStart;
   private Timestamp dttmRqstPrcsgEnd;
   
   private Timestamp dttmCreate;     
   private Timestamp dttmLstUpdt;                   
   private String idCreate;                          
   private String idLstUpdt;
   
   public SubmnLinkSvcSubmnTest() {
   }
   
   public SubmnLinkSvcSubmnTest( long idSubmn, 
         String idPmlSubmnLink, 
         Timestamp dttmSubmnRqst, 
         String nameSrceSyst, 
         String namePrtyRoleTypeMtch, 
         String idPrtyMtch, 
         String nameStdzdPptyCityMtch,
         String cdStdzdPptyFipsStAlpha,
         String idApprslDocFileMtch, 
         String idLendrLoanMtch, 
         String idLoanUwCaseMtch, 
         String idMersMinMtch, 
         String nameAusTypeMtch, 
         String cdStdzdPptyPstlMtch, 
         String textStdzdPptyAddrLiMtch, 
         String textStdzdPptyAddrLiCnctntd, 
         Timestamp dttmCreate, 
         Timestamp dttmLstUpdt, 
         String idCreate, 
         String idLstUpdt ) {

      this.idSubmn = idSubmn;
      
      this.idPmlSubmnLink = idPmlSubmnLink;
      this.dttmSubmnRqst = dttmSubmnRqst;
      this.nameSrceSyst = nameSrceSyst;
      this.namePrtyRoleTypeMtch = namePrtyRoleTypeMtch;
      this.idPrtyMtch = idPrtyMtch;
      
      this.nameStdzdPptyCityMtch = nameStdzdPptyCityMtch;
    
      this.idApprslDocFileMtch = idApprslDocFileMtch;
      this.idLendrLoanMtch = idLendrLoanMtch;
      this.idLoanUwCaseMtch = idLoanUwCaseMtch;
      this.idMersMinMtch = idMersMinMtch;
      this.nameAusTypeMtch = nameAusTypeMtch;
      this.cdStdzdPptyPstlMtch = cdStdzdPptyPstlMtch;
      this.textStdzdPptyAddrLiMtch = textStdzdPptyAddrLiMtch;
      this.textStdzdPptyAddrLiCnctntd = textStdzdPptyAddrLiCnctntd;
      
      this.dttmCreate = dttmCreate;
      this.dttmLstUpdt = dttmLstUpdt;
      this.idCreate = idCreate;
      this.idLstUpdt = idLstUpdt;

   }
   
   public long getIdSubmn()
   {
      return idSubmn;
   }

   public void setIdSubmn( long idSubmn )
   {
      this.idSubmn = idSubmn;
   }

   public String getCdStdzdPptyPstlMtch()
   {
      return cdStdzdPptyPstlMtch;
   }

   public void setCdStdzdPptyPstlMtch( String cdStdzdPptyPstlMtch )
   {
      this.cdStdzdPptyPstlMtch = cdStdzdPptyPstlMtch;
   }

   public String getCdSubmnLinkSvcActnLgcy()
   {
      return cdSubmnLinkSvcActnLgcy;
   }

   public void setCdSubmnLinkSvcActnLgcy( String cdSubmnLinkSvcActnLgcy )
   {
      this.cdSubmnLinkSvcActnLgcy = cdSubmnLinkSvcActnLgcy;
   }

   public int getCntMdlSvcSubmn()
   {
      return cntMdlSvcSubmn;
   }

   public void setCntMdlSvcSubmn( int cntMdlSvcSubmn )
   {
      this.cntMdlSvcSubmn = cntMdlSvcSubmn;
   }

   public Timestamp getDttmSubmnRqst()
   {
      return dttmSubmnRqst;
   }

   public void setDttmSubmnRqst( Timestamp dttmSubmnRqst )
   {
      this.dttmSubmnRqst = dttmSubmnRqst;
   }

   public String getIdApprslDocFile()
   {
      return idApprslDocFile;
   }

   public void setIdApprslDocFile( String idApprslDocFile )
   {
      this.idApprslDocFile = idApprslDocFile;
   }

   public String getIdApprslDocFileMtch()
   {
      return idApprslDocFileMtch;
   }

   public void setIdApprslDocFileMtch( String idApprslDocFileMtch )
   {
      this.idApprslDocFileMtch = idApprslDocFileMtch;
   }

   public String getIdCndtMtchRslt()
   {
      return idCndtMtchRslt;
   }

   public void setIdCndtMtchRslt( String idCndtMtchRslt )
   {
      this.idCndtMtchRslt = idCndtMtchRslt;
   }

   public Long getIdDcsnMtchSubmn()
   {
      return idDcsnMtchSubmn;
   }

   public void setIdDcsnMtchSubmn( Long idDcsnMtchSubmn )
   {
      this.idDcsnMtchSubmn = idDcsnMtchSubmn;
   }

   public String getIdDoc()
   {
      return idDoc;
   }

   public void setIdDoc( String idDoc )
   {
      this.idDoc = idDoc;
   }

   public String getIdFmLoan()
   {
      return idFmLoan;
   }

   public void setIdFmLoan( String idFmLoan )
   {
      this.idFmLoan = idFmLoan;
   }

   public String getIdLendrLoan()
   {
      return idLendrLoan;
   }

   public void setIdLendrLoan( String idLendrLoan )
   {
      this.idLendrLoan = idLendrLoan;
   }

   public String getIdLendrLoanMtch()
   {
      return idLendrLoanMtch;
   }

   public void setIdLendrLoanMtch( String idLendrLoanMtch )
   {
      this.idLendrLoanMtch = idLendrLoanMtch;
   }

   public String getIdLoanUwCase()
   {
      return idLoanUwCase;
   }

   public void setIdLoanUwCase( String idLoanUwCase )
   {
      this.idLoanUwCase = idLoanUwCase;
   }

   public String getIdLoanUwCaseMtch()
   {
      return idLoanUwCaseMtch;
   }

   public void setIdLoanUwCaseMtch( String idLoanUwCaseMtch )
   {
      this.idLoanUwCaseMtch = idLoanUwCaseMtch;
   }

   public String getIdMersMin()
   {
      
      return idMersMin;
   }

   public void setIdMersMin( String idMersMin )
   {
      this.idMersMin = idMersMin;
   }

   public String getIdMersMinMtch()
   {
      return idMersMinMtch;
   }

   public void setIdMersMinMtch( String idMersMinMtch )
   {
      this.idMersMinMtch = idMersMinMtch;
   }

   public String getIdModelRqst()
   {
      return idModelRqst;
   }

   public void setIdModelRqst( String idModelRqst )
   {
      this.idModelRqst = idModelRqst;
   }

   public String getIdMtchMdlVrsn()
   {
      return idMtchMdlVrsn;
   }

   public void setIdMtchMdlVrsn( String idMtchMdlVrsn )
   {
      this.idMtchMdlVrsn = idMtchMdlVrsn;
   }

   public String getIdPmlSrceSubmnTrans()
   {
      return idPmlSrceSubmnTrans;
   }

   public void setIdPmlSrceSubmnTrans( String idPmlSrceSubmnTrans )
   {
      this.idPmlSrceSubmnTrans = idPmlSrceSubmnTrans;
   }

   public String getIdPrty()
   {
      return idPrty;
   }

   public void setIdPrty( String idPrty )
   {
      this.idPrty = idPrty;
   }
   
   public String getIdPrtyMtch()
   {
      return idPrtyMtch;
   }

   public void setIdPrtyMtch( String idPrtyMtch )
   {
      this.idPrtyMtch = idPrtyMtch;
   }

   public String getIdSrceSubmn()
   {
      return idSrceSubmn;
   }

   public void setIdSrceSubmn( String idSrceSubmn )
   {
      this.idSrceSubmn = idSrceSubmn;
   }

   public String getIdPmlSubmnLink()
   {
      return idPmlSubmnLink;
   }

   public void setIdPmlSubmnLink( String idPmlSubmnLink )
   {
      this.idPmlSubmnLink = idPmlSubmnLink;
   }
      
   public String getIdPmlSubmnLinkOrigl()
   {
      return idPmlSubmnLinkOrigl;
   }

   public void setIdPmlSubmnLinkOrigl( String idPmlSubmnLinkOrigl )
   {
      this.idPmlSubmnLinkOrigl = idPmlSubmnLinkOrigl;
   }

   public String getIdSubmnRqst()
   {
      return idSubmnRqst;
   }

   public void setIdSubmnRqst( String idSubmnRqst )
   {
      this.idSubmnRqst = idSubmnRqst;
   }

   public String getIdValidtnRuleVrsn()
   {
      return idValidtnRuleVrsn;
   }

   public void setIdValidtnRuleVrsn( String idValidtnRuleVrsn )
   {
      this.idValidtnRuleVrsn = idValidtnRuleVrsn;
   }

   public String getIndMtchErr()
   {
      return indMtchErr;
   }

   public void setIndMtchErr( String indMtchErr )
   {
      this.indMtchErr = indMtchErr;
   }

   public String getIndRqstErr()
   {
      return indRqstErr;
   }

   public void setIndRqstErr( String indRqstErr )
   {
      this.indRqstErr = indRqstErr;
   }

   public String getIndSubmnErr()
   {
      return indSubmnErr;
   }

   public void setIndSubmnErr( String indSubmnErr )
   {
      this.indSubmnErr = indSubmnErr;
   }

   public String getNameAusType()
   {
      return nameAusType;
   }

   public void setNameAusType( String nameAusType )
   {
      this.nameAusType = nameAusType;
   }

   public String getNameAusTypeMtch()
   {
      return nameAusTypeMtch;
   }

   public void setNameAusTypeMtch( String nameAusTypeMtch )
   {
      this.nameAusTypeMtch = nameAusTypeMtch;
   }

   public String getNameCndtMtchType()
   {
      return nameCndtMtchType;
   }

   public void setNameCndtMtchType( String nameCndtMtchType )
   {
      this.nameCndtMtchType = nameCndtMtchType;
   }

   public String getNamePrtyRoleType()
   {
      return namePrtyRoleType;
   }

   public void setNamePrtyRoleType( String namePrtyRoleType )
   {
      this.namePrtyRoleType = namePrtyRoleType;
   }
   
   public String getNamePrtyRoleTypeMtch()
   {
      return namePrtyRoleTypeMtch;
   }

   public void setNamePrtyRoleTypeMtch( String namePrtyRoleTypeMtch )
   {
      this.namePrtyRoleTypeMtch = namePrtyRoleTypeMtch;
   }

   public String getNameSrceSyst()
   {
      return nameSrceSyst;
   }

   public void setNameSrceSyst( String nameSrceSyst )
   {
      this.nameSrceSyst = nameSrceSyst;
   }
   
   public String getNameSrceSystMtch()
   {
      return nameSrceSystMtch;
   }

   public void setNameSrceSystMtch( String nameSrceSystMtch )
   {
      this.nameSrceSystMtch = nameSrceSystMtch;
   }

   public String getNameSubmtngSystShort()
   {
      return nameSubmtngSystShort;
   }

   public void setNameSubmtngSystShort( String nameSubmtngSystShort )
   {
      this.nameSubmtngSystShort = nameSubmtngSystShort;
   }

   public String getNameStdzdPptyCityMtch()
   {
      return nameStdzdPptyCityMtch;
   }

   public void setNameStdzdPptyCityMtch( String nameStdzdPptyCityMtch )
   {
      this.nameStdzdPptyCityMtch = nameStdzdPptyCityMtch;
   }

   public String getTextStdzdPptyAddrLiMtch()
   {
      return textStdzdPptyAddrLiMtch;
   }

   public void setTextStdzdPptyAddrLiMtch( String textStdzdPptyAddrLiMtch )
   {
      this.textStdzdPptyAddrLiMtch = textStdzdPptyAddrLiMtch;
   }

   public String getTextStdzdPptyAddrLiCnctntd()
   {
      return textStdzdPptyAddrLiCnctntd;
   }

   public void setTextStdzdPptyAddrLiCnctntd( String textStdzdPptyAddrLiCnctntd )
   {
      this.textStdzdPptyAddrLiCnctntd = textStdzdPptyAddrLiCnctntd;
   }

   public Timestamp getDttmRqstPrcsgStart()
   {
      return dttmRqstPrcsgStart;
   }

   public Timestamp getDttmRqstPrcsgEnd()
   {
      return dttmRqstPrcsgEnd;
   }

   public void setDttmRqstPrcsgStart( Timestamp dttmRqstPrcsgStart )
   {
      this.dttmRqstPrcsgStart = dttmRqstPrcsgStart;
   }

   public void setDttmRqstPrcsgEnd( Timestamp dttmRqstPrcsgEnd )
   {
      this.dttmRqstPrcsgEnd = dttmRqstPrcsgEnd;
   }

   public Timestamp getDttmCreate()
   {
      return dttmCreate;
   }

   public void setDttmCreate( Timestamp dttmCreate )
   {
      this.dttmCreate = dttmCreate;
   }

   public Timestamp getDttmLstUpdt()
   {
      return dttmLstUpdt;
   }

   public void setDttmLstUpdt( Timestamp dttmLstUpdt )
   {
      this.dttmLstUpdt = dttmLstUpdt;
   }

   public String getIdCreate()
   {
      return idCreate;
   }

   public void setIdCreate( String idCreate )
   {
      this.idCreate = idCreate;
   }

   public String getIdLstUpdt()
   {
      return idLstUpdt;
   }

   public void setIdLstUpdt( String idLstUpdt )
   {
      this.idLstUpdt = idLstUpdt;
   }
   
   public String getNameStdzdPptyCity()
   {
      return nameStdzdPptyCity;
   }

   public void setNameStdzdPptyCity( String nameStdzdPptyCity )
   {
      this.nameStdzdPptyCity = nameStdzdPptyCity;
   }

   public String getTextStdzdPptyAddrLi()
   {
      return textStdzdPptyAddrLi;
   }

   public void setTextStdzdPptyAddrLi( String textStdzdPptyAddrLi )
   {
      this.textStdzdPptyAddrLi = textStdzdPptyAddrLi;
   }
   
   public String getStreetPrimeNumberText()
   {
      return streetPrimeNumberText;
   }

   public void setStreetPrimeNumberText( String streetPrimeNumberText )
   {
      this.streetPrimeNumberText = streetPrimeNumberText;
   }

   public FIPSStateAlphaCode getFipsStateAlphaCode()
   {
      return fipsStateAlphaCode;
   }

   public void setFipsStateAlphaCode( FIPSStateAlphaCode fipsStateAlphaCode )
   {
      this.fipsStateAlphaCode = fipsStateAlphaCode;
   }

   public String getPostalCode()
   {
      return postalCode;
   }

   public void setPostalCode( String postalCode )
   {
      this.postalCode = postalCode;
   }

   public String getPostalCodeMtch()
   {
      return postalCodeMtch;
   }

   public void setPostalCodeMtch( String postalCodeMtch )
   {
      this.postalCodeMtch = postalCodeMtch;
   }


}
