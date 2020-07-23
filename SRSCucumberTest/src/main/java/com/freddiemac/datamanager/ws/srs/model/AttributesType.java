package com.freddiemac.datamanager.ws.srs.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.freddiemac.datamanager.ws.util.CollectionUtils;



@JsonPropertyOrder(
{ "MersminIdentifier", "AutomatedUnderwritingSystemType", "LoanUnderwritingCaseIdentifier", "AppraisalIdentifier", "PartyIdentifier",
      "PartyRoleType", "LenderLoanIdentifier", "DocumentIdentifier", "SourceSystemTransactionIdentifer", "FreddieMacLoanIdentifier",
      "PropertyAddress", "TaxpayerIdentificationNumbers" } )
public class AttributesType
{

   private String mersminIdentifier;
   private String automatedUnderwritingSystemType;
   private String loanUnderwritingCaseIdentifier;
   private String appraisalIdentifier;
   private String partyIdentifier;
   private String partyRoleType;
   private String lenderLoanIdentifier;
   private String documentIdentifier;
   private String sourceSystemTransactionIdentifer;
   private String freddieMacLoanIdentifier;
   private AddressType propertyAddress;
   private List< String > taxpayerIdentificationNumbers;

   @JsonGetter( "MersminIdentifier" )
   public String getMersminIdentifier()
   {
      return mersminIdentifier;
   }

   @JsonSetter( "MersminIdentifier" )
   public void setMersminIdentifier( String mersminIdentifier )
   {
      this.mersminIdentifier = mersminIdentifier;
   }

   @JsonGetter( "AutomatedUnderwritingSystemType" )
   public String getAutomatedUnderwritingSystemType()
   {
      return automatedUnderwritingSystemType;
   }

   @JsonSetter( "AutomatedUnderwritingSystemType" )
   public void setAutomatedUnderwritingSystemType( String automatedUnderwritingSystemType )
   {
      this.automatedUnderwritingSystemType = automatedUnderwritingSystemType;
   }

   @JsonGetter( "LoanUnderwritingCaseIdentifier" )
   public String getLoanUnderwritingCaseIdentifier()
   {
      return loanUnderwritingCaseIdentifier;
   }

   @JsonSetter( "LoanUnderwritingCaseIdentifier" )
   public void setLoanUnderwritingCaseIdentifier( String loanUnderwritingCaseIdentifier )
   {
      this.loanUnderwritingCaseIdentifier = loanUnderwritingCaseIdentifier;
   }

   @JsonGetter( "AppraisalIdentifier" )
   public String getAppraisalIdentifier()
   {
      return appraisalIdentifier;
   }

   @JsonSetter( "AppraisalIdentifier" )
   public void setAppraisalIdentifier( String appraisalIdentifier )
   {
      this.appraisalIdentifier = appraisalIdentifier;
   }

   @JsonGetter( "PartyIdentifier" )
   public String getPartyIdentifier()
   {
      return partyIdentifier;
   }

   @JsonSetter( "PartyIdentifier" )
   public void setPartyIdentifier( String partyIdentifier )
   {
      this.partyIdentifier = partyIdentifier;
   }

   @JsonGetter( "PartyRoleType" )
   public String getPartyRoleType()
   {
      return partyRoleType;
   }

   @JsonSetter( "PartyRoleType" )
   public void setPartyRoleType( String partyRoleType )
   {
      this.partyRoleType = partyRoleType;
   }

   @JsonGetter( "LenderLoanIdentifier" )
   public String getLenderLoanIdentifier()
   {
      return lenderLoanIdentifier;
   }

   @JsonSetter( "LenderLoanIdentifier" )
   public void setLenderLoanIdentifier( String lenderLoanIdentifier )
   {
      this.lenderLoanIdentifier = lenderLoanIdentifier;
   }

   @JsonGetter( "DocumentIdentifier" )
   public String getDocumentIdentifier()
   {
      return documentIdentifier;
   }

   @JsonSetter( "DocumentIdentifier" )
   public void setDocumentIdentifier( String documentIdentifier )
   {
      this.documentIdentifier = documentIdentifier;
   }

   @JsonGetter( "SourceSystemTransactionIdentifer" )
   public String getSourceSystemTransactionIdentifer()
   {
      return sourceSystemTransactionIdentifer;
   }

   @JsonSetter( "SourceSystemTransactionIdentifer" )
   public void setSourceSystemTransactionIdentifer( String sourceSystemTransactionIdentifer )
   {
      this.sourceSystemTransactionIdentifer = sourceSystemTransactionIdentifer;
   }

   @JsonGetter( "FreddieMacLoanIdentifier" )
   public String getFreddieMacLoanIdentifier()
   {
      return freddieMacLoanIdentifier;
   }

   @JsonSetter( "FreddieMacLoanIdentifier" )
   public void setFreddieMacLoanIdentifier( String freddieMacLoanIdentifier )
   {
      this.freddieMacLoanIdentifier = freddieMacLoanIdentifier;
   }

   @JsonGetter( "PropertyAddress" )
   public AddressType getPropertyAddress()
   {
      return propertyAddress;
   }

   @JsonSetter( "PropertyAddress" )
   public void setPropertyAddress( AddressType propertyAddress )
   {
      this.propertyAddress = propertyAddress;
   }

   @JsonGetter( "TaxpayerIdentificationNumbers" )
   public List< String > getTaxpayerIdentificationNumbers()
   {
      return taxpayerIdentificationNumbers;
   }

   @JsonSetter( "TaxpayerIdentificationNumbers" )
   public void setTaxpayerIdentificationNumbers( List< String > taxpayerIdentificationNumbers )
   {
      if( CollectionUtils.doesCollectionContainsValue( taxpayerIdentificationNumbers ) )
         this.taxpayerIdentificationNumbers = taxpayerIdentificationNumbers;
      else
         this.taxpayerIdentificationNumbers = new ArrayList<>();
   }

}
