package org.example.appqa_registardefecto.controller;


import org.example.appqa_registardefecto.dto.ProductoDTO;
import org.example.appqa_registardefecto.model.Producto;
import org.example.appqa_registardefecto.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


/**
 * Fabricio Omar y Carlos
 * Aqui se exponen los endpoints mediante la arquitectura REST y son consumidops por el cliente frontend
 *
 * Ahora no se usaria mucho este endpoint porque rabbit no jalo
 * as que esta parte de la app va mandar los post a la otra app
 */
@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * Crear un producto
     * @param DTO dto para ocultar cmpos de la entidddad al cliente
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> agregarProducto(@RequestBody ProductoDTO DTO) {
        productoService.agregarProducto(DTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    /**
     * buscar un producto
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Producto> obtenerProducto(@PathVariable Long id){
        System.out.println(productoService.obtenerProducto(id));
        return productoService.obtenerProducto(id);



    }


    /**
     * Eliminar un producto
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id){
        productoService.eliminar(id);
        return ResponseEntity.ok().build();
    }


    /**
     * Actualizar un producot
     * @param id
     * @param DTO
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody ProductoDTO DTO){
        Producto productoActualizado = productoService.actualizarProducto(id, DTO);
        return ResponseEntity.ok(productoActualizado);
    }


}
