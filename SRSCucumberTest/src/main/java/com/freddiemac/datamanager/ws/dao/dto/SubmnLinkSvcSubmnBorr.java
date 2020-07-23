package com.freddiemac.datamanager.ws.dao.dto;

public class SubmnLinkSvcSubmnBorr
{

   // keys
   private long idSubmn = 0;

   // attributes
   private String taxpayerIdentificationNumber = null;

   
   public SubmnLinkSvcSubmnBorr()
   {
      this.idSubmn = 0;
      this.taxpayerIdentificationNumber = null;
   }
   
   
   public SubmnLinkSvcSubmnBorr( long idSubmn, String taxpayerIdentificationNumber )
   {
      this.idSubmn = idSubmn;
      this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
   }

   public long getIdSubmn() {
      return idSubmn;
   }

   public void setIdSubmn( long idSubmn ) {
      this.idSubmn = idSubmn;
   }

   public String getTaxpayerIdentificationNumber() {
      return taxpayerIdentificationNumber;
   }

   public void setTaxpayerIdentificationNumber( String taxpayerIdentificationNumber ) {
      this.taxpayerIdentificationNumber = taxpayerIdentificationNumber.trim();
   }

   @Override
   public String toString() {
      return "SubmnLinkSvcSubmnBorr [idSubmn=" + idSubmn + ", taxpayerIdentificationNumber=" + taxpayerIdentificationNumber + "]";
   }

   

}
