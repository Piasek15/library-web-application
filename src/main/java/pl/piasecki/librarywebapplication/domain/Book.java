package pl.piasecki.librarywebapplication.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Patrick on 25 kwi 2018
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String category;
    private Integer pages;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();
}
