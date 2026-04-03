package com.exemplo.produto.service;

import com.exemplo.produto.dto.ProdutoDTO;
import com.exemplo.produto.entity.Produto;
import com.exemplo.produto.mapper.ProdutoMapper;
import com.exemplo.produto.repository.ProdutoRepository;
import com.exemplo.produto.producer.ProdutoProducer; // 👈 IMPORTANTE
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
Service responsável pela lógica de negócio
relacionada aos produtos.

Faz a comunicação entre Controller e Repository.
*/
@Service
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;
    private final ProdutoProducer producer; // 👈 NOVO

    public ProdutoService(ProdutoRepository repository, ProdutoMapper mapper, ProdutoProducer producer) {
        this.repository = repository;
        this.mapper = mapper;
        this.producer = producer; // 👈 NOVO
    }

    public ProdutoDTO salvar(ProdutoDTO dto) {
        Produto produto = mapper.toEntity(dto);
        Produto produtoSalvo = repository.save(produto); // 👈 salva primeiro
        producer.enviarProdutoCriado(produtoSalvo.getId()); // 🚀 ENVIA EVENTO PRO RABBITMQ
        return mapper.toDTO(produtoSalvo);
    }

    public List<ProdutoDTO> listar() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public ProdutoDTO buscarPorId(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return mapper.toDTO(produto);
    }

    public void deletarProduto(Long id){
        repository.deleteById(id);
    }
}