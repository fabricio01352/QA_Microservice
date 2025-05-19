package com.empresa.qasystem.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Lote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreLote;  // Nombre o código del lote
    private String descripcion; // Descripción del lote
    private String estado;      // Estado del lote (e.g., "En producción", "Finalizado", etc.)

    @OneToMany(mappedBy = "lote")
    private List<ProductoDefectuoso> productosDefectuosos;  // Relación con los productos defectuosos

}
