package com.example.api.domain.consula.validaciones;

import com.example.api.domain.consula.DatosAgendarConsulta;
import com.example.api.domain.paciente.PacienteRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteActivo implements ValidadorDeConsultas{

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DatosAgendarConsulta datos) {
        if (datos.idPaciente() == null) {
            return;
        }

        var pacienteActivo = pacienteRepository.findActivoById(datos.idPaciente());
        if (!pacienteActivo) {
            throw new ValidationException("Paciente inactivo");
        }
    }
}
