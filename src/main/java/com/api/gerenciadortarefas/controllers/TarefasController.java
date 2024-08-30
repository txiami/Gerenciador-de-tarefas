package com.api.gerenciadortarefas.controllers;


import Dtos.TarefaDTO;
import com.api.gerenciadortarefas.models.TarefaModel;
import com.api.gerenciadortarefas.services.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController

public class TarefasController {

    @Autowired
    private TarefaService tarefaService;

    // Criar uma nova tarefa
    @PostMapping("/tarefas")
    public ResponseEntity<TarefaModel> createTarefa(@RequestBody @Valid TarefaDTO tarefaDTO) {
        TarefaModel tarefaModel = tarefaService.createTarefa(tarefaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaModel);
    }

    @GetMapping("/tarefas")
    public ResponseEntity<List<TarefaModel>> getAllTarefas() {
        List<TarefaModel> tarefas = tarefaService.getAllTarefas();
        return ResponseEntity.ok(tarefas);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TarefaModel> getTarefaById(@PathVariable UUID id) {
        Optional<TarefaModel> tarefaModel = Optional.ofNullable(tarefaService.getTarefaById(id));
        return tarefaModel.map(ResponseEntity::ok) // Retorna 200 OK se encontrada
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // Retorna 404 Not Found se não encontrada
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaModel> updateTarefa(@PathVariable UUID id, @RequestBody @Valid TarefaDTO tarefaDTO) {
        Optional<TarefaModel> updatedTarefa = tarefaService.updateTarefa(id, tarefaDTO);
        return updatedTarefa.map(ResponseEntity::ok).orElseGet(()
                -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTarefa(@PathVariable UUID id) {
        boolean isDeleted = tarefaService.deleteTarefa(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 No Content se deletada
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found se não encontrada
        }
    }
    }

//    @DeleteMapping("/teste/{id}")
//    public ResponseEntity<Void> deleteTarefa(@PathVariable UUID id) {
//        boolean isDeleted = tarefaService.deleteTarefa(id);
//        if (isDeleted) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

