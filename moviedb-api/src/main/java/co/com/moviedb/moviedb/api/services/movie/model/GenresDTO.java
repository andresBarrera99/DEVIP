package co.com.moviedb.moviedb.api.services.movie.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenresDTO {
	
	@JsonProperty(value="id")
	private Integer id;
	
	@JsonProperty(value="name")
	private String name;
	
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
	
	@Override
	public String toString() {
		return "GenresDTO [id=" + id + ", name=" + name + "]";
	}
	
	
	

}