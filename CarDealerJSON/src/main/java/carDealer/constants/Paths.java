package carDealer.constants;

import java.nio.file.Path;

public enum Paths {
    ;
    public static final Path SUPPLIERS_JSON_PATH = Path.of("src", "main", "resources", "dbContent", "suppliers.json");
    public static final Path PARTS_JSON_PATH = Path.of("src", "main", "resources", "dbContent", "parts.json");
    public static final Path CARS_JSON_PATH = Path.of("src", "main", "resources", "dbContent", "cars.json");
    public static final Path CUSTOMERS_JSON_PATH = Path.of("src", "main", "resources", "dbContent", "customers.json");

    public static final Path ORDERED_CUSTOMERS_JSON_PATH = Path.of("src", "main", "resources", "output", "ordered-customers.json");
    public static final Path TOYOTA_CARS_JSON_PATH = Path.of("src", "main", "resources", "output", "toyota-cars.json");
    public static final Path LOCAL_SUPPLIERS_JSON_PATH = Path.of("src", "main", "resources", "output", "local-suppliers.json");
    public static final Path CARS_AND_PARTS_JSON_PATH = Path.of("src", "main", "resources", "output", "cars-and-parts.json");
    public static final Path CUSTOMERS_TOTAL_SALES_JSON_PATH = Path.of("src", "main", "resources", "output", "customers-total-sales.json");
    public static final Path SALES_DISCOUNTS_JSON_PATH = Path.of("src", "main", "resources", "output", "sales-discounts.json");

}
