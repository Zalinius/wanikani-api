package com.zalinius.wanikaniapi.data.subject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MeaningDataTest {

	@Test
	void jsonInjection_withSampleMeaningData_fillsMeaningAndPrimaryFields() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String sampleMeaningData = sampleMeaningDataJson();
		
		MeaningData meaningData = objectMapper.readValue(sampleMeaningData, MeaningData.class);
		
		assertEquals("One", meaningData.getMeaning());
		assertEquals(true, meaningData.isPrimary());
	}

	
	private static String sampleMeaningDataJson() {
		return    "{\n"
				+ "    \"meaning\": \"One\",\n"
				+ "    \"primary\": true,\n"
				+ "    \"accepted_answer\": true\n"
				+ "}";
	}
}
