package com.example.events.repository;

import com.example.events.domain.entity.EventEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    @Query("SELECT e FROM EventEntity e " +
           "WHERE (:city IS NULL OR LOWER(e.venue.city) = LOWER(:city)) " +
           "AND (:category IS NULL OR LOWER(e.category) = LOWER(:category)) " +
           "AND (:startDate IS NULL OR e.startDate >= :startDate)")
    Page<EventEntity> search(
            @Param("city") String city,
            @Param("category") String category,
            @Param("startDate") LocalDateTime startDate,
            Pageable pageable
    );
}
