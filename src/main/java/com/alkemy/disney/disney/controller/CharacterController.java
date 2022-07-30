package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.disney.dto.CharacterDTO;
import com.alkemy.disney.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("characters")
public class CharacterController {
    private CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CharacterBasicDTO>> getAll(){
        List<CharacterBasicDTO> characters = characterService.getAllCharacters();
        return ResponseEntity.ok().body(characters);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getDetailsById(@PathVariable Long id){
        CharacterDTO character = characterService.getDetailsById(id);
        return ResponseEntity.ok(character);
    }

    @GetMapping
    public ResponseEntity<List<CharacterDTO>> getDetailsByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Long weight,
            @RequestParam(required = false) Set<Long> movies,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ){
        List<CharacterDTO> characters = characterService.getByFilters(name, age, weight, movies, order);
        return ResponseEntity.ok(characters);
    }

    @PostMapping
    public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO character){
        CharacterDTO characterSaved = characterService.save(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(characterSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> update(@PathVariable Long id, @RequestBody CharacterDTO character){
        CharacterDTO result = characterService.update(id, character);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        characterService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
    @PostMapping("/{id}/movie/{idMovie}")
    public ResponseEntity<Void> addMovie(@PathVariable Long id, @PathVariable Long idMovie){
        characterService.addMovie(id, idMovie);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }*/

    /**
    @DeleteMapping("/{id}/movie/{idMovie}")
    public ResponseEntity<Void> removeMovie(@PathVariable Long id, @PathVariable Long idMovie){
        characterService.removeMovie(id, idMovie);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }*/
}
