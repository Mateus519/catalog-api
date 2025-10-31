package com.ansan.tickets.catalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Evento del catálogo")
public class EventDTO {
    @Schema(description = "Identificador del evento", example = "1")
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Schema(description = "Nombre del evento", example = "Estadio Metropolitano")
    private String name;

    @NotNull(message = "La fecha/hora del evento es obligatoria")
    @Schema(description = "Fecha y hora del evento (ISO-8601)", example = "")
    private LocalDateTime eventDateTime;

    @NotNull(message = "El venueId es obligatorio")
    @Schema(description = "ID del venue donde se realizará", example = "1")
    private Long venueId;

    public EventDTO() {}

    public EventDTO(Long id, String name, LocalDateTime eventDateTime, Long venueId) {
        this.id = id;
        this.name = name;
        this.eventDateTime = eventDateTime;
        this.venueId = venueId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDateTime getEventDateTime() { return eventDateTime; }
    public void setEventDateTime(LocalDateTime eventDateTime) { this.eventDateTime = eventDateTime; }

    public Long getVenueId() { return venueId; }
    public void setVenueId(Long venueId) { this.venueId = venueId; }
}
