package com.empresa.qasystem.messaging;

import com.empresa.qasystem.model.ProductoDefectuoso;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoNotificacionPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // Método para enviar un evento de notificación
    public void publicarEventoNotificacion(ProductoDefectuoso productoDefectuoso) {
        System.out.println("Publicando evento de notificación: " + productoDefectuoso);

        // Enviar el mensaje a la cola de eventos de notificación
        rabbitTemplate.convertAndSend("notificacion-event-exchange", "notificacion-event-routing-key", productoDefectuoso);
    }
}
