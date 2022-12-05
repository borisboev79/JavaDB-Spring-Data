package carDealer.domain.dtos.cars;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarToyotaDto {
    private Long Id;
    private String Make;
    private String Model;
    private Long TravelledDistance;


}
