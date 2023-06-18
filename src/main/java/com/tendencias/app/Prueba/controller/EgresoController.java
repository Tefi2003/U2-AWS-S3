/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.Prueba.controller;

import com.tendencias.app.Prueba.model.Egreso;
import com.tendencias.app.Prueba.service.EgresoServiceImpl;
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
@RequestMapping("/egreso")
public class EgresoController {
    
    @Autowired
    EgresoServiceImpl egresoService;

    @Operation(summary = "Se obtiene la lista de Egreso")
    @GetMapping("/listar")
    public ResponseEntity<List<Egreso>> listaEgreso() {
        return new ResponseEntity<>(egresoService.findByAll(), HttpStatus.OK);
    }

    

    public ResponseEntity<Egreso> elimiarEgreso(@PathVariable Integer id) {
        egresoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

