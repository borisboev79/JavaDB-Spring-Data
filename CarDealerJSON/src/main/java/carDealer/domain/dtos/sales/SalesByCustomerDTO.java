package carDealer.domain.dtos.sales;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalesByCustomerDTO implements Serializable {
    private String fullName;
    private Long boughtCars;
    private double spentMoney;
}
