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
    public List<Book> findAllBookByReleaseDateAfter(LocalDate date) throws NoSuchFieldException {
        return this.books.findAllBookByReleaseDateAfter(date).orElseThrow(NoSuchFieldException::new);
    }

    @Override
    public List<Book> countBookByAuthor() {
        return this.books.countBookByAuthor().orElseThrow(NoSuchElementException::new);
    }

}
