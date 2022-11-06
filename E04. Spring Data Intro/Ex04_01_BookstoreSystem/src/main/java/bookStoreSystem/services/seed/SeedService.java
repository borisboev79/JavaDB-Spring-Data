package bookStoreSystem.services.seed;

import java.io.IOException;

public interface SeedService {

    void seedAuthor() throws IOException;
    void seedBook() throws IOException;
    void seedCategory() throws IOException;

    default void seedAllData() throws IOException {
        seedAuthor();
        seedBook();
        seedCategory();
    }
}
