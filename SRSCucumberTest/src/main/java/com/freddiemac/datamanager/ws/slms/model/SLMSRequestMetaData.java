package com.freddiemac.datamanager.ws.slms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder(
{ "slmsRequstIdentifier", "slmsRequstSourceSystem", "slmsRequstTimeStamp", "slmsRequstRecordCount" } )
public class SLMSRequestMetaData
{
   private String slmsRequstIdentifier;
   private String slmsRequstSourceSystem;
   private String slmsRequstTimeStamp;
   private int slmsRequstRecordCount;

   public SLMSRequestMetaData()
   {
      this.slmsRequstIdentifier = "";
      this.slmsRequstSourceSystem = "";
      this.slmsRequstTimeStamp = "";
      this.slmsRequstRecordCount = 0;
   }

   @JsonProperty( "SLMSRequestIdentifier" )
   public String getSLMSRequstIdentifier()
   {
      return slmsRequstIdentifier;
   }

   @JsonProperty( "SLMSRequestIdentifier" )
   public void setSLMSRequstIdentifier( String slmsRequstIdentifier )
   {
      this.slmsRequstIdentifier = slmsRequstIdentifier;
   }

   @JsonProperty( "SLMSRequestSourceSystem" )
   public String getSLMSRequstSourceSystem()
   {
      return slmsRequstSourceSystem;
   }

   @JsonProperty( "SLMSRequestSourceSystem" )
   public void setSLMSRequstSourceSystem( String slmsRequstSourceSystem )
   {
      this.slmsRequstSourceSystem = slmsRequstSourceSystem;
   }

   @JsonProperty( "SLMSRequestTimestamp" )
   public String getSLMSRequstTimeStamp()
   {
      return slmsRequstTimeStamp;
   }

   @JsonProperty( "SLMSRequestTimestamp" )
   public void setSLMSRequstTimeStamp( String slmsRequstTimeStamp )
   {
      this.slmsRequstTimeStamp = slmsRequstTimeStamp;
   }

   @JsonProperty( "SLMSRequestRecordCount" )
   public int getSLMSRequstRecordCount()
   {
      return slmsRequstRecordCount;
   }

   @JsonProperty( "SLMSRequestRecordCount" )
   public void setSLMSRequstRecordCount( int slmsRequstRecordCount )
   {
      this.slmsRequstRecordCount = slmsRequstRecordCount;
   }

}
