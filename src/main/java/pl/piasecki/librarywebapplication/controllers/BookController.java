package pl.piasecki.librarywebapplication.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.piasecki.librarywebapplication.DTOs.model.BookDTO;
import pl.piasecki.librarywebapplication.DTOs.model.BookPureDTO;
import pl.piasecki.librarywebapplication.services.BookService;

import java.util.List;

/**
 * Created by Patrick on 25 kwi 2018
 */
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDTO> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookPureDTO createBook(@RequestBody BookPureDTO bookPureDTO){
        return bookService.createBook(bookPureDTO);
    }

    @PutMapping("/{id}")
    public BookPureDTO updateBook(@PathVariable Long id, @RequestBody BookPureDTO bookPureDTO){
        return bookService.updateBook(id, bookPureDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

    @PutMapping("/{bookId}/authors/{authorId}")
    public BookDTO addAuthorToBook(@PathVariable Long authorId, @PathVariable Long bookId){
        return bookService.addAuthorToBook(authorId, bookId);
    }

    @DeleteMapping("/{bookId}/authors/{authorId}")
    public BookDTO removeAuthorFromBook(@PathVariable Long authorId, @PathVariable Long bookId){
        return bookService.removeAuthorFromBook(authorId, bookId);
    }
}
