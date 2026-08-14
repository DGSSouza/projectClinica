package com.clinicamedica.programa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable=false)
    private Medico medicoId;

    @NotNull(message = "Data e hora da consulta é obrigatória")
    @Column(nullable = false)
    private LocalDate dataHora;

    private String motivo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusConsulta status = StatusConsulta.AGENDADA;

    public enum StatusConsulta {
        AGENDADA,
        REALIZADA,
        CANCELADA
    }
    public Consulta() {
    }

    public Consulta(Paciente paciente, Medico medico, LocalDate dataHora, String motivo) {
        this.paciente = paciente;
        this.medicoId = medico;
        this.dataHora = dataHora;
        this.motivo = motivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medicoId;
    }

    public void setMedico(Medico medico) {
        this.medicoId = medico;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Consulta [id=" + id + ", paciente=" + paciente + ", medico=" + medicoId + ", dataHora=" + dataHora
                + ", motivo=" + motivo + ", status=" + status + "]";
    }
}
