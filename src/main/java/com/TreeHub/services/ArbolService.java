
package com.TreeHub.services;

import com.TreeHub.domain.Arbol;
import java.util.List;


public interface ArbolService {
    //Se obtiene un arraylist con los registros de la tabla categoría, todos los registros o solo los activos

public List<Arbol> getArbols (boolean activos);


   // Se obtiene un Arbol, a partir del id de un Arbol
    public Arbol getArbol(Arbol Arbol);
    
    // Se inserta un nuevo Arbol si el id del Arbol esta vacío
    // Se actualiza un Arbol si el id del Arbol NO esta vacío
    public void save(Arbol Arbol);
    
    // Se elimina el Arbol que tiene el id pasado por parámetro
    public void delete(Arbol Arbol);
}
