package org.perscholas.minihackathon3_rest_api.service;

import org.perscholas.minihackathon3_rest_api.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(Long id);
    Movie save(Movie movie);
    void deleteById(Long id);
    List<Movie> searchByTitle(String title);
}
