/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.app.Prueba.repository;

import com.tendencias.app.Prueba.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author tefip
 */
public interface VentasRepository extends JpaRepository<Ventas, Integer>{
        
    @Query(value = "Select * from ventas u where u.id_venta = :id_venta", nativeQuery = true)
    public Ventas buscarVentas(String id_venta);
}
