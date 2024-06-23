package com.example.api.domain.consula.validaciones;

import com.example.api.domain.consula.DatosAgendarConsulta;
import com.example.api.domain.medico.MedicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MedicoActivo implements ValidadorDeConsultas{

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DatosAgendarConsulta datos) {
        if (datos.idMedico() == null) {
            return;
        }

        var medicoActivo = medicoRepository.findActivoById(datos.idPaciente());
        if (!medicoActivo) {
            throw new ValidationException("Médico inactivo");
        }
    }
}
