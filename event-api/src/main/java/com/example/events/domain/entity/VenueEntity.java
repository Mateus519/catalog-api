package com.example.events.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "venues")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VenueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String name;

    @Column(nullable = false, length = 80)
    private String city;

    @Column(nullable = false, length = 200)
    private String address;

    @Column(nullable = false)
    private Integer capacity;
}
