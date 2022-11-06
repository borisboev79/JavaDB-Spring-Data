package bookStoreSystem.services.author;

import bookStoreSystem.domain.entities.Author;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
    void seedAuthors(List<Author> authors);

    boolean isDataSeeded();

    Author getRandomAuthor();

   List<Author> findAuthorByBooksBefore(LocalDate date);

    List<Author> countAuthorsByBooksOrderByBooksDesc();

}