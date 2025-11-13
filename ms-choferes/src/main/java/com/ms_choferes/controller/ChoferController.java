package com.ms_choferes.controller;

import com.ms_choferes.entity.Chofer;
import com.ms_choferes.logic.ChoferLogic;
import com.ms_choferes.request.ChoferRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/choferes")
public class ChoferController {

    @Autowired
    ChoferLogic chService;

    @GetMapping
    public ResponseEntity<List<Chofer>> mostrarTodos(){
        List<Chofer> listaCh = chService.mostrar();

        return new ResponseEntity<List<Chofer>>(listaCh, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<Chofer> guardar(@Valid @RequestBody ChoferRequest request){
        Chofer ch = chService.registrar(request);
        return new ResponseEntity<Chofer>(ch,HttpStatusCode.valueOf(300));
    }

    @PutMapping
    public ResponseEntity<Chofer> actualizar(@Valid @RequestBody ChoferRequest request){
        Chofer ch = chService.actualizar(request);
        return new ResponseEntity<Chofer>(ch,HttpStatusCode.valueOf(300));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        String mensaje = chService.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/buscar-folio/{folio}")
    public ResponseEntity<Chofer> buscarFolio(@PathVariable String folio){
        Chofer ch = chService.buscarPorFolio(folio);
        return new ResponseEntity<Chofer>(ch, HttpStatusCode.valueOf(200));
    }

}
