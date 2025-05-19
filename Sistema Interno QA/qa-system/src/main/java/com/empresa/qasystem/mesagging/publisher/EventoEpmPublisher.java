package com.empresa.qasystem.messaging;

import com.empresa.qasystem.model.ProductoDefectuoso;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoEpmPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // Método para enviar un mensaje al ERP local sobre un defecto registrado
    public void publicarEventoEpm(ProductoDefectuoso productoDefectuoso) {
        System.out.println("Publicando evento al ERP: " + productoDefectuoso);

        // Publicar el mensaje a la cola de eventos de ERP
        rabbitTemplate.convertAndSend("erp-event-exchange", "erp-event-routing-key", productoDefectuoso);
    }
}
