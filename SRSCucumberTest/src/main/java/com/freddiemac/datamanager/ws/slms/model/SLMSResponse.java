package com.freddiemac.datamanager.ws.slms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder(
{ "ModelVersion" } )
public class SLMSResponse
{

   private String modelVersion;

   @JsonProperty( "ModelVersion" )
   public String getModelVersion()
   {
      return modelVersion;
   }

   @JsonProperty( "ModelVersion" )
   public void setModelVersion( String modelVersion )
   {
      this.modelVersion = modelVersion;
   }
}
