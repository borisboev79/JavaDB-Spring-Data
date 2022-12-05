package carDealer.domain.dtos.sales;

import carDealer.domain.entities.Car;
import carDealer.domain.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


public class SaleImportDTO {

    private Customer customer;
    private Car car;
    private BigDecimal discount;

    public SaleImportDTO(){}

    public SaleImportDTO(Customer customer, Car car, BigDecimal discount) {
        this.customer = customer;
        this.car = car;
        setDiscount(discount);
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setDiscount(BigDecimal discount) {

        if (this.getCustomer().isYoungDriver()) {
            this.discount = discount.add(BigDecimal.valueOf(0.05));
        } else {
            this.discount = discount;
        }
    }

}
