package bookStoreSystem;

import bookStoreSystem.services.author.AuthorService;
import bookStoreSystem.services.book.BookService;
import bookStoreSystem.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final LocalDate YEAR_AFTER = LocalDate.of(2000,12, 31);
    private final LocalDate YEAR_BEFORE = LocalDate.of(1990,1, 1);


    private final SeedService seedService;
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedAllData();
      //  this.getAllBooksAfter();
      //  this.findAuthorsWithBooksBefore();
       // this.orderAuthorsByBooks();
        this.countBooksByAuthor();
    }

    private void getAllBooksAfter() throws NoSuchFieldException {
        this.bookService.findAllBookByReleaseDateAfter(YEAR_AFTER)
                .forEach(book -> System.out.println(book.getTitle()));
    }

    private void findAuthorsWithBooksBefore(){
        this.authorService.findAuthorByBooksBefore(YEAR_BEFORE).forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));

    }

    private void orderAuthorsByBooks(){
        this.authorService
                .countAuthorsByBooksOrderByBooksDesc()
                .forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));
    }

    private void countBooksByAuthor(){
        this.bookService
                .countBookByAuthor();

        System.out.println();
    }

}
