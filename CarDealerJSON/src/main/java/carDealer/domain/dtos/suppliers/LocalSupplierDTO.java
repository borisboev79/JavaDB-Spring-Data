package carDealer.domain.dtos.suppliers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalSupplierDTO {
    private Long Id;
    private String Name;
    private Long partsCount;

}


