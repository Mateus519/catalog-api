package com.example.events.controller;

import com.example.events.dto.VenueRequest;
import com.example.events.dto.VenueResponse;
import com.example.events.service.VenueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venues")
@RequiredArgsConstructor
public class VenueController {

    private final VenueService venueService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VenueResponse create(@Valid @RequestBody VenueRequest request) {
        return venueService.create(request);
    }

    @GetMapping
    public List<VenueResponse> list() {
        return venueService.findAll();
    }
}
