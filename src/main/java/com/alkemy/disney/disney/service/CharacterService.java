package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.CharacterDTO;

import java.util.List;
import java.util.Set;

public interface CharacterService {
    List<CharacterDTO> getAllCharacters();
    CharacterDTO save(CharacterDTO character);
    void delete(Long id);
    List<CharacterDTO> getByFilters(String name, Integer age, Long weight, Set<Long> movies, String order);
}
