package pl.piasecki.librarywebapplication.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.piasecki.librarywebapplication.DTOs.model.BookDTO;
import pl.piasecki.librarywebapplication.DTOs.model.BookPureDTO;
import pl.piasecki.librarywebapplication.services.BookService;

import java.util.Arrays;
import java.util.List;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.piasecki.librarywebapplication.controllers.AbstractRestControllerTest.asJsonString;

/**
 * Created by Patrick on 27 kwi 2018
 */
public class BookControllerTest {
    private static final String TITLE = "LOTR";
    private static final String CATEGORY = "AAA";
    private static final Integer PAGES = 111;
    private static final long ID = 1L;

    @Mock
    BookService bookService;

    @InjectMocks
    BookController bookController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void getBooks() throws Exception {
        List<BookDTO> bookDTOS = Arrays.asList(new BookDTO(), new BookDTO());
        when(bookService.getBooks()).thenReturn(bookDTOS);

        mockMvc.perform(get("/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void getBookById() throws Exception {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle(TITLE);

        when(bookService.getBookById(anyLong())).thenReturn(bookDTO);

        mockMvc.perform(get("/books/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", equalTo(TITLE)));
    }

    @Test
    public void createBook() throws Exception {
        BookPureDTO bookPureDTO = new BookPureDTO();
        bookPureDTO.setTitle(TITLE);

        BookPureDTO savedDTO = new BookPureDTO();
        savedDTO.setTitle(bookPureDTO.getTitle());

        when(bookService.createBook(bookPureDTO)).thenReturn(savedDTO);

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(savedDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", equalTo(TITLE)));
    }

    @Test
    public void deleteBook() throws Exception {
        mockMvc.perform(delete("/books/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(bookService).deleteBook(1L);
    }
}