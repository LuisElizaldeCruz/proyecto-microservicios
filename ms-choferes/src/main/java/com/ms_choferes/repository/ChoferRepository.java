package com.ms_choferes.repository;

import com.ms_choferes.entity.Chofer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChoferRepository  extends JpaRepository<Chofer, Integer> {

    @Query("SELECT c FROM Chofer c WHERE c.folio =:folio")
    Optional<Chofer> findByFolio (String folio);
}
