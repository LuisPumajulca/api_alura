package com.example.api.domain.consula.validaciones;

import com.example.api.domain.consula.DatosAgendarConsulta;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HorarioDeAnticipacion implements ValidadorDeConsultas{
    public void validar(DatosAgendarConsulta datos) {
        var ahora = LocalDateTime.now();
        var horaDeConsulta = datos.fecha();
        var diferenciade30Min = Duration.between(ahora, horaDeConsulta).toMinutes()<30;
        if (diferenciade30Min) {
            throw new ValidationException("La consulta debe ser agendada con al menos 30 minutos de anticipación");
        }

    }
}
