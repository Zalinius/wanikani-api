package com.zalinius.wanikaniapi.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zalinius.wanikaniapi.data.subject.SubjectType;

public class AssignmentDataTest {

	@Test
	void jsonInjection_withSampleAssignmentData_fillsSubjectAndSrsStageFields() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String sampleAssignmentData = sampleAssignmentDataJsonString();
		
		AssignmentData assignmentData = objectMapper.readValue(sampleAssignmentData, AssignmentData.class);
		
		assertEquals(SubjectType.RADICAL, assignmentData.getSubjectType());
		assertEquals(8, assignmentData.getSrsStage());
	}
	
	
	
	private static String sampleAssignmentDataJsonString() {
		return    "{\n"
				+ "    \"created_at\": \"2017-09-05T23:38:10.695133Z\",\n"
				+ "    \"subject_id\": 8761,\n"
				+ "    \"subject_type\": \"radical\",\n"
				+ "    \"srs_stage\": 8,\n"
				+ "    \"unlocked_at\": \"2017-09-05T23:38:10.695133Z\",\n"
				+ "    \"started_at\": \"2017-09-05T23:41:28.980679Z\",\n"
				+ "    \"passed_at\": \"2017-09-07T17:14:14.491889Z\",\n"
				+ "    \"burned_at\": null,\n"
				+ "    \"available_at\": \"2018-02-27T00:00:00.000000Z\",\n"
				+ "    \"resurrected_at\": null,\n"
				+ "    \"hidden\": false\n"
				+ "}";
	}
}
