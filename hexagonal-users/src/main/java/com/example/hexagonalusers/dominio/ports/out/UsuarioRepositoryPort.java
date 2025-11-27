package com.example.hexagonalusers.dominio.ports.out;

import com.example.hexagonalusers.dominio.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepositoryPort {

    Usuario guardar(Usuario usuario);

    void eliminarPorId(Long id);

    Optional<Usuario> buscarPorId(Long id);

    List<Usuario> listarTodos();
}
