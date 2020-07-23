package com.freddiemac.datamanager.ws.slms.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder(
{ "SurrogateKey", "SLSRequestSourceSystem", "SubmissionLinkIdentifier", "AppraiserFileIdentifier", "LoanUnderwritingCase", "MERSMINIdentifier", "PartyRole", "LenderLoanIdentifier", "PropertyAddress",
      "SSNs", "CreateDateTime", "LastUpdateDateTime", "SubmissionRequestDateTime" } )
public class SLSPossibleMatches
{
   private String surrogateKey;
   private String submissionLinkIdentifier = "";
   private String appraisalIdentifier = "";
   private LoanUnderwritingCase loanUnderwritingCase;
   private String MERSMINIdentifier = "";
   private PartyRole partyRole;
   private String lenderLoanIdentifier = "";
   private PropertyAddress propertyAddress;
   private List< String > sSNs;
   private String createDateTime;
   private String lastUpdateDateTime;
   private String submissionRequestDateTime;
   private String slsRequestSourceSystem = "";

   @JsonProperty( "SurrogateKey" )
   public String getSurrogateKey()
   {
      return surrogateKey;
   }

   public void setSurrogateKey( String surrogateKey )
   {
      this.surrogateKey = surrogateKey;
   }

   @JsonProperty( "SubmissionLinkIdentifier" )
   public String getSubmissionLinkIdentifier()
   {
      return submissionLinkIdentifier;
   }

   public void setSubmissionLinkIdentifier( String submissionLinkIdentifier )
   {
      this.submissionLinkIdentifier = submissionLinkIdentifier;
   }

   @JsonProperty( "AppraiserFileIdentifier" )
   public String getAppraisalIdentifier()
   {
      return appraisalIdentifier;
   }

   public void setAppraisalIdentifier( String appraisalIdentifier )
   {
      this.appraisalIdentifier = appraisalIdentifier;
   }

   @JsonProperty( "LoanUnderwritingCase" )
   public LoanUnderwritingCase getLoanUnderwritingCase()
   {
      return loanUnderwritingCase;
   }

   public void setLoanUnderwritingCase( LoanUnderwritingCase loanUnderwritingCase )
   {
      this.loanUnderwritingCase = loanUnderwritingCase;
   }

   @JsonProperty( "MERSMINIdentifier" )
   public String getMERSMINIdentifier()
   {
      return MERSMINIdentifier;
   }

   public void setMERSMINIdentifier( String mERSMINIdentifier )
   {
      MERSMINIdentifier = mERSMINIdentifier;
   }

   @JsonProperty( "PartyRole" )
   public PartyRole getPartyRole()
   {
      return partyRole;
   }

   public void setPartyRole( PartyRole partyRole )
   {
      this.partyRole = partyRole;
   }

   @JsonProperty( "LenderLoanIdentifier" )
   public String getLenderLoanIdentifier()
   {
      return lenderLoanIdentifier;
   }

   public void setLenderLoanIdentifier( String lenderLoanIdentifier )
   {
      this.lenderLoanIdentifier = lenderLoanIdentifier;
   }

   @JsonProperty( "PropertyAddress" )
   public PropertyAddress getPropertyAddress()
   {
      return propertyAddress;
   }

   public void setPropertyAddress( PropertyAddress propertyAddress )
   {
      this.propertyAddress = propertyAddress;
   }

   @JsonProperty( "SSNs" )
   public List< String > getSSNs()
   {
      return sSNs;
   }

   public void setSSNs( List< String > sSNs )
   {
      this.sSNs = sSNs;
   }

   @JsonProperty( "CreateDateTime" )
   public String getCreateDateTime()
   {
      return createDateTime;
   }

   public void setCreateDateTime( String createDateTime )
   {
      this.createDateTime = createDateTime;
   }

   @JsonProperty( "LastUpdateDateTime" )
   public String getLastUpdateDateTime()
   {
      return lastUpdateDateTime;
   }

   public void setLastUpdateDateTime( String lastUpdateDateTime )
   {
      this.lastUpdateDateTime = lastUpdateDateTime;
   }

   @JsonProperty( "SubmissionRequestDateTime" )
   public String getSubmissionRequestDateTime()
   {
      return submissionRequestDateTime;
   }

   public void setSubmissionRequestDateTime( String submissionRequestDateTime )
   {
      this.submissionRequestDateTime = submissionRequestDateTime;
   }

   @JsonProperty( "SLSRequestSourceSystem" )
   public String getSlsRequestSourceSystem()
   {
      return slsRequestSourceSystem;
   }

   public void setSlsRequestSourceSystem( String slsRequestSourceSystem )
   {
      this.slsRequestSourceSystem = slsRequestSourceSystem;
   }
}
