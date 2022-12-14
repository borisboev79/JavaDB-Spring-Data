package carDealer.repositories;

import carDealer.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    @Query(value = "SELECT * FROM car_dealer.cars ORDER BY RAND () LIMIT 1", nativeQuery = true)
    Optional<Car> getRandomEntity();

    Optional<List<Car>> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make);

    List<Car> findAll();
}
