package bookStoreSystem.repositories;

import bookStoreSystem.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<List<Book>> findAllBookByReleaseDateAfter(LocalDate localDate);

    Optional<List<Book>> countBookByAuthor();

}
