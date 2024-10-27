
package com.TreeHub.services;

import com.TreeHub.domain.Especie;
import java.util.List;


public interface EspecieService {
    //Se obtiene un arraylist con los registros de la tabla categoría, todos los registros o solo los activos

public List<Especie> getEspecies (boolean activos);


   // Se obtiene un Especie, a partir del id de un Especie
    public Especie getEspecie(Especie Especie);
    
    // Se inserta un nuevo Especie si el id del Especie esta vacío
    // Se actualiza un Especie si el id del Especie NO esta vacío
    public void save(Especie Especie);
    
    // Se elimina el Especie que tiene el id pasado por parámetro
    public void delete(Especie Especie);
}
