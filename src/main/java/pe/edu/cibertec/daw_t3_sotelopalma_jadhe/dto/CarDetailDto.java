package pe.edu.cibertec.daw_t3_sotelopalma_jadhe.dto;

import java.util.Date;

public record CarDetailDto(Integer carId,
        String make,
        String model,
        Integer year,
        String vin,
        String licensePlate,
        String ownerName,
        String ownerContact,
        String purchaseDate,
        Integer mileage,
        String engineType,
        String color,
        String insuranceCompany,
        String insurancePolicyNumber,
        Date registrationExpirationDate,
        Date serviceDueDate) {
}
