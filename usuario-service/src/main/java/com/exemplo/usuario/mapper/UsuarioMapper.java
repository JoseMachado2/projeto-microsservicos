package com.exemplo.usuario.mapper;

import com.exemplo.usuario.dto.UsuarioDTO;
import com.exemplo.usuario.entity.Usuario;
import org.mapstruct.Mapper;

/*
Mapper responsável por converter entre Usuario (Entity) e UsuarioDTO.

Utiliza MapStruct para gerar automaticamente o código de conversão.
*/

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDTO toDTO(Usuario usuario);

    Usuario toEntity(UsuarioDTO usuarioDTO);
}
