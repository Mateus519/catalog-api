package com.example.events.repository;

import com.example.events.domain.entity.VenueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VenueRepository extends JpaRepository<VenueEntity, Long> {

    Optional<VenueEntity> findByNameIgnoreCase(String name);
}
