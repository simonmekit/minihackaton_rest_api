package org.perscholas.minihackathon3_rest_api.controller;

import org.perscholas.minihackathon3_rest_api.model.Movie;
import org.perscholas.minihackathon3_rest_api.service.MovieService;
import org.perscholas.minihackathon3_rest_api.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieServiceImpl movieService){
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String showForm() {
        return "search-form";
    }

    @PostMapping("/search")
    public String searchMovie(String title, Model model) {
        List<Movie> movies = movieService.searchByTitle(title);
        Movie movie = movies.get(0);
        model.addAttribute("movies", movies);
        movieService.save(movie);
        return "result-page";
    }
}