package com.clinicamedica.programa.controller;
import com.clinicamedica.programa.model.Medico;
import com.clinicamedica.programa.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;



@RestController
@RequestMapping("/medicos")
public class MedicoController {


        private final MedicoService servico;

        public MedicoController(MedicoService servico) {
            this.servico = servico;
        }


        @PostMapping
        public ResponseEntity<Medico> cadastrar(@Valid @RequestBody Medico medico) {
            return ResponseEntity.status(HttpStatus.CREATED).body(servico.cadastrarMedico(medico));
        }


        @GetMapping
        public ResponseEntity<List<Medico>> listarAtivos() {
            return ResponseEntity.ok(servico.listarAtivos());
        }


        @GetMapping("/{id}")
        public ResponseEntity<Medico> buscarPorId(@PathVariable Long id) {
            return ResponseEntity.ok(servico.buscarPOrID(id));
        }


        @GetMapping("/especialidade")
        public ResponseEntity<List<Medico>> listarPorEspecialidade(@RequestParam String nome) {
            return ResponseEntity.ok(servico.listarPorEspecialidade(nome));
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<Void> desativar(@PathVariable Long id) {
            servico.desativarMedicco(id);
            return ResponseEntity.noContent().build();
        }


        @PatchMapping("/{id}/reativar")
        public ResponseEntity<Void> reativar(@PathVariable Long id) {
            servico.reativarMedico(id);
            return ResponseEntity.ok().build();
        }
    }

