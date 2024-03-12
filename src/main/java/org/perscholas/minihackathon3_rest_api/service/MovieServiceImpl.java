package org.perscholas.minihackathon3_rest_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.perscholas.minihackathon3_rest_api.model.Movie;
import org.perscholas.minihackathon3_rest_api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    private final MovieRepository movieRepository;

    private static final String OMDB_API_URL = "http://www.omdbapi.com/";
    private static final String API_KEY = "b79fdda2";


    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteById(Long id) {
    movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> searchByTitle(String title) {
        String apiUrl = String.format("%s?apikey=%s&t=%s", OMDB_API_URL, API_KEY, title);

        List<Movie> movies = new ArrayList<>();

        // Make HTTP request to OMDB API
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Movie movie = null;
        try {
            movie = mapper.readValue(restTemplate.getForObject(apiUrl, String.class), Movie.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        movies.add(movie);
        return movies;
    }
}
