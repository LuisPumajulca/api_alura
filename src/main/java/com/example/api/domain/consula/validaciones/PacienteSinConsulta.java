package com.example.api.domain.consula.validaciones;

import com.example.api.domain.consula.ConsultaRepository;
import com.example.api.domain.consula.DatosAgendarConsulta;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteSinConsulta implements ValidadorDeConsultas{

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DatosAgendarConsulta datos) {

        var primerHorario= datos.fecha().withHour(7).withMinute(0);
        var ultimoHorario= datos.fecha().withHour(18).withMinute(0);

        var pacienteConConsulta = consultaRepository.existsByPacienteIdAndDataBetween(datos.idPaciente(),primerHorario,ultimoHorario);

        if (pacienteConConsulta) {
            throw new ValidationException("El paciente ya tiene una consulta agendada para el día de hoy");
        }
    }

}
