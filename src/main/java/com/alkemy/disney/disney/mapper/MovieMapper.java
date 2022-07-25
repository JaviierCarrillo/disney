package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.MovieDTO;
import com.alkemy.disney.disney.entity.MovieEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {
    public MovieEntity movieDTO2Entity(MovieDTO dto) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setImage(dto.getImage());
        movieEntity.setTitle(dto.getTitle());
        movieEntity.setCreationDate(dto.getCreationDate());
        movieEntity.setQualification(dto.getQualification());
        movieEntity.setGenreId(dto.getGenreId());
        return movieEntity;
    }

    public MovieDTO movieEntity2DTO(MovieEntity entity) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(entity.getId());
        movieDTO.setImage(entity.getImage());
        movieDTO.setTitle(entity.getTitle());
        movieDTO.setCreationDate(entity.getCreationDate());
        movieDTO.setQualification(entity.getQualification());
        movieDTO.setGenreId(entity.getGenreId());
        movieDTO.setGenre(entity.getGenre());
        return movieDTO;
    }

    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities) {
        List<MovieDTO> dtos = new ArrayList<>();
        for(MovieEntity entity : entities){
            dtos.add(movieEntity2DTO(entity));
        }
        return dtos;
    }
}
