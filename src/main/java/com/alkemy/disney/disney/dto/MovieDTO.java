package com.alkemy.disney.disney.dto;

import com.alkemy.disney.disney.entity.GenreEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MovieDTO {
    private Long id;
    private String image;
    private String title;
    private LocalDate creationDate;
    private Long qualification;
    private GenreEntity genre;
    private Long genreId;
    //@JsonIgnore
    private List<CharacterDTO> characters;
}
