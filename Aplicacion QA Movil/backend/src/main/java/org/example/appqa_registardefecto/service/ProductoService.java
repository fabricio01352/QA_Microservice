package org.example.appqa_registardefecto.service;


import org.example.appqa_registardefecto.dto.ProductoDTO;
import org.example.appqa_registardefecto.model.Producto;
import org.example.appqa_registardefecto.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


/**
 * Fabricio Oma y Carlos
 * Esta es l acapa de servicios y se encarga de la logica de negocios y operaciones a mas bajo nivel;
 * Se comunica directamente con el repositorio
 */
@Service
public class ProductoService {


    private  ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }
// aqui podriamos implementar una interfaz que dicte los metodos CRUD pero como es solo un microservicio no se que sentido tendria
    public void agregarProducto(ProductoDTO dto){
        Producto producto = new Producto();

        producto.setDescripcion(dto.getDescripcion());
        producto.setNombre(dto.getNombre());
        producto.setDefectuoso(dto.isDefectuoso());
        producto.setFecha(LocalDateTime.now());


        productoRepository.save(producto);
    }

    public Optional<Producto> obtenerProducto(Long id) {
       return productoRepository.findById(id);
    }

    public void eliminar(Long id) {
    productoRepository.deleteById(id);

    }

    public Producto actualizarProducto(Long id, ProductoDTO dto) {

        Producto producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontraod"));


        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setDefectuoso(dto.isDefectuoso());
        producto.setFecha(LocalDateTime.now());

        return productoRepository.save(producto);

    }














}
