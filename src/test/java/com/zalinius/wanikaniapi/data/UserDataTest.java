package com.zalinius.wanikaniapi.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserDataTest {
	
	@Test
	void jsonInjection_withSampleUserData_fillsUsernameAndLevelFields() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String sampleUserData = sampleUserDataJsonString();
		
		UserData userData = objectMapper.readValue(sampleUserData, UserData.class);
		
		assertEquals("example_user", userData.getUsername());
		assertEquals(5, userData.getLevel());
	}
	
	
	
	private static String sampleUserDataJsonString() {
		return    "{\n"
				+ "    \"id\": \"5a6a5234-a392-4a87-8f3f-33342afe8a42\",\n"
				+ "    \"username\": \"example_user\",\n"
				+ "    \"level\": 5,\n"
				+ "    \"profile_url\": \"https://www.wanikani.com/users/example_user\",\n"
				+ "    \"started_at\": \"2012-05-11T00:52:18.958466Z\",\n"
				+ "    \"current_vacation_started_at\": null,\n"
				+ "    \"subscription\": {\n"
				+ "      \"active\": true,\n"
				+ "      \"type\": \"recurring\",\n"
				+ "      \"max_level_granted\": 60,\n"
				+ "      \"period_ends_at\": \"2018-12-11T13:32:19.485748Z\"\n"
				+ "    }"
				+ "}";
	}

}
