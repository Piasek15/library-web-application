package pl.piasecki.librarywebapplication.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.piasecki.librarywebapplication.DTOs.model.AuthorDTO;
import pl.piasecki.librarywebapplication.DTOs.model.AuthorPureDTO;
import pl.piasecki.librarywebapplication.services.AuthorService;

import java.util.List;

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

    @GetMapping
    public List<AuthorDTO> getAuthors(){
        return authorService.getAuthors();
    }

    @GetMapping("/{id}")
    public AuthorDTO getAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorPureDTO createAuthor(@RequestBody AuthorPureDTO authorPureDTO){
        return authorService.createAuthor(authorPureDTO);
    }

    @PutMapping("/{id}")
    public AuthorPureDTO updateAuthor(@PathVariable Long id, @RequestBody AuthorPureDTO authorPureDTO){
        return authorService.updateAuthor(id, authorPureDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
    }
}
