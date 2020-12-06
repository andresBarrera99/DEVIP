package co.com.moviedb.moviedb.api.services.movie.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDetailResponseDTO extends BasicMovieResultDTO{
	
	@JsonProperty(value="belongs_to_collection")
	private CollectionDTO belongsToCollection;
	
	@JsonProperty(value="budget")
	private Long budget;
	
	@JsonProperty(value="genres")
	private List<GenresDTO> genres;
	
	@JsonProperty(value="homepage")
	private String homepage;
	
	@JsonProperty(value="imdb_id")
	private String imdbID;
	
	@JsonProperty(value="production_companies")
	private List<ProductionCompaniesDTO> productionCompanies;
	
	@JsonProperty(value="production_countries")
	private List<ProductionCountriesDTO> productionCountries;
	
	@JsonProperty(value="revenue")
	private Long revenue;
	
	@JsonProperty(value="runtime")
	private Integer runtime;

	@JsonProperty(value="spoken_languages")
	private List<SpokenLanguagesDTO> spokenLanguages;

	@JsonProperty(value="status")
	private String status;

	@JsonProperty(value="tagline")
	private String tagline;

	public CollectionDTO getBelongsToCollection() {
		return belongsToCollection;
	}

	public void setBelongsToCollection(CollectionDTO belongsToCollection) {
		this.belongsToCollection = belongsToCollection;
	}

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public List<GenresDTO> getGenres() {
		return genres;
	}

	public void setGenres(List<GenresDTO> genres) {
		this.genres = genres;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public List<ProductionCompaniesDTO> getProductionCompanies() {
		return productionCompanies;
	}

	public void setProductionCompanies(List<ProductionCompaniesDTO> productionCompanies) {
		this.productionCompanies = productionCompanies;
	}

	public List<ProductionCountriesDTO> getProductionCountries() {
		return productionCountries;
	}

	public void setProductionCountries(List<ProductionCountriesDTO> productionCountries) {
		this.productionCountries = productionCountries;
	}

	public Long getRevenue() {
		return revenue;
	}

	public void setRevenue(Long revenue) {
		this.revenue = revenue;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	public List<SpokenLanguagesDTO> getSpokenLanguages() {
		return spokenLanguages;
	}

	public void setSpokenLanguages(List<SpokenLanguagesDTO> spokenLanguages) {
		this.spokenLanguages = spokenLanguages;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	@Override
	public String toString() {
		return "MovieDetailResponseDTO [belongsToCollection=" + belongsToCollection + ", budget=" + budget + ", genres="
				+ genres + ", homepage=" + homepage + ", imdbID=" + imdbID + ", productionCompanies="
				+ productionCompanies + ", productionCountries=" + productionCountries + ", revenue=" + revenue
				+ ", runtime=" + runtime + ", spokenLanguages=" + spokenLanguages + ", status=" + status + ", tagline="
				+ tagline + "]";
	}
	
	

}
