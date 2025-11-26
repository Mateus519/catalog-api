package com.example.events.service;

import com.example.events.domain.entity.VenueEntity;
import com.example.events.dto.VenueRequest;
import com.example.events.dto.VenueResponse;
import com.example.events.exception.NotFoundException;
import com.example.events.repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VenueService {

    private final VenueRepository venueRepository;

    public VenueResponse create(VenueRequest request) {
        VenueEntity entity = VenueEntity.builder()
                .name(request.getName())
                .city(request.getCity())
                .address(request.getAddress())
                .capacity(request.getCapacity())
                .build();

        VenueEntity saved = venueRepository.save(entity);
        return toResponse(saved);
    }

    public List<VenueResponse> findAll() {
        return venueRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public VenueEntity getById(Long id) {
        return venueRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Venue con id " + id + " no encontrado"));
    }

    private VenueResponse toResponse(VenueEntity v) {
        return VenueResponse.builder()
                .id(v.getId())
                .name(v.getName())
                .city(v.getCity())
                .address(v.getAddress())
                .capacity(v.getCapacity())
                .build();
    }
}
