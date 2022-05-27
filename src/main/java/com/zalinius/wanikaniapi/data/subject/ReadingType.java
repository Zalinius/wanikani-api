package com.zalinius.wanikaniapi.data.subject;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ReadingType {
	@JsonProperty("onyomi")
	ONYOMI,
	
	@JsonProperty("kunyomi")
	KUNYOMI
}
