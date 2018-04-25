package pl.piasecki.librarywebapplication.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piasecki.librarywebapplication.services.BookService;

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
}
