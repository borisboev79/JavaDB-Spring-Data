package carDealer.services.sales;


import carDealer.domain.dtos.sales.SaleDetailsDTO;
import carDealer.domain.dtos.sales.SalesByCustomerDTO;
import carDealer.domain.entities.Car;
import carDealer.domain.entities.Customer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface SaleService {
    List<SalesByCustomerDTO> getSalesByCustomer() throws IOException;

    void save(Car car, Customer customer, BigDecimal discount);

    List<SaleDetailsDTO> getSalesWithDiscount() throws IOException;
}
