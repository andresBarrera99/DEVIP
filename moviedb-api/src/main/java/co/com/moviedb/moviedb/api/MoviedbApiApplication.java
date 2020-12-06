package co.com.moviedb.moviedb.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.com.moviedb.moviedb.*"})
@EnableAutoConfiguration
public class MoviedbApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviedbApiApplication.class, args);
	}

}
