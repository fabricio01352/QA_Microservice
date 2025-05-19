package com.empresa.qasystem.repository;

import com.empresa.qasystem.model.ProductoDefectuoso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoDefectuosoRepository extends JpaRepository<ProductoDefectuoso, Long> {

    // Método para obtener defectos urgentes
    List<ProductoDefectuoso> findByRequiereAtencionTrue();
}
