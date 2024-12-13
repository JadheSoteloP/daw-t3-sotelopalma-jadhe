package pe.edu.cibertec.daw_t3_sotelopalma_jadhe.dto;

public record CarUpdateDto(Integer carId,
                           String make,
                           String model,
                           Integer year,
                           String color) {
}
