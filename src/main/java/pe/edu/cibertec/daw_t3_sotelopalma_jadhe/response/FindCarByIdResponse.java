package pe.edu.cibertec.daw_t3_sotelopalma_jadhe.response;

import pe.edu.cibertec.daw_t3_sotelopalma_jadhe.dto.CarDetailDto;

public record FindCarByIdResponse(String code,
                                  String error,
                                  CarDetailDto car) {
}
