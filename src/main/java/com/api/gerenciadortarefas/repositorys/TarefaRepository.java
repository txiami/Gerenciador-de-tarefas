package com.api.gerenciadortarefas.repositorys;


import com.api.gerenciadortarefas.models.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaModel, UUID> {
}
