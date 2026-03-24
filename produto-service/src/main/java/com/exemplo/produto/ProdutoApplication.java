package com.exemplo.produto;
/*
Classe principal da aplicação Spring Boot do microsserviço produto-service.; É COMO SE FOSSE O DONO ABRINDO A LOJA

Função:
- Inicializar a aplicação Spring Boot
- Criar o contexto da aplicação Spring
- Iniciar o servidor web embutido (Tomcat)
- Permitir que o serviço se registre no servidor Eureka
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProdutoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProdutoApplication.class, args); /* O método inicia toda a aplicação, carrega as configurações do application.yml e ativa os componentes do Spring (controllers, repositories, etc).*/

    }

}