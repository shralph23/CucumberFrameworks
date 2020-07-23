package com.freddiemac.datamanager.ws.srs.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;


@JsonPropertyOrder({"CorrelationIdentifier", "Attributes"})
public class SubmissionRequestType
{

   private String correlationIdentifier;
   private AttributesType attributes;

   @JsonGetter( "CorrelationIdentifier" )
   public String getCorrelationIdentifier()
   {
      return correlationIdentifier;
   }

   @JsonSetter( "CorrelationIdentifier" )
   public void setCorrelationIdentifier( String correlationIdentifier )
   {
      this.correlationIdentifier = correlationIdentifier;
   }

   @JsonGetter( "Attributes" )
   public AttributesType getAttributes()
   {
      return attributes;
   }

   @JsonSetter( "Attributes" )
   public void setAttributes( AttributesType attributes )
   {
      this.attributes = attributes;
   }

}
