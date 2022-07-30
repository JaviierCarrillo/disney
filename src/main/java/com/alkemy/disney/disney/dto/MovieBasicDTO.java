package com.alkemy.disney.disney.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieBasicDTO {
    private Long id;
    private String image;
    private String title;
    private String creationDate;
}
