package com.ms_unidades.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="UNIDADES")
//serializacion : desintegracion en bytes del estado de un objeto, para su transmision
//deserializacion : reconstruccion del estado del onjeto basado en la secuencia de bytes
public class Unidad implements Serializable {

    @Id
    @Column(name="UNIDAD_ID",columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unidadId;

    @Column(name="NUM_UNIDAD",columnDefinition = "NUMBER")
    private int numUnidad;

    @Column(name="PLACAS",columnDefinition = "NVARCHAR(10)")
    private String placas;

    @Column(name="ASIENTOS",columnDefinition = "NUMBER")
    private int asientos;

    @Column(name="TIPO_SERVICIO",columnDefinition = "NVARCHAR(20)")
    private String tipoServicio;

    @Column(name="MODELO",columnDefinition = "NVARCHAR(20)")
    private String modelo;

    @Column(name="AÑO",columnDefinition = "NUMBER")
    private int año;

    //si no generas ningu constructor, java otorga el vacio por default


    public int getUnidadId() {
        return unidadId;
    }

    public void setUnidadId(int unidadId) {
        this.unidadId = unidadId;
    }

    public int getNumUnidad() {
        return numUnidad;
    }

    public void setNumUnidad(int numUnidad) {
        this.numUnidad = numUnidad;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
}
