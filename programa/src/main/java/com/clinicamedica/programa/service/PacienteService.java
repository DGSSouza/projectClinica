package com.clinicamedica.programa.service;

import com.clinicamedica.programa.model.Paciente;
import com.clinicamedica.programa.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository){
        this.repository = repository;

    }

    public Paciente cadastrar(Paciente paciente){
        if(repository.existsByCpf(paciente.getCpf())){
            throw new RuntimeException("Paciente com CPF já cadastrado"+paciente.getCpf());
        }
        if (repository.existsByEmail(paciente.getEmail())){
            throw new RuntimeException("Paciente com Email já cadastrado"+paciente.getEmail());
        }

        return repository.save(paciente);

    }

    public Paciente buscaPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Paciente não encontrado com id: "+id));
    }

    public List<Paciente> buscaTodos(){
        return repository.findAll();
    }

    public List<Paciente> buscaPorNome(String nome){
        return repository.findByNomeContainingIgnoreCase(nome);
    }


    public Paciente atualizar (Long id, Paciente dados){

        Paciente paciente = buscaPorId(id);
        paciente.setNome(dados.getNome());
        paciente.setCpf(dados.getCpf());
        paciente.setEmail(dados.getEmail());

        return repository.save(paciente);
    }

    public void deletar(Long id){

        Paciente paciente = buscaPorId(id);
        repository.delete(paciente);

    }
}
