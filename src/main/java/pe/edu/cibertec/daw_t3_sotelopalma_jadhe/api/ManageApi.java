package pe.edu.cibertec.daw_t3_sotelopalma_jadhe.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.daw_t3_sotelopalma_jadhe.dto.CarDetailDto;
import pe.edu.cibertec.daw_t3_sotelopalma_jadhe.dto.CarDto;
import pe.edu.cibertec.daw_t3_sotelopalma_jadhe.dto.CarUpdateDto;
import pe.edu.cibertec.daw_t3_sotelopalma_jadhe.response.*;
import pe.edu.cibertec.daw_t3_sotelopalma_jadhe.service.ManageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manage-car")
public class ManageApi {

    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public FindCarsResponse findCars(@RequestParam(value = "carId", defaultValue = "0") String id) {

        try {
            if (Integer.parseInt(id) > 0) {
                Optional<CarDto> optional = manageService.getAllCarsById(Integer.parseInt(id));
                if (optional.isPresent()) {
                    CarDto carDto = optional.get();
                    return new FindCarsResponse("01", "", List.of(carDto));
                } else {
                    return new FindCarsResponse("02", "Car not found", null);
                }

            } else {
                List<CarDto> users = manageService.getAllCars();
                if (!users.isEmpty())
                    return new FindCarsResponse("01", "", users);
                else
                    return new FindCarsResponse("03", "Car list not found", users);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsResponse("99", "Service not found", null);

        }

    }

    @GetMapping("/detail")
    public FindCarByIdResponse findUserById(@RequestParam(value = "carId", defaultValue = "0") String id) {

        try {
            if (Integer.parseInt(id) > 0) {
                Optional<CarDetailDto> optional = manageService.getCarById(Integer.parseInt(id));
                if (optional.isPresent()) {
                    CarDetailDto carDetailDto = optional.get();
                    return new FindCarByIdResponse("01", "", carDetailDto);
                } else {
                    return new FindCarByIdResponse("02", "Car not found", null);
                }

            } else
                return new FindCarByIdResponse("03", "Parameter not found", null);

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarByIdResponse("99", "Service not found", null);

        }

    }

    @PostMapping("/update")
    public UpdateCarResponse updateUser(@RequestBody CarUpdateDto carUpdateDto) {

        try {
            if (manageService.updateCar(carUpdateDto)) {
                return new UpdateCarResponse("01", "");
            } else {
                return new UpdateCarResponse("02", "Car not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "Service not found");

        }

    }

    @PostMapping("/delete")
    public DeleteCarResponse deleteCar(@RequestParam("carId") int carId) {
        try {
            boolean deleted = manageService.deleteCarById(carId);
            if (deleted) {
                return new DeleteCarResponse("01", "");
            } else {
                return new DeleteCarResponse("02", "Car not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99", "Service not found");
        }
    }

    @PostMapping("/add")
    public AddCarResponse addCar(@RequestBody CarDetailDto carDetailDto) {
        try {
            boolean added = manageService.addCar(carDetailDto);
            if (added) {
                return new AddCarResponse("01", "");
            } else {
                return new AddCarResponse("02", "Car con ID ya existe");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AddCarResponse("99", "Service not found");
        }
    }




}//FIN
