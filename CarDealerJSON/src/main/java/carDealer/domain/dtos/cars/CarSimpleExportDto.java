package carDealer.domain.dtos.cars;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarSimpleExportDto {
    private String make;
    private String model;
    private Long travelledDistance;
}