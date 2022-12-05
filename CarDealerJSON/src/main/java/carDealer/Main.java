package carDealer;

import carDealer.services.cars.CarService;
import carDealer.services.customers.CustomerService;
import carDealer.services.sales.SaleService;
import carDealer.services.seed.SeedService;
import carDealer.services.suppliers.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {
    private final SeedService seedService;
    private final CustomerService customerService;
    private final CarService carService;
    private final SupplierService supplierService;
    private final SaleService saleService;
    private final Scanner scanner;

    @Autowired
    public Main(SeedService seedService, CustomerService customerService, CarService carService, SupplierService supplierService, SaleService saleService, Scanner scanner) {
        this.seedService = seedService;
        this.customerService = customerService;
        this.carService = carService;
        this.supplierService = supplierService;
        this.saleService = saleService;
        this.scanner = scanner;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sit and relax until all data is seeded to Database!");
        Thread.sleep(2000);

        this.seedService.seedSuppliers();
        Thread.sleep(2000);
        this.seedService.seedParts();
        Thread.sleep(2000);
        this.seedService.seedCars();
        Thread.sleep(2000);
        this.seedService.seedCustomers();
        Thread.sleep(2000);
        this.seedService.seedSales();

        System.out.println("Please, enter the number of task to be performed:");
        System.out.println("        =================================================");
        System.out.println("        = Enter 1 for 01. Ordered Customers             =");
        System.out.println("        = Enter 2 for 02. Cars from Make Toyota         =");
        System.out.println("        = Enter 3 for 03. Local Suppliers               =");
        System.out.println("        = Enter 4 for 04. Cars with Their List of Parts =");
        System.out.println("        = Enter 5 for 05. Total Sales by Customer       =");
        System.out.println("        = Enter 6 for 06. Sales With Applied Discount   =");
        System.out.println("        =================================================");
        System.out.print("      Enter your choice here: ");

        String input = scanner.nextLine();

        switch (input) {
            case "1" -> this.customerService.findAllOrderByBirthDateAsc();
            case "2" -> this.carService.FindAllByMakeOrOrderByModelAscTravelledDistanceDesc("Toyota");
            case "3" -> this.supplierService.getLocalSuppliers();
            case "4" -> this.carService.findAllCarsAndParts();
            case "5" -> this.saleService.getSalesByCustomer();
            case "6" -> this.saleService.getSalesWithDiscount();
            default -> System.out.println("Invalid input");
        }



    }
}
