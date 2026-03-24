package com.exemplo.pedido.service;

import com.exemplo.pedido.dto.PedidoDTO;
import com.exemplo.pedido.entity.Pedido;
import com.exemplo.pedido.mapper.PedidoMapper;
import com.exemplo.pedido.repository.PedidoRepository;
import com.exemplo.pedido.client.ProdutoClient;
import com.exemplo.pedido.client.UsuarioClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
Service responsável pela lógica de negócio
relacionada aos usuários.

Faz a comunicação entre Controller e Repository.
*/

@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final UsuarioClient usuarioClient;
    private final ProdutoClient produtoClient;
    private final PedidoMapper mapper;
    

    public PedidoService(PedidoRepository repository,
                         UsuarioClient usuarioClient,
                         ProdutoClient produtoClient,
                         PedidoMapper mapper) {
        this.repository = repository;
        this.usuarioClient = usuarioClient;
        this.produtoClient = produtoClient;
        this.mapper = mapper;
        
    }
    public List<PedidoDTO> listarPedidos(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public PedidoDTO salvar(PedidoDTO dto) {
        
        try {
            usuarioClient.buscarPorId(dto.getUsuarioId());
        } catch (Exception e) {
            throw new RuntimeException("Usuário não encontrado");
        }

        try {
            produtoClient.buscarPorId(dto.getProdutoId());
        } catch (Exception e) {
            throw new RuntimeException("Produto não encontrado");
        }
        
        Pedido pedido = mapper.toEntity(dto);
        pedido = repository.save(pedido);
        return mapper.toDTO(pedido);
    }

    
}