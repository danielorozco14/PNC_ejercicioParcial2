CREATE DATABASE ejercicio2;

CREATE TABLE importancia(
    c_importancia serial NOT NULL PRIMARY KEY,
    s_importancia varchar (30)
);

CREATE TABLE contribuyente(

    c_contribuyente serial NOT NULL PRIMARY KEY,
    c_importancia INTEGER,
    s_nombre varchar(30),
    s_apellido varchar (30),
    s_nit varchar (14),
    f_fecha_ingreso DATE,

    FOREIGN KEY (c_importancia) REFERENCES importancia(c_importancia)

);

INSERT INTO importancia (c_importancia,s_importancia) VALUES (1,'Grandes');
INSERT INTO importancia (c_importancia,s_importancia) VALUES (2,'Medianos');
INSERT INTO importancia (c_importancia,s_importancia) VALUES (3,'Otros');

SELECT C.c_contribuyente, I.s_importancia AS c_importancia,C.s_nombre,C.s_apellido,C.s_nit,C.f_fecha_ingreso
FROM contribuyente C INNER JOIN importancia I 
ON C.c_importancia=I.c_importancia;