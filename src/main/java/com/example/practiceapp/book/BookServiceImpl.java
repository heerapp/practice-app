package com.example.practiceapp.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBook(long bookId) {
        return bookRepo.findById(bookId).get();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public void deleteBook(Long parseLong) {
        Book book = bookRepo.getById(parseLong);
        bookRepo.delete(book);
    }

}
