package org.example.appqa_registardefecto.repository;

import org.example.appqa_registardefecto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * usamos el repositorio de JPA con el connector de MySQL, no utilizamos metodos personalizados
 */
@Repository
public interface ProductoRepository  extends JpaRepository<Producto,Long> {

  // metodos personalizados con @QUERY





}
