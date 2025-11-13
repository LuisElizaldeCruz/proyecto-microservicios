package com.ms_viajes.records;

import java.time.LocalDate;

public record ChoferRecord(int choferId, String folio, String nombre, String tipoSangre, LocalDate fechaNac, LocalDate fechaIngreso, String telefono) {
}
