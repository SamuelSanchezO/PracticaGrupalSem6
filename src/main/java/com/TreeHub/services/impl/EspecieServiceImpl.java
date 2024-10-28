/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TreeHub.services.impl;

import com.TreeHub.dao.EspecieDao;
import com.TreeHub.domain.Especie;
import com.TreeHub.services.EspecieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EspecieServiceImpl implements EspecieService {

    @Autowired
    private EspecieDao especieDao;

    @Override
    @Transactional(readOnly = true)
    public List<Especie> getEspecies(boolean activos) {
        var lista = especieDao.findAll();
        if (activos) {
            //Se deben eliminar de la lista los inactivos
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Especie getEspecie(Especie especie) {
        return especieDao.findById(especie.getIdEspecie()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Especie especie) {
        especieDao.save(especie);
    }

    @Override
    @Transactional
    public void delete(Especie especie) {
        especieDao.delete(especie);
    }
}
