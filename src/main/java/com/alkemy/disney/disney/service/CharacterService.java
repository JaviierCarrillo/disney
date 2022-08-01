package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.disney.dto.CharacterDTO;
import com.alkemy.disney.disney.entity.CharacterEntity;

import java.util.List;
import java.util.Set;

public interface CharacterService {
    List<CharacterBasicDTO> getAllCharacters();
    CharacterDTO save(CharacterDTO character);
    void delete(Long id);
    List<CharacterDTO> getByFilters(String name, Integer age, Long weight, Set<Long> movies, String order);

    CharacterDTO getDetailsById(Long id);

    CharacterDTO update(Long id, CharacterDTO characterDTO);
}
