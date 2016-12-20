package com.adictos.spark.movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adictos.spark.movies.dao.MoviesRespository;
import com.adictos.spark.movies.model.Movie;

@Service
public class MoviesServiceImpl implements MoviesService {

	@Autowired
	private MoviesRespository moviesRepository;
	
	@Override
	public Movie addMovie(Movie movie) {
		return moviesRepository.addMovie(movie);
	}

	@Override
	public void deleteMovie(Long id) {
		moviesRepository.deleteMovie(id);
	}

	@Override
	public Movie updateMovie(Movie movie) {
		return moviesRepository.updateMovie(movie);
	}

	@Override
	public Movie getMovie(Long id) {
		return moviesRepository.getMovie(id);
	}

	@Override
	public List<Movie> getMovies() {
		return moviesRepository.getMovies();
	}

}
