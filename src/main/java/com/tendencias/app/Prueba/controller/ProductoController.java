/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.Prueba.controller;
import com.tendencias.app.Prueba.model.Producto;
import com.tendencias.app.Prueba.service.ProductoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author tefip
 */
@RestController
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    ProductoServiceImpl productoService;

    @Operation(summary = "Se obtiene la lista de Producto")
    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listaProducto() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Producto")
    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto u) {
        return new ResponseEntity<>(productoService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto u) {
        Producto prod = productoService.findById(id);
        if (prod != null) {
            try {
                prod.setPro_nombre(u.getPro_nombre());
                prod.setPro_detalle(u.getPro_detalle());
                prod.setPro_descrip(u.getPro_descrip());
                prod.setPro_categoria(u.getPro_categoria());
                prod.setPro_cantidad(u.getPro_cantidad());
                prod.setPro_img(u.getPro_img());
                prod.setPro_precio_emp(u.getPro_precio_emp());
                prod.setPro_inv(u.getPro_inv());
                prod.setPro_adicional(u.getPro_adicional());
                return new ResponseEntity<>(productoService.save(prod), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Producto> elimiarProducto(@PathVariable Integer id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
