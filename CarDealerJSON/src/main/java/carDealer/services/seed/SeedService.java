package carDealer.services.seed;

import java.io.IOException;

public interface SeedService {
    void seedCars() throws IOException;

    void seedParts() throws IOException;

    void seedCustomers() throws IOException;

    void seedSuppliers() throws IOException;

    void seedSales() throws IOException;


    default void seedAll() throws IOException {
        seedSuppliers();
        seedParts();
        seedCars();
        seedCustomers();
        seedSales();
    }
}
