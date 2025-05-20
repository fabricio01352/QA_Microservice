package org.example.appqa_registardefecto.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data


@Entity
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;
    private String descripcion;
    private String tipoDefecto;
    private int costo;
    private boolean requiereAtencion;
    private boolean defectuoso;
    private LocalDateTime fecha;


}
