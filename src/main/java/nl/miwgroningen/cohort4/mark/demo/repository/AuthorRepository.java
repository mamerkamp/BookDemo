package nl.miwgroningen.cohort4.mark.demo.repository;

import nl.miwgroningen.cohort4.mark.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Mark Amerkamp (markamerkamp@gmail.com)
 * <p>
 * Beschrijving:
 */
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
