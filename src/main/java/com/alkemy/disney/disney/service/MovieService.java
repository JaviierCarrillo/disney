package com.alkemy.disney.disney.service;


import com.alkemy.disney.disney.dto.MovieBasicDTO;
import com.alkemy.disney.disney.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieDTO save(MovieDTO dto);

    List<MovieBasicDTO> getAllMovies();

    void delete(Long id);

    MovieDTO update(Long id, MovieDTO movie);

    List<MovieDTO> getByFilters(String title, Long genreId, String creationDate, String order);

    MovieDTO getDetailsById(Long id);
}
