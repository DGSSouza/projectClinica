package com.clinicamedica.programa.repository;

import com.clinicamedica.programa.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {


    Optional<Medico> findByCrm(String CRM);

    List <Medico> findByNomeContainingIgnoreCase(String nome);

    List<Medico>findByEspecialidadeContainingIgnoreCase(String especialidade);

    List<Medico> findByAtivoTrueAndEspecialidadeContainingIgnoreCase(String especialidade, boolean ativo);

    Boolean existsByCrm(String CRM);

    List<Medico> findByAtivoTrue(boolean ativo);
}
