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
import jakarta.persistence.Transient;
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
public class Usuarios {
    
    @ManyToOne
	    @JoinColumn(name="id_rol", referencedColumnName="id_rol")
	    private Rol rol;
    
    
    @JsonIgnore
	    @OneToMany(mappedBy="usuarios")
	    private List<Egreso> listaEgreso;
    
    
    @JsonIgnore
	    @OneToMany(mappedBy="usuarios")
	    private List<Ingreso> listaIngreso;
    
    
    
    @JsonIgnore
	    @OneToMany(mappedBy="usuario")
	    private List<Ventas> listaVentas;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id_usuario;
    
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "per_nombre")
    private String per_nombre;
    
    @NotBlank(message = "El apellido no puede estar en blanco")
    @Column(name = "per_apellido")
    private String per_apellido;
    
    @Email(message = "Debe ingresar una dirección de correo válida")
    @Column(name = "per_correo")
    private String per_correo;
    
    @NotBlank(message = "La direcciono no puede estar en blanco")
    @Column(name = "per_direccion")
    private String per_direccion;
    
    @NotBlank(message = "La clave no puede estar en blanco")
    @Column(name = "per_clave")
    private String per_clave;
    
    @Column(name = "per_telefono")
    private int per_telefono;
    
    
    
    ///NUEVAS ENTIDADES PARA AWS-S3
    
    @Transient
    @Column(name = "per_cedula")
    private String per_cedula;
    
    @Transient
    @Column(name = "per_foto")
    private String per_foto;
}
