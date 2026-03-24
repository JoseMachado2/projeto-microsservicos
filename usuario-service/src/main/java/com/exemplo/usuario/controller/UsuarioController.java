package com.exemplo.usuario.controller;
/*
Controller REST responsável por expor os endpoints da API de usuários. ; É COMO SE FOSSE O 'ATENDENTE' DA API

Função:
- Receber requisições HTTP dos clientes
- Processar operações relacionadas aos usuários
- Retornar respostas em formato JSON

Define endpoints como:
GET /usuarios  -> lista usuários
POST /usuarios -> cria um novo usuário

Chama o UsuarioRepository para ele acessar o banco de dados  (antes)
*/

/* import com.exemplo.usuario.entity.Usuario;                  ANTES ELE FALAVA COM 'Usuario Repository' mas agora é com UsuarioService
import com.exemplo.usuario.repository.UsuarioRepository; */

import com.exemplo.usuario.dto.UsuarioDTO;
import com.exemplo.usuario.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return service.listarUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public UsuarioDTO criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return service.salvarUsuario(usuarioDTO);
    }

    @DeleteMapping
    public void deletarUsuario(@RequestBody Long id) {
        service.deletarUsuario(id);
    }
}
