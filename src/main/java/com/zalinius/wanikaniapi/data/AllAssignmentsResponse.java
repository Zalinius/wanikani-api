package com.zalinius.wanikaniapi.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllAssignmentsResponse {

	private List<AssignmentResponse> data;
	
	
	public AllAssignmentsResponse() {
	}
	

	public List<AssignmentResponse> getData() {
		return data;
	}

	public void setData(List<AssignmentResponse> data) {
		this.data = data;
	}
	
	
}
