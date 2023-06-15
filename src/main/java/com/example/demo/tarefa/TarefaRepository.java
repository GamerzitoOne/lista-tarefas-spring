package com.example.demo.tarefa;

import com.example.demo.tags.Tag;
import com.example.demo.tarefa.Tarefa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
