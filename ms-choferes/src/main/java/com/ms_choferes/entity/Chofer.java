package com.ms_choferes.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "CHOFERES")
public class Chofer {
    @Id
    @Column(name = "CHOFER_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int choferId;

    @Column(name = "FOLIO", columnDefinition = "NVARCHAR(5)")
    String folio;

    @Column(name = "NOMBRE", columnDefinition = "NVARCHAR(100)")
    String nombre;

    @Column(name = "TIPO_SANGRE", columnDefinition = "NVARCHAR(3)")
    String tipoSangre;

    @Column(name = "FECHA_NAC", columnDefinition = "DATE")
    LocalDate fechaNac;

    @Column(name = "FECHA_INGRESO", columnDefinition = "DATE")
    LocalDate fechaIngreso;

    @Column(name = "TELEFONO", columnDefinition = "NVARCHAR(10)")
    String telefono;

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
}
