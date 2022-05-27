package com.zalinius.wanikaniapi.data.subject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AllSubjectResponsesTest {

	@Test
	void jsonInjection_withSampleAllSubjectsResponse_fillsDataWith1Subject() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String sampleAllSubjectsResponse = sampleAllSubjectsResponseJsonString();
		
		AllSubjectsResponse allSubjectsResponse = objectMapper.readValue(sampleAllSubjectsResponse, AllSubjectsResponse.class);
		
		assertEquals(1, allSubjectsResponse.getSubjectResponses().size());
		assertEquals(SubjectType.KANJI, allSubjectsResponse.getSubjectResponses().get(0).getSubjectType());
		assertEquals(440, allSubjectsResponse.getSubjectResponses().get(0).getId());
	}
	
	
	
	private static String sampleAllSubjectsResponseJsonString() {
		return    "{\n"
				+ "  \"object\": \"collection\",\n"
				+ "  \"url\": \"https://api.wanikani.com/v2/subjects?types=kanji\",\n"
				+ "  \"pages\": {\n"
				+ "    \"per_page\": 1000,\n"
				+ "    \"next_url\": \"https://api.wanikani.com/v2/subjects?page_after_id=1439\\u0026types=kanji\",\n"
				+ "    \"previous_url\": null\n"
				+ "  },\n"
				+ "  \"total_count\": 2027,\n"
				+ "  \"data_updated_at\": \"2018-04-09T18:08:59.946969Z\",\n"
				+ "  \"data\": [\n"
				+ "    {\n"
				+ "      \"id\": 440,\n"
				+ "      \"object\": \"kanji\",\n"
				+ "      \"url\": \"https://api.wanikani.com/v2/subjects/440\",\n"
				+ "      \"data_updated_at\": \"2018-03-29T23:14:30.805034Z\",\n"
				+ "      \"data\": {\n"
				+ "        \"created_at\": \"2012-02-27T19:55:19.000000Z\",\n"
				+ "        \"level\": 1,\n"
				+ "        \"slug\": \"一\",\n"
				+ "        \"hidden_at\": null,\n"
				+ "        \"document_url\": \"https://www.wanikani.com/kanji/%E4%B8%80\",\n"
				+ "        \"characters\": \"一\",\n"
				+ "        \"meanings\": [\n"
				+ "          {\n"
				+ "            \"meaning\": \"One\",\n"
				+ "            \"primary\": true,\n"
				+ "            \"accepted_answer\": true\n"
				+ "          }\n"
				+ "        ],\n"
				+ "        \"readings\": [\n"
				+ "          {\n"
				+ "            \"type\": \"onyomi\",\n"
				+ "            \"primary\": true,\n"
				+ "            \"accepted_answer\": true,\n"
				+ "            \"reading\": \"いち\"\n"
				+ "          },\n"
				+ "          {\n"
				+ "            \"type\": \"kunyomi\",\n"
				+ "            \"primary\": false,\n"
				+ "            \"accepted_answer\": false,\n"
				+ "            \"reading\": \"ひと\"\n"
				+ "          },\n"
				+ "          {\n"
				+ "            \"type\": \"nanori\",\n"
				+ "            \"primary\": false,\n"
				+ "            \"accepted_answer\": false,\n"
				+ "            \"reading\": \"かず\"\n"
				+ "          }\n"
				+ "        ],\n"
				+ "        \"component_subject_ids\": [\n"
				+ "          1\n"
				+ "        ],\n"
				+ "        \"amalgamation_subject_ids\": [\n"
				+ "          56,\n"
				+ "          88,\n"
				+ "          91\n"
				+ "        ],\n"
				+ "        \"visually_similar_subject_ids\": [],\n"
				+ "        \"meaning_mnemonic\": \"Lying on the <radical>ground</radical> is something that looks just like the ground, the number <kanji>One</kanji>. Why is this One lying down? It's been shot by the number two. It's lying there, bleeding out and dying. The number One doesn't have long to live.\",\n"
				+ "        \"meaning_hint\": \"To remember the meaning of <kanji>One</kanji>, imagine yourself there at the scene of the crime. You grab <kanji>One</kanji> in your arms, trying to prop it up, trying to hear its last words. Instead, it just splatters some blood on your face. \\\"Who did this to you?\\\" you ask. The number One points weakly, and you see number Two running off into an alleyway. He's always been jealous of number One and knows he can be number one now that he's taken the real number one out.\",\n"
				+ "        \"reading_mnemonic\": \"As you're sitting there next to <kanji>One</kanji>, holding him up, you start feeling a weird sensation all over your skin. From the wound comes a fine powder (obviously coming from the special bullet used to kill One) that causes the person it touches to get extremely <reading>itchy</reading> (いち)\",\n"
				+ "        \"reading_hint\": \"Make sure you feel the ridiculously <reading>itchy</reading> sensation covering your body. It climbs from your hands, where you're holding the number <kanji>One</kanji> up, and then goes through your arms, crawls up your neck, goes down your body, and then covers everything. It becomes uncontrollable, and you're scratching everywhere, writhing on the ground. It's so itchy that it's the most painful thing you've ever experienced (you should imagine this vividly, so you remember the reading of this kanji).\",\n"
				+ "        \"lesson_position\": 2,\n"
				+ "        \"spaced_repetition_system_id\": 1\n"
				+ "      }\n"
				+ "    }\n"
				+ "  ]\n"
				+ "}";
	}

}
