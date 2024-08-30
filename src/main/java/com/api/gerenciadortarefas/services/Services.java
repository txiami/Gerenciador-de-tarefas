package com.api.gerenciadortarefas.services;


import com.api.gerenciadortarefas.repositorys.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {

    @Autowired
    private TarefaRepository tarefaRepository;



}
