package co.com.moviedb.moviedb.api.services.movie.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.moviedb.moviedb.api.services.movie.model.BasicMovieResultDTO;
import co.com.moviedb.moviedb.api.services.movie.model.BasicResponseDTO;
import co.com.moviedb.moviedb.api.services.movie.model.MovieDetailResponseDTO;
import co.com.moviedb.moviedb.api.services.movie.service.MovieService;
import co.com.moviedb.moviedb.framework.controller.BaseController;
import co.com.moviedb.moviedb.framework.controller.executeService;
import co.com.moviedb.moviedb.framework.response.BaseResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "moviedb")
public class MovieController extends BaseController<MovieService> {
	
	@GetMapping(path = "/popularMovies")
	public ResponseEntity<BaseResponse<BasicResponseDTO<BasicMovieResultDTO>>> getMostPopularMovies(@RequestParam Integer page) throws Exception{
		return executeService(new executeService<BaseResponse<BasicResponseDTO<BasicMovieResultDTO>>>(null,page) {

			@Override
			public ResponseEntity<BaseResponse<BasicResponseDTO<BasicMovieResultDTO>>> execute(
					BaseResponse<BasicResponseDTO<BasicMovieResultDTO>> response) throws Exception {
				response.setResponseBody(getService().getMostPopularMovies(String.valueOf(page)));
				return new ResponseEntity<>(response,HttpStatus.OK);
			}			
		});
	}
	
	@GetMapping(path = "/topRatedMovies")
	public ResponseEntity<BaseResponse<BasicResponseDTO<BasicMovieResultDTO>>> getTopRatedMovies(@RequestParam Integer page) throws Exception{
		return executeService(new executeService<BaseResponse<BasicResponseDTO<BasicMovieResultDTO>>>(null,page) {

			@Override
			public ResponseEntity<BaseResponse<BasicResponseDTO<BasicMovieResultDTO>>> execute(
					BaseResponse<BasicResponseDTO<BasicMovieResultDTO>> response) throws Exception {
				response.setResponseBody(getService().getMostPopularMovies(String.valueOf(page)));
				return new ResponseEntity<>(response,HttpStatus.OK);
			}			
		});
	}
	
	@PostMapping(path = "/searchMovie")
	public ResponseEntity<BaseResponse<BasicResponseDTO<BasicMovieResultDTO>>> searchMovie(@RequestBody Map<String,String> request,BindingResult bindingResult) throws Exception{
		return executeService(new executeService<BaseResponse<BasicResponseDTO<BasicMovieResultDTO>>>(bindingResult,request) {

			@Override
			public ResponseEntity<BaseResponse<BasicResponseDTO<BasicMovieResultDTO>>> execute(
					BaseResponse<BasicResponseDTO<BasicMovieResultDTO>> response) throws Exception {
				response.setResponseBody(getService().searchMovie(request));
				return new ResponseEntity<>(response,HttpStatus.OK);
			}			
		});
	}
	
	@GetMapping(path = "/movieDetail/{movieID}")
	public ResponseEntity<BaseResponse<MovieDetailResponseDTO>> getMovieDetail(@PathVariable(required=true,name="movieID") Integer movieID) throws Exception{
		return executeService(new executeService<BaseResponse<MovieDetailResponseDTO>>(null,movieID) {

			@Override
			public ResponseEntity<BaseResponse<MovieDetailResponseDTO>> execute(
					BaseResponse<MovieDetailResponseDTO> response) throws Exception {
				response.setResponseBody(getService().getMovieDetail(String.valueOf(movieID)));
				return new ResponseEntity<>(response,HttpStatus.OK);
			}			
		});
	}
}
