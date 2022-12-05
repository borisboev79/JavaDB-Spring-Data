package carDealer.repositories;

import carDealer.domain.entities.Part;
import carDealer.domain.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
    @Query(value = "SELECT * FROM car_dealer.parts ORDER BY RAND () LIMIT 1", nativeQuery = true)
    Optional<Part> getRandomEntity();
}
