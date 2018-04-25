package pl.piasecki.librarywebapplication.DTOs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.piasecki.librarywebapplication.DTOs.model.AuthorDTO;
import pl.piasecki.librarywebapplication.DTOs.model.AuthorPureDTO;
import pl.piasecki.librarywebapplication.domain.Author;

/**
 * Created by Patrick on 25 kwi 2018
 */
@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDTO authorToAuthorDTO(Author author);
    Author authorDTOToAuthor(AuthorDTO authorDTO);

    AuthorPureDTO authorToAuthorPureDTO(Author author);
    Author authorPureDTOToAuthor(AuthorPureDTO authorPureDTO);
}
