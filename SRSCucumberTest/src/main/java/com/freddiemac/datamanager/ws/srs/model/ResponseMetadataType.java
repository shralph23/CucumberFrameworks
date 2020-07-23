package com.freddiemac.datamanager.ws.srs.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonPropertyOrder({"RequestIdentifier", "RequestSourceSystem", "SubmittingSourceSystem", "RequestTimeStamp", "RequestRecordCount"})
public class ResponseMetadataType {
   
   private String requestIdentifier;
   private String requestSourceSystem;
   private String submittingSourceSystem;
   private String requestTimeStamp;
   private int requestRecordCount;

   @JsonGetter( "RequestIdentifier" )
   public String getRequestIdentifier()
   {
      return requestIdentifier;
   }

   @JsonSetter( "RequestIdentifier" )
   public void setRequestIdentifier( String requestIdentifier )
   {
      this.requestIdentifier = requestIdentifier;
   }

   @JsonGetter( "RequestSourceSystem" )
   public String getRequestSourceSystem()
   {
      return requestSourceSystem;
   }

   @JsonSetter( "RequestSourceSystem" )
   public void setRequestSourceSystem( String requestSourceSystem )
   {
      this.requestSourceSystem = requestSourceSystem;
   }

   @JsonGetter( "SubmittingSourceSystem" )
   public String getSubmittingSourceSystem()
   {
      return submittingSourceSystem;
   }

   @JsonGetter( "SubmittingSourceSystem" )
   public void setSubmittingSourceSystem( String submittingSourceSystem )
   {
      this.submittingSourceSystem = submittingSourceSystem;
   }

   @JsonGetter( "RequestTimeStamp" )
   public String getRequestTimeStamp()
   {
      return requestTimeStamp;
   }

   @JsonSetter( "RequestTimeStamp" )
   public void setRequestTimeStamp( String requestTimeStamp )
   {
      this.requestTimeStamp = requestTimeStamp;
   }

   @JsonGetter( "RequestRecordCount" )
   public int getRequestRecordCount()
   {
      return requestRecordCount;
   }

   @JsonSetter( "RequestRecordCount" )
   public void setRequestRecordCount( int requestRecordCount )
   {
      this.requestRecordCount = requestRecordCount;
   }

}
