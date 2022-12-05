package carDealer.services.cars;

import carDealer.domain.dtos.cars.CarToyotaDto;
import carDealer.domain.dtos.cars.CarsAndPartsDTO;
import carDealer.repositories.CarRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static carDealer.constants.Paths.CARS_AND_PARTS_JSON_PATH;
import static carDealer.constants.Paths.TOYOTA_CARS_JSON_PATH;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, Gson gson) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public List<CarToyotaDto> FindAllByMakeOrOrderByModelAscTravelledDistanceDesc(String make) throws IOException {

            List<CarToyotaDto> cars = this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc(make).orElseThrow()
                    .stream()
                    .map(customer -> modelMapper.map(customer, CarToyotaDto.class)).toList();

            final FileWriter fileWriter = new FileWriter(TOYOTA_CARS_JSON_PATH.toFile());

            gson.toJson(cars, fileWriter);

            fileWriter.flush();
            fileWriter.close();

          //     writeJsonToFile(cars, TOYOTA_CARS_JSON_PATH);

            return cars;
    }

    @Override
    @Transactional
    public List<CarsAndPartsDTO> findAllCarsAndParts() throws IOException {
        List<CarsAndPartsDTO> cars = this.carRepository.findAll()
                .stream()
                .map(car -> modelMapper.map(car, CarsAndPartsDTO.class)).toList();

        final FileWriter fileWriter = new FileWriter(CARS_AND_PARTS_JSON_PATH.toFile());

        gson.toJson(cars, fileWriter);

        fileWriter.flush();
        fileWriter.close();

        //     writeJsonToFile(cars, CARS_AND_PARTS_JSON_PATH);

        return cars;
    }

}
