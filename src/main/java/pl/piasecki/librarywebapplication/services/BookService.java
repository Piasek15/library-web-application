package pl.piasecki.librarywebapplication.services;

import org.springframework.stereotype.Service;
import pl.piasecki.librarywebapplication.DTOs.mapper.BookMapper;
import pl.piasecki.librarywebapplication.repositories.BookRepository;

/**
 * Created by Patrick on 25 kwi 2018
 */
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

}
