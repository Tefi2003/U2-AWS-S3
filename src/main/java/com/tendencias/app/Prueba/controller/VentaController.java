/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.Prueba.controller;

import com.tendencias.app.Prueba.model.Ventas;
import com.tendencias.app.Prueba.service.VentaServiceImpl;
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
@RequestMapping("/ventas")
public class VentaController {
 
    @Autowired
    VentaServiceImpl ventasService;

    @Operation(summary = "Se obtiene la lista de Ventas")
    @GetMapping("/listar")
    public ResponseEntity<List<Ventas>> listaVentas() {
        return new ResponseEntity<>(ventasService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Ventas")
    @PostMapping("/crear")
    public ResponseEntity<Ventas> crearVentas(@RequestBody Ventas u) {
        return new ResponseEntity<>(ventasService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Ventas> actualizarVentas(@PathVariable Integer id, @RequestBody Ventas u) {
        Ventas vent = ventasService.findById(id);
        if (vent != null) {
            try {
                vent.setVen_nombre(u.getVen_nombre());
                vent.setVen_cantidad(u.getVen_cantidad());
                vent.setVen_fecha(u.getVen_fecha());
                vent.setVen_precio(u.getVen_precio());
                return new ResponseEntity<>(ventasService.save(vent), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Ventas> elimiarVentas(@PathVariable Integer id) {
        ventasService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
