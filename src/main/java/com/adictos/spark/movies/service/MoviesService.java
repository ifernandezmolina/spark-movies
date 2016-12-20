package com.adictos.spark.movies.service;

import java.util.List;

import com.adictos.spark.movies.model.Movie;

public interface MoviesService {

	Movie addMovie(final Movie movie);

	void deleteMovie(final Long id);

	Movie updateMovie(final Movie movie);

	Movie getMovie(final Long id);

	List<Movie> getMovies();
	
}
