/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendencias.app.Prueba.controller;
import com.tendencias.app.Prueba.model.Compras;
import com.tendencias.app.Prueba.model.Usuarios;
import com.tendencias.app.Prueba.service.CompraServiceImpl;
import com.tendencias.app.Prueba.service.UsuarioServiceImpl;
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
@RequestMapping("/compras")
public class CompraController {
    
    @Autowired
    CompraServiceImpl compraService;

    @Operation(summary = "Se obtiene la lista de Compras")
    @GetMapping("/listar")
    public ResponseEntity<List<Compras>> listaCompras() {
        return new ResponseEntity<>(compraService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de la Compras")
    @PostMapping("/crear")
    public ResponseEntity<Compras> crearCompras(@RequestBody Compras u) {
        return new ResponseEntity<>(compraService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Compras> actualizarCompras(@PathVariable Integer id, @RequestBody Compras u) {
        Compras comp = compraService.findById(id);
        if (comp != null) {
            try {
                comp.setCom_det(u.getCom_det());
                comp.setCom_fecha(u.getCom_fecha());
               // comp.setProducto(u.getProducto());
                return new ResponseEntity<>(compraService.save(comp), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Compras> elimiarCompras(@PathVariable Integer id) {
        compraService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
