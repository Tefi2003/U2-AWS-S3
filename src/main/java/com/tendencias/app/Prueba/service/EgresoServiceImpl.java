/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.Prueba.service;

import com.tendencias.app.Prueba.model.Egreso;
import com.tendencias.app.Prueba.repository.EgresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author tefip
 */
@Service
public class EgresoServiceImpl extends GenericServiceImpl<Egreso, Integer> implements GenericService<Egreso, Integer> {

    @Autowired
    EgresoRepository egresoRepository;

    @Override
    public CrudRepository<Egreso, Integer> getDao() {
        return egresoRepository;
    }
    
}
