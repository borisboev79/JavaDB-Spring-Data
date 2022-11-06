package bookStoreSystem;

import bookStoreSystem.domain.entities.Book;
import bookStoreSystem.services.author.AuthorService;
import bookStoreSystem.services.book.BookService;
import bookStoreSystem.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final LocalDate YEAR_AFTER = LocalDate.of(2000, 12, 31);
    private final LocalDate YEAR_BEFORE = LocalDate.of(1990, 1, 1);


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

        // ******* SEED ALL DATA FROM THE FILES *******

        //  this.seedService.seedAllData();

        // ******* 1. Get all books after the year 2000. Print only their titles *******

        //  this.getAllBooksAfter();

        // ******* 2. Get all authors with at least one book with release date before 1990.
        //         Print their first name and last name. ********

        // this.findAuthorsWithBooksBefore();

        // ******* 3.	Get all authors, ordered by the number of their books (descending).
        //         Print their first name, last name and book count. *******

        //this.orderAuthorsByNumberOfBooks();

        // ******* 4.	Get all books from author George Powell, ordered by their release date (descending),
        //         then by book title (ascending). Print the book's title, release date and copies. *******

        this.findAllBooksByAuthor();


    }


    private void getAllBooksAfter() throws NoSuchFieldException {
        this.bookService.findAllByReleaseDateAfter(YEAR_AFTER)
                .forEach(book -> System.out.println(book.getTitle()));
    }

    private void findAuthorsWithBooksBefore() {
        this.authorService.findDistinctAuthorByBooksBefore(YEAR_BEFORE).forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));

    }

    private void findAllBooksByAuthor() {

        String[] authorsName = new Scanner(System.in).nextLine().split("\\s+");
        String firstName = authorsName[0];
        String lastName = authorsName[1];
        List<Book> books = this.bookService
                .findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName);

        System.out.printf("Author %s %s has published %d books:%n", firstName, lastName, books.size());

        books.forEach(book -> System.out.println(book.getTitle() + " "
                + book.getReleaseDate() + " "
                + book.getCopies()));
    }

    private void orderAuthorsByNumberOfBooks(){
        this.authorService
                .findAllOrderByBooks()
                .forEach(author -> System.out.println(author.toStringWithCount()));;
    }

}

