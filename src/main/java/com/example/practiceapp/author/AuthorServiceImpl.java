package com.example.practiceapp.author;

import com.example.practiceapp.book.Book;
import com.example.practiceapp.book.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Author> getAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public Author getAuthor(long authorId) {
        return authorRepo.findById(authorId).get();
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public void deleteAuthor(Long parseLong) {
        Author author = authorRepo.getById(parseLong);
        authorRepo.delete(author);
    }

}
