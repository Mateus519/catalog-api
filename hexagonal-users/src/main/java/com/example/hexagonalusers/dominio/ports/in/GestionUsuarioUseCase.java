package com.example.hexagonalusers.dominio.ports.in;

import com.example.hexagonalusers.dominio.model.Usuario;
import java.util.List;

public interface GestionUsuarioUseCase {

    Usuario crear(Usuario usuario);

    Usuario actualizar(Long id, Usuario usuario);

    void eliminar(Long id);

    Usuario obtenerPorId(Long id);

    List<Usuario> listar();
}
