/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.app.Prueba.repository;

import com.tendencias.app.Prueba.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author tefip
 */
public interface RolRepository extends JpaRepository<Rol, Integer>{
        
    @Query(value = "Select * from rol u where u.rol_nombre = :rol_nombre", nativeQuery = true)
    public Rol buscarRol(String rol_nombre);
    
}
