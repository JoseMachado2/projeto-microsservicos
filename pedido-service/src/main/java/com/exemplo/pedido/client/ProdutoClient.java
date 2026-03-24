package com.exemplo.pedido.client;

import com.exemplo.pedido.dto.ProdutoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "produto-service")
public interface ProdutoClient {

    @GetMapping("/produtos/{id}")
    ProdutoDTO buscarPorId(@PathVariable Long id);
}