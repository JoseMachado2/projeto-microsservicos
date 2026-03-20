package com.exemplo.eureka;
/*
Classe principal da aplicação Spring Boot que inicia o servidor Eureka.

Função:
- Inicializar a aplicação Spring Boot
- Ativar o servidor Eureka através da anotação @EnableEurekaServer
- Criar o Service Registry onde os microsserviços podem se registrar

Quando a aplicação é executada (mvn spring-boot:run),
o método SpringApplication.run() inicia o Spring Boot,
inicia o servidor web embutido (Tomcat)
e disponibiliza o painel Eureka em http://localhost:8761.
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/* EurekaServerApplication.class (eureka-server\target\classes\com\exemplo\eureka):
 Arquivo compilado da classe EurekaServerApplication.java.

Este arquivo é gerado automaticamente pelo Maven durante o processo de build
(mvn compile ou mvn spring-boot:run).

Ele contém o bytecode Java que será executado pela JVM.
Fica localizado na pasta target/classes, que armazena os arquivos compilados do projeto.

NÃO TEM COMO COMENTAR DIRETAMENTE NELE:  pasta target = arquivos gerados automaticamente
SÓ PODE COMENTAR os da pasta src*/





@SpringBootApplication /*  : Essa anotação faz  coisas ao mesmo tempo:1️⃣ ativa configuração automática do Spring2️⃣ ativa o container Spring*/
@EnableEurekaServer              /* : ela fica em cima da classe para habilitar o servidor Eureka ; Transforma a aplicação em um servidor de regristro de microsserviços */
public class EurekaServerApplication {

    public static void main(String[] args)/*  Esse é o ponto inicial do programa Java. */{
        SpringApplication.run(EurekaServerApplication.class, args); /* essa linha: 1️⃣cria o contexto Spring 2️⃣ inicia o servidor web (Tomcat)3️⃣ carrega configurações (application.yml)4️⃣ inicia o Eureka Server */
    }

}