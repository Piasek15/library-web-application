package pl.piasecki.librarywebapplication.services;

import org.springframework.stereotype.Service;
import pl.piasecki.librarywebapplication.DTOs.mapper.BookMapper;
import pl.piasecki.librarywebapplication.DTOs.model.BookDTO;
import pl.piasecki.librarywebapplication.DTOs.model.BookPureDTO;
import pl.piasecki.librarywebapplication.domain.Author;
import pl.piasecki.librarywebapplication.domain.Book;
import pl.piasecki.librarywebapplication.exceptions.NotFoundException;
import pl.piasecki.librarywebapplication.repositories.AuthorRepository;
import pl.piasecki.librarywebapplication.repositories.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Patrick on 25 kwi 2018
 */
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
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
                .orElseThrow(() -> new NotFoundException("Book (ID: " + id + ") Not Found"));
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

    public BookDTO addAuthorToBook(Long authorId, Long bookId){
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new NotFoundException("Author (ID: " + authorId + ") Not Found"));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("Book (ID: " + bookId + ") Not Found"));

        book.addAuthor(author);
        bookRepository.save(book);

        return bookMapper.bookToBookDTO(book);
    }

    public BookDTO removeAuthorFromBook(Long authorId, Long bookId){
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new NotFoundException("Author (ID: " + authorId + ") Not Found"));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("Book (ID: " + bookId + ") Not Found"));

        book.removeAuthor(author);
        bookRepository.save(book);

        return bookMapper.bookToBookDTO(book);
    }

    public List<BookDTO> findAllByCategoryIgnoreCase(String category){
        return bookRepository.findAllByCategoryIgnoreCase(category)
                .stream()
                .map(bookMapper::bookToBookDTO)
                .collect(Collectors.toList());
    }
}
