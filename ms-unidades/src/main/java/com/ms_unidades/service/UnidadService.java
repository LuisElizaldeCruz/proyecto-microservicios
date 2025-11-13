package com.ms_unidades.service;

import com.ms_unidades.entity.Unidad;
import com.ms_unidades.request.UnidadRequest;
import org.springframework.stereotype.Service;

import java.util.List;

//interface de negocio : deseñá las operaciones de las que este servicio se hara cargo
public interface UnidadService {

    /*
    registrar
    actualizar
    borrar
    leer
    buscar(placas)
    buscarPorAsientosMayoresA()
    buscarPorAsientosMenoresA()
    Buscar(modelo anio)
    buscarPorTipoServicio(tipo)
     */

    Unidad registrar(UnidadRequest request);
    Unidad actualizar(UnidadRequest request);
    String eliminar(int unidadId);
    List<Unidad> mostrar();
    Unidad buscarPorPlacas(String placas);
    List<Unidad> buscarConCantidadAsientosMayorA(int asientos);
    List<Unidad> buscarConCantidadAsientosMenorA(int asientos);
    List<Unidad> buscarModeloAño(String modelo, int año);
    List<Unidad> buscarPorTipoServicio(String tipo);
    Unidad buscarPorNumUnidad(String numUnidad);

}
