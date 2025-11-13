package com.ms_unidades.repository;

import com.ms_unidades.entity.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//DAO : Datta Access Object : Es el componente encargado de gestionar el acceso a la base de datos
//y sus consultas
@Repository//comunicacion y acceso a datos
public interface UnidadRepository extends JpaRepository<Unidad, Integer> {

    //buscarPorPlacas
    //@Query se usa para describir como se debe hacer una consulta personalizada
    @Query("SELECT u FROM Unidad u WHERE u.placas =:placas")//despues de los dos puntos es el valor de la variable que va a recbir
    Optional<Unidad> buscarPlacas(@Param("placas") String placas);

    //buscar unidades con cantidad asientos mayor A
    @Query("SELECT u FROM Unidad u WHERE u.asientos >=:asientos")
    List<Unidad> findByUnidadesMayoresA(@Param("asientos") int asientos);

    @Query("SELECT u FROM Unidad u WHERE u.asientos <=:asientos")
    List<Unidad> findByUnidadesMenoresA(@Param("asientos") int asientos);

    //buscar por modelo y anio
    @Query("SELECT u FROM Unidad u WHERE u.modelo =:modelo AND u.año =:año")
    List<Unidad> findByModeloAño(@Param("modelo") String modelo, @Param("año") int año);

    @Query("SELECT u FROM Unidad u WHERE u.tipoServicio =:servicio")
    List<Unidad> findByTipoServicio(@Param("servicio") String servicio);

    @Query("SELECT u FROM Unidad u Where u.numUnidad =:numUnidad")
    Optional<Unidad> findByNumUnidad(String numUnidad);

}
