/**
 * 
 */
package com.freddiemac.datamanager.ws.srs.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.freddiemac.datamanager.ws.util.CollectionUtils;


@JsonPropertyOrder(
{ "RequestMetadata", "Submissions" } )
public class RequestType
{

   private RequestMetadataType requestMetadata;
   private List< SubmissionRequestType > submissions;

   @JsonGetter( "RequestMetadata" )
   public RequestMetadataType getRequestMetadata()
   {
      return requestMetadata;
   }

   @JsonSetter( "RequestMetadata" )
   public void setRequestMetadata( RequestMetadataType requestMetaData )
   {
      this.requestMetadata = requestMetaData;
   }

   @JsonGetter( "Submissions" )
   public List< SubmissionRequestType > getSubmissions()
   {
      return submissions;
   }

   @JsonSetter( "Submissions" )
   public void setSubmissions( List< SubmissionRequestType > submissions )
   {
      if( CollectionUtils.doesCollectionContainsValue( submissions ) )
         this.submissions = submissions;
      else
         this.submissions = new ArrayList<>();
   }

   @Override
   public String toString()
   {
      return "RequestType [requestMetadata=" + requestMetadata + ", submissions=" + submissions + "]";
   }
   
}
