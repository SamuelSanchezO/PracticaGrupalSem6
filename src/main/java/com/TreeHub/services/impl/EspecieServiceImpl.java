/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TreeHub.services.impl;

import com.TreeHub.domain.Especie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.TreeHub.dao.EspecieDao;
import com.TreeHub.services.EspecieService;

@Service
public class EspecieServiceImpl implements EspecieService {

    @Autowired
    private EspecieDao EspecieDao;

    @Override
    @Transactional(readOnly = true)
    public List<Especie> getEspecies(boolean activos) {
        var lista = EspecieDao.findAll();
        if (activos) {
            //Se deben eliminar de la lista los inactivos
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Especie getEspecie(Especie Especie) {
        return EspecieDao.findById(Especie.getIdEspecie()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Especie Especie) {
        EspecieDao.save(Especie);
    }

    @Override
    @Transactional
    public void delete(Especie Especie) {
        EspecieDao.delete(Especie);
    }
}
