package org.perscholas.minihackathon3_rest_api.repository;

import org.perscholas.minihackathon3_rest_api.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
   // List<Movie> findByTitleContainingIgnoreCase(String title);
}
