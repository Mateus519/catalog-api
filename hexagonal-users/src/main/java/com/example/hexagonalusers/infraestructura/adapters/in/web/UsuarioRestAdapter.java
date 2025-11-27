package com.example.hexagonalusers.infraestructura.adapters.in.web;

import com.example.hexagonalusers.dominio.model.Usuario;
import com.example.hexagonalusers.dominio.ports.in.GestionUsuarioUseCase;
import com.example.hexagonalusers.infraestructura.adapters.in.web.dto.UsuarioRequest;
import com.example.hexagonalusers.infraestructura.adapters.in.web.dto.UsuarioResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@Tag(name = "Usuarios", description = "Gestión de usuarios (ejemplo arquitectura hexagonal)")
public class UsuarioRestAdapter {

    private final GestionUsuarioUseCase gestionUsuarioUseCase;

    @PostMapping
    @Operation(summary = "Crear usuario")
    public ResponseEntity<UsuarioResponse> crear(@RequestBody UsuarioRequest request) {
        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .email(request.getEmail())
                .rol(request.getRol())
                .build();

        Usuario creado = gestionUsuarioUseCase.crear(usuario);

        UsuarioResponse response = UsuarioResponse.builder()
                .id(creado.getId())
                .nombre(creado.getNombre())
                .email(creado.getEmail())
                .rol(creado.getRol())
                .creadoEn(creado.getCreadoEn())
                .actualizadoEn(creado.getActualizadoEn())
                .build();

        return ResponseEntity
                .created(URI.create("/api/usuarios/" + creado.getId()))
                .body(response);
    }

    @GetMapping
    @Operation(summary = "Listar usuarios")
    public ResponseEntity<List<UsuarioResponse>> listar() {
        List<UsuarioResponse> lista = gestionUsuarioUseCase.listar().stream()
                .map(u -> UsuarioResponse.builder()
                        .id(u.getId())
                        .nombre(u.getNombre())
                        .email(u.getEmail())
                        .rol(u.getRol())
                        .creadoEn(u.getCreadoEn())
                        .actualizadoEn(u.getActualizadoEn())
                        .build())
                .toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/<built-in function id>")
    @Operation(summary = "Obtener usuario por id")
    public ResponseEntity<UsuarioResponse> obtener(@PathVariable Long id) {
        Usuario u = gestionUsuarioUseCase.obtenerPorId(id);
        UsuarioResponse response = UsuarioResponse.builder()
                .id(u.getId())
                .nombre(u.getNombre())
                .email(u.getEmail())
                .rol(u.getRol())
                .creadoEn(u.getCreadoEn())
                .actualizadoEn(u.getActualizadoEn())
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/<built-in function id>")
    @Operation(summary = "Actualizar usuario")
    public ResponseEntity<UsuarioResponse> actualizar(@PathVariable Long id,
                                                      @RequestBody UsuarioRequest request) {
        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .email(request.getEmail())
                .rol(request.getRol())
                .build();

        Usuario actualizado = gestionUsuarioUseCase.actualizar(id, usuario);

        UsuarioResponse response = UsuarioResponse.builder()
                .id(actualizado.getId())
                .nombre(actualizado.getNombre())
                .email(actualizado.getEmail())
                .rol(actualizado.getRol())
                .creadoEn(actualizado.getCreadoEn())
                .actualizadoEn(actualizado.getActualizadoEn())
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/<built-in function id>")
    @Operation(summary = "Eliminar usuario")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        gestionUsuarioUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
