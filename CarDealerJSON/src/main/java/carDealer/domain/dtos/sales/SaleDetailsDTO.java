package carDealer.domain.dtos.sales;

import carDealer.domain.dtos.cars.CarSimpleExportDto;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDetailsDTO {
    private CarSimpleExportDto car;
    private String customerName;
    private BigDecimal discount;
    private BigDecimal price;
    private BigDecimal priceWithDiscount;
}
