package bookStoreSystem.services.book;

import bookStoreSystem.domain.entities.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookService {
    void seedBooks(List<Book> books);

    boolean isDataSeeded();

    List<Book> findAllBookByReleaseDateAfter(LocalDate localDate) throws NoSuchFieldException;

    List<Book> countBookByAuthor();

}
