package pe.edu.cibertec.daw_t3_sotelopalma_jadhe.response;

import pe.edu.cibertec.daw_t3_sotelopalma_jadhe.dto.CarDto;

public record FindCarsResponse(String code,
                               String error,
                               Iterable<CarDto> cars) {
}
