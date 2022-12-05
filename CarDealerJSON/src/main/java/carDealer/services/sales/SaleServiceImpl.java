package carDealer.services.sales;

import carDealer.config.CustomMapper;
import carDealer.domain.dtos.sales.SaleDetailsDTO;
import carDealer.domain.dtos.sales.SalesByCustomerDTO;
import carDealer.domain.entities.Car;
import carDealer.domain.entities.Customer;
import carDealer.repositories.SaleRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static carDealer.constants.Paths.CUSTOMERS_TOTAL_SALES_JSON_PATH;
import static carDealer.constants.Paths.SALES_DISCOUNTS_JSON_PATH;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, ModelMapper modelMapper, Gson gson) {
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }
    @Override
    @Transactional
    public List<SalesByCustomerDTO> getSalesByCustomer() throws IOException {
        List<SalesByCustomerDTO> sales = this.saleRepository.getSalesByCustomer()
                .orElseThrow(NoSuchElementException::new);

        final FileWriter fileWriter = new FileWriter(CUSTOMERS_TOTAL_SALES_JSON_PATH.toFile());

        gson.toJson(sales, fileWriter);

        fileWriter.flush();
        fileWriter.close();

        //     writeJsonToFile(sales, CUSTOMERS_TOTAL_SALES_JSON_PATH);

        return sales;
    }

    @Override
    @Transactional
    public List<SaleDetailsDTO> getSalesWithDiscount() throws IOException {
        List<SaleDetailsDTO> sales = saleRepository
                .findAll()
                .stream()
                .map(CustomMapper::saleToSaleDetails)
                .toList();

        final FileWriter fileWriter = new FileWriter(SALES_DISCOUNTS_JSON_PATH.toFile());

        gson.toJson(sales, fileWriter);

        fileWriter.flush();
        fileWriter.close();

        //     writeJsonToFile(sales, CUSTOMERS_TOTAL_SALES_JSON_PATH);

        return sales;
    }

    @Override
    public void save(Car car, Customer customer, BigDecimal discount) {

    }

}
