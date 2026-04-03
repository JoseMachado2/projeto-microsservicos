package com.exemplo.pedido.consumer;
import com.exemplo.pedido.config.RabbitConfig;
import com.exemplo.pedido.dto.ProdutoEventDTO;
import com.exemplo.pedido.entity.Estoque;
import com.exemplo.pedido.repository.EstoqueRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProdutoConsumer {

    private final EstoqueRepository estoqueRepository;

    public ProdutoConsumer(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void consumirProdutoCriado(ProdutoEventDTO event) {

        System.out.println("📩 Evento recebido: Produto ID = " + event.getProdutoId());

        // 🔥 cria registro no estoque
        Estoque estoque = new Estoque();
        estoque.setProdutoId(event.getProdutoId());
        estoque.setQuantidade(0);

        estoqueRepository.save(estoque);

        System.out.println("✅ Estoque criado para produto: " + event.getProdutoId());
    }
}