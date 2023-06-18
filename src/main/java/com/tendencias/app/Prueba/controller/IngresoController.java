/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.Prueba.controller;

import com.tendencias.app.Prueba.model.Ingreso;
import com.tendencias.app.Prueba.model.Ventas;
import com.tendencias.app.Prueba.service.IngresoServiceImpl;
import com.tendencias.app.Prueba.repository.VentasRepository;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author tefip
 */

@RestController
@RequestMapping("/ingreso")
public class IngresoController {
    
@Autowired
    IngresoServiceImpl ingresoService;

    @Operation(summary = "Se obtiene la lista de Usuarios")
    @GetMapping("/listar")
    public ResponseEntity<List<Ingreso>> listaIngreso() {
        return new ResponseEntity<>(ingresoService.findByAll(), HttpStatus.OK);
    }

    
   
    
    @GetMapping("/ingresoTotal")
    public ResponseEntity<Double> calcularIngreso() {
        VentasRepository ventarep = null;
        double ingto = ventarep.findAll().stream().mapToDouble(Ventas::getVen_precio).sum();
        return new ResponseEntity<>(ingto, HttpStatus.OK);
    }
    
    
//    @GetMapping("/ingresoProv")
//    public ResponseEntity<Double> calcularIngresoProv(@RequestParam Integer id) {
//        VentasRepository ventarep = null;
//        double ingpro = ventarep.findAll().stream().filter(venta -> venta.getCompras().getId_compra()==(id)).mapToDouble(Ventas::getVen_precio).sum();
//        return new ResponseEntity<>(ingpro, HttpStatus.OK);
//    }
//    
    

    public ResponseEntity<Ingreso> elimiarIngreso(@PathVariable Integer id) {
        ingresoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
   

}

