package bookStoreSystem.repositories;

import bookStoreSystem.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findAuthorById(long randomAuthorId);

    Optional<List<Author>> findDistinctByBooksReleaseDateBefore(LocalDate date);

    @Query("Select a from Author AS a ORDER BY a.books.size DESC")
    Optional<List<Author>> findAllDistinctOrderByBooks();

}
