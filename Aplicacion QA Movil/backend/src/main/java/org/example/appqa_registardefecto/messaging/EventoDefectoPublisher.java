package org.example.appqa_registardefecto.messaging;


import org.example.appqa_registardefecto.dto.ProductoDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoDefectoPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE = "erp-event-exchange";
    private static final String ROUTING_KEY = "defecto-command-routing-key";

    public void publicarEventoDefecto(ProductoDTO dto) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, dto);
    }
}
