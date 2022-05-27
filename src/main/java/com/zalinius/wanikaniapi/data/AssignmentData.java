package com.zalinius.wanikaniapi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zalinius.wanikaniapi.data.subject.SubjectType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignmentData {
	
	@JsonProperty("subject_id")
	private int subjectId;
	
	@JsonProperty("subject_type")
	private SubjectType subjectType;
	
	@JsonProperty("srs_stage")
	private int srsStage;


	public AssignmentData() {
	}
	
	
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	
	public SubjectType getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}
	
	public int getSrsStage() {
		return srsStage;
	}

	public void setSrsStage(int srsStage) {
		this.srsStage = srsStage;
	}


	
}
