package com.example.demo.tags;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Table(name = "tags")
@Entity(name = "Tag")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nome;
    private String descricao;
    private Boolean ativo;
    public Tag(DadosCadastroTag dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.ativo = true;
    }

    public void excluir() {
        this.ativo = false;
    }
}
