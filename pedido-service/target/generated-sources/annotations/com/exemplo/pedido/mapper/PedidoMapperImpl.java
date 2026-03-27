package com.exemplo.pedido.mapper;

import com.exemplo.pedido.dto.PedidoDTO;
import com.exemplo.pedido.entity.Pedido;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-27T09:34:44-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class PedidoMapperImpl implements PedidoMapper {

    @Override
    public PedidoDTO toDTO(Pedido usuario) {
        if ( usuario == null ) {
            return null;
        }

        PedidoDTO pedidoDTO = new PedidoDTO();

        pedidoDTO.setId( usuario.getId() );
        pedidoDTO.setUsuarioId( usuario.getUsuarioId() );
        pedidoDTO.setProdutoId( usuario.getProdutoId() );
        pedidoDTO.setQuantidade( usuario.getQuantidade() );

        return pedidoDTO;
    }

    @Override
    public Pedido toEntity(PedidoDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Pedido pedido = new Pedido();

        pedido.setId( usuarioDTO.getId() );
        pedido.setUsuarioId( usuarioDTO.getUsuarioId() );
        pedido.setProdutoId( usuarioDTO.getProdutoId() );
        pedido.setQuantidade( usuarioDTO.getQuantidade() );

        return pedido;
    }
}
