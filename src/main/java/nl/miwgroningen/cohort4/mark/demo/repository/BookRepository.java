package nl.miwgroningen.cohort4.mark.demo.repository;

import nl.miwgroningen.cohort4.mark.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Author: Mark Amerkamp (markamerkamp@gmail.com)
 * <p>
 * Haal boeken uit en schrijf boeken naar de database.
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByTitle(String title);

}
