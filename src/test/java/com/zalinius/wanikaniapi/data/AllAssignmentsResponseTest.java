package com.zalinius.wanikaniapi.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zalinius.wanikaniapi.data.subject.SubjectType;

public class AllAssignmentsResponseTest {

	@Test
	void jsonInjection_withSampleAllAssignmentsResponse_fillsDataWith1Assignment() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String sampleAllAssignmentResponse = sampleAllAssignmentsResponseJsonString();
		
		AllAssignmentsResponse allAssignmentsResponse = objectMapper.readValue(sampleAllAssignmentResponse, AllAssignmentsResponse.class);
		
		assertEquals(1, allAssignmentsResponse.getData().size());
		assertEquals(SubjectType.KANJI, allAssignmentsResponse.getData().get(0).getData().getSubjectType());
		assertEquals(4, allAssignmentsResponse.getData().get(0).getData().getSrsStage());
	}
	
	
	
	private static String sampleAllAssignmentsResponseJsonString() {
		return    "{\n"
				+ "  \"object\": \"collection\",\n"
				+ "  \"url\": \"https://api.wanikani.com/v2/assignments\",\n"
				+ "  \"pages\": {\n"
				+ "    \"per_page\": 500,\n"
				+ "    \"next_url\": \"https://api.wanikani.com/v2/assignments?page_after_id=80469434\",\n"
				+ "    \"previous_url\": null\n"
				+ "  },\n"
				+ "  \"total_count\": 1600,\n"
				+ "  \"data_updated_at\": \"2017-11-29T19:37:03.571377Z\",\n"
				+ "  \"data\": [\n"
				+ "    {\n"
				+ "      \"id\": 80463006,\n"
				+ "      \"object\": \"assignment\",\n"
				+ "      \"url\": \"https://api.wanikani.com/v2/assignments/80463006\",\n"
				+ "      \"data_updated_at\": \"2017-10-30T01:51:10.438432Z\",\n"
				+ "      \"data\": {\n"
				+ "        \"created_at\": \"2017-09-05T23:38:10.695133Z\",\n"
				+ "        \"subject_id\": 8761,\n"
				+ "        \"subject_type\": \"kanji\",\n"
				+ "        \"srs_stage\": 4,\n"
				+ "        \"unlocked_at\": \"2017-09-05T23:38:10.695133Z\",\n"
				+ "        \"started_at\": \"2017-09-05T23:41:28.980679Z\",\n"
				+ "        \"passed_at\": \"2017-09-07T17:14:14.491889Z\",\n"
				+ "        \"burned_at\": null,\n"
				+ "        \"available_at\": \"2018-02-27T00:00:00.000000Z\",\n"
				+ "        \"resurrected_at\": null\n"
				+ "      }\n"
				+ "    }\n"
				+ "  ]\n"
				+ "}";
	}
}
