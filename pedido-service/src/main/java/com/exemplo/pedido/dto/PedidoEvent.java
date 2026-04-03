package com.exemplo.pedido.dto; // e também no produto-service

import java.io.Serializable;

public class PedidoEvent implements Serializable {

    private Long produtoId;

    public PedidoEvent() {}

    public PedidoEvent(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Long getprodutoId() {
        return produtoId;
    }

    public void setprodutoId(Long produtoId) {
        this.produtoId = produtoId;
    }
}