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
import java.util.Date;
import java.util.List;
import lombok.Data;
/**
 *
 * @author tefip
 */
@Data
@Entity
public class Ingreso {
    
    
    @ManyToOne
	    @JoinColumn(name="id_ventas", referencedColumnName="id_ventas")
	    private Ventas ventas;
    
    
   @ManyToOne
	    @JoinColumn(name="id_usuario", referencedColumnName="id_usuario")
	    private Usuarios usuarios;
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ing")
    private int id_ing;
    
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "ing_monto")
    private String ing_monto;
}
