package com.example.api.domain.consula.validaciones;

import com.example.api.domain.consula.ConsultaRepository;
import com.example.api.domain.consula.DatosAgendarConsulta;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoConConsulta implements ValidadorDeConsultas  {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DatosAgendarConsulta datos){
        if (datos.idMedico() == null) {
            return;
        }
        var medicoConConsulta = consultaRepository.existsByMedicoIdAndData(datos.idMedico(),datos.fecha());

        if (medicoConConsulta) {
            throw new ValidationException("El médico ya tiene una consulta agendada para el día de hoy");
        }
    }
}
