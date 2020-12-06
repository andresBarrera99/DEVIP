package co.com.moviedb.moviedb.api.services.movie.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductionCompaniesDTO {

	@JsonProperty(value = "id")
	private Integer id;

	@JsonProperty(value = "logo_path")
	private String logoPath;

	@JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "origin_country")
	private String originCountry;

	@Override
	public String toString() {
		return "ProductionCompaniesDTO [id=" + id + ", logoPath=" + logoPath + ", name=" + name + ", originCountry="
				+ originCountry + "]";
	}
	
	

}
