package com.exemplo.produto.service;

import com.exemplo.produto.dto.ProdutoDTO;
import com.exemplo.produto.entity.Produto;
import com.exemplo.produto.mapper.ProdutoMapper;
import com.exemplo.produto.repository.ProdutoRepository;
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

    public ProdutoService(ProdutoRepository repository, ProdutoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProdutoDTO salvar(ProdutoDTO dto) {
        Produto produto = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(produto));
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
}