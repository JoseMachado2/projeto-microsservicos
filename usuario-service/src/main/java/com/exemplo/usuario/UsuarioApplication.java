package com.exemplo.usuario;
/*
Classe principal da aplicação Spring Boot do microsserviço usuario-service.; É COMO SE FOSSE O DONO ABRINDO A LOJA

Função:
- Inicializar a aplicação Spring Boot
- Criar o contexto da aplicação Spring
- Iniciar o servidor web embutido (Tomcat)
- Permitir que o serviço se registre no servidor Eureka
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsuarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsuarioApplication.class, args); /* O método inicia toda a aplicação, carrega as configurações do application.yml e ativa os componentes do Spring (controllers, repositories, etc).*/

    }

}