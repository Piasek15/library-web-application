package pl.piasecki.librarywebapplication.DTOs.model;

import lombok.Data;

import java.util.Set;

/**
 * Created by Patrick on 25 kwi 2018
 */
@Data
public class BookDTO {
    private String title;
    private String category;
    private Integer pages;
    private Set<AuthorPureDTO> authors;
}
