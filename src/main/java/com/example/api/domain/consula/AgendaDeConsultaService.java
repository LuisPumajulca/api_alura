package com.example.api.domain.consula;

import com.example.api.domain.consula.validaciones.ValidadorDeConsultas;
import com.example.api.domain.medico.Medico;
import com.example.api.domain.medico.MedicoRepository;
import com.example.api.domain.paciente.PacienteRepository;
import com.example.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultaService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    List<ValidadorDeConsultas> validadores;

    public void agendar(DatosAgendarConsulta datos) {

        if (!pacienteRepository.findById(datos.idPaciente()).isPresent()) {
            throw new ValidacionDeIntegridad("Paciente no encontrado");
        }
        if (datos.idMedico() !=null && !medicoRepository.existsById(datos.idMedico())) {
            throw new ValidacionDeIntegridad("Medico no encontrado");
        }

        //Validaciones de negocio

        validadores.forEach(validador -> validador.validar(datos));

        var paciente = pacienteRepository.findById(datos.idPaciente()).get();

        var medico = seleccionarMedico(datos);

        var consulta = new Consulta(null,medico,paciente,datos.fecha());

        consultaRepository.save(consulta);
    }

    private Medico seleccionarMedico(DatosAgendarConsulta datos) {

        if (datos.idMedico() != null) {
            return medicoRepository.getReferenceById(datos.idMedico());
        }
        if (datos.especialidad() == null) {
            throw new ValidacionDeIntegridad("Especialidad no encontrada");
        }

        return medicoRepository.seleccionarMedicoConEspecialidadEnFecha(datos.especialidad(),datos.fecha());
    }
}
