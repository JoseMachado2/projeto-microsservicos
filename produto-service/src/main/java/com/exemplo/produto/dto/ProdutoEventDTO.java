package com.exemplo.produto.dto; // e também no produto-service

import java.io.Serializable;

public class ProdutoEventDTO implements Serializable {

    private Long produtoId;

    public ProdutoEventDTO() {}

    public ProdutoEventDTO(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }
}
