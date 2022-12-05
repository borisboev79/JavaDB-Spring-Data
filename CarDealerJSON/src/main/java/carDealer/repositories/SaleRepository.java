package carDealer.repositories;

import carDealer.domain.dtos.sales.SalesByCustomerDTO;
import carDealer.domain.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Query("SELECT new carDealer.domain.dtos.sales.SalesByCustomerDTO(c.name, count(DISTINCT (car.id)), (sum(p.price) * (1 - (avg(s.discount))))) FROM Sale AS s JOIN s.customer AS c JOIN s.car AS car JOIN s.car.parts AS p GROUP BY s.customer.name")
    Optional<List<SalesByCustomerDTO>> getSalesByCustomer();

    //Native Query Can't make it work

    /*@Query(value = "SELECT c.name, count(distinct (car.id)) as count, (sum(p.price) * (1 - avg(s.discount))) AS total FROM car_dealer.customers AS c JOIN car_dealer.sales AS s on c.id = s.customer_id " +
            "JOIN car_dealer.cars AS car on car.id = s.car_id JOIN car_dealer.parts_cars AS pc ON pc.car_id = car.id JOIN car_dealer.parts AS p on pc.part_id = p.id GROUP BY c.name ORDER BY total DESC, count DESC;", nativeQuery = true)
    Optional<List<SalesByCustomerDTO>> getSalesByCustomer();*/


    List<Sale> findAll();



}

