package com.freddiemac.datamanager.ws.request.setup;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.freddiemac.datamanager.ws.constants.SRSConstants;

public class SRSScenariosForBatch
{
   private List< String > correlationIdentifier;
   private List< String > appraisalIdentifiers;
   private List< String > automatedUnderwritingSystemType;
   private List< String > documentIdentifier;
   private List< String > freddieMacLoanIdentifier;
   private List< String > lenderLoanIdentifier;
   private List< String > loanUnderwritingCaseIdentifier;
   private List< String > mersminIdentifier;
   private List< String > partyIdentifier;
   private List< String > partyRoleType;
   private List< String > addressLineText;
   private List< String > cityName;
   private List< String > fipsStateAlphaCode;
   private List< String > postalCode;
   private List< String > streetName;
   private List< String > streetPrimaryNumberText;
   private List< String > zipPlusFourCode;
   private List< String > sourceSystemTransactionIdentifer;
   private List< String > taxpayerIdentificationNumbers;
   //To append to the variable so it's unique
   private Map< Integer, String > randomKeyMap;
   private List< String > scenarioIDs;
   private String submittingSourceSystem;
   private String requestSourceSystem;
   private int recordCount;

   public SRSScenariosForBatch()
   {
   }

   public SRSScenariosForBatch( List< String > scenarioIds, Map< Integer, String > randomKeyMap )
   {
      this.randomKeyMap = randomKeyMap;
      this.scenarioIDs = scenarioIds;
      this.setRecordCount( scenarioIds.size() );
   }

   public List< String > getCorrelationIdentifier()
   {
      return correlationIdentifier;
   }

   public void setCorrelationIdentifier( List< String > correlationIdentifier )
   {
      this.correlationIdentifier = correlationIdentifier;
   }

   public List< String > getAppraisalIdentifier()
   {
      return appraisalIdentifiers;
   }

   public void setAppraisalIdentifier( String appraisalIdentifier )
   {
      //      this.appraisalIdentifiers = Arrays.asList( appraisalIdentifier.split(",") ) ;
      //      for (int index = 0; index < appraisalIdentifiers.size(); index++) {
      //         if(!appraisalIdentifiers.get( index ).contains("-" )){
      //            appraisalIdentifiers.set(index, appraisalIdentifiers.get(index).concat(randomKeyMap.get(Integer.parseInt(scenarioIDs.get(index)))));
      //         }else{
      //            appraisalIdentifiers.set( index, "" );
      //         }
      //      }    
      this.appraisalIdentifiers = processListsWithRandomId( appraisalIdentifier );
   }

   public List< String > getAutomatedUnderwritingSystemType()
   {
      return automatedUnderwritingSystemType;
   }

   public void setAutomatedUnderwritingSystemType( String automatedUnderwritingSystemType )
   {
      this.automatedUnderwritingSystemType = Arrays.asList( automatedUnderwritingSystemType.split(",") );
   }

   public List< String > getDocumentIdentifier()
   {
      return documentIdentifier;
   }

   public void setDocumentIdentifier( String documentIdentifier )
   {
      this.documentIdentifier = processListsWithRandomId(documentIdentifier);
   }

   public List< String > getFreddieMacLoanIdentifier()
   {
      return freddieMacLoanIdentifier;
   }

   public void setFreddieMacLoanIdentifier( String freddieMacLoanIdentifier )
   {
      this.freddieMacLoanIdentifier = processListsWithRandomId(freddieMacLoanIdentifier);
   }

   public List< String > getLenderLoanIdentifier()
   {
      return lenderLoanIdentifier;
   }

   public void setLenderLoanIdentifier( String lenderLoanIdentifier )
   {
      this.lenderLoanIdentifier = processListsWithRandomId(lenderLoanIdentifier);
   }

   public List< String > getLoanUnderwritingCaseIdentifier()
   {
      return loanUnderwritingCaseIdentifier;
   }

   public void setLoanUnderwritingCaseIdentifier( String loanUnderwritingCaseIdentifier )
   {
      this.loanUnderwritingCaseIdentifier = processListsWithRandomId(loanUnderwritingCaseIdentifier);
   }

   public List< String > getMersminIdentifier()
   {
      return mersminIdentifier;
   }

   public void setMersminIdentifier( String mersminIdentifier )
   {
      this.mersminIdentifier = processListsWithRandomId(mersminIdentifier);
   }

   public List< String > getPartyIdentifier()
   {
      return partyIdentifier;
   }

   public void setPartyIdentifier( String partyIdentifier )
   {
      this.partyIdentifier = processListsWithRandomId(partyIdentifier);
   }

   public List< String > getPartyRoleType()
   {
      return partyRoleType;
   }

   public void setPartyRoleType( String partyRoleType )
   {
      this.partyRoleType = Arrays.asList( partyRoleType.split(",") );
   }

   public List< String > getAddressLineText()
   {
      return addressLineText;
   }

   public void setAddressLineText( String addressLineText )
   {
      this.addressLineText = processListsWithRandomId(addressLineText);
   }

   public List< String > getCityName()
   {
      return cityName;
   }

   public void setCityName( String cityName )
   {
      this.cityName = Arrays.asList( cityName.split(",") );
   }

   public List< String > getFipsStateAlphaCode()
   {
      return fipsStateAlphaCode;
   }

   public void setFipsStateAlphaCode( String fipsStateAlphaCode )
   {
      this.fipsStateAlphaCode = Arrays.asList( fipsStateAlphaCode.split(",") );
   }

   public List< String > getPostalCode()
   {
      return postalCode;
   }

   public void setPostalCode( String postalCode )
   {
      this.postalCode = Arrays.asList( postalCode.split(",") );
   }

   public List< String > getStreetName()
   {
      return streetName;
   }

   public void setStreetName(String streetName )
   {
      this.streetName = Arrays.asList( streetName.split(",") );
   }

   public List< String > getStreetPrimaryNumberText()
   {
      return streetPrimaryNumberText;
   }

   public void setStreetPrimaryNumberText( String streetPrimaryNumberText )
   {
      this.streetPrimaryNumberText = Arrays.asList( streetPrimaryNumberText.split(",") );
   }

   public List< String > getZipPlusFourCode()
   {
      return zipPlusFourCode;
   }

   public void setZipPlusFourCode( String zipPlusFourCode )
   {
      this.zipPlusFourCode = Arrays.asList( zipPlusFourCode.split(",") );
   }

   public List< String > getSourceSystemTransactionIdentifer()
   {
      return sourceSystemTransactionIdentifer;
   }

   public void setSourceSystemTransactionIdentifer( String sourceSystemTransactionIdentifer )
   {
      this.sourceSystemTransactionIdentifer = Arrays.asList( sourceSystemTransactionIdentifer.split(",") );
   }

   public List< String > getTaxpayerIdentificationNumbers()
   {
      return taxpayerIdentificationNumbers;
   }

   public void setTaxpayerIdentificationNumbers( List<String> taxpayerIdentificationNumbers )
   {
      this.taxpayerIdentificationNumbers = taxpayerIdentificationNumbers;
   }

   public String getSubmittingSourceSystem()
   {
      return submittingSourceSystem;
   }

   public void setSubmittingSourceSystem( String submittingSourceSystem )
   {
      this.submittingSourceSystem = submittingSourceSystem;
   }

   public String getRequestSourceSystem()
   {
      return requestSourceSystem;
   }

   public void setRequestSourceSystem( String requestSourceSystem )
   {
      this.requestSourceSystem = requestSourceSystem;
   }

   public int getRecordCount()
   {
      return recordCount;
   }

   public void setRecordCount( int recordCount )
   {
      this.recordCount = recordCount;
   }

   public Map< Integer, String > getRandomKeyMap()
   {
      return randomKeyMap;
   }

   public void setRandomKeyMap( Map< Integer, String > randomKeyMap )
   {
      this.randomKeyMap = randomKeyMap;
   }

   public List< String > getScenarioIDs()
   {
      return scenarioIDs;
   }

   public void setScenarioIDs( List< String > scenarioIDs )
   {
      this.scenarioIDs = scenarioIDs;
   }

   public List< String > processListsWithRandomId( String appendRandomId )
   {
      List< String > appendRandomIdList = Arrays.asList( appendRandomId.split( "," ) );
      for( int index = 0; index < appendRandomIdList.size(); index++ ) {
         if( !appendRandomIdList.get( index ).contains( "-" ) ) {
            appendRandomIdList.set( index, appendRandomIdList.get( index ).concat( randomKeyMap.get( Integer.parseInt( scenarioIDs.get( index ) ) ) ) );
         }else if(appendRandomIdList.get( index ).contains( "000601" )){
            appendRandomIdList.set( index, "000601" );
         }
         else {
            appendRandomIdList.set( index, SRSConstants.EMPTY_STRING );
         }
      }
      return appendRandomIdList;
   }
}
