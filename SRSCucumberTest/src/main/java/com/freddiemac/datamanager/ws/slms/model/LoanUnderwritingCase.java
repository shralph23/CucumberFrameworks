package com.freddiemac.datamanager.ws.slms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder(
{ "automatedUnderwritingSystemType", "loanUnderwritingCaseIdentifier" } )
public class LoanUnderwritingCase
{

   private String automatedUnderwritingSystemType = "";
   private String loanUnderwritingCaseIdentifier = "";

   public LoanUnderwritingCase()
   {
      this.automatedUnderwritingSystemType = "";
      this.loanUnderwritingCaseIdentifier = "";
   }

   @JsonProperty( "AutomatedUnderwritingSystemType" )
   public String getAutomatedUnderwritingSystemType()
   {
      return automatedUnderwritingSystemType;
   }

   @JsonProperty( "AutomatedUnderwritingSystemType" )
   public void setAutomatedUnderwritingSystemType(
         String automatedUnderwritingSystemType )
   {
      this.automatedUnderwritingSystemType = automatedUnderwritingSystemType;
   }

   @JsonProperty( "LoanUnderwritingCaseIdentifier" )
   public String getLoanUnderwritingCaseIdentifier()
   {
      return loanUnderwritingCaseIdentifier;
   }

   @JsonProperty( "LoanUnderwritingCaseIdentifier" )
   public void setLoanUnderwritingCaseIdentifier(
         String loanUnderwritingCaseIdentifier )
   {
      this.loanUnderwritingCaseIdentifier = loanUnderwritingCaseIdentifier;
   }

   @Override
   public String toString()
   {
      return "LoanUnderwritingCaseVO [automatedUnderwritingSystemType=" + automatedUnderwritingSystemType + ", loanUnderwritingCaseIdentifier=" + loanUnderwritingCaseIdentifier + "]";
   }

}
