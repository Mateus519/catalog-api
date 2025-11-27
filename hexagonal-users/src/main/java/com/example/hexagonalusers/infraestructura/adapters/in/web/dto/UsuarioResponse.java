package com.example.hexagonalusers.infraestructura.adapters.in.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UsuarioResponse {

    @Schema(example = "1")
    private Long id;

    private String nombre;

    private String email;

    private String rol;

    private LocalDateTime creadoEn;

    private LocalDateTime actualizadoEn;
}
