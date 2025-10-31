package com.ansan.tickets.catalog.controller;

import com.ansan.tickets.catalog.dto.VenueDTO;
import com.ansan.tickets.catalog.service.VenueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Tag(name = "Venues", description = "CRUD de venues (in-memory)")
@RestController
@RequestMapping("/venues")
public class VenueController {

    private final VenueService service;

    public VenueController(VenueService service) {
        this.service = service;
    }

    @Operation(summary = "Crear venue")
    @PostMapping
    public ResponseEntity<VenueDTO> create(@Valid @RequestBody VenueDTO dto) {
        VenueDTO saved = service.create(dto);
        return ResponseEntity.created(URI.create("/venues/" + saved.getId())).body(saved);
    }

    @Operation(summary = "Listar venues")
    @GetMapping
    public ResponseEntity<List<VenueDTO>> list() {
        return ResponseEntity.ok(service.list());
    }

    @Operation(summary = "Obtener venue por id")
    @GetMapping("/{id}")
    public ResponseEntity<VenueDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @Operation(summary = "Actualizar venue")
    @PutMapping("/{id}")
    public ResponseEntity<VenueDTO> update(@PathVariable Long id, @Valid @RequestBody VenueDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Operation(summary = "Eliminar venue")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
