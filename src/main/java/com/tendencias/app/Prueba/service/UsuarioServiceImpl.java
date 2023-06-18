/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.Prueba.service;

import com.tendencias.app.Prueba.model.Usuarios;
import com.tendencias.app.Prueba.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author tefip
 */
@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuarios, Integer> implements GenericService<Usuarios, Integer> {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public CrudRepository<Usuarios, Integer> getDao() {
        return usuarioRepository;
    }


}
