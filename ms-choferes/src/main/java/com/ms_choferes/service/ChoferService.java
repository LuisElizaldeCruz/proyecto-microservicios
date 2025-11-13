package com.ms_choferes.service;

import com.ms_choferes.entity.Chofer;
import com.ms_choferes.request.ChoferRequest;

import java.util.List;
import java.util.Optional;

public interface ChoferService {

    List<Chofer> mostrar();
    Chofer registrar(ChoferRequest request);
    Chofer actualizar(ChoferRequest request);
    String eliminar(int choferId);
    Chofer buscarPorFolio(String folio);
}
