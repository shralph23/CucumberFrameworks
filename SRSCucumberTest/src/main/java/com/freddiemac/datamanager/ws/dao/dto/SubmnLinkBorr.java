package com.freddiemac.datamanager.ws.dao.dto;

import com.freddiemac.datamanager.ws.util.StringUtils;

public class SubmnLinkBorr {

   private String submissionLinkServiceIdentifier = "";
   private String taxpayerIdentificationNumber = "";

   public String getSubmissionLinkServiceIdentifier() {
      return submissionLinkServiceIdentifier;
   }

   public void setSubmissionLinkServiceIdentifier(String submissionLinkServiceIdentifier) {
      this.submissionLinkServiceIdentifier = submissionLinkServiceIdentifier.trim();
   }

   public String getTaxpayerIdentificationNumber() {
      return taxpayerIdentificationNumber;
   }

   public void setTaxpayerIdentificationNumber(String taxpayerIdentificationNumber) {
      this.taxpayerIdentificationNumber = taxpayerIdentificationNumber.trim();
   }

   @Override
   public String toString()
   {
      return "SubmnLinkBorr [submissionLinkServiceIdentifier=" + submissionLinkServiceIdentifier + ", taxpayerIdentificationNumber=" + taxpayerIdentificationNumber + "]";
   }
   
   public String toStringLog() {
      return "SubmnLinkBorr [submissionLinkServiceIdentifier=" + submissionLinkServiceIdentifier + ",  taxpayerIdentificationNumber="
                            + StringUtils.getMaskedString(taxpayerIdentificationNumber) + "]";
   }

}
