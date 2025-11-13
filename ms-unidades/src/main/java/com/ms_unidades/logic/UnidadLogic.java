package com.ms_unidades.logic;

import com.ms_unidades.entity.Unidad;
import com.ms_unidades.exception.BusinessException;
import com.ms_unidades.exception.ResourceNotFoundException;
import com.ms_unidades.message.Constants;
import com.ms_unidades.repository.UnidadRepository;
import com.ms_unidades.request.UnidadRequest;
import com.ms_unidades.service.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadLogic implements UnidadService {

    //inyeccion de dependencias / inversion de control
    //inyeccion de dependencias : exponer/consumir la funcionalidad
    //de un componenete de manera desacoplada (cuando y donde se necesite)
    @Autowired
    private UnidadRepository repo;

    //DTO : data transfer objeto para transmitir solo los datos necesarios

    @Override
    public Unidad registrar(UnidadRequest request) {
        Unidad u = null;
        //tengo que validar que la placa no este repetida
        if (repo.buscarPlacas(request.getPlacas()).isEmpty()) {
            //aqui todavia no existe la placa se puede registrar
            u = new Unidad();
            u.setNumUnidad(request.getNumUnidad());
            u.setAño(request.getAño());
            u.setAsientos(request.getAsientos());
            u.setModelo(request.getModelo());
            u.setTipoServicio(request.getTipoServicio());
            u.setPlacas(request.getPlacas());
            //guardar
            repo.save(u);
        return u;
        }else{
            throw new BusinessException(Constants.PLACA_EXISTENTE);
        }

    }

    @Override
    public Unidad actualizar(UnidadRequest request) {
        Unidad u = repo.findById(request.getUnidadId()).get();
        u.setNumUnidad(request.getNumUnidad());
        u.setAño(request.getAño());
        u.setAsientos(request.getAsientos());
        u.setModelo(request.getModelo());
        u.setTipoServicio(request.getTipoServicio());
        u.setPlacas(request.getPlacas());

        //guardar
        repo.save(u);
        return u;
    }

    @Override
    public String eliminar(int unidadId) {
        repo.deleteById(unidadId);
        return "Eliminado";
    }

    @Override
    public List<Unidad> mostrar() {
        return repo.findAll();
    }

    @Override
    public Unidad buscarPorPlacas(String placas) {
        Optional<Unidad> uni = repo.buscarPlacas(placas);
        Unidad data = null;

        if (uni.isPresent()) {
            data = uni.get();
        return data;
        }else{
            throw  new ResourceNotFoundException(Constants.PLACA_NO_EXISTE);
        }
    }

    @Override
    public List<Unidad> buscarConCantidadAsientosMayorA(int asientos) {

        return repo.findByUnidadesMayoresA(asientos);
    }

    @Override
    public List<Unidad> buscarConCantidadAsientosMenorA(int asientos) {
        return repo.findByUnidadesMenoresA(asientos);
    }

    @Override
    public List<Unidad> buscarModeloAño(String modelo, int año) {
        return repo.findByModeloAño(modelo, año);
    }

    @Override
    public List<Unidad> buscarPorTipoServicio(String tipo) {
        return repo.findByTipoServicio(tipo);
    }

    @Override
    public Unidad buscarPorNumUnidad(String numUnidad) {
        Optional<Unidad> uni = repo.findByNumUnidad(numUnidad);
        Unidad data = null;

        if (uni.isPresent()) {
            data = uni.get();
        return data;
        }else{
            throw new ResourceNotFoundException(Constants.UNIDAD_NO_EXISTE);
        }
    }


}
