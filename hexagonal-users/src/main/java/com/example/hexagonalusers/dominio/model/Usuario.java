package com.example.hexagonalusers.dominio.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor       //constructor vacío
@AllArgsConstructor      //constructor con todos los campos
public class Usuario {

    private Long id;
    private String nombre;
    private String email;
    private String rol;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;
}
