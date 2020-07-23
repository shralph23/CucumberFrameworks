package com.freddiemac.datamanager.ws.srs.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonPropertyOrder({"CorrelationIdentifier", "SubmissionLinkServiceIdentifier", "RetrievalServiceResult", "MatchDetails", "ErrorDetails"})
public class SubmissionResponseType {

	private String correlationIdentifier;
	private String submissionLinkServiceIdentifier;
	private String retrievalServiceResult;
	private String errorDetails;

	@JsonGetter("CorrelationIdentifier")
	public String getCorrelationIdentifier() {
		return correlationIdentifier;
	}

	@JsonSetter("CorrelationIdentifier")
	public void setCorrelationIdentifier(String correlationIdentifier) {
		this.correlationIdentifier = correlationIdentifier;
	}

	@JsonGetter("SubmissionLinkServiceIdentifier")
	public String getSubmissionLinkServiceIdentifier() {
		return submissionLinkServiceIdentifier;
	}

	@JsonSetter("SubmissionLinkServiceIdentifier")
	public void setSubmissionLinkServiceIdentifier(String submissionLinkServiceIdentifier) {
		this.submissionLinkServiceIdentifier = submissionLinkServiceIdentifier;
	}

	@JsonGetter("RetrievalServiceResult")
	public String getRetrievalServiceResult() {
		return retrievalServiceResult;
	}

	@JsonSetter("RetrievalServiceResult")
	public void setRetrievalServiceResult(String retrievalServiceResult) {
		this.retrievalServiceResult = retrievalServiceResult;
	}

	@JsonGetter("ErrorDetails")
	public String getErrorDetails() {
		return errorDetails;
	}

	@JsonGetter("ErrorDetails")
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

}
