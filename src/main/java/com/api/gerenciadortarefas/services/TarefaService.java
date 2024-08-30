package com.api.gerenciadortarefas.services;


import com.api.gerenciadortarefas.Dtos.TarefaDTO;
import com.api.gerenciadortarefas.exceptions.ResourceNotFoundException;
import com.api.gerenciadortarefas.models.TarefaModel;
import com.api.gerenciadortarefas.repositorys.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;


    public TarefaModel createTarefa( TarefaDTO tarefaDTO) {
        TarefaModel tarefa = new TarefaModel();
        tarefa.setTitulo(tarefaDTO.titulo());
        tarefa.setDescricao(tarefaDTO.descricao());
        return tarefaRepository.save(tarefa);
    }

    public List<TarefaModel> getAllTarefas() {
        return tarefaRepository.findAll();
    }

    public TarefaModel getTarefaById(UUID id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa com ID " + id + " não encontrada."));
    }

    public Optional<TarefaModel> updateTarefa(UUID id, TarefaDTO tarefaDTO) {
        TarefaModel tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa com ID " + id + " não encontrada."));

        tarefa.setTitulo(tarefaDTO.titulo());
        tarefa.setDescricao(tarefaDTO.descricao());
        return Optional.of(tarefaRepository.save(tarefa));
    }

    public boolean deleteTarefa(UUID id) {
        TarefaModel tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa com ID " + id + " não encontrada."));

        tarefaRepository.delete(tarefa);
        return true;
    }
}

