package com.TreeHub.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
@Data
@Entity
@Table (name="arbol")
public class Arbol implements Serializable{
private static final long serialVersionUID = 1l;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id_arbol;
private String nombre_comun;
private String tipo_flor;
private int dureza_madera;
private float altura;
private String ruta_imagen;


/*CREATE TABLE arbol (
    id_arbol INT NOT NULL AUTO_INCREMENT,
    nombre_comun VARCHAR(50) NOT NULL,
    tipo_flor VARCHAR(50) NOT NULL,
    dureza_madera INT NOT NULL,
    altura FLOAT NOT NULL,
    ruta_imagen VARCHAR(1024),
    PRIMARY KEY (id_arbol)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;
*/

}