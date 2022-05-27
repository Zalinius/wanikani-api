package com.zalinius.wanikaniapi.data.subject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReadingData {
	private String reading;
	private boolean primary;
	
	public ReadingData() {}

	public String getReading() {
		return reading;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}

	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
}
