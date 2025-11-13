package com.ms_viajes.service;

import com.ms_viajes.entity.Viaje;
import com.ms_viajes.request.ViajeRequest;

import java.util.List;

public interface ViajeService {

    List<Viaje> mostrar();
    Viaje registrar(ViajeRequest vrequest);
    Viaje actualizar(ViajeRequest vrequest);
    String eliminar(int id);

    List<Viaje> buscarChoferId(int choferId);
    List<Viaje> buscarPorLinea(String linea);
    List<Viaje> buscarPorUnidad(int unidadId);

}
