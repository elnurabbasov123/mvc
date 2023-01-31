package com.example.mvc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "programming_languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    //    @ManyToMany (uni d. (yeni tek yalniz studentin icinde languageler var , languagenin icinde studentler yoxdu) )
//    private List<Student> students;
}
