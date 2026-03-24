package com.exemplo.produto.dto;

/*
DTO (Data Transfer Object) utilizado para transportar dados de usuário
entre as camadas da aplicação e para respostas da API.

Evita expor diretamente a entidade do banco de dados.
*/

public class ProdutoDTO {
    private Long id;
    private String nome;
    private Double preco;

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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
