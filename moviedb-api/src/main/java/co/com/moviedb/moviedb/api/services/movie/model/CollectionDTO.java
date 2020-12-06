package co.com.moviedb.moviedb.api.services.movie.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CollectionDTO {
	
	@JsonProperty(value="id")
	private Integer id;
	
	@JsonProperty(value="name")
	private String name;
	
	@JsonProperty(value="poster_path")
	private String posterPath;
	
	@JsonProperty(value="backdrop_path")
	private String backdropPath;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	@Override
	public String toString() {
		return "CollectionDTO [id=" + id + ", name=" + name + ", posterPath=" + posterPath + ", backdropPath="
				+ backdropPath + "]";
	}
	
	

}
