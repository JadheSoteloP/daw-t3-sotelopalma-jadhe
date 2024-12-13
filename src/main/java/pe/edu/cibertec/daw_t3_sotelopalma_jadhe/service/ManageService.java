package pe.edu.cibertec.daw_t3_sotelopalma_jadhe.service;

import pe.edu.cibertec.daw_t3_sotelopalma_jadhe.dto.CarDetailDto;
import pe.edu.cibertec.daw_t3_sotelopalma_jadhe.dto.CarDto;
import pe.edu.cibertec.daw_t3_sotelopalma_jadhe.dto.CarUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto> getAllCars() throws Exception;

    Optional<CarDto> getAllCarsById(int carId) throws Exception;

    Optional<CarDetailDto> getCarById(int carId) throws Exception;

    boolean updateCar(CarUpdateDto carUpdateDto) throws Exception;

    boolean deleteCarById(int carId) throws Exception;

    boolean addCar(CarDetailDto carDetailDto) throws Exception;
}
