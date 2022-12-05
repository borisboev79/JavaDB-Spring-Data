package carDealer.repositories;

import carDealer.domain.dtos.customers.AllCustomersByBirthdateDTO;
import carDealer.domain.entities.Customer;
import carDealer.domain.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM car_dealer.customers ORDER BY RAND () LIMIT 1", nativeQuery = true)
  Optional<Customer> getRandomEntity();

    @Query("SELECT c FROM Customer c ORDER BY c.birthDate")
    Optional<List<Customer>> findAllOrderByBirthDateAsc();

}
