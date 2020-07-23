package com.freddiemac.datamanager.ws.dao.dto;

import java.sql.Timestamp;

public class PmlSubmnLink
{

   private String idPmlSubmnLink;
   
   private String idCreate;
   
   private String idLstUpdt;

   private Timestamp dttmLstUpdt;
   
   private Timestamp dttmCreate;

   public Timestamp getDttmLstUpdt()
   {
      return dttmLstUpdt;
   }

   public void setDttmLstUpdt( Timestamp dttmLstUpdt )
   {
      this.dttmLstUpdt = dttmLstUpdt;
   }

   public Timestamp getDttmCreate()
   {
      return dttmCreate;
   }

   public void setDttmCreate( Timestamp dttmCreate )
   {
      this.dttmCreate = dttmCreate;
   }

   public String getIdPmlSubmnLink()
   {
      return idPmlSubmnLink;
   }

   public void setIdPmlSubmnLink( String idPmlSubmnLink )
   {
      this.idPmlSubmnLink = idPmlSubmnLink;
   }

   public String getIdCreate()
   {
      return idCreate;
   }

   public void setIdCreate( String idCreate )
   {
      this.idCreate = idCreate;
   }

   public String getIdLstUpdt()
   {
      return idLstUpdt;
   }

   public void setIdLstUpdt( String idLstUpdt )
   {
      this.idLstUpdt = idLstUpdt;
   }

   @Override
   public String toString()
   {
      return "PmlSubmnLink [idPmlSubmnLink=" + idPmlSubmnLink + ", idCreate=" + idCreate + ", idLstUpdt=" + idLstUpdt + ", dttmLstUpdt=" + dttmLstUpdt + ", dttmCreate=" + dttmCreate + "]";
   }

 
   
}
