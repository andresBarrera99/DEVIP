package co.com.moviedb.moviedb.api.services.movie.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpokenLanguagesDTO {
	@JsonProperty(value = "english_name")
	private String englishName;
	@JsonProperty(value = "iso_639_1")
	private String iso;
	@JsonProperty(value = "name")
	private String name;
	
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getIso() {
		return iso;
	}
	public void setIso(String iso) {
		this.iso = iso;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SpokenLanguagesDTO [englishName=" + englishName + ", iso=" + iso + ", name=" + name + "]";
	}
	
}
