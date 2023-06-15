package com.example.demo.tarefa;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAtualizacaoTarefa(
        @NotNull
        Long id,
        String nome,
        String descricao,
        LocalDateTime dataFinalizacao) {
}
