/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendencias.app.Prueba.repository;

import com.tendencias.app.Prueba.model.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author tefip
 */
public interface ComprasRepository extends JpaRepository<Compras, Integer>{
     
    @Query(value = "Select * from compras u where u.id_compra = :id_compra", nativeQuery = true)
    public Compras buscarCompra(String id_compra);
}
