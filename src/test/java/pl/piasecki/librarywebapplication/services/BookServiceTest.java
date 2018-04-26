package pl.piasecki.librarywebapplication.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.piasecki.librarywebapplication.DTOs.mapper.BookMapper;
import pl.piasecki.librarywebapplication.DTOs.model.BookDTO;
import pl.piasecki.librarywebapplication.domain.Book;
import pl.piasecki.librarywebapplication.repositories.BookRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Patrick on 25 kwi 2018
 */
public class BookServiceTest {
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        bookService = new BookService(bookRepository, BookMapper.INSTANCE);
    }

    @Test
    public void getBooks() {
        List<Book> books = Arrays.asList(new Book(), new Book());
        when(bookRepository.findAll()).thenReturn(books);

        List<BookDTO> bookDTOS = bookService.getBooks();

        assertEquals(2, bookDTOS.size());
    }


}