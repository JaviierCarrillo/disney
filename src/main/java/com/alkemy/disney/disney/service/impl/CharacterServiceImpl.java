package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.CharacterDTO;
import com.alkemy.disney.disney.dto.CharacterFiltersDTO;
import com.alkemy.disney.disney.entity.CharacterEntity;
import com.alkemy.disney.disney.mapper.CharacterMapper;
import com.alkemy.disney.disney.service.repository.CharacterRepository;
import com.alkemy.disney.disney.service.repository.specifications.CharacterSpecification;
import com.alkemy.disney.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CharacterServiceImpl implements CharacterService {

    private CharacterMapper characterMapper;
    private CharacterSpecification characterSpecification;
    private CharacterRepository characterRepository;

    @Autowired
    public CharacterServiceImpl(
            CharacterMapper characterMapper,
            CharacterSpecification characterSpecification,
            CharacterRepository characterRepository
    ){
        this.characterMapper = characterMapper;
        this.characterSpecification = characterSpecification;
        this.characterRepository = characterRepository;
    }
    @Override
    public List<CharacterDTO> getAllCharacters() {
        List<CharacterEntity> characters = characterRepository.findAll();
        List<CharacterDTO> result = characterMapper.characterEntityList2DTOList(characters, true);
        return result;
    }

    @Override
    public CharacterDTO save(CharacterDTO dto) {
        CharacterEntity entity = characterMapper.characterDTO2Entity(dto);
        CharacterEntity entitySaved = characterRepository.save(entity);
        CharacterDTO result = characterMapper.characterEntity2DTO(entitySaved, true);
        return result;
    }

    public void delete(Long id) {
        characterRepository.deleteById(id);
    }

    @Override
    public List<CharacterDTO> getByFilters(String name, Integer age, Long weight, Set<Long> movies, String order) {
        CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO(name, age, weight, movies, order);
        List<CharacterEntity> entities = characterRepository.findAll(characterSpecification.getByFilters(filtersDTO));
        List<CharacterDTO> dtos = characterMapper.characterEntityList2DTOList(entities, true);
        return dtos;
    }

}
