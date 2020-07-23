package com.freddiemac.datamanager.ws.slms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder(
{ "requstIdentifier", "requstSourceSystem", "requstTimeStamp", "requstRecordCount" } )
public class SLSRequestMetaData
{
   private String requstIdentifier;
   private String requstSourceSystem;
   private String requstTimeStamp;
   private int requstRecordCount;

   public SLSRequestMetaData()
   {
      this.requstIdentifier = "";
      this.requstSourceSystem = "";
      this.requstTimeStamp = "";
      this.requstRecordCount = 0;
   }

   @JsonProperty( "SLSRequestIdentifier" )
   public String getRequstIdentifier()
   {
      return requstIdentifier;
   }

   @JsonProperty( "SLSRequestIdentifier" )
   public void setRequstIdentifier( String requstIdentifier )
   {
      this.requstIdentifier = requstIdentifier;
   }

   @JsonProperty( "SLSRequestSourceSystem" )
   public String getRequstSourceSystem()
   {
      return requstSourceSystem;
   }

   @JsonProperty( "SLSRequestSourceSystem" )
   public void setRequstSourceSystem( String requstSourceSystem )
   {
      this.requstSourceSystem = requstSourceSystem;
   }

   @JsonProperty( "SLSRequestTimestamp" )
   public String getRequstTimeStamp()
   {
      return requstTimeStamp;
   }

   @JsonProperty( "SLSRequestTimestamp" )
   public void setRequstTimeStamp( String requstTimeStamp )
   {
      this.requstTimeStamp = requstTimeStamp;
   }

   @JsonProperty( "SLSRequestRecordCount" )
   public int getRequstRecordCount()
   {
      return requstRecordCount;
   }

   @JsonProperty( "SLSRequestRecordCount" )
   public void setRequstRecordCount( int requstRecordCount )
   {
      this.requstRecordCount = requstRecordCount;
   }

}
