package carDealer.domain.dtos.cars;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarImportDTO {

    private String make;

    private String model;

    private Long TravelledDistance;
}
