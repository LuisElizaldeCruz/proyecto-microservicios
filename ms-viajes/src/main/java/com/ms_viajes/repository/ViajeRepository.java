package com.ms_viajes.repository;

import com.ms_viajes.entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Integer> {

    @Query("SELECT v FROM Viaje v WHERE v.choferId =:choferId")
    List<Viaje> findByChoferesId(@Param("choferId") int choferId);

    @Query("SELECT v FROM Viaje v WHERE v.linea =:lineaId")
    List<Viaje> findByLinea(@Param("lineaId") String lineaId);

    @Query("SELECT v FROM Viaje v WHERE v.autobusId =:autobusId")
    List<Viaje> findByUnidades(@Param("autobusId") int autobusId);
}
