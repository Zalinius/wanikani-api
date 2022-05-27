package com.zalinius.wanikaniapi.data.subject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectResponse {
	
	private int id;

	@JsonProperty("object")
	private SubjectType subjectType;

	@JsonProperty("data")
	private SubjectData subjectData;
	
	public SubjectResponse() {
	}	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SubjectType getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}

	public SubjectData getSubjectData() {
		return subjectData;
	}

	public void setSubjectData(SubjectData subjectData) {
		this.subjectData = subjectData;
	}

}
