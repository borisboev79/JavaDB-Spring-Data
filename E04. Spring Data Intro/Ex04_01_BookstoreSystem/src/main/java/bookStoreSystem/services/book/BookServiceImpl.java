package bookStoreSystem.services.book;

import bookStoreSystem.domain.entities.Book;
import bookStoreSystem.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository books;

    @Autowired
    public BookServiceImpl(BookRepository books) {
        this.books = books;
    }

    @Override
    public void seedBooks(List<Book> books) {
        this.books.saveAll(books);
    }

    @Override
    public boolean isDataSeeded() {
        return this.books.count() > 0;
    }

    @Override
    public List<Book> findAllByReleaseDateAfter(LocalDate date) {
        return this.books.findAllByReleaseDateAfter(date).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName) {
        return this.books.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName)
                .orElseThrow(NoSuchElementException::new);
    }

}
