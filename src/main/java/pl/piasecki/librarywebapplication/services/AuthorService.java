package pl.piasecki.librarywebapplication.services;

import org.springframework.stereotype.Service;
import pl.piasecki.librarywebapplication.DTOs.mapper.AuthorMapper;
import pl.piasecki.librarywebapplication.DTOs.model.AuthorDTO;
import pl.piasecki.librarywebapplication.DTOs.model.AuthorPureDTO;
import pl.piasecki.librarywebapplication.domain.Author;
import pl.piasecki.librarywebapplication.exceptions.NotFoundException;
import pl.piasecki.librarywebapplication.repositories.AuthorRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<AuthorDTO> getAuthors(){
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::authorToAuthorDTO)
                .collect(Collectors.toList());
    }

    public AuthorDTO getAuthorById(Long id){
        return authorRepository.findById(id)
                .map(authorMapper::authorToAuthorDTO)
                .orElseThrow(() -> new NotFoundException("Author (ID: " + id + ") Not Found"));
    }

    public AuthorPureDTO createAuthor(AuthorPureDTO authorPureDTO){
        Author author = authorMapper.authorPureDTOToAuthor(authorPureDTO);
        authorRepository.save(author);
        return authorMapper.authorToAuthorPureDTO(author);
    }

    public AuthorPureDTO updateAuthor(Long id, AuthorPureDTO authorPureDTO){
        Author author = authorMapper.authorPureDTOToAuthor(authorPureDTO);
        author.setId(id);
        authorRepository.save(author);
        return authorMapper.authorToAuthorPureDTO(author);
    }

    public void deleteAuthor(Long id){
        authorRepository.deleteById(id);
    }

}
