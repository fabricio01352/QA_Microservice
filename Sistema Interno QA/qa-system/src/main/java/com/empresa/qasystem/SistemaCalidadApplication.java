package com.empresa.qasystem;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class SistemaCalidadApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaCalidadApplication.class, args);
    }
}
