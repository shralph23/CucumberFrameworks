package com.freddiemac.datamanager.ws.request.setup;

import java.util.List;

import com.freddiemac.datamanager.ws.util.StringUtils;

import datageneration.generic.DataGeneratorUtils;


public class SRSScenario
{
   private String correlationIdentifier = DataGeneratorUtils.generateUniqueId();
   private String appraisalIdentifier;
   private String automatedUnderwritingSystemType;
   private String documentIdentifier;
   private String freddieMacLoanIdentifier;
   private String lenderLoanIdentifier;
   private String loanUnderwritingCaseIdentifier;
   private String mersminIdentifier;
   private String partyIdentifier;
   private String partyRoleType;
   private String addressLineText;
   private String cityName;
   private String fipsStateAlphaCode;
   private String postalCode;
   private String streetName;
   private String streetPrimaryNumberText;
   private String zipPlusFourCode;
   private String sourceSystemTransactionIdentifer;
   private List< String > taxpayerIdentificationNumbers;
   //To append to the variable so it's unique
   private String randomKey;
   private int scenarioID;
   private String submittingSourceSystem;
   private String requestSourceSystem;
   private String errorCode;
   private int recordCount = 1;

   public SRSScenario( int scenarioID, String randomKey )
   {
      this.scenarioID = scenarioID;
      this.randomKey = randomKey;
   }

   public SRSScenario()
   {

   }

   public int getScenarioID()
   {
      return scenarioID;
   }

   public void setScenarioID( int scenarioID )
   {
      this.scenarioID = scenarioID;
   }

   public String getCorrelationIdentifier()
   {
      return correlationIdentifier;
   }

   public void setCorrelationIdentifier( String correlationIdentifier )
   {
      this.correlationIdentifier = correlationIdentifier;
   }

   public String getAppraisalIdentifier()
   {
      return appraisalIdentifier;
   }

   public void setAppraisalIdentifier( String appraisalIdentifier )
   {
      this.appraisalIdentifier = appendRandomKey( appraisalIdentifier );
   }

   public String getAutomatedUnderwritingSystemType()
   {
      return automatedUnderwritingSystemType;
   }

   public void setAutomatedUnderwritingSystemType( String automatedUnderwritingSystemType )
   {
      this.automatedUnderwritingSystemType = automatedUnderwritingSystemType;
   }

   public String getDocumentIdentifier()
   {
      return documentIdentifier;
   }

   public void setDocumentIdentifier( String documentIdentifier )
   {
      this.documentIdentifier = documentIdentifier;
   }

   public String getFreddieMacLoanIdentifier()
   {
      return freddieMacLoanIdentifier;
   }

   public void setFreddieMacLoanIdentifier( String freddieMacLoanIdentifier )
   {
      this.freddieMacLoanIdentifier = freddieMacLoanIdentifier;
   }

   public String getLenderLoanIdentifier()
   {
      return lenderLoanIdentifier;
   }

   public void setLenderLoanIdentifier( String lenderLoanIdentifier )
   {
      this.lenderLoanIdentifier = appendRandomKey( lenderLoanIdentifier );
   }

   public String getLoanUnderwritingCaseIdentifier()
   {
      return loanUnderwritingCaseIdentifier;
   }

   public void setLoanUnderwritingCaseIdentifier( String loanUnderwritingCaseIdentifier )
   {
      this.loanUnderwritingCaseIdentifier = appendRandomKey( loanUnderwritingCaseIdentifier );
   }

   public String getMersminIdentifier()
   {
      return mersminIdentifier;
   }

   public void setMersminIdentifier( String mersminIdentifier )
   {
      this.mersminIdentifier = appendRandomKey( mersminIdentifier );
   }

   public String getPartyIdentifier()
   {
      return partyIdentifier;
   }

   public void setPartyIdentifier( String partyIdentifier )
   {
      this.partyIdentifier = appendRandomKey( partyIdentifier );
   }

   public void setStubbedPartyIdentifier( String partyIdentifier )
   {
      this.partyIdentifier = partyIdentifier;
   }

   public String getPartyRoleType()
   {
      return partyRoleType;
   }

   public void setPartyRoleType( String partyRoleType )
   {
      this.partyRoleType = partyRoleType;
   }

   public String getAddressLineText()
   {
      return addressLineText;
   }

   public void setAddressLineText( String addressLineText )
   {
      this.addressLineText = appendRandomKey( addressLineText );
   }

   public String getCityName()
   {
      return cityName;
   }

   public void setCityName( String cityName )
   {
      this.cityName = appendRandomKey( cityName );
   }

   public String getFipsStateAlphaCode()
   {
      return fipsStateAlphaCode;
   }

   public void setFipsStateAlphaCode( String fipsStateAlphaCode )
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

   public String getStreetName()
   {
      return streetName;
   }

   public void setStreetName( String streetName )
   {
      this.streetName = streetName;
   }

   public String getStreetPrimaryNumberText()
   {
      return streetPrimaryNumberText;
   }

   public void setStreetPrimaryNumberText( String streetPrimaryNumberText )
   {
      this.streetPrimaryNumberText = streetPrimaryNumberText;
   }

   public String getZipPlusFourCode()
   {
      return zipPlusFourCode;
   }

   public void setZipPlusFourCode( String zipPlusFourCode )
   {
      this.zipPlusFourCode = zipPlusFourCode;
   }

   public String getSourceSystemTransactionIdentifer()
   {
      return sourceSystemTransactionIdentifer;
   }

   public void setSourceSystemTransactionIdentifer( String sourceSystemTransactionIdentifer )
   {
      this.sourceSystemTransactionIdentifer = sourceSystemTransactionIdentifer;
   }

   public List< String > getTaxpayerIdentificationNumbers()
   {
      return taxpayerIdentificationNumbers;
   }

   public void setTaxpayerIdentificationNumbers( List< String > taxpayerIdentificationNumbers )
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

   public String getRandomKey()
   {
      return randomKey;
   }

   public void setRandomKey( String randomID )
   {
      this.randomKey = randomID;
   }

   public String getErrorCode()
   {
      return errorCode;
   }

   public void setErrorCode( String errorCode )
   {
      this.errorCode = errorCode;
   }

   //Append Random ID to the attributes
   public String appendRandomKey( String attribute )
   {
      String modifiedAttribute = null;
      if( attribute != null && !attribute.trim().equals( "" ) ) {
         if( attribute.contains( "." ) ) {
            modifiedAttribute = StringUtils.getTruncatedString( attribute, attribute.length() - 1 );
         }
         else {
            modifiedAttribute = attribute + getRandomKey();
         }
      }
      return modifiedAttribute;
   }

}
