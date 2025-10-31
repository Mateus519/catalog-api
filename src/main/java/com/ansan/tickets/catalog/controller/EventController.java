package com.ansan.tickets.catalog.controller;

import com.ansan.tickets.catalog.dto.EventDTO;
import com.ansan.tickets.catalog.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Tag(name = "Events", description = "CRUD de eventos (in-memory)")
@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @Operation(summary = "Crear evento")
    @PostMapping
    public ResponseEntity<EventDTO> create(@Valid @RequestBody EventDTO dto) {
        EventDTO saved = service.create(dto);
        return ResponseEntity.created(URI.create("/events/" + saved.getId())).body(saved);
    }

    @Operation(summary = "Listar eventos")
    @GetMapping
    public ResponseEntity<List<EventDTO>> list() {
        return ResponseEntity.ok(service.list());
    }

    @Operation(summary = "Obtener evento por id")
    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @Operation(summary = "Actualizar evento")
    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> update(@PathVariable Long id, @Valid @RequestBody EventDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Operation(summary = "Eliminar evento")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
