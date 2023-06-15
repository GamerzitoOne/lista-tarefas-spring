package com.example.demo.tarefa;

import com.example.demo.tags.Tag;

import java.time.LocalDateTime;

public record DadosListagemTarefa(Long id, String nome, String descricao, LocalDateTime dataCriacao,
                                      LocalDateTime dataFinalizacao, Prioridade prioridade, Long idTag) {
    public DadosListagemTarefa(Tarefa tarefa) {
        this(tarefa.getId(), tarefa.getNome(), tarefa.getDescricao(), tarefa.getDataCriacao(), tarefa.getDataFinalizacao(), tarefa.getPrioridade(), tarefa.getTag().getId());
    }

}

