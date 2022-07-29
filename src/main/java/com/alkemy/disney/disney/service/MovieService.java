package com.alkemy.disney.disney.service;


import com.alkemy.disney.disney.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieDTO save(MovieDTO dto);
    List<MovieDTO> getAllMovies();
    void delete(Long id);
}
