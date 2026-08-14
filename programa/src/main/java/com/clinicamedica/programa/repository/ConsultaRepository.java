package com.clinicamedica.programa.repository;

import com.clinicamedica.programa.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    List<Consulta> findByPacienteId(Long id);

    List<Consulta> findByMedicoId(Long id);

    List<Consulta> findByStatus(Consulta.StatusConsulta status);

    List<Consulta> findByDataHoraBetween(LocalDate inicio, LocalDate fim);

    boolean existsByMedicoIdAndDataHoraAndStatusNot(Long medicoId, LocalDate dataHora, Consulta.StatusConsulta status);
}
