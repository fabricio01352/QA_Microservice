package org.example.appqa_registardefecto.config;



import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;


@Configuration
public class RabbitConfig {
    public static final String DEFECTO_COMMAND_QUEUE = "defecto-command-queue";
    public static final String ERP_EVENT_EXCHANGE = "erp-event-exchange";
    public static final String ERP_EVENT_ROUTING_KEY = "defecto-command-routing-key";

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jackson2JsonMessageConverter());
        return template;
    }


    @Bean
    public Queue defectoCommandQueue() {
        System.out.println("rabbit esta jalando");
        return new Queue(DEFECTO_COMMAND_QUEUE, true);
    }

    @Bean
    public DirectExchange erpEventExchange() {
        return new DirectExchange(ERP_EVENT_EXCHANGE, true, false);
    }

    @Bean
    public Binding defectoCommandBinding() {
        return BindingBuilder.bind(defectoCommandQueue())
                .to(erpEventExchange())
                .with(ERP_EVENT_ROUTING_KEY);
    }

}
