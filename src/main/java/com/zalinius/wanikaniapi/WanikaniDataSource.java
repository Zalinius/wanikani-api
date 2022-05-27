package com.zalinius.wanikaniapi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.zalinius.japaneseutils.CharStreamUtils;
import com.zalinius.japaneseutils.HiraganaUtils;
import com.zalinius.wanikaniapi.data.AllAssignmentsResponse;
import com.zalinius.wanikaniapi.data.UserData;
import com.zalinius.wanikaniapi.data.UserResponse;
import com.zalinius.wanikaniapi.data.subject.AllSubjectsResponse;
import com.zalinius.wanikaniapi.data.subject.SubjectData;
import com.zalinius.wanikaniapi.data.subject.SubjectResponse;
import com.zalinius.wanikaniapi.data.subject.SubjectType;

public class WanikaniDataSource {
	
	public static final int[] GURU_AND_ABOVE = new int[]{5,6,7,8,9};
	public static final SubjectType[] KANJI_AND_VOCAB = new SubjectType[] {SubjectType.KANJI, SubjectType.VOCABULARY};
	public static final SubjectType[] JUST_KANJI = new SubjectType[] {SubjectType.KANJI};


	private RestTemplate restTemplate;
	private final String oAuthKey;

	public WanikaniDataSource(RestTemplateBuilder builder, String oAuthKey) {
		this.restTemplate = builder.build();
		this.oAuthKey = oAuthKey;
	}

	@GetMapping("subjects")
	public List<SubjectData> getGuruKanjiAndVocabSubjects(int[] lengths){
		AllAssignmentsResponse allAssignmentsResponse = getAllAssignments(GURU_AND_ABOVE, KANJI_AND_VOCAB);
		List<Integer> subjectIds = allAssignmentsResponse.
				getData().
				stream().
				map(assignment -> assignment.getData().getSubjectId()).
				collect(Collectors.toList());

		List<SubjectData> subjects = findAllSubjectsById(subjectIds).
				getSubjectResponses().
				stream().map(SubjectResponse::getSubjectData).
				collect(Collectors.toList());

		List<Integer> lengthsList = Arrays.stream(lengths).boxed().toList();

		return subjects.stream().
				filter(subject -> lengthsList.contains(subject.getPrimaryReading().getReading().length())).
				filter(subject -> HiraganaUtils.containsOnlyHiragana(subject.getPrimaryReading().getReading())).
				collect(Collectors.toList());
	}

	public List<SubjectData> getGuruKanjiSubjects(){
		AllAssignmentsResponse allAssignmentsResponse = getAllAssignments(GURU_AND_ABOVE, JUST_KANJI);
		List<Integer> subjectIds = allAssignmentsResponse.
				getData().
				stream().
				map(assignment -> assignment.getData().getSubjectId()).
				collect(Collectors.toList());

		List<SubjectData> subjects = findAllSubjectsById(subjectIds).
				getSubjectResponses().
				stream().map(SubjectResponse::getSubjectData).
				collect(Collectors.toList());

		return subjects;
	}

	@GetMapping("user")
	public UserData getUserData() throws Exception {
		return findUserResponse().getData();
	}

	@GetMapping("assignments")
	public AllAssignmentsResponse getAllAssignments(int[] stages, SubjectType[] subjectTypes){
		return findAllAssignments(stages, subjectTypes);
	}

	public UserResponse findUserResponse() throws Exception {
		UserResponse userResponse = restTemplate.exchange(
				"https://api.wanikani.com/v2/user", HttpMethod.GET, prepHttpEntity(), UserResponse.class).getBody();

		return userResponse;
	}

	public AllAssignmentsResponse findAllAssignments(int[] stages, SubjectType[] subjectTypes) {
		Map<String, Object> params = new HashMap<>();
		params.put("srs_stages", stages);
		params.put("subject_types", subjectTypes);

		String urlTemplate = UriComponentsBuilder.fromHttpUrl("https://api.wanikani.com/v2/assignments")
				.queryParam("srs_stages", "{srs_stages}")
				.queryParam("subject_types", "{subject_types}")
				.encode()
				.toUriString();


		AllAssignmentsResponse allAssignmentsResponse = restTemplate.exchange(
				urlTemplate, HttpMethod.GET, prepHttpEntity(), AllAssignmentsResponse.class, params).getBody();

		return allAssignmentsResponse;
	}

	public AllSubjectsResponse findAllSubjectsById(List<Integer> subjectIds) {
		Map<String, Object> params = new HashMap<>();
		params.put("ids", subjectIds.toArray());

		String urlTemplate = UriComponentsBuilder.fromHttpUrl("https://api.wanikani.com/v2/subjects")
				.queryParam("ids", "{ids}")
				.encode()
				.toUriString();

		AllSubjectsResponse allSubjectsResponse = restTemplate.exchange(
				urlTemplate, HttpMethod.GET, prepHttpEntity(), AllSubjectsResponse.class, params).getBody();

		return allSubjectsResponse;

	}

	public Map<Character, SubjectData> findAllKanjiSubjects() throws Exception {
		Map<Character, SubjectData> allKanji = new HashMap<>();

		Map<String, Object> params = new HashMap<>();
		params.put("types", JUST_KANJI);
		String url = "https://api.wanikani.com/v2/subjects";

		String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("types", "{types}")
				.encode()
				.toUriString();

		AllSubjectsResponse allSubjectsResponse = restTemplate.exchange(
				urlTemplate, HttpMethod.GET, prepHttpEntity(), AllSubjectsResponse.class, params).getBody();

		allSubjectsResponse.getSubjectResponses().stream().map(sr -> sr.getSubjectData()).forEach(data -> allKanji.put(CharStreamUtils.makeChar(data.getCharacters()), data));

		while (allSubjectsResponse.getPages().getNextUrl() != null) {
			params.clear();
			urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
					.encode()
					.toUriString();

			url = allSubjectsResponse.getPages().getNextUrl();
			allSubjectsResponse = restTemplate.exchange(
					urlTemplate, HttpMethod.GET, prepHttpEntity(), AllSubjectsResponse.class, params).getBody();			

			allSubjectsResponse.getSubjectResponses().stream().map(sr -> sr.getSubjectData()).forEach(data -> allKanji.put(CharStreamUtils.makeChar(data.getCharacters()), data));

		}

		return allKanji;
	}

	private HttpEntity<String> prepHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + oAuthKey);
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		return httpEntity;
	}


}
