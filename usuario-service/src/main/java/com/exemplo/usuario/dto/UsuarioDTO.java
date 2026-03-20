package com.exemplo.usuario.dto;

/*
DTO (Data Transfer Object) utilizado para transportar dados de usuário
entre as camadas da aplicação e para respostas da API.

Evita expor diretamente a entidade do banco de dados.
*/

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;

    public UsuarioDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
