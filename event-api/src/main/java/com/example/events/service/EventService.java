package com.example.events.service;

import com.example.events.domain.entity.EventEntity;
import com.example.events.domain.entity.VenueEntity;
import com.example.events.dto.EventRequest;
import com.example.events.dto.EventResponse;
import com.example.events.exception.NotFoundException;
import com.example.events.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final VenueService venueService;

    public EventResponse create(EventRequest request) {
        VenueEntity venue = venueService.getById(request.getVenueId());

        EventEntity entity = EventEntity.builder()
                .name(request.getName())
                .category(request.getCategory())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .venue(venue)
                .build();

        EventEntity saved = eventRepository.save(entity);
        return toResponse(saved);
    }

    public EventResponse update(Long id, EventRequest request) {
        EventEntity existing = eventRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Evento con id " + id + " no encontrado"));

        VenueEntity venue = venueService.getById(request.getVenueId());

        existing.setName(request.getName());
        existing.setCategory(request.getCategory());
        existing.setStartDate(request.getStartDate());
        existing.setEndDate(request.getEndDate());
        existing.setVenue(venue);

        EventEntity saved = eventRepository.save(existing);
        return toResponse(saved);
    }

    public void delete(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new NotFoundException("Evento con id " + id + " no encontrado");
        }
        eventRepository.deleteById(id);
    }

    public EventResponse getById(Long id) {
        EventEntity entity = eventRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Evento con id " + id + " no encontrado"));
        return toResponse(entity);
    }

    public Page<EventResponse> search(
            String city,
            String category,
            LocalDateTime startDate,
            Pageable pageable
    ) {
        Page<EventEntity> page = eventRepository.search(city, category, startDate, pageable);
        return page.map(this::toResponse);
    }

    private EventResponse toResponse(EventEntity e) {
        return EventResponse.builder()
                .id(e.getId())
                .name(e.getName())
                .category(e.getCategory())
                .startDate(e.getStartDate())
                .endDate(e.getEndDate())
                .venueId(e.getVenue().getId())
                .venueName(e.getVenue().getName())
                .venueCity(e.getVenue().getCity())
                .build();
    }
}
