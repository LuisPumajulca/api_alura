package com.example.api.domain.medico;

import com.example.api.domain.direccion.DatosDireccion;

public record DatosRespuestaMedico(
        Long id,
        String nombre,
        String email,
        String teelefono,
        String documento,
        DatosDireccion direccion
) {
}
