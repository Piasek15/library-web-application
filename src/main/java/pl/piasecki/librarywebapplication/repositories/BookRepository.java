package pl.piasecki.librarywebapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasecki.librarywebapplication.domain.Book;

import java.util.List;

/**
 * Created by Patrick on 25 kwi 2018
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByCategoryIgnoreCase(String category);
}
