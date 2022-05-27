package com.zalinius.wanikaniapi.data.subject;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zalinius.wanikaniapi.data.PaginationData;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllSubjectsResponse {
	
	@JsonProperty("data")
	private List<SubjectResponse> subjectResponses;
	
	private PaginationData pages;
	
	public AllSubjectsResponse() {
	}

	public List<SubjectResponse> getSubjectResponses() {
		return subjectResponses;
	}

	public void setSubjectResponses(List<SubjectResponse> subjectResponses) {
		this.subjectResponses = subjectResponses;
	}

	public PaginationData getPages() {
		return pages;
	}

	public void setPages(PaginationData pages) {
		this.pages = pages;
	}

	
	
}
