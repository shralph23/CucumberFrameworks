package com.freddiemac.datamanager.ws.request.setup;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.freddiemac.sls.SLSRequestType;

import datageneration.sls.EScenarioType;

public class SLSScenariosForBatch {

    private int id;
    private List<String> scenarioSetIds;
    private long idPmlSubmnMtchSgrt;
    private String slsid;
    private Map<Integer,String> randomKeyMap;
    private EScenarioType type;
    private List<String> docFileIds;
    private List<String> ausTypes;
    private List<String> ausIds;
    private List<String> fmLoanIds;
    private List<String> mersminids;
    private List<String> partyids;
    private List<String> partyRoleTypes;
    private List<String> lenderlnids;
    private List<String> ssnList;
    private List<String> addressLineTexts;
    private List<String> streetNames;
    private List<String> zipPlusFours;
    private List<String> cityNames;
    private List<String> stateCodes;
    private List<String> postalCodes;
    private String sourceSystems;
    private List<String> slsActions;
    private List<String> errorMessages;
    private String submnId;
    private String requestId;
    private List<String> correlationIdList;
    private String modelRequest;
    private String submittingSourceSystem;
    private boolean orphan;
    private boolean checkHindsight;
    private SLSRequestType slsRequest;
    private boolean handleEmptyFields;
    private int recordCount;
    private boolean slsInputRequestsExists;
    private boolean emptySLSInputRequests;
    private int slsInputRequestsCount;

    public SLSScenariosForBatch(int id, List<String> scenarioSetIds, Map<Integer,String> randomKeyMap, EScenarioType type, boolean orphan) {
       this.id = id;
       this.randomKeyMap = randomKeyMap;
       this.type = type;
       this.orphan = orphan;
       this.scenarioSetIds = scenarioSetIds;
       this.setCheckHindsight(false);
       this.setRecordCount(scenarioSetIds.size());
   }
        
    public SLSScenariosForBatch(){
       
    }

   public int getId()
   {
      return id;
   }

   public void setId( int id )
   {
      this.id = id;
   }

   public List< String > getScenarioSetIds()
   {
      return scenarioSetIds;
   }

   public void setScenarioSetIds( List< String > scenarioSetIds )
   {
      this.scenarioSetIds = scenarioSetIds;
   }

   public long getIdPmlSubmnMtchSgrt()
   {
      return idPmlSubmnMtchSgrt;
   }

   public void setIdPmlSubmnMtchSgrt( long idPmlSubmnMtchSgrt )
   {
      this.idPmlSubmnMtchSgrt = idPmlSubmnMtchSgrt;
   }

   public String getSlsid()
   {
      return slsid;
   }

   public void setSlsid( String slsid )
   {
      this.slsid = slsid;
   }
   
   public Map< Integer, String > getRandomKeyMap()
   {
      return randomKeyMap;
   }

   public void setRandomKeyMap( Map< Integer, String > randomKeyMap )
   {
      this.randomKeyMap = randomKeyMap;
   }

   public EScenarioType getType()
   {
      return type;
   }

   public void setType( EScenarioType type )
   {
      this.type = type;
   }

   public List< String > getDocFileIds()
   {
      return docFileIds;      
   }

   public void setDocFileIds( String docFileId )
   {
      this.docFileIds = Arrays.asList(docFileId.split(","));      
      for (int index = 0; index < docFileIds.size(); index++) {
         if(!docFileIds.get( index ).contains("-" )){
         docFileIds.set(index, docFileIds.get(index).concat(randomKeyMap.get(Integer.parseInt(scenarioSetIds.get(index)))));
         }else{
            docFileIds.set( index, "" );
         }
      }      
   }

   public List< String > getAusTypes()
   {
      return ausTypes;
   }

   public void setAusTypes( String ausType )
   {
      this.ausTypes = Arrays.asList(ausType.split(","));
      for (int index = 0; index < ausTypes.size(); index++) {
         if(!ausTypes.get( index ).contains("-" )){
            ausTypes.set(index, ausTypes.get(index));
         }else{
            ausTypes.set( index, "" );
         }
      }    
   }

   public List< String > getAusIds()
   {
      return ausIds;
   }

   public void setAusIds( String ausId )
   {
      this.ausIds = Arrays.asList(ausId.split(","));
      for (int index = 0; index < ausIds.size(); index++) {
         if(!ausIds.get( index ).contains("-" )){
            ausIds.set(index, ausIds.get(index).concat(randomKeyMap.get(Integer.parseInt(scenarioSetIds.get(index)))));
         }else{
            ausIds.set( index, "" );
         }
      }   
   }

   public List< String > getFmLoanIds()
   {
      return fmLoanIds;
   }

   public void setFmLoanIds( String fmLoanIds )
   {
      this.fmLoanIds = Arrays.asList(fmLoanIds.split(","));
      
   }

   public List< String > getMersminids()
   {
      return mersminids;
   }

   public void setMersminids( String mersminid )
   {
      this.mersminids = Arrays.asList(mersminid.split(","));
      for (int index = 0; index < mersminids.size(); index++) {
         if(!mersminids.get( index ).contains("-" )){
            mersminids.set(index, mersminids.get(index).concat(randomKeyMap.get(Integer.parseInt(scenarioSetIds.get(index)))));
         }else{
            mersminids.set( index, "" );
         }
      }   
   }

   public List< String > getPartyids()
   {
      return partyids;
   }

   public void setPartyids( String partyid )
   {
      this.partyids = Arrays.asList(partyid.split(","));
      for (int index = 0; index < partyids.size(); index++) {
         if(!partyids.get( index ).contains("-" )){
            if(partyids.get( index ).contains( "_" )){
            partyids.set(index, partyids.get(index).replace( "_", randomKeyMap.get(Integer.parseInt(scenarioSetIds.get(index)))) );
            }else{
               partyids.set( index, partyids.get( index ) );
            }
         }else{
            partyids.set( index, "" );
         }
      }   
   }

   public List< String > getPartyRoleTypes()
   {
      return partyRoleTypes;
   }

   public void setPartyRoleTypes( String partyRoleType )
   {
      this.partyRoleTypes = Arrays.asList(partyRoleType.split(","));
      for (int index = 0; index < partyRoleTypes.size(); index++) {
         if(!partyRoleTypes.get( index ).contains("-" )){
            partyRoleTypes.set(index, partyRoleTypes.get(index));
         }else{
            partyRoleTypes.set( index, "" );
         }
      }   
   }

   public List<String> getLenderlnids()
   {
      return lenderlnids;
   }

   public void setLenderlnids( String lenderlnid )
   {
      this.lenderlnids = Arrays.asList(lenderlnid.split(","));
      for (int index = 0; index < lenderlnids.size(); index++) {
         if(!lenderlnids.get( index ).contains("-" )){
            lenderlnids.set(index, lenderlnids.get(index).concat(randomKeyMap.get(Integer.parseInt(scenarioSetIds.get(index)))));
         }else{
            lenderlnids.set( index, "" );
         }
      }   
   }

   public List< String > getSsnList()
   {
      return ssnList;
   }

   public void setSsnList( String ssnLists )
   {
      this.ssnList = Arrays.asList(ssnLists.split(","));
      for (int index = 0; index < ssnList.size(); index++) {
         if(!ssnList.get( index ).contains("-" )){
            ssnList.set(index, ssnList.get(index));
         }else{
            ssnList.set( index, "" );
         }
      }   
   }

   public List< String > getAddressLineTexts()
   {
      return addressLineTexts;
   }

   public void setAddressLineTexts( String addressLineText )
   {
      this.addressLineTexts = Arrays.asList(addressLineText.split(","));
      for (int index = 0; index < addressLineTexts.size(); index++) {
         if(!addressLineTexts.get( index ).contains("-" )){
            addressLineTexts.set(index, addressLineTexts.get(index).concat(randomKeyMap.get(Integer.parseInt(scenarioSetIds.get(index)))));
         }else{
            addressLineTexts.set( index, "" );
         }
      }   
   }

   public List< String > getStreetNames()
   {
      return streetNames;
   }

   public void setStreetNames( String streetName )
   {
      this.streetNames = Arrays.asList(streetName.split(","));
      for (int index = 0; index < streetNames.size(); index++) {
         if(!streetNames.get( index ).contains("-" )){
            streetNames.set(index, streetNames.get(index));
         }else{
            streetNames.set( index, "" );
         }
      }   
   }

   public List< String > getZipPlusFours()
   {
      return zipPlusFours;
   }

   public void setZipPlusFours( String zipPlusFours )
   {
      this.zipPlusFours = Arrays.asList(zipPlusFours.split(","));
   }

   public List< String > getCityNames()
   {
      return cityNames;
   }

   public void setCityNames( String cityName )
   {
      this.cityNames = Arrays.asList(cityName.split(","));
      for (int index = 0; index < cityNames.size(); index++) {
         if(!cityNames.get( index ).contains("-" )){
            cityNames.set(index, cityNames.get(index).concat(randomKeyMap.get(Integer.parseInt(scenarioSetIds.get(index)))));
         }else{
            cityNames.set( index, "" );
         }
      }   
   }

   public List< String > getStateCodes()
   {
      return stateCodes;
   }

   public void setStateCodes( String stateCode )
   {
      this.stateCodes = Arrays.asList(stateCode.split(","));
      for (int index = 0; index < stateCodes.size(); index++) {
         if(!stateCodes.get( index ).contains("-" )){
            stateCodes.set(index, stateCodes.get(index));
         }else{
            stateCodes.set( index, "" );
         }
      }   
   }

   public List< String > getPostalCodes()
   {
      return postalCodes;
   }

   public void setPostalCodes( String postalCode )
   {
      this.postalCodes = Arrays.asList(postalCode.split(","));
      for (int index = 0; index < postalCodes.size(); index++) {
         if(!postalCodes.get( index ).contains("-" )){
            postalCodes.set(index, postalCodes.get(index));
         }else{
            postalCodes.set( index, "" );
         }
      }   
   }

   public String getSourceSystems()
   {
      return sourceSystems;
   }

   public void setSourceSystems( String sourceSystems )
   {
      this.sourceSystems = sourceSystems;
   }

   public List< String > getSlsActions()
   {
      return slsActions;
   }

   public void setSlsActions( String slsActions )
   {
      this.slsActions = Arrays.asList(slsActions.split(","));
   }

   public List< String > getErrorMessages()
   {
      return errorMessages;
   }

   public void setErrorMessages( String errorMessages )
   {
      this.errorMessages = Arrays.asList(errorMessages.split(","));
   }

   public String getSubmnId()
   {
      return submnId;
   }

   public void setSubmnId( String submnId )
   {
      this.submnId = submnId;
   }

   public String getRequestId()
   {
      return requestId;
   }

   public void setRequestId( String requestId )
   {
      this.requestId = requestId;
   }

   public List<String> getCorrelationIdList()
   {
      return correlationIdList;
   }

   public void setCorrelationIdList( List<String> correlationId )
   {
      this.correlationIdList = correlationId;
   }

   public String getModelRequest()
   {
      return modelRequest;
   }

   public void setModelRequest( String modelRequest )
   {
      this.modelRequest = modelRequest;
   }

   public String getSubmittingSourceSystem()
   {
      return submittingSourceSystem;
   }

   public void setSubmittingSourceSystem( String submittingSourceSystem )
   {
      this.submittingSourceSystem = submittingSourceSystem;
   }

   public boolean isOrphan()
   {
      return orphan;
   }

   public void setOrphan( boolean orphan )
   {
      this.orphan = orphan;
   }

   public boolean isCheckHindsight()
   {
      return checkHindsight;
   }

   public void setCheckHindsight( boolean checkHindsight )
   {
      this.checkHindsight = checkHindsight;
   }

   public SLSRequestType getSlsRequest()
   {
      return slsRequest;
   }

   public void setSlsRequest( SLSRequestType slsRequest )
   {
      this.slsRequest = slsRequest;
   }

   public boolean isHandleEmptyFields()
   {
      return handleEmptyFields;
   }

   public void setHandleEmptyFields( boolean handleEmptyFields )
   {
      this.handleEmptyFields = handleEmptyFields;
   }

   public int getRecordCount()
   {
      return recordCount;
   }

   public void setRecordCount( int recordCount )
   {
      this.recordCount = recordCount;
   }

   public boolean isSlsInputRequestsExists()
   {
      return slsInputRequestsExists;
   }

   public void setSlsInputRequestsExists( boolean slsInputRequestsExists )
   {
      this.slsInputRequestsExists = slsInputRequestsExists;
   }

   public boolean isEmptySLSInputRequests()
   {
      return emptySLSInputRequests;
   }

   public void setEmptySLSInputRequests( boolean emptySLSInputRequests )
   {
      this.emptySLSInputRequests = emptySLSInputRequests;
   }

   public int getSlsInputRequestsCount()
   {
      return slsInputRequestsCount;
   }

   public void setSlsInputRequestsCount( int slsInputRequestsCount )
   {
      this.slsInputRequestsCount = slsInputRequestsCount;
   }
   
}