package com.TreeHub.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table (name="Especie")
public class Especie implements Serializable{
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspecie;
    
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    /*
create table Especie (
  id_Especie INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(30) NOT NULL,
  ruta_imagen varchar(1024),
  activo bool,
  PRIMARY KEY (id_Especie))*/
    
    
}
