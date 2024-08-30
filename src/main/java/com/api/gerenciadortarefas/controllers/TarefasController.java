package com.api.gerenciadortarefas.controllers;


import com.api.gerenciadortarefas.Dtos.TarefaDTO;
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
@RequestMapping("/tarefas")
public class TarefasController {

    @Autowired
    private TarefaService tarefaService;

    // Criar uma nova tarefa
    @PostMapping()
    public ResponseEntity<TarefaModel> createTarefa(@RequestBody @Valid TarefaDTO tarefaDTO) {
        TarefaModel tarefaModel = tarefaService.createTarefa(tarefaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaModel);
    }

    @GetMapping()
    public ResponseEntity<List<TarefaModel>> getAllTarefas() {
        List<TarefaModel> tarefas = tarefaService.getAllTarefas();
        return ResponseEntity.ok(tarefas);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TarefaModel> getTarefaById(@PathVariable UUID id) {
        Optional<TarefaModel> tarefaModel = Optional.ofNullable(tarefaService.getTarefaById(id));
        return tarefaModel.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    }
