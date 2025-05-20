package com.empresa.qasystem.model;

import jakarta.persistence.Entity;
import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "producto")
public class ProductoDefectuoso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private boolean defectuoso;
    private String tipoDefecto;
    private double costo;  // Costo de la pieza defectuosa (en USD o en pesos)
    private LocalDateTime fecha;
    @Column(name = "requiereAtencion")
    private boolean requiereAtencion;  // Flag para indicar si requiere atención inmediata

//    @ManyToOne
//    private Lote lote; // Relacionar con el lote de producción
}
