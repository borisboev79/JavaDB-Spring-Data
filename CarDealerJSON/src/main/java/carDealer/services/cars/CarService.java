package carDealer.services.cars;

import carDealer.domain.dtos.cars.CarToyotaDto;
import carDealer.domain.dtos.cars.CarsAndPartsDTO;

import java.io.IOException;
import java.util.List;

public interface CarService {
    List<CarToyotaDto> FindAllByMakeOrOrderByModelAscTravelledDistanceDesc(String make) throws IOException;

    List<CarsAndPartsDTO> findAllCarsAndParts() throws IOException;

}
