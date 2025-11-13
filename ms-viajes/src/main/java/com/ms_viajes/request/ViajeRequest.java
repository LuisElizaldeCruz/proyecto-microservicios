package com.ms_viajes.request;

import java.time.LocalDate;

public class ViajeRequest {
    private int viajeId;
    private String folio;//cambiar por folio
    private int origenId;
    private int destinoId;
    private int tipoViajeId;
    private LocalDate fechaHora;
    private String linea;
    private String numUnidad;

    public ViajeRequest(){

    }

    public ViajeRequest(int viajeId, String folio, int origenId, int destinoId, int tipoViajeId, LocalDate fechaHora, String linea, String numUnidad) {
        this.viajeId = viajeId;
        this.folio = folio;
        this.origenId = origenId;
        this.destinoId = destinoId;
        this.tipoViajeId = tipoViajeId;
        this.fechaHora = fechaHora;
        this.linea = linea;
        this.numUnidad = numUnidad;
    }

    public int getViajeId() {
        return viajeId;
    }

    public void setViajeId(int viajeId) {
        this.viajeId = viajeId;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
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

    public String getNumUnidad() {
        return numUnidad;
    }

    public void setNumUnidad(String numUnidad) {
        this.numUnidad = numUnidad;
    }

    @Override
    public String toString() {
        return "ViajeRequest{" +
                "viajeId=" + viajeId +
                ", folio=" + folio +
                ", origenId=" + origenId +
                ", destinoId=" + destinoId +
                ", tipoViajeId=" + tipoViajeId +
                ", fechaHora=" + fechaHora +
                ", linea='" + linea + '\'' +
                ", numUnidad='" + numUnidad + '\'' +
                '}';
    }
}
