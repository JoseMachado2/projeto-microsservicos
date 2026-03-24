package com.exemplo.pedido.mapper;

import com.exemplo.pedido.dto.PedidoDTO;
import com.exemplo.pedido.entity.Pedido;
import org.mapstruct.Mapper;

/*
Mapper responsável por converter entre Usuario (Entity) e UsuarioDTO.

Utiliza MapStruct para gerar automaticamente o código de conversão.
*/

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidoDTO toDTO(Pedido usuario);

    Pedido toEntity(PedidoDTO usuarioDTO);
}
