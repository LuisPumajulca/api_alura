package com.example.api.domain.consula;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

    Boolean existByPacienteIdAndDataBetween(Long aLong, LocalDateTime primerHorario, LocalDateTime ultimoHorario);

    Boolean existByMedicoIdAndData(Long aLong, LocalDateTime fecha);
}
