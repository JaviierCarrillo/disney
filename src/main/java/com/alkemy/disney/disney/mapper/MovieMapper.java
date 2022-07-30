package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.CharacterDTO;
import com.alkemy.disney.disney.dto.MovieBasicDTO;
import com.alkemy.disney.disney.dto.MovieDTO;
import com.alkemy.disney.disney.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class MovieMapper {

    @Autowired
    private CharacterMapper characterMapper;



    public MovieEntity movieDTO2Entity(MovieDTO dto) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setImage(dto.getImage());
        movieEntity.setTitle(dto.getTitle());
        movieEntity.setCreationDate(string2LocalDate(dto.getCreationDate()));
        movieEntity.setQualification(dto.getQualification());
        movieEntity.setGenreId(dto.getGenreId());
        return movieEntity;
    }

    public MovieDTO movieEntity2DTO(MovieEntity entity, boolean loadCharacters) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(entity.getId());
        movieDTO.setImage(entity.getImage());
        movieDTO.setTitle(entity.getTitle());
        movieDTO.setCreationDate(entity.getCreationDate().toString());
        movieDTO.setQualification(entity.getQualification());
        movieDTO.setGenreId(entity.getGenreId());
        movieDTO.setGenre(entity.getGenre());
        if(loadCharacters){
            List<CharacterDTO> characterDTOS = characterMapper.characterEntityList2DTOList(entity.getCharacters(), false);
            movieDTO.setCharacters(characterDTOS);
        }

        return movieDTO;
    }

    private LocalDate string2LocalDate(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        return date;
    }

    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities, boolean loadCharacters) {
        List<MovieDTO> dtos = new ArrayList<>();
        for(MovieEntity entity : entities){
            dtos.add(movieEntity2DTO(entity, loadCharacters));
        }
        return dtos;
    }

    public void movieEntityRefreshValues(MovieEntity entity, MovieDTO dto) {
        entity.setImage(dto.getImage());
        entity.setTitle(dto.getTitle());
        entity.setCreationDate(string2LocalDate(dto.getCreationDate()));
        entity.setQualification(dto.getQualification());
    }

    public List<MovieBasicDTO> movieEntitySet2movieBasicDTOList(Collection<MovieEntity> entities){
        List<MovieBasicDTO> dtos = new ArrayList<>();
        MovieBasicDTO basicDTO;
        for (MovieEntity entity : entities){
            basicDTO = new MovieBasicDTO();
            basicDTO.setId(entity.getId());
            basicDTO.setImage(entity.getImage());
            basicDTO.setTitle(entity.getTitle());
            basicDTO.setCreationDate(entity.getCreationDate().toString());
        }
        return dtos;
    }
}
