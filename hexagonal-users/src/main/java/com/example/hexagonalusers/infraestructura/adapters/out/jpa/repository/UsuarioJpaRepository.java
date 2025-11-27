package com.example.hexagonalusers.infraestructura.adapters.out.jpa.repository;

import com.example.hexagonalusers.infraestructura.adapters.out.jpa.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {

    boolean existsByEmail(String email);
}
