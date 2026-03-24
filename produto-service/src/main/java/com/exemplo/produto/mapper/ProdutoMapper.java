package com.exemplo.produto.mapper;

import com.exemplo.produto.dto.ProdutoDTO;
import com.exemplo.produto.entity.Produto;
import org.mapstruct.Mapper;

/*
Mapper responsável por converter entre Produto (Entity) e ProdutoDTO.

Utiliza MapStruct para gerar automaticamente o código de conversão.
*/

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoDTO toDTO(Produto produto);

    Produto toEntity(ProdutoDTO dto);
}