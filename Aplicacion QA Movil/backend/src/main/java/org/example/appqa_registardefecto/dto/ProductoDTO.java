package org.example.appqa_registardefecto.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * kle ocultamos campos al cliente, solo queremos que introduzca ciertos campos, los demas se encargara el backend (fecha y ID)
 */
@Data
public class ProductoDTO implements Serializable {


    private String nombre;
    private String descripcion;
    private String tipoDefecto;
    private int costo;
    private boolean isDefectuoso;
    private boolean requiereAtencion;
}
