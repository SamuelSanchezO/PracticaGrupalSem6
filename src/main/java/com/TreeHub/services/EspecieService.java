package com.TreeHub.services;

import com.TreeHub.domain.Especie;
import java.util.List;
public interface EspecieService {
    
//Se obtiene un arraylist con los registros de la tabla categoría, todos los registros o solo los activos
public List getEspecies (boolean activos);
// Se obtiene un Especie, a partir del id de un especie
public Especie getEspecie(Especie especie);

// Se inserta un nuevo especie si el id del especie esta vacío
// Se actualiza un especie si el id del especie NO esta vacío
public void save(Especie especie);

// Se elimina el especie que tiene el id pasado por parámetro
public void delete(Especie especie);
}