package com.clinicamedica.programa.repository;

import com.clinicamedica.programa.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {


    Optional <Paciente> findByCpf(String cpf);

    Optional<Paciente> findByEmail(String email);

    List<Paciente> findByNomeContainingIgnoreCase(String nome);

    Boolean existsByCpf(String cpf);

    Boolean existsByEmail(String email);






}
