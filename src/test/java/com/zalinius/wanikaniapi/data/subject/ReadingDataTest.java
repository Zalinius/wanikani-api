package com.zalinius.wanikaniapi.data.subject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadingDataTest {

	@Test
	void jsonInjection_withSampleReadingData_fillsReadingAndPrimaryFields() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String sampleReadingData = sampleReadingDataJson();
		
		ReadingData readingData = objectMapper.readValue(sampleReadingData, ReadingData.class);
		
		assertEquals("いち", readingData.getReading());
		assertEquals(true, readingData.isPrimary());
	}

	
	private static String sampleReadingDataJson() {
		return    "      {\n"
				+ "        \"primary\": true,\n"
				+ "        \"reading\": \"いち\",\n"
				+ "        \"accepted_answer\": true\n"
				+ "      }\n"
				+ "";
	}

}
