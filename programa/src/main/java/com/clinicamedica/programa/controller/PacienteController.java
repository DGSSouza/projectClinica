package com.clinicamedica.programa.controller;
import com.clinicamedica.programa.model.Paciente;
import com.clinicamedica.programa.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/pacientes")
public class PacienteController {
        private final PacienteService servico;

        public PacienteController(PacienteService servico) {
            this.servico = servico;
        }



        @PostMapping
        public ResponseEntity<Paciente> cadastrar(@Valid @RequestBody Paciente paciente) {
            Paciente salvo = servico.cadastrar(paciente);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        }



        @GetMapping
        public ResponseEntity<List<Paciente>> listarTodos() {
            return ResponseEntity.ok(servico.buscaTodos());
        }

        /**
         * Busca paciente pelo ID.
         * GET /pacientes/{id}
         *
         * @PathVariable → pega o {id} da URL
         * @return 200 OK com o paciente ou 404 se não encontrar
         */
        @GetMapping("/{id}")
        public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
            return ResponseEntity.ok(servico.buscaPorId(id));
        }

        /**
         * Busca pacientes pelo nome.
         * GET /pacientes/buscar?nome=joão
         *
         * @RequestParam → pega o parâmetro da query string (?nome=...)
         * @return 200 OK com lista de pacientes encontrados
         */
        @GetMapping("/buscar")
        public ResponseEntity<List<Paciente>> buscarPorNome(@RequestParam String nome) {
            return ResponseEntity.ok(servico.buscaPorNome(nome));
        }

        /**
         * Atualiza dados de um paciente.
         * PUT /pacientes/{id}
         *
         * @return 200 OK com paciente atualizado
         */
        @PutMapping("/{id}")
        public ResponseEntity<Paciente> atualizar(@PathVariable Long id,
                                                  @Valid @RequestBody Paciente dados) {
            return ResponseEntity.ok(servico.atualizar(id, dados));
        }

        /**
         * Remove um paciente.
         * DELETE /pacientes/{id}
         *
         * @return 204 NO CONTENT — sucesso sem corpo na resposta
         */
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletar(@PathVariable Long id) {
            servico.deletar(id);
            return ResponseEntity.noContent().build();
        }
    }

