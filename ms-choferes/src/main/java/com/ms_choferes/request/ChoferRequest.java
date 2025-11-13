package com.ms_choferes.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class ChoferRequest {
    int choferId;

    @NotBlank(message = "Este campo no puede quedar vacio ni nulo")
    @Pattern(regexp = "^[A-Z]{2}\\d{2}$", message = "Esta placa no cumple con la esttructura")
    String folio;

    @NotBlank(message = "Este campo no puede quedar vacio ni nulo")
    String nombre;

    @NotBlank(message = "Este campo no puede quedar vacio ni nulo")
    @Pattern(regexp = "^(A|B|AB|O)[+-]$", message = "Ingresa un tipo de sangre valido")
    String tipoSangre;


    LocalDate fechaNac;
    LocalDate fechaIngreso;

    @NotBlank(message = "Este campo no puede quedar vacio ni nulo")
    @Pattern(regexp = "^\\d{10}$", message = "Ingresa un numero de telefono con el formato valido")
    String telefono;

    public ChoferRequest(){

    }

    public ChoferRequest(int choferId, String folio, String nombre, String tipoSangre, LocalDate fechaNac, LocalDate fechaIngreso, String telefono) {
        this.choferId = choferId;
        this.folio = folio;
        this.nombre = nombre;
        this.tipoSangre = tipoSangre;
        this.fechaNac = fechaNac;
        this.fechaIngreso = fechaIngreso;
        this.telefono = telefono;
    }

    public int getChoferId() {
        return choferId;
    }

    public void setChoferId(int choferId) {
        this.choferId = choferId;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ChoferRequest{" +
                "choferId=" + choferId +
                ", folio='" + folio + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipoSangre='" + tipoSangre + '\'' +
                ", fechaNac=" + fechaNac +
                ", fechaIngreso=" + fechaIngreso +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
