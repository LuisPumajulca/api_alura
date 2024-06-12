package com.example.api.medico;

import com.example.api.direccion.DatosDireccion;

public record DatosRespuestaMedico(
        Long id,
        String nombre,
        String email,
        String teelefono,
        String documento,
        DatosDireccion direccion
) {
}
