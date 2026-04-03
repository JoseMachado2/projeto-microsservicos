package com.exemplo.produto.producer;
import com.exemplo.produto.config.RabbitConfig;
import com.exemplo.produto.dto.ProdutoEventDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProdutoProducer {

    private final RabbitTemplate rabbitTemplate;

    public ProdutoProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;}

    public void enviarProdutoCriado(Long produtoId) {
        ProdutoEventDTO event = new ProdutoEventDTO(produtoId);
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE,RabbitConfig.ROUTING_KEY,event);}
}