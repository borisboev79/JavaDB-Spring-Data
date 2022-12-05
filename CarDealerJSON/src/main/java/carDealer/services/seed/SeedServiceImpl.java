package carDealer.services.seed;

import carDealer.constants.Discounts;
import carDealer.domain.dtos.cars.CarImportDTO;
import carDealer.domain.dtos.customers.CustomerImportDTO;
import carDealer.domain.dtos.parts.PartImportDTO;
import carDealer.domain.dtos.sales.SaleImportDTO;
import carDealer.domain.dtos.suppliers.SupplierImportDTO;
import carDealer.domain.entities.*;
import carDealer.repositories.*;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.LongStream;

import static carDealer.constants.Paths.*;

@Service
public class SeedServiceImpl implements SeedService {
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;
    private final SaleRepository saleRepository;

    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public SeedServiceImpl(CarRepository carRepository, CustomerRepository customerRepository, PartRepository partRepository, SupplierRepository supplierRepository, SaleRepository saleRepository, ModelMapper modelMapper, Gson gson) {
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
        this.saleRepository = saleRepository;

        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedSuppliers() throws IOException {
        if (checkCount(this.supplierRepository)) {
            final FileReader fileReader = new FileReader(SUPPLIERS_JSON_PATH.toFile());

            final List<Supplier> suppliers = Arrays.stream(gson.fromJson(fileReader, SupplierImportDTO[].class))
                    .map(supplierImportDTO -> modelMapper
                            .map(supplierImportDTO, Supplier.class))
                    .toList();

            this.supplierRepository.saveAllAndFlush(suppliers);
            fileReader.close();
        }
    }


    @Override
    @Transactional
    public void seedParts() throws IOException {
        if (checkCount(this.partRepository)) {
            final FileReader fileReader = new FileReader(PARTS_JSON_PATH.toFile());

            final List<Part> parts = Arrays.stream(gson.fromJson(fileReader, PartImportDTO[].class))
                    .map(partImportDTO -> modelMapper
                            .map(partImportDTO, Part.class))
                    .map(this::setRandomSupplier)
                    .toList();

            this.partRepository.saveAllAndFlush(parts);
            fileReader.close();
        }
    }

    @Override
    @Transactional
    public void seedCars() throws IOException {
        if (checkCount(this.carRepository)) {
            final FileReader fileReader = new FileReader(CARS_JSON_PATH.toFile());

            final List<Car> cars = Arrays.stream(gson.fromJson(fileReader, CarImportDTO[].class))
                    .map(carImportDTO -> modelMapper
                            .map(carImportDTO, Car.class))
                    .map(this::setRandomParts)
                    .toList();

            this.carRepository.saveAllAndFlush(cars);
            fileReader.close();
        }
    }


    @Override
    public void seedCustomers() throws IOException {
        if (checkCount(this.customerRepository)) {
            final FileReader fileReader = new FileReader(CUSTOMERS_JSON_PATH.toFile());

            final List<Customer> customers = Arrays.stream(gson.fromJson(fileReader, CustomerImportDTO[].class))
                    .map(customerImportDTO -> modelMapper
                            .map(customerImportDTO, Customer.class))
                    .toList();

            this.customerRepository.saveAllAndFlush(customers);
            fileReader.close();
        }
    }

    @Override
    @Transactional
    public void seedSales() {

        if (checkCount(this.saleRepository)) {
            int totalSales = getRandomNumber(20, (int) carRepository.count());
            List<Sale> sales = new ArrayList<>();
            for (int i = 0; i < totalSales; i++) {
                SaleImportDTO saleImportDTO = new SaleImportDTO(setRandomCustomer(), setRandomCar(), setRandomDiscount());
                sales.add(modelMapper.map(saleImportDTO, Sale.class));
            }

            this.saleRepository.saveAllAndFlush(sales);

        }
    }

    private Customer setRandomCustomer() {
        return this.customerRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
    }

    private Car setRandomCar() {
        return this.carRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
    }

    private BigDecimal setRandomDiscount() {
        return Discounts.getRandomDiscount().discountValue;
    }


    private boolean checkCount(JpaRepository<?, Long> repository) {
        return repository.count() == 0;
    }

    private Part setRandomSupplier(Part part) {
        final Supplier supplier = this.supplierRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
        part.setSupplier(supplier);

        return part;
    }

    private Car setRandomParts(Car car) {
        Set<Part> parts = new HashSet<>();

        final int randomNum = getRandomNumber(3, 6);

        LongStream.range(0, randomNum)
                .forEach(number -> {
                    Part part = this.partRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);

                    while (parts.contains(part)) {
                        part = this.partRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
                    }

                    parts.add(part);
                });

       /* for (int i = 0; i < randomNum; i++) {
            final Part part = this.partRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
            parts.add(part);
        }*/

        car.setParts(parts);

        return car;
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


}
