package pl.piasecki.librarywebapplication.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @ManyToMany(mappedBy = "books", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Author> authors;

    public void addAuthor(Author author){
        authors.add(author);
        author.getBooks().add(this);
    }

    public void removeAuthor(Author author){
        authors.remove(author);
        author.getBooks().remove(this);
    }

    private Book(final Builder builder){
        this.title = builder.title;
        this.category = builder.category;
        this.pages = builder.pages;
        this.id = builder.id;
    }

    public static class Builder{
        private final String title;
        private String category;
        private Integer pages;
        private Long id;

        public Builder(final String title){
            this.title = title;
        }

        public Builder category(String category){
            this.category = category;
            return this;
        }

        public Builder pages(Integer pages){
            this.pages = pages;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Book build(){
            return new Book(this);
        }
    }
}
