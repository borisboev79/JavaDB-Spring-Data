package bookStoreSystem.services.author;

import bookStoreSystem.domain.entities.Author;
import bookStoreSystem.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorsRepo;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authors) {
        this.authorsRepo = authors;
    }

    @Override
    public void seedAuthors(List<Author> authors) {
        this.authorsRepo.saveAll(authors);
    }

    @Override
    public boolean isDataSeeded() {
        return this.authorsRepo.count() > 0;
    }

    @Override
    public Author getRandomAuthor() {
        final long count = this.authorsRepo.count();
        if (count != 0) {
            final long randomAuthorId = new Random().nextLong(1L, count) + 1L;
            return this.authorsRepo.findAuthorById(randomAuthorId).orElseThrow(NoSuchElementException::new);
        }
        throw new RuntimeException();
    }

    @Override
    public List<Author> findAuthorByBooksBefore(LocalDate date) {
        return this.authorsRepo.findDistinctByBooksReleaseDateBefore(date).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Author> countAuthorsByBooksOrderByBooksDesc() {
        return this.authorsRepo.countAuthorsByBooksOrderByBooksDesc().orElseThrow(NoSuchElementException::new);
    }


}
