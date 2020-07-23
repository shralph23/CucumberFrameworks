package com.freddiemac.datamanager.ws.srs.enums;

/**
 * Enum for ActiveFlag which is optional parameter so you can have Y or N or default which is Both
 * 
 * @author f352017
 */
public enum AutomatedUnderwritingSystemTypeEnum {

   LOAN_PROSPECTOR( "LoanProspector" );

   private String automatedUnderwritingSystemType;

   private AutomatedUnderwritingSystemTypeEnum( String automatedUnderwritingSystemType )
   {
      this.automatedUnderwritingSystemType = automatedUnderwritingSystemType;
   }

   public String getAutomatedUnderwritingSystemType()
   {
      return automatedUnderwritingSystemType;
   }

}
