package com.example.demo.tarefa;

import java.time.LocalDateTime;

public record DadosDetalhamentoTarefa(Long id, String nome, String descricao, LocalDateTime dataCriacao,
                                      LocalDateTime dataFinalizacao, Prioridade prioridade, Long idTag) {
    public DadosDetalhamentoTarefa(Tarefa tarefa) {
        this(tarefa.getId(), tarefa.getNome(), tarefa.getDescricao(), tarefa.getDataCriacao(), tarefa.getDataFinalizacao(), tarefa.getPrioridade(), tarefa.getTag().getId());
    }
}

