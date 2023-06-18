/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.app.Prueba.repository;

import com.tendencias.app.Prueba.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author tefip
 */
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
        
    @Query(value = "Select * from producto u where u.pro_nombre = :pro_nombre", nativeQuery = true)
    public Producto buscarProducto(String pro_nombre);
}
