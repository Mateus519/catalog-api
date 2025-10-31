package com.ansan.tickets.catalog.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Lugar o recinto (venue)")
public class VenueDTO {
    @Schema(description = "Identificador del venue", example = "1")
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Schema(description = "Nombre del venue", example = "Estadio Metropolitano")
    private String name;

    @NotBlank(message = "La dirección es obligatoria")
    @Schema(description = "Dirección física", example = "Cra 46 #1-1, Barranquilla")
    private String address;

    @Min(value = 1, message = "La capacidad debe ser positiva")
    @Schema(description = "Capacidad máxima de personas", example = "45000")
    private Integer capacity;

    public VenueDTO() {}

    public VenueDTO(Long id, String name, String address, Integer capacity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
}
