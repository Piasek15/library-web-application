package pl.piasecki.librarywebapplication.DTOs.model;

import lombok.Data;

import java.util.Set;

/**
 * Created by Patrick on 25 kwi 2018
 */
@Data
public class AuthorDTO {
    private String firstName;
    private String lastName;
    private Set<BookPureDTO> books;
}
