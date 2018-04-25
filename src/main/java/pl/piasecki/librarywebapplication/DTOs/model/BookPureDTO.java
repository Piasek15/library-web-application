package pl.piasecki.librarywebapplication.DTOs.model;

import lombok.Data;

/**
 * Created by Patrick on 25 kwi 2018
 */
@Data
public class BookPureDTO {
    private String title;
    private String category;
    private Integer pages;
}
