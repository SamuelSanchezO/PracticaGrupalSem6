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
private Long idArbol;
private Long idCategoria;
private String descripcion;
private String detalle;
private double precio;
private int existencias;
private String rutaImagen;
private boolean activo;

/*create table arbol (
id_arbol INT NOT NULL AUTO_INCREMENT,
id_categoria INT NOT NULL,
descripcion VARCHAR(30) NOT NULL,
detalle VARCHAR(1600) NOT NULL,
precio double,
existencias int,
ruta_imagen varchar(1024),
activo bool,
PRIMARY KEY (id_arbol),
foreign key fk_arbol_caregoria (id_categoria) references categoria(id_categoria)
)*/

}