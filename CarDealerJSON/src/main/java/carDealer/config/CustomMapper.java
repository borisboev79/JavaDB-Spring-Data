package carDealer.config;

import carDealer.domain.dtos.cars.CarSimpleExportDto;
import carDealer.domain.dtos.sales.SaleDetailsDTO;
import carDealer.domain.entities.Car;
import carDealer.domain.entities.Part;
import carDealer.domain.entities.Sale;

import java.math.BigDecimal;


public class CustomMapper {
    public static SaleDetailsDTO saleToSaleDetails(Sale sale) {
        return SaleDetailsDTO
                .builder()
                .customerName(sale.getCustomer().getName())
                .car(carToCarSimpleExportDto(sale.getCar()))
                .discount(sale.getDiscount())
                .price(sale.getCar().getParts().stream().map(Part::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add))
                .priceWithDiscount((sale.getCar().getParts().stream().map(Part::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add)).multiply(BigDecimal.ONE.subtract(sale.getDiscount())))
                .build();
    }

    private static CarSimpleExportDto carToCarSimpleExportDto(Car car) {
        return CarSimpleExportDto
                .builder()
                .make(car.getMake())
                .model(car.getModel())
                .travelledDistance(car.getTravelledDistance())
                .build();
    }
}
