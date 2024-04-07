DROP DATABASE IF EXISTS cooper_up;
CREATE DATABASE cooper_up;
CREATE TABLE Alumno(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(50),
    apellido VARCHAR(50),
    biografia VARCHAR(200),
    foto_perfil VARCHAR(50), -- he estado buscando y dicen q l omejor es guardar la ruta de la imagen y que esa imagen se guarde en un servidor o algo asi 
    edad INT,
    correo VARCHAR(100),
    telefono VARCHAR(15),
    cv VARCHAR(50), -- todavia no se sabe si sera un enlace o una imagen (yo diria que enlace)
	github_username VARCHAR(50)
    );

CREATE TABLE Profesor(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    correo VARCHAR(100),
    centro_profesor VARCHAR(50),
    cursos_imparte VARCHAR(50)
    );    
    
CREATE TABLE Empresa(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50),
    nombre_empresa VARCHAR(50),
	foto_empresa VARCHAR(50) -- imagen que todavia no sabemos como
    );  
        