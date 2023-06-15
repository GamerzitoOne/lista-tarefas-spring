package com.example.demo.tags;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTag(

        @NotBlank
        String nome,

        @NotBlank
        String descricao
) {
}
