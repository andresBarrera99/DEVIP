package co.com.moviedb.moviedb.api.services.movie.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductionCountriesDTO {
	@JsonProperty(value = "iso_3166_1")
	private String iso;
	@JsonProperty(value = "name")
	private String name;
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
		return "ProductionCountries [iso=" + iso + ", name=" + name + "]";
	}
	
	
}
