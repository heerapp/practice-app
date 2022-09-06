package com.example.practiceapp.book;

import java.util.List;

public interface BookService {

    public List<Book> getBooks();

    public Book getBook(long bookId);

    public Book addBook(Book book);

    public Book updateBook(Book book);

    public void deleteBook(Long parseLong);

}
