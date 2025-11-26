package com.example.events.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VenueResponse {

    private Long id;
    private String name;
    private String city;
    private String address;
    private Integer capacity;
}
