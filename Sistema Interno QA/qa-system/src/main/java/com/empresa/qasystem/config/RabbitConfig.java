package com.empresa.qasystem.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    // Declarar la cola para el comando de defecto
    @Bean
    public Queue defectoCommandQueue() {
        return new Queue("defecto-command-queue", true);
    }

    // Declarar el exchange para eventos ERP
    @Bean
    public Exchange erpEventExchange() {
        return ExchangeBuilder.directExchange("erp-event-exchange").durable(true).build();
    }

    // Declarar el exchange para eventos de notificación
    @Bean
    public Exchange notificacionEventExchange() {
        return ExchangeBuilder.directExchange("notificacion-event-exchange").durable(true).build();
    }

    // Enlazar la cola de defecto con el exchange
    @Bean
    public Binding defectoCommandBinding() {
        return BindingBuilder.bind(defectoCommandQueue())
                .to(erpEventExchange())
                .with("defecto-command-routing-key")
                .noargs();
    }

    // Enlazar la cola de notificación con el exchange
    @Bean
    public Binding notificacionEventBinding() {
        return BindingBuilder.bind(defectoCommandQueue())
                .to(notificacionEventExchange())
                .with("notificacion-event-routing-key")
                .noargs();
    }
}
