/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TreeHub.services.impl;

import com.TreeHub.domain.Arbol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.TreeHub.dao.ArbolDao;
import com.TreeHub.services.ArbolService;

@Service
public class ArbolServiceImpl implements ArbolService {

    @Autowired
    private ArbolDao ArbolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Arbol> getArbols(boolean activos) {
        var lista = ArbolDao.findAll();
        if (activos) {
            //Se deben eliminar de la lista los inactivos
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Arbol getArbol(Arbol Arbol) {
        return ArbolDao.findById(Arbol.getIdArbol()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Arbol Arbol) {
        ArbolDao.save(Arbol);
    }

    @Override
    @Transactional
    public void delete(Arbol Arbol) {
        ArbolDao.delete(Arbol);
    }
}
