package pl.piasecki.librarywebapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasecki.librarywebapplication.domain.Book;

/**
 * Created by Patrick on 25 kwi 2018
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
