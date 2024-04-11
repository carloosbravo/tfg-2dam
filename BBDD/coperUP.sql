create database coperup;
use coperup;
CREATE TABLE UsuarioNormal (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    cv TEXT,
    expediente_academico TEXT,
    valoracion_profesorado DECIMAL(3,2),
    centro_id INT,
    FOREIGN KEY (centro_id) REFERENCES Centro(id)
);

CREATE TABLE Empresa (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    biografia TEXT,
    oferta_practicas TEXT,
    oferta_trabajo TEXT
);

CREATE TABLE Centro (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    direccion VARCHAR(255),
    contraseña VARCHAR(255) NOT NULL,
    telefono VARCHAR(20)
);

CREATE TABLE Solicitud (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario_id INT,
    empresa_id INT,
    tipo_oferta ENUM('practica', 'trabajo') NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES UsuarioNormal(id),
    FOREIGN KEY (empresa_id) REFERENCES Empresa(id)
);
 tabla intermedia entre centro y empresa para ver valoración del centro.


