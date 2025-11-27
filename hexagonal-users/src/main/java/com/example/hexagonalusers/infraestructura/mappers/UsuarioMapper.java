package com.example.hexagonalusers.infraestructura.mappers;

import com.example.hexagonalusers.dominio.model.Usuario;
import com.example.hexagonalusers.infraestructura.adapters.out.jpa.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioEntity toEntity(Usuario usuario);

    Usuario toDomain(UsuarioEntity entity);
}
