package carDealer.domain.dtos.suppliers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierImportDTO {

    private String name;

    private boolean isImporter;

}
