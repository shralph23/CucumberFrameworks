package com.freddiemac.datamanager.ws.srs.enums;

/**
 * 
 * Enum for type of matching done
 * 
 * @author f352017
 *
 */
public enum MatchTypeEnum {

   UNKNOWN,
   APPRAISAL_IDENTIFIER,
   AUTOMATED_UNDERWRITING_SYSTEM_TYPE_AND_LOAN_UNDERWRITING_CASE_IDENTIFIER,
   LOAN_UNDERWRITING_CASE_IDENTIFIER,
   AUTOMATED_UNDERWRITING_SYSTEM_TYPE,
   MERSMIN_IDENTIFIER,
   PARTY_IDENTIFIER_AND_LENDER_LOAN_IDENTIFIER,
   STUBBED_PARTNER;

   public String value() {
      return name();
   }
   
   public static MatchTypeEnum fromValue(String v) {
      return valueOf(v);
   }
   
}
