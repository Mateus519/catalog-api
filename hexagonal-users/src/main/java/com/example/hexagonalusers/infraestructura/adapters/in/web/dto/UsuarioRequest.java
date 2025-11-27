package com.example.hexagonalusers.infraestructura.adapters.in.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UsuarioRequest {

    @Schema(example = "Juan Pérez")
    private String nombre;

    @Schema(example = "juan.perez@example.com")
    private String email;

    @Schema(example = "USER")
    private String rol;
}
