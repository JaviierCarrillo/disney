package com.alkemy.disney.disney.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieFiltersDTO {
    private String title;
    private Long genreId;
    private String creationDate;
    private String order;

    public MovieFiltersDTO(String title, Long genreId, String creationDate, String order) {
        this.title = title;
        this.genreId = genreId;
        this.creationDate = creationDate;
        this.order = order;
    }

    public boolean isASC(){
        return order.compareToIgnoreCase("ASC") == 0;
    }
}
