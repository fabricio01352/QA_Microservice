package org.example.appqa_registardefecto.service;


import org.example.appqa_registardefecto.dto.ProductoDTO;
import org.example.appqa_registardefecto.messaging.EventoDefectoPublisher;
import org.example.appqa_registardefecto.model.Producto;
import org.example.appqa_registardefecto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Optional;


/**
 * Fabricio Oma y Carlos
 * Esta es l acapa de servicios y se encarga de la logica de negocios y operaciones a mas bajo nivel;
 * Se comunica directamente con el repositorio
 */
@Service
public class ProductoService {


    @Autowired
    private EventoDefectoPublisher eventoDefectoPublisher;

    private  ProductoRepository productoRepository;
    private final  RestTemplate restTemplate;

    public ProductoService(ProductoRepository productoRepository, RestTemplate restTemplate){
        this.productoRepository = productoRepository;
        this.restTemplate = restTemplate;
    }
// aqui podriamos implementar una interfaz que dicte los metodos CRUD pero como es solo un microservicio no se que sentido tendria



    public void agregarProducto(ProductoDTO dto){
        Producto producto = new Producto();

        producto.setDescripcion(dto.getDescripcion());
        producto.setNombre(dto.getNombre());
        producto.setDefectuoso(dto.isDefectuoso());
        producto.setTipoDefecto(dto.getTipoDefecto());
        producto.setCosto(dto.getCosto());
        producto.setFecha(LocalDateTime.now());

        String url = "http://localhost:3001/api/productos-defectuosos";
        restTemplate.postForEntity(url, dto, Void.class);

       // productoRepository.save(producto);
        eventoDefectoPublisher.publicarEventoDefecto(dto);
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
