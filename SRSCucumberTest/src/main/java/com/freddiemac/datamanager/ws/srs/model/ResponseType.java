/**
 * 
 */
package com.freddiemac.datamanager.ws.srs.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;


@JsonPropertyOrder({"ResponseMetadata", "Submissions"})
public class ResponseType
{
   private ResponseMetadataType responseMetaData;
   private List<SubmissionResponseType> submissions;

   @JsonGetter( "ResponseMetadata" )
   public ResponseMetadataType getResponseMetadata()
   {
      return responseMetaData;
   }

   @JsonSetter( "ResponseMetadata" )
   public void setResponseMetadata( ResponseMetadataType responseMetaData )
   {
      this.responseMetaData = responseMetaData;
   }

   public void setResponseMetadata( RequestMetadataType requestMetaData )
   {      
      this.responseMetaData = new ResponseMetadataType();
      this.responseMetaData.setRequestIdentifier( requestMetaData.getRequestIdentifier() );
      this.responseMetaData.setRequestSourceSystem( requestMetaData.getRequestSourceSystem() );
      this.responseMetaData.setSubmittingSourceSystem( requestMetaData.getSubmittingSourceSystem() );
      this.responseMetaData.setRequestTimeStamp( requestMetaData.getRequestTimeStamp() );
      this.responseMetaData.setRequestRecordCount( requestMetaData.getRequestRecordCount() );
      
   }
   
   @JsonGetter( "Submissions" )
   public List<SubmissionResponseType> getSubmissions()
   {
      return submissions;
   }

   @JsonSetter( "Submissions" )
   public void setSubmissions( List<SubmissionResponseType> outputResponses )
   {
      this.submissions = outputResponses;
   }

}
