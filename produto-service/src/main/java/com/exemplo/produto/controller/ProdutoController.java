package com.exemplo.produto.controller;
/*
Controller REST responsável por expor os endpoints da API de produtos. ; É COMO SE FOSSE O 'ATENDENTE' DA API

Função:
- Receber requisições HTTP dos clientes
- Processar operações relacionadas aos produtos
- Retornar respostas em formato JSON

Define endpoints como:
GET /produtos  -> lista produtos
POST /produtos -> cria um novo usuário

Chama o ProdutoRepository para ele acessar o banco de dados  (antes)
*/

/* import com.exemplo.produto.entity.Produto;                  ANTES ELE FALAVA COM 'Produto Repository' mas agora é com ProdutoService
import com.exemplo.produto.repository.ProdutoRepository; */

import com.exemplo.produto.dto.ProdutoDTO;
import com.exemplo.produto.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ProdutoDTO criar(@RequestBody ProdutoDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<ProdutoDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ProdutoDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}