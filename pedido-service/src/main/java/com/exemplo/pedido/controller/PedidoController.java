package com.exemplo.pedido.controller;
/*
Controller REST responsável por expor os endpoints da API de usuários. ; É COMO SE FOSSE O 'ATENDENTE' DA API

Função:
- Receber requisições HTTP dos clientes
- Processar operações relacionadas aos usuários
- Retornar respostas em formato JSON

Define endpoints como:
GET /pedidos  -> lista usuários
POST /pedidos -> cria um novo usuário

Chama o UsuarioRepository para ele acessar o banco de dados  (antes)
*/

/* import com.exemplo.pedido.entity.Usuario;                  ANTES ELE FALAVA COM 'Usuario Repository' mas agora é com UsuarioService
import com.exemplo.pedido.repository.UsuarioRepository; */

import com.exemplo.pedido.dto.PedidoDTO;
import com.exemplo.pedido.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping
    public List<PedidoDTO> listarPedidos() {
        return service.listarPedidos();
    }

    @PostMapping
    public PedidoDTO criar(@RequestBody PedidoDTO pedidoDTO) {
        return service.salvar(pedidoDTO);
    }

}
