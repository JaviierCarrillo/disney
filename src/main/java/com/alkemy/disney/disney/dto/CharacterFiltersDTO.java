package com.alkemy.disney.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CharacterFiltersDTO {
    private String name;
    private Integer age;
    private Long weight;
    private Set<Long> movies;
    private String order;

    public CharacterFiltersDTO(String name, Integer age, Long weight, Set<Long> movies, String order){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.movies = movies;
        this.order = order;
    }

    public boolean isASC(){
        return order.compareToIgnoreCase("ASC") == 0;
    }
    public boolean isDESC(){
        return order.compareToIgnoreCase("DESC") == 0;
    }

}
