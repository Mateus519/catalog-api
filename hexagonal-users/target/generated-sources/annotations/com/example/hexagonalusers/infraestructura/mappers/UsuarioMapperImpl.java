package com.example.hexagonalusers.infraestructura.mappers;

import com.example.hexagonalusers.dominio.model.Usuario;
import com.example.hexagonalusers.infraestructura.adapters.out.jpa.entity.UsuarioEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-26T17:31:35-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioEntity toEntity(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioEntity.UsuarioEntityBuilder usuarioEntity = UsuarioEntity.builder();

        usuarioEntity.actualizadoEn( usuario.getActualizadoEn() );
        usuarioEntity.creadoEn( usuario.getCreadoEn() );
        usuarioEntity.email( usuario.getEmail() );
        usuarioEntity.id( usuario.getId() );
        usuarioEntity.nombre( usuario.getNombre() );
        usuarioEntity.rol( usuario.getRol() );

        return usuarioEntity.build();
    }

    @Override
    public Usuario toDomain(UsuarioEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.actualizadoEn( entity.getActualizadoEn() );
        usuario.creadoEn( entity.getCreadoEn() );
        usuario.email( entity.getEmail() );
        usuario.id( entity.getId() );
        usuario.nombre( entity.getNombre() );
        usuario.rol( entity.getRol() );

        return usuario.build();
    }
}
