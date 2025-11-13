package com.ms_unidades.controller;

import com.ms_unidades.entity.Unidad;
import com.ms_unidades.logic.UnidadLogic;
import com.ms_unidades.request.UnidadRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/unidades")
public class UnidadController {

    @Autowired
    UnidadLogic service;

    @PostMapping//http://localhost:8090/api/v1/unidades
    public ResponseEntity<Unidad> guardar(@Valid @RequestBody UnidadRequest request){
        Unidad uni = service.registrar(request);
        return  new ResponseEntity<Unidad>(uni, HttpStatusCode.valueOf(200));
    }

    @PutMapping//http://localhost:8090/api/v1/unidades
    public ResponseEntity<Unidad> actualizar(@Valid @RequestBody UnidadRequest request){
        Unidad uni = service.actualizar(request);
        return  new ResponseEntity<Unidad>(uni, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{id}")//http://localhost:8090/api/v1/unidades
    public ResponseEntity<String> eliminar (@PathVariable int id){
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{placas}")
    public ResponseEntity<Unidad> buscar(@PathVariable String placas){
        Unidad uni = service.buscarPorPlacas(placas);
        return new ResponseEntity<Unidad>(uni,HttpStatusCode.valueOf(200));
    }

    @GetMapping//por defecto
    public ResponseEntity<List<Unidad>> mostrar(){
        List<Unidad> lista = service.mostrar();
        return  new ResponseEntity<List<Unidad>>(lista,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/cantidad-mayor/{cantidad}")
    public ResponseEntity<List<Unidad>> buscarCantidadMayorA(@PathVariable int cantidad){
        List<Unidad> lista = service.buscarConCantidadAsientosMayorA(cantidad);
        return new ResponseEntity<List<Unidad>>(lista, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/cantidad-menor/{cantidad}")
    public ResponseEntity<List<Unidad>> buscarCantidadMenorA(@PathVariable int cantidad){
        List<Unidad> lista = service.buscarConCantidadAsientosMenorA(cantidad);
        return new ResponseEntity<List<Unidad>>(lista,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/modelo/{modelo}/año/{año}")
    public ResponseEntity<List<Unidad>> buscarModeloAño(@PathVariable String modelo, @PathVariable int año){
        List<Unidad> lista = service.buscarModeloAño(modelo,año);
        return new ResponseEntity<List<Unidad>>(lista,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/tipo-servicio/{tipo}")
    public ResponseEntity<List<Unidad>> buscarTipoServicio(@PathVariable String tipo){
        List<Unidad> lista = service.buscarPorTipoServicio(tipo);
        return new ResponseEntity<List<Unidad>>(lista,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/buscar-num-unidad/{numUnidad}")
    public ResponseEntity<Unidad> buscarPorUnidad(@PathVariable String numUnidad){
        Unidad u = service.buscarPorNumUnidad(numUnidad);
        return new ResponseEntity<Unidad>(u,HttpStatusCode.valueOf(200));
    }
}
