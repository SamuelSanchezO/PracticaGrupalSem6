/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TreeHub.services.impl;

import com.TreeHub.dao.ArbolDao;
import com.TreeHub.domain.Arbol;
import com.TreeHub.services.ArbolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArbolServiceImpl implements ArbolService {

    @Autowired
    private ArbolDao arbolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Arbol> getArboles(boolean activos) {
        var lista = arbolDao.findAll();
        if (activos) {
            //Se deben eliminar de la lista los inactivos
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Arbol getArbol(Arbol arbol) {
        return arbolDao.findById(arbol.getIdArbol()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Arbol arbol) {
        arbolDao.save(arbol);
    }

    @Override
    @Transactional
    public void delete(Arbol arbol) {
        arbolDao.delete(arbol);
    }
}
