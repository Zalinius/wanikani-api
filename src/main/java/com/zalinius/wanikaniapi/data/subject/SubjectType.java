package com.zalinius.wanikaniapi.data.subject;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SubjectType {
	@JsonProperty("radical")
	RADICAL,
	
	@JsonProperty("kanji")
	KANJI,
	
	@JsonProperty("vocabulary")
	VOCABULARY;
	
	
	@Override
	public String toString() {
		return this.name().toLowerCase();
	}
}
