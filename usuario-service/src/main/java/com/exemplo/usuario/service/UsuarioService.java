package com.exemplo.usuario.service;

import com.exemplo.usuario.dto.UsuarioDTO;
import com.exemplo.usuario.entity.Usuario;
import com.exemplo.usuario.mapper.UsuarioMapper;
import com.exemplo.usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
Service responsável pela lógica de negócio
relacionada aos usuários.

Faz a comunicação entre Controller e Repository.
*/

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<UsuarioDTO> listarUsuarios() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = mapper.toEntity(usuarioDTO);
        Usuario salvo = repository.save(usuario);
        return mapper.toDTO(salvo);
    }
}