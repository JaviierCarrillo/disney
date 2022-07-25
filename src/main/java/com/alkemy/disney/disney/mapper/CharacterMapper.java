package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.CharacterDTO;
import com.alkemy.disney.disney.entity.CharacterEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMapper {
    public CharacterEntity characterDTO2Entity(CharacterDTO dto) {
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setImage(dto.getImage());
        characterEntity.setName(dto.getName());
        characterEntity.setAge(dto.getAge());
        characterEntity.setWeight(dto.getWeight());
        characterEntity.setHistory(dto.getHistory());
        characterEntity.setMovies(dto.getMovies());
        return characterEntity;
    }

    public CharacterDTO characterEntity2DTO(CharacterEntity entity) {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(entity.getId());
        characterDTO.setImage(entity.getImage());
        characterDTO.setName(entity.getName());
        characterDTO.setAge(entity.getAge());
        characterDTO.setWeight(entity.getWeight());
        characterDTO.setHistory(entity.getHistory());
        characterDTO.setMovies(entity.getMovies());
        return characterDTO;
    }

    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> characters) {
        List<CharacterDTO> dtos = new ArrayList<>();
        for(CharacterEntity entity : characters){
            dtos.add(characterEntity2DTO(entity));
        }
        return dtos;
    }
}
