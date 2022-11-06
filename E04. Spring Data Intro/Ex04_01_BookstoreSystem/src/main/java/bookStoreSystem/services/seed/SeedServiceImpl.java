package bookStoreSystem.services.seed;

import bookStoreSystem.domain.entities.Author;
import bookStoreSystem.domain.entities.Book;
import bookStoreSystem.domain.entities.Category;
import bookStoreSystem.domain.enums.AgeRestriction;
import bookStoreSystem.domain.enums.EditionType;
import bookStoreSystem.services.author.AuthorService;
import bookStoreSystem.services.book.BookService;
import bookStoreSystem.services.category.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static bookStoreSystem.constants.FilePath.*;

@Service
public class SeedServiceImpl implements SeedService {
    private final CategoryService categoryService;
    private final BookService bookService;
    private final AuthorService authorService;

    public SeedServiceImpl(CategoryService categoryService, BookService bookService, AuthorService authorService) {
        this.categoryService = categoryService;
        this.bookService = bookService;
        this.authorService = authorService;
    }


    @Override
    public void seedAuthor() throws IOException {
        if (!this.authorService.isDataSeeded()) {

            this.authorService.seedAuthors(Files.readAllLines(Path.of(RESOURCE_URL + AUTHOR_FILENAME))
                    .stream()
                    .filter(s -> !s.isBlank())
                    .map(fullName -> Author.builder().firstName(fullName.split(" ")[0])
                            .lastName(fullName.split(" ")[1])
                            .build())
                    .collect(Collectors.toList()));

        }
    }

    @Override
    public void seedBook() throws IOException {
        if (!this.bookService.isDataSeeded()) {

            final List<Book> books = Files.readAllLines(Path.of(RESOURCE_URL + BOOK_FILENAME))
                    .stream()
                    .filter(s -> !s.isBlank())
                    .map(line -> {
                        String[] data = line.split("\\s+");

                        String title = Arrays.stream(data)
                                .skip(5)
                                .collect(Collectors.joining(" "));

                        return Book.builder()
                                .title(title)
                                .editionType(EditionType.values()[Integer.parseInt(data[0])])
                                .price(new BigDecimal(data[3]))
                                .releaseDate(LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy")))
                                .ageRestriction(AgeRestriction.values()[Integer.parseInt(data[4])])
                                .author(this.authorService.getRandomAuthor())
                                .categories(this.categoryService.getRandomCategories())
                                .copies(Integer.parseInt(data[2]))
                                .build()
                                ;
                    }).toList();

            this.bookService.seedBooks(books);
        }
    }

    @Override
    public void seedCategory() throws IOException {
        if (!this.categoryService.isDataSeeded()) {

            this.categoryService.seedCategories(Files.readAllLines(Path.of(RESOURCE_URL + CATEGORY_FILENAME))
                    .stream()
                    .filter(s -> !s.isBlank())
                    .map(name -> Category.builder()
                            .name(name)
                            .build())
                    .collect(Collectors.toList()));
        }

    }

}
