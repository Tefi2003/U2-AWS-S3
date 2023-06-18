/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.Prueba.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;

/**
 *
 * @author tefip
 */
@Data
@Entity
public class Producto {
    
    
    
    @JsonIgnore
	    @OneToMany(mappedBy="producto")
	    private List<Ventas> listaVentas;
    
    @JsonIgnore
	    @OneToMany(mappedBy="producto")
	    private List<Compras> listaCompras;
    
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;
    
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "pro_nombre")
    private String pro_nombre;
    
    @NotBlank(message = "El detalle no puede estar en blanco")
    @Column(name = "pro_detalle")
    private String pro_detalle;
    
    @NotBlank(message = "La cantidad no puede estar en blanco")
    @Column(name = "pro_descrip")
    private String pro_descrip;
    
    @NotBlank(message = "La categoria no puede estar en blanco")
    @Column(name = "pro_categoria")
    private String pro_categoria;
    
    @Column(name = "pro_precio_emp")
    private double pro_precio_emp;
    
    @NotBlank(message = "La imagen no puede estar en blanco")
    @Column(name = "pro_img")
    private String pro_img;
    
    @NotBlank(message = "El adicional no puede estar en blanco")
    @Column(name = "pro_adicional")
    private String pro_adicional;
    
    @Column(name = "pro_cantidad")
    private int pro_cantidad;
    
    @Column(name = "pro_inv")
    private int pro_inv;
}
