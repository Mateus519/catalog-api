package com.example.events.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EventResponse {

    private Long id;
    private String name;
    private String category;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Long venueId;
    private String venueName;
    private String venueCity;
}
