package com.example.practiceapp.author;

import com.example.practiceapp.book.Book;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String firstName;

    private String lastName;

    private String country;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> books;

}
