package com.exemplo.pedido.dto;

/*
DTO (Data Transfer Object) utilizado para transportar dados de usuário
entre as camadas da aplicação e para respostas da API.

Evita expor diretamente a entidade do banco de dados.
*/

public class PedidoDTO {
    private Long id;
    private Long usuarioId;
    private Long produtoId;
    private Integer quantidade;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
