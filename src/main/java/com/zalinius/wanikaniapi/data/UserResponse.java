package com.zalinius.wanikaniapi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {
	private UserData data;
	
	public UserResponse() {
	}

	public UserData getData() {
		return data;
	}

	public void setData(UserData data) {
		this.data = data;
	}	

}
