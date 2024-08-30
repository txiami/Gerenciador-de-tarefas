package com.api.gerenciadortarefas.services;


import Dtos.TarefaDTO;
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

    // Método para obter todas as tarefas
    public List<TarefaModel> getAllTarefas() {
        return tarefaRepository.findAll();
    }

    // Método para obter uma tarefa pelo ID
    public TarefaModel getTarefaById(UUID id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa com ID " + id + " não encontrada."));
    }

    // Método para atualizar uma tarefa
    public Optional<TarefaModel> updateTarefa(UUID id, TarefaDTO tarefaDTO) {
        TarefaModel tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa com ID " + id + " não encontrada."));

        tarefa.setTitulo(tarefaDTO.titulo());
        tarefa.setDescricao(tarefaDTO.descricao());
        return Optional.of(tarefaRepository.save(tarefa));
    }

    // Método para deletar uma tarefa
    public boolean deleteTarefa(UUID id) {
        TarefaModel tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa com ID " + id + " não encontrada."));

        tarefaRepository.delete(tarefa);
        return true;
    }
}

