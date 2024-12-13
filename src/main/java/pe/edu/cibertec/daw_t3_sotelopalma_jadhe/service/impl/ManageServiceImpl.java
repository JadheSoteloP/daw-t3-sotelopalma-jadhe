package pe.edu.cibertec.daw_t3_sotelopalma_jadhe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.daw_t3_sotelopalma_jadhe.dto.CarDetailDto;
import pe.edu.cibertec.daw_t3_sotelopalma_jadhe.dto.CarDto;
import pe.edu.cibertec.daw_t3_sotelopalma_jadhe.dto.CarUpdateDto;
import pe.edu.cibertec.daw_t3_sotelopalma_jadhe.entity.Car;
import pe.edu.cibertec.daw_t3_sotelopalma_jadhe.repository.CarRepository;
import pe.edu.cibertec.daw_t3_sotelopalma_jadhe.service.ManageService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;

    public List<CarDto> getAllCars() throws Exception {

        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            CarDto carDto = new CarDto(car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getYear());
            cars.add(carDto);
        });
        return cars;

    }

    @Override
    public Optional<CarDto> getAllCarsById(int carId) throws Exception {
        Optional<Car> optional = carRepository.findById(carId);
        return optional.map(car -> new CarDto(car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear()));
    }

    @Override
    public Optional<CarDetailDto> getCarById(int carId) throws Exception {
        Optional<Car> optional = carRepository.findById(carId);
        return optional.map(car -> new CarDetailDto(car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getPurchaseDate(),
                car.getMileage(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber(),
                car.getRegistrationExpirationDate(),
                car.getServiceDueDate()));
    }

    @Override
    public boolean updateCar(CarUpdateDto carUpdateDto) throws Exception {
        Optional<Car> optional = carRepository.findById(carUpdateDto.carId());
        return optional.map(car -> {
            car.setMake(carUpdateDto.make());
            car.setModel(carUpdateDto.model());
            car.setYear(carUpdateDto.year());
            car.setColor(carUpdateDto.color());
            carRepository.save(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean deleteCarById(int carId) throws Exception {
        Optional<Car> optional = carRepository.findById(carId);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean addCar(CarDetailDto carDetailDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDetailDto.carId());
        if (optional.isPresent())
            return false;
        else {
            Car car = new Car();
            car.setMake(carDetailDto.make());
            car.setModel(carDetailDto.model());
            car.setYear(carDetailDto.year());
            car.setVin(carDetailDto.vin());
            car.setLicensePlate(carDetailDto.licensePlate());
            car.setOwnerName(carDetailDto.ownerName());
            car.setOwnerContact(carDetailDto.ownerContact());
            car.setPurchaseDate(carDetailDto.purchaseDate());
            car.setMileage(carDetailDto.mileage());
            car.setEngineType(carDetailDto.engineType());
            car.setColor(carDetailDto.color());
            car.setInsuranceCompany(carDetailDto.insuranceCompany());
            car.setInsurancePolicyNumber(carDetailDto.insurancePolicyNumber());
            car.setRegistrationExpirationDate(new Date());
            car.setServiceDueDate(new Date());
            carRepository.save(car);
            return true;
        }
    }
}
