package com.example.events.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventRequest {

    @NotBlank(message = "El nombre del evento es obligatorio")
    @Size(max = 120, message = "El nombre del evento no puede superar 120 caracteres")
    private String name;

    @NotBlank(message = "La categoría es obligatoria")
    @Size(max = 60, message = "La categoría no puede superar 60 caracteres")
    private String category;

    @NotNull(message = "La fecha de inicio es obligatoria")
    @Future(message = "La fecha de inicio debe ser en el futuro")
    private LocalDateTime startDate;

    @Future(message = "La fecha de fin debe ser en el futuro")
    private LocalDateTime endDate;

    @NotNull(message = "El venueId es obligatorio")
    private Long venueId;
}
