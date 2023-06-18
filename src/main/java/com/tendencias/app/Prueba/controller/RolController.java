/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.Prueba.controller;
import com.tendencias.app.Prueba.model.Rol;
import com.tendencias.app.Prueba.service.RolServiceImpl;
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
@RequestMapping("/rol")
public class RolController {
    
    @Autowired
    RolServiceImpl rolServiceImpl;

    @Operation(summary = "Se obtiene la lista de Rol")
    @GetMapping("/listar")
    public ResponseEntity<List<Rol>> listaRol() {
        return new ResponseEntity<>(rolServiceImpl.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Rol")
    @PostMapping("/crear")
    public ResponseEntity<Rol> crearRol(@RequestBody Rol u) {
        return new ResponseEntity<>(rolServiceImpl.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable Integer id, @RequestBody Rol u) {
        Rol roll = rolServiceImpl.findById(id);
        if (roll != null) {
            try {
                roll.setRol_nombre(u.getRol_nombre());
                return new ResponseEntity<>(rolServiceImpl.save(roll), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Rol> elimiarRol(@PathVariable Integer id) {
        rolServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
