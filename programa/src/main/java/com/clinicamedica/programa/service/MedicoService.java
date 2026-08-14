package com.clinicamedica.programa.service;

import com.clinicamedica.programa.model.Consulta;
import com.clinicamedica.programa.model.Medico;
import com.clinicamedica.programa.model.Paciente;
import com.clinicamedica.programa.repository.ConsultaRepository;
import com.clinicamedica.programa.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public Medico cadastrarMedico(Medico medico) {
        if(medicoRepository.existsByCrm(medico.getCrm())) {
            throw new IllegalArgumentException("CRM já cadastrado" + medico.getCrm());

        }
        return medicoRepository.save(medico);
    }

    public Medico buscarPOrID(Long id){

        return medicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Médico não encontrado com o ID: " + id));

    }

    public List<Medico> listarAtivos(){
        return medicoRepository.findByAtivoTrue(true);

    }

    public List<Medico> listarPorEspecialidade(String especialidade){
        return medicoRepository.findByAtivoTrueAndEspecialidadeContainingIgnoreCase(especialidade, true);
    }

    public void desativarMedicco(Long id){
        Medico medico = buscarPOrID(id);
        medico.setAtivo(false);
        medicoRepository.save(medico);
    }

    public void reativarMedico(Long Id){
        Medico medico = buscarPOrID(Id);
        medico.setAtivo(true);
        medicoRepository.save(medico);
    }




}





