package com.ms_unidades.request;

import jakarta.validation.constraints.*;

//replica de la estructura de la tabla sin anotaciones
public class UnidadRequest {
    private int unidadId;

    //@NotBlank(message = "Este campo no puede quedar vacio ni nulo")
    @Digits(integer = 5, fraction = 0, message = "Este campo solo permite nuemeros enteros de hasta 5 cifras")
    private int numUnidad;

    @Pattern(regexp = "([A-Z]{3}[-][A-Z]{3}-[0-9]{1})", message = "Esta placa no cumple con la estructura")
    private String placas;//FALTA VALIDAR QUE NO SE REPITA

    @Max(value = 35, message = "Este campo no permite valores mayores a 35")
    @Digits(integer = 2, fraction = 0, message = "Este campo solo permite nuemeros enteros")
    private int asientos;

    @NotBlank(message = "Este campo no puede quedar vacio ni nulo")
    @Pattern(regexp = "^(LUJO|ECONOMICO|PRIMERA)$", message = "El tipo debe ser 'LUJO', 'ECONOMICO' o 'PRIMERA'")
    private String tipoServicio;

    @NotBlank(message = "Este campo no puede quedar vacio ni nulo")
    @Size(max = 25, min = 10, message = "El valor ingresado no cumple con la longitud necesaria")
    private String modelo;

    @Min(value = 2018)
    private int año;

    public UnidadRequest(){

    }

    public UnidadRequest(int unidadId, int numUnidad, String placas, int asientos, String tipoServicio, String modelo, int año) {
        this.unidadId = unidadId;
        this.numUnidad = numUnidad;
        this.placas = placas;
        this.asientos = asientos;
        this.tipoServicio = tipoServicio;
        this.modelo = modelo;
        this.año = año;
    }

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

    @Override
    public String toString() {
        return "UnidadRequest{" +
                "unidadId=" + unidadId +
                ", numUnidad=" + numUnidad +
                ", placas='" + placas + '\'' +
                ", asicentos=" + asientos +
                ", tipoServicio='" + tipoServicio + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + año +
                '}';
    }
}
