package org.example.appqa_registardefecto.dto;

import lombok.Data;

/**
 * kle ocultamos campos al cliente, solo queremos que introduzca ciertos campos, los demas se encargara el backend (fecha y ID)
 */
@Data
public class ProductoDTO {


    private String nombre;
    private String descripcion;
    private boolean defectuoso;

}
