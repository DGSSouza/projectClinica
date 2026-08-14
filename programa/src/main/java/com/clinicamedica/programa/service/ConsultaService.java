package com.clinicamedica.programa.service;

import ch.qos.logback.core.status.Status;
import com.clinicamedica.programa.model.Consulta;
import com.clinicamedica.programa.model.Medico;
import com.clinicamedica.programa.model.Paciente;
import com.clinicamedica.programa.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;
    private final PacienteService pacienteService;
    private final MedicoService medicoService;

    public ConsultaService(ConsultaRepository repository, PacienteService pacienteService, MedicoService medicoService) {
        this.repository = repository;
        this.pacienteService = pacienteService;
        this.medicoService = medicoService;
    }

    public Consulta agendar(Long id, Long medicoId,
                            LocalDate dataHora, String motivo) {

        Paciente paciente = pacienteService.buscaPorId(medicoId);
        Medico medico = medicoService.buscarPOrID(medicoId);

        if(!medico.isAtivo()){
            throw new IllegalArgumentException("Médico não está ativo" + medico.getNome());

        }
        if(dataHora.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Data e hora da consulta não pode ser no passado" + dataHora);

        }

        Consulta consulta = new Consulta(paciente, medico, dataHora, motivo);
        return repository.save(consulta);


    }

    public Consulta buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Consulta não encontrada com o ID: " + id));
    }

    public void cancelar(Long id){
        Consulta consulta = buscarPorId(id);

        if (consulta.getStatus()!= Consulta.StatusConsulta.AGENDADA) {
            throw new IllegalArgumentException("Não é possível cancelar a consulta com o status: " + consulta.getStatus());
        }
        consulta.setStatus(Consulta.StatusConsulta.CANCELADA);
        repository.save(consulta);
    }

    public void realizar(Long id){
        Consulta consulta = buscarPorId(id);
        if (consulta.getStatus()!= Consulta.StatusConsulta.AGENDADA) {
            throw new IllegalArgumentException("Não é possível realizar a consulta com o status: " + consulta.getStatus());
        }
        consulta.setStatus(Consulta.StatusConsulta.REALIZADA);
        repository.save(consulta);
    }
    public List<Consulta> listarPorPaciente(Long pacienteId) {
        return repository.findByPacienteId(pacienteId);
    }

    public List<Consulta> listarPorPeriodo(LocalDate inicio, LocalDate fim) {
        return repository.findByDataHoraBetween(inicio, fim);

    }
    public List<Consulta> listarAgendadas(){
        return repository.findByStatus(Consulta.StatusConsulta.AGENDADA);
    }
    }


