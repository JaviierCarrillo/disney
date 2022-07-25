package com.alkemy.disney.disney.controller;

import com.alkemy.disney.disney.dto.GenreDTO;
import com.alkemy.disney.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAll(){
        List<GenreDTO> genres = genreService.getAllGenres();
        return ResponseEntity.ok().body(genres);
    }

    @PostMapping
    public ResponseEntity<GenreDTO> save(@RequestBody GenreDTO genre){
        // save genre
        GenreDTO genreSaved = genreService.save(genre);
        //201, genre saved
        return ResponseEntity.status(HttpStatus.CREATED).body(genreSaved);
    }
}
