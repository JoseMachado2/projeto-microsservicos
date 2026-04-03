package com.exemplo.produto.config; // ou pedido.config
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
/*
CONFIGURAÇÃO DO RABBITMQ

Essa classe define os componentes necessários para comunicação assíncrona entre microsserviços:

1) QUEUE (Fila)
- Local onde as mensagens ficam armazenadas até serem consumidas
- Ex: produto.criado.queue

2) EXCHANGE
- Responsável por receber mensagens do producer
- Decide para qual fila enviar a mensagem

3) ROUTING KEY
- "Chave" usada pela exchange para direcionar a mensagem corretamente

4) BINDING
- Liga a exchange à fila usando a routing key

5) MESSAGE CONVERTER (JSON)
- Converte objetos Java em JSON ao enviar
- Converte JSON em objeto ao consumir
- Evita problemas de serialização entre microsserviços

6) RABBIT TEMPLATE
- Usado para enviar mensagens para o RabbitMQ
- Configurado para usar JSON em vez de serialização Java

RESUMO:
Producer → Exchange → Queue → Consumer
*/
@Configuration
public class RabbitConfig {

    public static final String QUEUE = "produto.criado.queue";
    public static final String EXCHANGE = "produto.exchange";
    public static final String ROUTING_KEY = "produto.criado";
    
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }


    @Bean
    public Queue queue() {
        return new Queue(QUEUE, true);
    }
    
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);}

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);}

    
}