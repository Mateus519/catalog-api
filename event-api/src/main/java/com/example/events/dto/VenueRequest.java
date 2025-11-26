package com.example.events.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VenueRequest {

    @NotBlank(message = "El nombre del venue es obligatorio")
    @Size(max = 120, message = "El nombre del venue no puede superar 120 caracteres")
    private String name;

    @NotBlank(message = "La ciudad es obligatoria")
    @Size(max = 80, message = "La ciudad no puede superar 80 caracteres")
    private String city;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 200, message = "La dirección no puede superar 200 caracteres")
    private String address;

    @Min(value = 1, message = "La capacidad debe ser al menos 1")
    private Integer capacity;
}
