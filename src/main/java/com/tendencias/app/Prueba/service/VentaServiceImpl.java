/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.Prueba.service;

import com.tendencias.app.Prueba.model.Ventas;
import com.tendencias.app.Prueba.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author tefip
 */
@Service
public class VentaServiceImpl extends GenericServiceImpl<Ventas, Integer> implements GenericService<Ventas, Integer> {

    @Autowired
    VentasRepository ventasRepository;

    @Override
    public CrudRepository<Ventas, Integer> getDao() {
        return ventasRepository;
    }
}
