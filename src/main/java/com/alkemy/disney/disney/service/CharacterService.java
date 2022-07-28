package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {
    List<CharacterDTO> getAllCharacters();
    CharacterDTO save(CharacterDTO character);
    void delete(Long id);
}
