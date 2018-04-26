package pl.piasecki.librarywebapplication.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.piasecki.librarywebapplication.DTOs.mapper.BookMapper;
import pl.piasecki.librarywebapplication.DTOs.model.BookDTO;
import pl.piasecki.librarywebapplication.DTOs.model.BookPureDTO;
import pl.piasecki.librarywebapplication.domain.Book;
import pl.piasecki.librarywebapplication.repositories.AuthorRepository;
import pl.piasecki.librarywebapplication.repositories.BookRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Patrick on 25 kwi 2018
 */
public class BookServiceTest {
    private static final String TITLE = "LOTR";
    private static final String CATEGORY = "AAA";
    private static final Integer PAGES = 111;
    private static final long ID = 1L;


    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Mock
    AuthorRepository authorRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        bookService = new BookService(bookRepository, authorRepository, BookMapper.INSTANCE);
    }

    @Test
    public void getBooks() {
        List<Book> books = Arrays.asList(new Book(), new Book());
        when(bookRepository.findAll()).thenReturn(books);

        List<BookDTO> bookDTOS = bookService.getBooks();

        assertEquals(2, bookDTOS.size());
    }

    @Test
    public void getBookById() {
        Book book = new Book.Builder(TITLE)
                .id(ID)
                .pages(PAGES)
                .category(CATEGORY)
                .build();

        when(bookRepository.findById(anyLong())).thenReturn(Optional.ofNullable(book));

        BookDTO bookDTO = bookService.getBookById(ID);

        assertEquals(TITLE, bookDTO.getTitle());
        assertEquals(PAGES, bookDTO.getPages());
    }


    @Test
    public void createBook() {
        BookPureDTO bookPureDTO = new BookPureDTO();
        bookPureDTO.setTitle(TITLE);

        Book book = new Book.Builder(bookPureDTO.getTitle()).build();

        when(bookRepository.save(any(Book.class))).thenReturn(book);

        BookPureDTO savedDTO = bookService.createBook(bookPureDTO);

        assertEquals(bookPureDTO.getTitle(), savedDTO.getTitle());
    }

    @Test
    public void updateBook() {
        BookPureDTO bookPureDTO = new BookPureDTO();
        bookPureDTO.setTitle(TITLE);

        Book book = new Book.Builder(bookPureDTO.getTitle()).build();

        when(bookRepository.save(any(Book.class))).thenReturn(book);

        BookPureDTO savedDTO = bookService.updateBook(anyLong(), bookPureDTO);

        assertEquals(TITLE, savedDTO.getTitle());
    }

    @Test
    public void deleteBook() {
        bookService.deleteBook(ID);

        verify(bookRepository, times(1)).deleteById(anyLong());
    }
}