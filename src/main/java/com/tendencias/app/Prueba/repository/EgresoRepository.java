/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.app.Prueba.repository;

import com.tendencias.app.Prueba.model.Egreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author tefip
 */
public interface EgresoRepository extends JpaRepository<Egreso, Integer>{
        
    @Query(value = "Select * from egreso u where u.egr_monto = :egr_monto", nativeQuery = true)
    public Egreso buscarEgreso(String egr_monto);
    
}
