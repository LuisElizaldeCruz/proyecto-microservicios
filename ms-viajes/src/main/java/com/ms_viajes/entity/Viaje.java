package com.ms_viajes.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "VIAJES")
public class Viaje {

    @Id
    @Column(name = "VIAJE_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int viajeId;

    @Column(name = "CHOFER_ID", columnDefinition = "NUMBER")
    private int choferId;

    @Column(name = "ORIGEN_ID", columnDefinition = "NUMBER")
    private int origenId;

    @Column(name = "DESTINO_ID", columnDefinition = "NUMBER")
    private int destinoId;

    @Column(name = "TIPO_VIAJE_ID", columnDefinition = "NUMBER")
    private int tipoViajeId;

    @Column(name = "FECHA_HORA", columnDefinition = "DATE")
    private LocalDate fechaHora;

    @Column(name = "LINEA", columnDefinition = "NVARCHAR(10)")
    private String linea;

    @Column(name = "UNIDAD_ID", columnDefinition = "NUMBER")
    private int autobusId;

    public int getViajeId() {
        return viajeId;
    }

    public void setViajeId(int viajeId) {
        this.viajeId = viajeId;
    }

    public int getChoferId() {
        return choferId;
    }

    public void setChoferId(int choferId) {
        this.choferId = choferId;
    }

    public int getOrigenId() {
        return origenId;
    }

    public void setOrigenId(int origenId) {
        this.origenId = origenId;
    }

    public int getDestinoId() {
        return destinoId;
    }

    public void setDestinoId(int destinoId) {
        this.destinoId = destinoId;
    }

    public int getTipoViajeId() {
        return tipoViajeId;
    }

    public void setTipoViajeId(int tipoViajeId) {
        this.tipoViajeId = tipoViajeId;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public int getAutobusId() {
        return autobusId;
    }

    public void setAutobusId(int autobusId) {
        this.autobusId = autobusId;
    }
}
