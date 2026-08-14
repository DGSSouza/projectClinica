package com.clinicamedica.programa.controller;


import com.clinicamedica.programa.model.Consulta;
import com.clinicamedica.programa.service.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;

    }
    public record AgendamentoRequest(
            Long          pacienteId,
            Long          medicoId,
            LocalDate dataHora,
            String        motivo
    ) {

    }
    @PostMapping
    public ResponseEntity<Consulta> agendar(@RequestBody AgendamentoRequest request){
        Consulta consulta = consultaService.agendar(
                request.pacienteId(), request.medicoId(),
                request.dataHora(), request.motivo());
        return ResponseEntity.status(HttpStatus.CREATED).body(consulta);

    }
    @GetMapping("/agendadas")
    public ResponseEntity<List<Consulta>> listarAgendadas() {
        return ResponseEntity.ok(consultaService.listarAgendadas());
    }
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Consulta>> listarPorPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(consultaService.listarPorPaciente(pacienteId));
    }
    @GetMapping("/periodo")
    public ResponseEntity<List<Consulta>> listarPorPeriodo(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim) {
        return ResponseEntity.ok(consultaService.listarPorPeriodo(inicio, fim));
    }
    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        consultaService.cancelar(id);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/{id}/realizar")
    public ResponseEntity<Void> realizar(@PathVariable Long id) {
        consultaService.realizar(id);
        return ResponseEntity.ok().build();
    }


}
