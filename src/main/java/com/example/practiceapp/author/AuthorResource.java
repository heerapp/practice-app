package com.example.practiceapp.author;

import com.example.practiceapp.book.Book;
import com.example.practiceapp.book.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorResource {

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> getAuthors(){
        return this.authorService.getAuthors();
    }

    @GetMapping("/authors/{authorId}")
    public Author getAuthor(@PathVariable String authorId){
        return this.authorService.getAuthor(Long.parseLong(authorId));
    }

    @PostMapping("/authors")
    public Author addAuthor(@RequestBody Author author){
        return this.authorService.addAuthor(author);
    }

    @PutMapping("/authors")
    public Author updateAuthor(@RequestBody Author author){
        return this.authorService.updateAuthor(author);
    }

    @DeleteMapping("/authors/{authorId}")
    public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable String authorId){
        try{
            this.authorService.deleteAuthor(Long.parseLong(authorId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/average/{authorId}")
    public float getAverage(@PathVariable long authorId) throws Exception {
        float sum = 0;
        Author author = authorRepo.findById(authorId).orElseThrow(() -> new Exception("Author not  found"));
        List<Book> books = author.getBooks();

        if (books.isEmpty()) {
            return 0;
        }

        for (Book book : books) {
            sum += book.getRating();
        }
        return sum / books.size();
    }

}
