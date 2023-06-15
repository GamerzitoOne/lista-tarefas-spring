package com.example.demo.tarefa;

import jakarta.validation.constraints.*;
import org.aspectj.weaver.ast.Not;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record DadosCadastroTarefa(
        @NotBlank
        String nome,
        @NotNull
        Long idTag,
        String descricao,

        @NotNull(message = "Não pode ser nulo")
        LocalDateTime dataCriacao,

        @NotNull(message = "Não pode ser nulo")
        @Future
        LocalDateTime dataFinalizacao,
        @NotNull(message = "Não pode ser nulo")
        Prioridade prioridade

){

}
