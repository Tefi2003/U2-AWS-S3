/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.app.Prueba.repository;

import com.tendencias.app.Prueba.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author tefip
 */
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer>{
        
    @Query(value = "Select * from usuario u where u.nombre = :nombre", nativeQuery = true)
    public Usuarios buscarUsuario(String nombre);
}
