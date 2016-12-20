package com.adictos.spark.movies;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;

import java.io.IOException;

import com.adictos.spark.movies.model.Movie;
import com.adictos.spark.movies.service.MoviesService;
import com.adictos.spark.movies.transformer.JsonTransformer;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MoviesApplication {
	
	private static final String ID_PARAMETER = "id";
	private MoviesService moviesService;
	
	public MoviesApplication(final MoviesService moviesService) {
		this.moviesService = moviesService;
		initializeRoutes();
	}
	
	private void initializeRoutes() {
		
		port(8080);
		
		get("/movie", (req, res) -> {
			return moviesService.getMovies();
		}, new JsonTransformer());
		
		get("/movie/:id", (req, res) -> {
			final String id = req.params(ID_PARAMETER);
			return moviesService.getMovie(Long.valueOf(id));
		}, new JsonTransformer());
		
		post("/movie", (req, res) -> {			
			final Movie movie = readBody(req.body());
			return moviesService.addMovie(movie);
		}, new JsonTransformer());
		
		delete("/movie/:id", (req, res) -> {
			final String id = req.params(ID_PARAMETER);
			moviesService.deleteMovie(Long.valueOf(id));
			return "";
		});
		
		put("/movie/:id", (req, res) -> {
			final Movie movie = readBody(req.body());
			return moviesService.updateMovie(movie);
		}, new JsonTransformer());				
		
	}
	
	private Movie readBody(final String jsonData) throws JsonParseException, JsonMappingException, IOException {
		final ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(jsonData, Movie.class);
	}
	
	
}
