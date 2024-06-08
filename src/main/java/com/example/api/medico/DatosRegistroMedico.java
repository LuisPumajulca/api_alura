package com.example.api.medico;

import com.example.api.direccion.DatosDireccion;

public record DatosRegistroMedico(String nombre,
                                  String email,
                                  String documento,
                                  Especialidad especialidad,
                                  DatosDireccion direccion) {
}
