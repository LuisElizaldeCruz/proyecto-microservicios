package com.ms_choferes.logic;

import com.ms_choferes.entity.Chofer;
import com.ms_choferes.exception.BusinessException;
import com.ms_choferes.exception.ResourceNotFoundException;
import com.ms_choferes.message.Constants;
import com.ms_choferes.repository.ChoferRepository;
import com.ms_choferes.request.ChoferRequest;
import com.ms_choferes.service.ChoferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChoferLogic implements ChoferService {

    @Autowired
    private ChoferRepository repo;


    @Override
    public List<Chofer> mostrar() {
        return repo.findAll();
    }

    @Override
    public Chofer registrar(ChoferRequest request) {

        if(repo.findByFolio(request.getFolio()).isEmpty()){

        Chofer ch = new Chofer();
        ch.setFolio(request.getFolio());
        ch.setNombre(request.getNombre());
        ch.setTipoSangre(request.getTipoSangre());
        ch.setFechaNac(request.getFechaNac());
        ch.setFechaIngreso(request.getFechaIngreso());
        ch.setTelefono(request.getTelefono());

        repo.save(ch);
        return ch;
        }else{
            throw new BusinessException("Este folio ya existe");
        }

    }

    @Override
    public Chofer actualizar(ChoferRequest request) {
        Chofer ch = repo.findById(request.getChoferId()).get();
        ch.setFolio(request.getFolio());
        ch.setNombre(request.getNombre());
        ch.setTipoSangre(request.getTipoSangre());
        ch.setFechaNac(request.getFechaNac());
        ch.setFechaIngreso(request.getFechaIngreso());
        ch.setTelefono(request.getTelefono());

        repo.save(ch);
        return ch;
    }

    @Override
    public String eliminar(int choferId) {
        repo.deleteById(choferId);
        return "Eliminado";
    }

    @Override
    public Chofer buscarPorFolio(String folio) {
        Optional<Chofer> ch = repo.findByFolio(folio);
        Chofer data = null;
        if(ch.isPresent()){
            data = ch.get();
            return data;
        }else{
            throw  new ResourceNotFoundException(Constants.FOLIO_EXISTENTE);

        }
    }
}
