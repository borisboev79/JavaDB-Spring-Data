package carDealer.domain.dtos.cars;

import carDealer.domain.dtos.parts.PartsShortDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarsAndPartsDTO {
    private CarImportDTO car;
    private List<PartsShortDto> parts;


}
