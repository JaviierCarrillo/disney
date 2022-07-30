package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.MovieBasicDTO;
import com.alkemy.disney.disney.dto.MovieDTO;
import com.alkemy.disney.disney.dto.MovieFiltersDTO;
import com.alkemy.disney.disney.entity.MovieEntity;
import com.alkemy.disney.disney.exception.ParamNotFound;
import com.alkemy.disney.disney.mapper.MovieMapper;
import com.alkemy.disney.disney.service.CharacterService;
import com.alkemy.disney.disney.service.repository.MovieRepository;
import com.alkemy.disney.disney.service.MovieService;
import com.alkemy.disney.disney.service.repository.specifications.MovieSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieMapper movieMapper;
    private MovieSpecification movieSpecification;
    private MovieRepository movieRepository;
    private CharacterService characterService;

    @Autowired
    public MovieServiceImpl(
            MovieMapper movieMapper,
            MovieSpecification movieSpecification,
            MovieRepository movieRepository,
            CharacterService characterService) {
        this.movieMapper = movieMapper;
        this.movieSpecification = movieSpecification;
        this.movieRepository = movieRepository;
        this.characterService = characterService;
    }

    @Override
    public MovieDTO save(MovieDTO dto) {
        MovieEntity entity = movieMapper.movieDTO2Entity(dto);
        MovieEntity entitySaved = movieRepository.save(entity);
        MovieDTO result = movieMapper.movieEntity2DTO(entitySaved, true);
        return result;
    }

    @Override
    public List<MovieBasicDTO> getAllMovies() {
        List<MovieEntity> movies = movieRepository.findAll();
        List<MovieBasicDTO> result = movieMapper.movieEntitySet2movieBasicDTOList(movies);
        return result;
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public MovieDTO update(Long id, MovieDTO movie) {
        Optional<MovieEntity> entity = movieRepository.findById(id);
        if(!entity.isPresent()){
            throw new ParamNotFound("movie id no valid");
        }
        movieMapper.movieEntityRefreshValues(entity.get(), movie);
        MovieEntity entitySaved = movieRepository.save(entity.get());
        MovieDTO result = movieMapper.movieEntity2DTO(entitySaved, true);
        return result;
    }

    @Override
    public List<MovieDTO> getByFilters(String title, Long genreId, String creationDate, String order) {
        MovieFiltersDTO filtersDTO = new MovieFiltersDTO(title, genreId, creationDate, order);
        List<MovieEntity> entities = movieRepository.findAll(movieSpecification.getByFilters(filtersDTO));
        List<MovieDTO> dtos = movieMapper.movieEntityList2DTOList(entities, true);
        return dtos;
    }

    @Override
    public MovieDTO getDetailsById(Long id) {
        Optional<MovieEntity> entity = movieRepository.findById(id);
        if(!entity.isPresent()){
            throw new ParamNotFound("movie id no valid");
        }
        MovieDTO movieDTO = movieMapper.movieEntity2DTO(entity.get(), true);
        return movieDTO;
    }

}
