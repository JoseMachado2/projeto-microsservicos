package com.exemplo.produto.repository;
/*
Interface responsável pelo acesso aos dados de usuários no banco. O Repository é a camada de acesso a dados.
É COMO SE FOSSE O "FUNCIONARIO" QUE SABE ACESSAR A TABELA (Produto.java)
Função:
- Fornecer operações de persistência para a entidade Produto
- Permitir operações CRUD automaticamente (create, read, update, delete)
*/


import com.exemplo.produto.entity.Produto;  /* Ele importa Produto porque ele precisa saber qual entidade ele gerencia */
/* Spring Data JPA gera o CRUD automaticamente. */
import org.springframework.data.jpa.repository.JpaRepository;

/*Herda de JpaRepository, que disponibiliza métodos prontos como:
save()     -> salvar entidade
findAll()  -> listar registros
findById() -> buscar por ID
delete()   -> remover registro
*/
public interface ProdutoRepository  extends JpaRepository<Produto, Long> {
}