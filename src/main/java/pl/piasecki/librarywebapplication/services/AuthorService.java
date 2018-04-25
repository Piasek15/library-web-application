package pl.piasecki.librarywebapplication.services;

import org.springframework.stereotype.Service;
import pl.piasecki.librarywebapplication.DTOs.mapper.AuthorMapper;
import pl.piasecki.librarywebapplication.repositories.AuthorRepository;

/**
 * Created by Patrick on 25 kwi 2018
 */
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

}
