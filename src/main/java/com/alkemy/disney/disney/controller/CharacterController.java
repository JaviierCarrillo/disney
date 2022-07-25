package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.CharacterDTO;
import com.alkemy.disney.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public ResponseEntity<List<CharacterDTO>> getAll(){
        List<CharacterDTO> characters = characterService.getAllCharacters();
        return ResponseEntity.ok().body(characters);
    }

    @PostMapping
    public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO character){
        CharacterDTO characterSaved = characterService.save(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(characterSaved);
    }
}
