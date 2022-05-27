package com.zalinius.wanikaniapi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaginationData {
	
	@JsonProperty("per_pages")
	private int perPages;

	@JsonProperty("next_url")
	private String nextUrl;

	
	public PaginationData() {
	}


	public int getPerPages() {
		return perPages;
	}

	public void setPerPages(int perPages) {
		this.perPages = perPages;
	}

	public String getNextUrl() {
		return nextUrl;
	}

	public void setNextUrl(String nextUrl) {
		this.nextUrl = nextUrl;
	}	
	
}
