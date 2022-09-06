package com.example.practiceapp.author;

import com.example.practiceapp.book.Book;

import java.util.List;

public interface AuthorService {

    public List<Author> getAuthors();

    public Author getAuthor(long authorId);

    public Author addAuthor(Author author);

    public Author updateAuthor(Author author);

    public void deleteAuthor(Long parseLong);

}
