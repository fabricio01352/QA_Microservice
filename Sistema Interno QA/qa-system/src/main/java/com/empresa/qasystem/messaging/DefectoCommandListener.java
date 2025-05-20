package com.empresa.qasystem.messaging;

import com.empresa.qasystem.dto.ProductoDefectuosoDTO;
import com.empresa.qasystem.model.ProductoDefectuoso;
import com.empresa.qasystem.service.ProductoDefectuosoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefectoCommandListener {

    @Autowired
    private ProductoDefectuosoService productoDefectuosoService;


    @RabbitListener(queues = "defecto-command-queue")
    public void handleDefectoCommand(ProductoDefectuosoDTO productoDefectuosoDTO) {
        System.out.println("Comando recibido para registrar defecto: " + productoDefectuosoDTO);

        // Registrar el producto defectuoso en la base de datos
        ProductoDefectuoso productoDefectuoso = productoDefectuosoService.registrarDefecto(productoDefectuosoDTO);

    }

    @RabbitListener(queues = "defecto-command-queue")
    public void testRawMessage(String message) {
        System.out.println("🎯 Recibido como texto: " + message);
    }
}
