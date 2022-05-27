package com.zalinius.wanikaniapi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignmentResponse {

	private AssignmentData data;
	
	
	public AssignmentResponse() {
	}
	

	public AssignmentData getData() {
		return data;
	}

	public void setData(AssignmentData data) {
		this.data = data;
	}
	
}
