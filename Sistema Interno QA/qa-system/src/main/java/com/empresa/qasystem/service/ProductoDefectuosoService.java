package com.empresa.qasystem.service;

import com.empresa.qasystem.dto.ProductoDefectuosoDTO;
import com.empresa.qasystem.model.ProductoDefectuoso;
import com.empresa.qasystem.repository.ProductoDefectuosoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductoDefectuosoService {

    @Autowired
    private ProductoDefectuosoRepository productoDefectuosoRepository;

    // Método para registrar un producto defectuoso
    public ProductoDefectuoso registrarDefecto(ProductoDefectuosoDTO productoDefectuosoDTO) {
        ProductoDefectuoso productoDefectuoso = new ProductoDefectuoso();
        productoDefectuoso.setNombre(productoDefectuosoDTO.getNombre());
        productoDefectuoso.setDescripcion(productoDefectuosoDTO.getDescripcion());
        productoDefectuoso.setTipoDefecto(productoDefectuosoDTO.getTipoDefecto());
        productoDefectuoso.setCosto(productoDefectuosoDTO.getCosto());
        productoDefectuoso.setRequiereAtencion(productoDefectuosoDTO.isRequiereAtencion());
        productoDefectuoso.setFecha(java.time.LocalDateTime.now());

        return productoDefectuosoRepository.save(productoDefectuoso);
    }

    // Método para generar un reporte de los defectos por tipo
    public Map<String, Long> reporteDefectosPorTipo() {
        List<ProductoDefectuoso> defectos = productoDefectuosoRepository.findAll();
        return defectos.stream()
                .collect(Collectors.groupingBy(ProductoDefectuoso::getTipoDefecto, Collectors.counting()));
    }

    // Método para generar un reporte de costos de productos defectuosos por tipo
    public Map<String, Double> reporteCostosPorTipo() {
        List<ProductoDefectuoso> defectos = productoDefectuosoRepository.findAll();
        return defectos.stream()
                .collect(Collectors.groupingBy(ProductoDefectuoso::getTipoDefecto,
                        Collectors.summingDouble(ProductoDefectuoso::getCosto)));
    }

    // Método para obtener los productos defectuosos que requieren atención urgente
    public List<ProductoDefectuoso> obtenerDefectosUrgentes() {
        return productoDefectuosoRepository.findByRequiereAtencionTrue();
    }
}
