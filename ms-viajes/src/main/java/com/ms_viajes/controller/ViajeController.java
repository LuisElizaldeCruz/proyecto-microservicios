package com.ms_viajes.controller;

import com.ms_viajes.entity.Viaje;
import com.ms_viajes.logic.ViajeLogic;
import com.ms_viajes.request.ViajeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/viajes")
public class ViajeController {

    @Autowired
    ViajeLogic vilService;

    @GetMapping
    public ResponseEntity<List<Viaje>> mostrar(){
        List<Viaje> vLista = vilService.mostrar();
        return new ResponseEntity<List<Viaje>>(vLista,HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<String> eliminar (@PathVariable int id){
        String mensaje = vilService.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<Viaje> registrarViaje(@RequestBody ViajeRequest request){
        Viaje vi = vilService.registrar(request);
        return new ResponseEntity<Viaje>(vi,HttpStatusCode.valueOf(200));
    }

    @PutMapping
    public ResponseEntity<Viaje> ActualizarViaje(@RequestBody ViajeRequest request){
        Viaje vi = vilService.actualizar(request);
        return new ResponseEntity<Viaje>(vi,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/chofer/{id}")
    public ResponseEntity<List<Viaje>> buscarChofer(@PathVariable int id){
        List<Viaje> lista = vilService.buscarChoferId(id);
        return new ResponseEntity<List<Viaje>>(lista,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/linea/{lin}")
    public ResponseEntity<List<Viaje>> buscarLinea(@PathVariable String lin){
        List<Viaje> lista = vilService.buscarPorLinea(lin);
        return new ResponseEntity<List<Viaje>>(lista,HttpStatusCode.valueOf(200));
    }

    @GetMapping("unidad/{unidadId}")
    public ResponseEntity<List<Viaje>> buscarPorUnidad(@PathVariable int unidadId){
        List<Viaje> listUnidad = vilService.buscarPorUnidad(unidadId);
        return new ResponseEntity<List<Viaje>>(listUnidad,HttpStatusCode.valueOf(200));
    }

}
