CREATE DATABASE IF NOT EXISTS qa;
USE qa;

-- DROP TABLE IF EXISTS producto;




CREATE TABLE producto(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY UNIQUE,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(500) DEFAULT 'N/A',
    defectuoso BOOLEAN DEFAULT 0,
    fecha VARCHAR(45) NOT NULL,
    costo float,
    requiereAtencion BOOLEAN DEFAULT 0,
    tipodefecto VARCHAR(50) DEFAULT 'N/A'

	

);