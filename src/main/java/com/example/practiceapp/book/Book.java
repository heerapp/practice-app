package com.example.practiceapp.book;

import com.example.practiceapp.author.Author;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int isbn;

    private String category;

    private int rating;

    private int price;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @JsonIgnore
    private Author author;

}
