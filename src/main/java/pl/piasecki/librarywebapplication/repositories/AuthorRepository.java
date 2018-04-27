package pl.piasecki.librarywebapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasecki.librarywebapplication.domain.Author;

import java.util.List;

/**
 * Created by Patrick on 25 kwi 2018
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByOrderByLastNameAsc();
}
