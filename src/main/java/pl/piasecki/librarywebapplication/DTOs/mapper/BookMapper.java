package pl.piasecki.librarywebapplication.DTOs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.piasecki.librarywebapplication.DTOs.model.BookDTO;
import pl.piasecki.librarywebapplication.DTOs.model.BookPureDTO;
import pl.piasecki.librarywebapplication.domain.Book;

/**
 * Created by Patrick on 25 kwi 2018
 */
@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO bookToBookDTO(Book book);
    Book bookDTOToBook(BookDTO bookDTO);

    BookPureDTO bookToBookPureDTO(Book book);
    Book bookPureDTOToBook(BookPureDTO bookPureDTO);
}
