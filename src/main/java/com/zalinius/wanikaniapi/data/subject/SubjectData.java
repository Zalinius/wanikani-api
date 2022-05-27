package com.zalinius.wanikaniapi.data.subject;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectData {

	private int level;
	private String characters;
	private List<MeaningData> meanings;
	private List<ReadingData> readings;

	public MeaningData getPrimaryMeaning() {
		return meanings.stream().filter(MeaningData::isPrimary).findFirst().orElseThrow();
	}
	public ReadingData getPrimaryReading() {
		return readings.stream().filter(ReadingData::isPrimary).findFirst().orElseThrow();
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getCharacters() {
		return characters;
	}

	public void setCharacters(String characters) {
		this.characters = characters;
	}

	public List<MeaningData> getMeanings() {
		return meanings;
	}

	public void setMeanings(List<MeaningData> meanings) {
		this.meanings = meanings;
	}

	public List<ReadingData> getReadings() {
		return readings;
	}

	public void setReadings(List<ReadingData> readings) {
		this.readings = readings;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(characters);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubjectData other = (SubjectData) obj;
		return Objects.equals(characters, other.characters);
	}
	
	
	
	
	
}
