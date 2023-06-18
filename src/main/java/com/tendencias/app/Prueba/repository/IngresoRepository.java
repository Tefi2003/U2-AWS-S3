/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.app.Prueba.repository;

import com.tendencias.app.Prueba.model.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author tefip
 */
public interface IngresoRepository extends JpaRepository<Ingreso, Integer>{
        
    @Query(value = "Select * from ingreso u where u.ing_pvp = :ing_pvp", nativeQuery = true)
    public Ingreso buscarIngreso(String ing_pvp);
    
}
