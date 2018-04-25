package pl.piasecki.librarywebapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasecki.librarywebapplication.domain.Author;

/**
 * Created by Patrick on 25 kwi 2018
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
