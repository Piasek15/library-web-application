package pl.piasecki.librarywebapplication.services;

import org.springframework.stereotype.Service;
import pl.piasecki.librarywebapplication.DTOs.mapper.BookMapper;
import pl.piasecki.librarywebapplication.DTOs.model.BookDTO;
import pl.piasecki.librarywebapplication.DTOs.model.BookPureDTO;
import pl.piasecki.librarywebapplication.domain.Book;
import pl.piasecki.librarywebapplication.repositories.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<BookDTO> getBooks(){
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::bookToBookDTO)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id){
        return bookRepository.findById(id)
                .map(bookMapper::bookToBookDTO)
                .orElseThrow(RuntimeException::new); //todo exception handler
    }

    public BookPureDTO createBook(BookPureDTO bookPureDTO){
        Book book = bookMapper.bookPureDTOToBook(bookPureDTO);
        bookRepository.save(book);
        return bookMapper.bookToBookPureDTO(book);
    }

    public BookPureDTO updateBook(Long id, BookPureDTO bookPureDTO){
        Book book = bookMapper.bookPureDTOToBook(bookPureDTO);
        book.setId(id);
        bookRepository.save(book);
        return bookMapper.bookToBookPureDTO(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
