package com.empresa.qasystem.dto;


import lombok.Data;

@Data
public class ProductoDefectuosoDTO {


    private String nombre;
    private String descripcion;
    private String tipoDefecto;
    private int costo;
    private boolean requiereAtencion;



}
