package com.empresa.qasystem.controller;

import com.empresa.qasystem.dto.ProductoDefectuosoDTO;
import com.empresa.qasystem.model.ProductoDefectuoso;
import com.empresa.qasystem.service.ProductoDefectuosoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/productos-defectuosos")
public class ProductoDefectuosoController {

    @Autowired
    private ProductoDefectuosoService productoDefectuosoService;

    @PostMapping
    public ResponseEntity<ProductoDefectuoso> registrarDefecto(@RequestBody ProductoDefectuosoDTO productoDefectuosoDTO) {
        ProductoDefectuoso productoDefectuoso = productoDefectuosoService.registrarDefecto(productoDefectuosoDTO);
        return ResponseEntity.ok(productoDefectuoso);
    }

    @GetMapping("/reporte/defectos")
    public ResponseEntity<Map<String, Long>> obtenerReporteDefectosPorTipo() {
        Map<String, Long> reporte = productoDefectuosoService.reporteDefectosPorTipo();
        return ResponseEntity.ok(reporte);
    }

    @GetMapping("/reporte/costos")
    public ResponseEntity<Map<String, Double>> obtenerReporteCostosPorTipo() {
        Map<String, Double> reporte = productoDefectuosoService.reporteCostosPorTipo();
        return ResponseEntity.ok(reporte);
    }

    @GetMapping("/urgentes")
    public ResponseEntity<List<ProductoDefectuoso>> obtenerDefectosUrgentes() {
        List<ProductoDefectuoso> defectosUrgentes = productoDefectuosoService.obtenerDefectosUrgentes();
        return ResponseEntity.ok(defectosUrgentes);
    }
}
