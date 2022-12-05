package carDealer.services.customers;

import carDealer.domain.dtos.customers.AllCustomersByBirthdateDTO;
import carDealer.repositories.CustomerRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static carDealer.constants.Paths.ORDERED_CUSTOMERS_JSON_PATH;


@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, Gson gson) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public List<AllCustomersByBirthdateDTO> findAllOrderByBirthDateAsc() throws IOException {

        List<AllCustomersByBirthdateDTO> customers = this.customerRepository.findAllOrderByBirthDateAsc().orElseThrow()
                .stream()
                .map(customer -> modelMapper.map(customer, AllCustomersByBirthdateDTO.class)).toList();

        final FileWriter fileWriter = new FileWriter(ORDERED_CUSTOMERS_JSON_PATH.toFile());

        gson.toJson(customers, fileWriter);

        fileWriter.flush();
        fileWriter.close();

     //   writeJsonToFile(customers, ORDERED_CUSTOMERS_JSON_PATH);

        return customers;
    }
}
