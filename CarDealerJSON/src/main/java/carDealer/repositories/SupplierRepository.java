package carDealer.repositories;

import carDealer.domain.dtos.suppliers.LocalSupplierDTO;
import carDealer.domain.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query(value = "SELECT * FROM car_dealer.suppliers ORDER BY RAND () LIMIT 1", nativeQuery = true)
    Optional<Supplier> getRandomEntity();

    @Query(value = "SELECT new carDealer.domain.dtos.suppliers.LocalSupplierDTO(s.id, s.name, count(p.id)) FROM Supplier AS s JOIN s.parts AS p WHERE s.isImporter IS FALSE GROUP BY s.id")
    Optional<List<LocalSupplierDTO>> getLocalSuppliers();
}
