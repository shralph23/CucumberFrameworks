package com.freddiemac.datamanager.ws.dao.dto;

public class SubmnLinkSvcHindsgt {
   
   private String idPmlSubmnLink = null;
   private String idPmlSubmnLinkPrr = null;
   private long idSubmn = 0;  
   private String idSubmnRqstID = null;     
   private long idSubmnLinkSvcHindsgtSgrt = 0;     // add for later publishing
   
   public SubmnLinkSvcHindsgt() {
      idPmlSubmnLink = null;
      idPmlSubmnLinkPrr = null;
      idSubmn = 0;     
      idSubmnRqstID = null;    
      idSubmnLinkSvcHindsgtSgrt = 0; 
   }

   public SubmnLinkSvcHindsgt( String idPmlSubmnLink, String idPmlSubmnLinkPrr, long idSubmn, String idSubmnRqstID ) {
      this.idPmlSubmnLink = idPmlSubmnLink;
      this.idPmlSubmnLinkPrr = idPmlSubmnLinkPrr;
      this.idSubmn = idSubmn;
      this.idSubmnRqstID = idSubmnRqstID;
   }

   public String getIdPmlSubmnLink()
   {
      return idPmlSubmnLink;
   }

   public String getIdPmlSubmnLinkPrr()
   {
      return idPmlSubmnLinkPrr;
   }

   public long getIdSubmn()
   {
      return idSubmn;
   }

   public String getIdSubmnRqstID()
   {
      return idSubmnRqstID;
   }

   public long getIdSubmnLinkSvcHindsgtSgrt()
   {
      return idSubmnLinkSvcHindsgtSgrt;
   }

   public void setIdPmlSubmnLink( String idPmlSubmnLink )
   {
      this.idPmlSubmnLink = idPmlSubmnLink;
   }

   public void setIdPmlSubmnLinkPrr( String idPmlSubmnLinkPrr )
   {
      this.idPmlSubmnLinkPrr = idPmlSubmnLinkPrr;
   }

   public void setIdSubmn( long idSubmn )
   {
      this.idSubmn = idSubmn;
   }

   public void setIdSubmnRqstID( String idSubmnRqstID )
   {
      this.idSubmnRqstID = idSubmnRqstID;
   }

   public void setIdSubmnLinkSvcHindsgtSgrt( long idSubmnLinkSvcHindsgtSgrt )
   {
      this.idSubmnLinkSvcHindsgtSgrt = idSubmnLinkSvcHindsgtSgrt;
   }

   @Override
   public String toString()
   {
      return "SubmnLinkSvcHindsgt [idPmlSubmnLink=" + idPmlSubmnLink + ", idPmlSubmnLinkPrr=" + idPmlSubmnLinkPrr + ", idSubmn=" + idSubmn + ", idSubmnRqstID=" + idSubmnRqstID
            + ", idSubmnLinkSvcHindsgtSgrt=" + idSubmnLinkSvcHindsgtSgrt + "]";
   }

}
