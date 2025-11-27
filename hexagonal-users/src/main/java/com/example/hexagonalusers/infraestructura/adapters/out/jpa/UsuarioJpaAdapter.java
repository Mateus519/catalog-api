package com.example.hexagonalusers.infraestructura.adapters.out.jpa;

import com.example.hexagonalusers.dominio.model.Usuario;
import com.example.hexagonalusers.dominio.ports.out.UsuarioRepositoryPort;
import com.example.hexagonalusers.infraestructura.adapters.out.jpa.entity.UsuarioEntity;
import com.example.hexagonalusers.infraestructura.adapters.out.jpa.repository.UsuarioJpaRepository;
import com.example.hexagonalusers.infraestructura.mappers.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioJpaAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository usuarioJpaRepository;
    private final UsuarioMapper mapper;

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        UsuarioEntity saved = usuarioJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public void eliminarPorId(Long id) {
        usuarioJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioJpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioJpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
