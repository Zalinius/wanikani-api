package com.zalinius.wanikaniapi.data.subject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SubjectResponseTest {

	@Test
	void jsonInjection_withSampleSubjectResponse_fillsIdTypeAndDataFields() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String sampleSubjectResponse = sampleSubjectResponseJson();
		
		SubjectResponse subjectResponse = objectMapper.readValue(sampleSubjectResponse, SubjectResponse.class);
		
		assertEquals(1, subjectResponse.getId());
		assertEquals(SubjectType.RADICAL, subjectResponse.getSubjectType());
		assertNotNull(subjectResponse.getSubjectData());
	}


	
	
	private static String sampleSubjectResponseJson() {
		return    "{\n"
				+ "  \"id\": 1,\n"
				+ "  \"object\": \"radical\",\n"
				+ "  \"url\": \"https://api.wanikani.com/v2/subjects/1\",\n"
				+ "  \"data_updated_at\": \"2018-03-29T23:13:14.064836Z\",\n"
				+ "  \"data\": {\n"
				+ "    \"amalgamation_subject_ids\": [\n"
				+ "      5,\n"
				+ "      4,\n"
				+ "      98\n"
				+ "    ],\n"
				+ "    \"auxiliary_meanings\": [\n"
				+ "      {\n"
				+ "        \"meaning\": \"ground\",\n"
				+ "        \"type\": \"blacklist\"\n"
				+ "      }\n"
				+ "    ],\n"
				+ "    \"characters\": \"一\",\n"
				+ "    \"character_images\": [\n"
				+ "      {\n"
				+ "        \"url\": \"https://cdn.wanikani.com/images/legacy/576-subject-1-without-css-original.svg?1520987227\",\n"
				+ "        \"metadata\": {\n"
				+ "          \"inline_styles\": false\n"
				+ "        },\n"
				+ "        \"content_type\": \"image/svg+xml\"\n"
				+ "      }\n"
				+ "    ],\n"
				+ "    \"created_at\": \"2012-02-27T18:08:16.000000Z\",\n"
				+ "    \"document_url\": \"https://www.wanikani.com/radicals/ground\",\n"
				+ "    \"hidden_at\": null,\n"
				+ "    \"lesson_position\": 1,\n"
				+ "    \"level\": 1,\n"
				+ "    \"meanings\": [\n"
				+ "      {\n"
				+ "        \"meaning\": \"Ground\",\n"
				+ "        \"primary\": true,\n"
				+ "        \"accepted_answer\": true\n"
				+ "      }\n"
				+ "    ],\n"
				+ "    \"meaning_mnemonic\": \"This radical consists of a single, horizontal stroke. What's the biggest, single, horizontal stroke? That's the ground. Look at the <radical>ground</radical>, look at this radical, now look at the ground again. Kind of the same, right?\",\n"
				+ "    \"slug\": \"ground\",\n"
				+ "    \"spaced_repetition_system_id\": 2\n"
				+ "  }\n"
				+ "}\n"
				+ "";
	}

}
