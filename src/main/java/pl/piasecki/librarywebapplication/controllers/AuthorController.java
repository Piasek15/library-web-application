package pl.piasecki.librarywebapplication.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piasecki.librarywebapplication.services.AuthorService;

/**
 * Created by Patrick on 25 kwi 2018
 */
@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
}
