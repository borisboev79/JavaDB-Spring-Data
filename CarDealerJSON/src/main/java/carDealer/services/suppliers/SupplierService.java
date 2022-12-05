package carDealer.services.suppliers;

import carDealer.domain.dtos.suppliers.LocalSupplierDTO;

import java.io.IOException;
import java.util.List;

public interface SupplierService {

    List<LocalSupplierDTO> getLocalSuppliers() throws IOException;
}
