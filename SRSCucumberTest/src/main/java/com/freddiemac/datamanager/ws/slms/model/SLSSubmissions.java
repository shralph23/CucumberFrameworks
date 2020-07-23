package com.freddiemac.datamanager.ws.slms.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder(
{ "correlationIdentifier", "appraisalIdentifier", "loanUnderwritingCase", "MERSMINIdentifier", "partyRole", "propertyAddress", "sSNs", "surrogateKeys" } )
public class SLSSubmissions
{
   private String correlationIdentifier = "";
   private String appraisalIdentifier = "";
   private LoanUnderwritingCase loanUnderwritingCase;
   private String MERSMINIdentifier = "";
   private PartyRole partyRole;
   private String lenderLoanIdentifier = "";
   private PropertyAddress propertyAddress;
   private List< String > sSNs;
   private ArrayList< String > surrogateKeys = new ArrayList< String >();

   public SLSSubmissions()
   {
      this.correlationIdentifier = "";
      this.appraisalIdentifier = "";
      this.loanUnderwritingCase = new LoanUnderwritingCase();
      MERSMINIdentifier = "";
      this.partyRole = new PartyRole();
      this.lenderLoanIdentifier = "";
      this.propertyAddress = new PropertyAddress();
      this.sSNs = new ArrayList< String >();
      this.surrogateKeys = new ArrayList< String >();
   }

   @JsonProperty( "CorrelationIdentifier" )
   public String getCorrelationIdentifier()
   {
      return correlationIdentifier;
   }

   @JsonProperty( "CorrelationIdentifier" )
   public void setCorrelationIdentifier( String correlationIdentifier )
   {
      this.correlationIdentifier = correlationIdentifier;
   }

   @JsonProperty( "AppraiserFileIdentifier" )
   public String getAppraisalIdentifier()
   {
      return appraisalIdentifier;
   }

   @JsonProperty( "AppraiserFileIdentifier" )
   public void setAppraisalIdentifier( String appraisalIdentifier )
   {
      this.appraisalIdentifier = appraisalIdentifier;
   }

   @JsonProperty( "LoanUnderwritingCase" )
   public LoanUnderwritingCase getLoanUnderwritingCase()
   {
      return loanUnderwritingCase;
   }

   @JsonProperty( "LoanUnderwritingCase" )
   public void setLoanUnderwritingCase( LoanUnderwritingCase loanUnderwritingCase )
   {
      this.loanUnderwritingCase = loanUnderwritingCase;
   }

   @JsonProperty( "MERSMINIdentifier" )
   public String getMERSMINIdentifier()
   {
      return MERSMINIdentifier;
   }

   @JsonProperty( "MERSMINIdentifier" )
   public void setMERSMINIdentifier( String mERSMINIdentifier )
   {
      MERSMINIdentifier = mERSMINIdentifier;
   }

   @JsonProperty( "PartyRole" )
   public PartyRole getPartyRole()
   {
      return partyRole;
   }

   @JsonProperty( "PartyRole" )
   public void setPartyRole( PartyRole partyRole )
   {
      this.partyRole = partyRole;
   }

   @JsonProperty( "LenderLoanIdentifier" )
   public String getLenderLoanIdentifier()
   {
      return lenderLoanIdentifier;
   }

   @JsonProperty( "LenderLoanIdentifier" )
   public void setLenderLoanIdentifier( String lenderLoanIdentifier )
   {
      this.lenderLoanIdentifier = lenderLoanIdentifier;
   }

   @JsonProperty( "PropertyAddress" )
   public PropertyAddress getPropertyAddress()
   {
      return propertyAddress;
   }

   @JsonProperty( "PropertyAddress" )
   public void setPropertyAddress( PropertyAddress propertyAddress )
   {
      this.propertyAddress = propertyAddress;
   }

   @JsonProperty( "SSNs" )
   public List< String > getSSNs()
   {
      if( sSNs == null ) {
         return new ArrayList< String >();
      }
      else {
         return sSNs;
      }
   }

   @JsonProperty( "SSNs" )
   public void setSSNs( List< String > sSNs )
   {
      this.sSNs = sSNs;
   }

   @JsonProperty( "SurrogateKeys" )
   public ArrayList< String > getSurrogateKeys()
   {
      return surrogateKeys;
   }

   @JsonProperty( "SurrogateKeys" )
   public void setSurrogateKeys( ArrayList< Long > surrogateKeys )
   {
      this.surrogateKeys = new ArrayList< String >();
      for( Long surrogateKey : surrogateKeys ) {
         this.surrogateKeys.add( Long.toString( surrogateKey ) );
      }
   }

}
