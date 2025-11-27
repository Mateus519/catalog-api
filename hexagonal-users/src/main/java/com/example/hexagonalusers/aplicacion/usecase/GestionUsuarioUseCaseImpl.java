package com.example.hexagonalusers.aplicacion.usecase;

import com.example.hexagonalusers.dominio.model.Usuario;
import com.example.hexagonalusers.dominio.ports.in.GestionUsuarioUseCase;
import com.example.hexagonalusers.dominio.ports.out.UsuarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GestionUsuarioUseCaseImpl implements GestionUsuarioUseCase {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    @Override
    public Usuario crear(Usuario usuario) {
        usuario.setId(null);
        usuario.setCreadoEn(LocalDateTime.now());
        usuario.setActualizadoEn(LocalDateTime.now());
        return usuarioRepositoryPort.guardar(usuario);
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuario) {
        Usuario existente = usuarioRepositoryPort.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + id));
        existente.setNombre(usuario.getNombre());
        existente.setEmail(usuario.getEmail());
        existente.setRol(usuario.getRol());
        existente.setActualizadoEn(LocalDateTime.now());
        return usuarioRepositoryPort.guardar(existente);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepositoryPort.eliminarPorId(id);
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return usuarioRepositoryPort.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + id));
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepositoryPort.listarTodos();
    }
}
