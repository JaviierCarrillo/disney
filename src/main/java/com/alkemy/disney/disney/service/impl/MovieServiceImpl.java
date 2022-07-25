package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.MovieDTO;
import com.alkemy.disney.disney.entity.MovieEntity;
import com.alkemy.disney.disney.mapper.MovieMapper;
import com.alkemy.disney.disney.repository.MovieRepository;
import com.alkemy.disney.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieRepository movieRepository;
    @Override
    public MovieDTO save(MovieDTO dto) {
        MovieEntity entity = movieMapper.movieDTO2Entity(dto);
        MovieEntity entitySaved = movieRepository.save(entity);
        MovieDTO result = movieMapper.movieEntity2DTO(entitySaved);
        return result;
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<MovieEntity> movies = movieRepository.findAll();
        List<MovieDTO> result = movieMapper.movieEntityList2DTOList(movies);
        return result;
    }
}
