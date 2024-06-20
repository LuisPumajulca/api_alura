package com.example.api.domain.paciente;

import com.example.api.domain.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;
public record DatosActualizarPaciente(
        @NotNull
        Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion
) {
}
