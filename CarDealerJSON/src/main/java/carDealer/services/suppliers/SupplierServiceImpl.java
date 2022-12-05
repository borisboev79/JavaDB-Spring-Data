package carDealer.services.suppliers;

import carDealer.domain.dtos.suppliers.LocalSupplierDTO;
import carDealer.repositories.SupplierRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static carDealer.constants.Paths.LOCAL_SUPPLIERS_JSON_PATH;

@Service
public class SupplierServiceImpl implements SupplierService {
    private SupplierRepository supplierRepository;
    private ModelMapper modelMapper;
    private Gson gson;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, Gson gson) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }
    @Override
    @Transactional

        public List<LocalSupplierDTO> getLocalSuppliers() throws IOException {

            List<LocalSupplierDTO> suppliers = this.supplierRepository.getLocalSuppliers()
                    .orElseThrow(NoSuchElementException::new);

            final FileWriter fileWriter = new FileWriter(LOCAL_SUPPLIERS_JSON_PATH.toFile());

            gson.toJson(suppliers, fileWriter);

            fileWriter.flush();
            fileWriter.close();

            //     writeJsonToFile(suppliers, LOCAL_SUPPLIERS_JSON_PATH);

            return suppliers;
    }
}
