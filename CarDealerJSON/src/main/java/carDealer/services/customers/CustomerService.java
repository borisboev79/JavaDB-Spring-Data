package carDealer.services.customers;

import carDealer.domain.dtos.customers.AllCustomersByBirthdateDTO;

import java.io.IOException;
import java.util.List;

public interface CustomerService {
    List<AllCustomersByBirthdateDTO> findAllOrderByBirthDateAsc() throws IOException;

}
