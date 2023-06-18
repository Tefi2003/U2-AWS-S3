/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.Prueba.service;

import com.tendencias.app.Prueba.model.Compras;
import com.tendencias.app.Prueba.repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author tefip
 */
@Service
public class CompraServiceImpl extends GenericServiceImpl<Compras, Integer> implements GenericService<Compras, Integer> {

    @Autowired
    ComprasRepository comprasRepository;

    @Override
    public CrudRepository<Compras, Integer> getDao() {
        return comprasRepository;
    }
    
}
