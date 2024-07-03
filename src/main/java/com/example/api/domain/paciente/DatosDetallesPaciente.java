package com.example.api.domain.paciente;

import com.example.api.domain.direccion.DatosDireccion;
import com.example.api.domain.direccion.Direccion;

public record DatosDetallesPaciente(
        Long id,
        String nombre,
        String email,
        String telefono,
        String documento,
        Direccion direccion
) {
    public DatosDetallesPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNombre(), paciente.getEmail(), paciente.getDocumento(), paciente.getTelefono(), paciente.getDireccion());
    }
}
