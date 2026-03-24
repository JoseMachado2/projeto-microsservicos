package com.exemplo.produto.entity;
/*
Classe de entidade que representa um usuário no sistema.; É COMO SE FOSSE A TABELA DO BANCO

Função:
- Mapear a tabela de usuários no banco de dados utilizando JPA/Hibernate
- Definir os campos que serão armazenados no banco (id, nome, preco)
*/
import jakarta.persistence.*;


@Entity  /* A anotação @Entity indica que esta classe será persistida no banco.. */
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  /* diz que O campo id é a chave primária da tabela ,que o Hibernate ORM vai gerar o ID automaticamente quando o registro for salvo no banco. */
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