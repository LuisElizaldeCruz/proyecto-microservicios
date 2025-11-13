package com.ms_viajes.logic;

import com.ms_viajes.entity.Viaje;
import com.ms_viajes.records.ChoferRecord;
import com.ms_viajes.records.UnidadRecord;
import com.ms_viajes.repository.ViajeRepository;
import com.ms_viajes.request.ViajeRequest;
import com.ms_viajes.service.ViajeService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ViajeLogic implements ViajeService {

    @Autowired
    private ViajeRepository vrepo;

    //Clientehttp
    RestTemplate http = new RestTemplate();

    @Override
    public Viaje registrar(ViajeRequest vrequest) {

        //llenamos el objeto a partir de una llamada HTTP hacia el otro servicio
        ChoferRecord chRecord = http.getForObject("http://localhost:8093/api/v1/choferes/buscar-folio/"+vrequest.getFolio(),ChoferRecord.class);
        UnidadRecord record = http.getForObject("http://localhost:8090/api/v1/unidades/buscar-num-unidad/"+vrequest.getNumUnidad(),UnidadRecord.class);
        //http://localhost:8090/api/v1/unidades/buscar-num-unidad/5143
        Viaje v = new Viaje();
        //v.setViajeId(vrequest.getViajeId());
        v.setChoferId(chRecord.choferId());
        v.setOrigenId(vrequest.getOrigenId());
        v.setDestinoId(vrequest.getDestinoId());
        v.setTipoViajeId(vrequest.getTipoViajeId());
        v.setFechaHora(vrequest.getFechaHora());
        v.setLinea(vrequest.getLinea());
        v.setAutobusId(record.unidadId());//id de autobus

        vrepo.save(v);
        return v;
    }

    @Override
    public Viaje actualizar(ViajeRequest vrequest) {
        ChoferRecord chRecord = http.getForObject("http://localhost:8093/api/v1/choferes/buscar-folio/"+vrequest.getFolio(),ChoferRecord.class);
        UnidadRecord record = http.getForObject("http://localhost:8090/api/v1/unidades/buscar-num-unidad/"+vrequest.getNumUnidad(),UnidadRecord.class);
        Viaje v = vrepo.findById(vrequest.getViajeId()).get();
        v.setChoferId(chRecord.choferId());
        v.setOrigenId(vrequest.getOrigenId());
        v.setDestinoId(vrequest.getDestinoId());
        v.setTipoViajeId(vrequest.getTipoViajeId());
        v.setFechaHora(vrequest.getFechaHora());
        v.setLinea(vrequest.getLinea());
        v.setAutobusId(record.unidadId());
        vrepo.save(v);

        return v;
    }

    @Override
    public String eliminar(int id) {
        vrepo.deleteById(id);
        return "Eliminado";
    }

    @Override
    public List<Viaje> mostrar() {
        return vrepo.findAll();
    }

    @Override
    public List<Viaje> buscarChoferId(int choferId) {
        return vrepo.findByChoferesId(choferId);
    }

    @Override
    public List<Viaje> buscarPorLinea(String linea) {
        return vrepo.findByLinea(linea);
    }

    @Override
    public List<Viaje> buscarPorUnidad(int unidad){
        return vrepo.findByUnidades(unidad);
    }


}
