-- Crear tablas de la base de datos
CREATE TABLE IF NOT EXISTS lote (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS producto_defectuoso (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    tipo_defecto VARCHAR(255) NOT NULL,
    costo DOUBLE NOT NULL,
    fecha DATETIME NOT NULL,
    requiere_atencion BOOLEAN NOT NULL,
    lote_id BIGINT,
    FOREIGN KEY (lote_id) REFERENCES lote(id)
);