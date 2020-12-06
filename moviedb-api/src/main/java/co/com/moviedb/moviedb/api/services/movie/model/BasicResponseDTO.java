package co.com.moviedb.moviedb.api.services.movie.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BasicResponseDTO  <B extends Object>{

	@JsonProperty(value="page")
	private Integer page;
	
	@JsonProperty(value="results")
	private List<B> results;
	
	@JsonProperty(value="total_pages")
	private Integer totalPages;
	
	@JsonProperty(value="total_results")
	private Integer totalResult;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public List<B> getResults() {
		return results;
	}

	public void setResults(List<B> results) {
		this.results = results;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(Integer totalResult) {
		this.totalResult = totalResult;
	}

	@Override
	public String toString() {
		return "BasicMovieResponseDTO [page=" + page + ", results=" + results + ", totalPages=" + totalPages
				+ ", totalResult=" + totalResult + "]";
	}
	
	

}
