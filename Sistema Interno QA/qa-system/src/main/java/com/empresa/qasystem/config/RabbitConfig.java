package com.empresa.qasystem.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

@Configuration
public class RabbitConfig {


    public static final String DEFECTO_COMMAND_QUEUE = "defecto-command-queue";
    public static final String ERP_EVENT_EXCHANGE = "erp-event-exchange";
    public static final String DEFECTO_COMMAND_ROUTING_KEY = "defecto-command-routing-key";


    public static final String NOTIFICACION_EVENT_EXCHANGE = "notificacion-event-exchange";
    public static final String NOTIFICACION_EVENT_ROUTING_KEY = "notificacion-event-routing-key";

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue defectoCommandQueue() {
        return new Queue(DEFECTO_COMMAND_QUEUE, true);
    }

    @Bean
    public DirectExchange erpEventExchange() {
        return new DirectExchange(ERP_EVENT_EXCHANGE, true, false);
    }

    @Bean
    public DirectExchange notificacionEventExchange() {
        return new DirectExchange(NOTIFICACION_EVENT_EXCHANGE, true, false);
    }

    @Bean
    public Binding defectoCommandBinding() {
        return BindingBuilder.bind(defectoCommandQueue())
                .to(erpEventExchange())
                .with(DEFECTO_COMMAND_ROUTING_KEY);
    }


    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory,
                                                                               Jackson2JsonMessageConverter messageConverter) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(messageConverter);
        return factory;
    }
}