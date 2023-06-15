package com.example.demo.tarefa;

import com.example.demo.tags.Tag;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "tarefas")
@Entity(name = "Tarefa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataFinalizacao;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public void atualizarInformacoes(DadosAtualizacaoTarefa dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.dataFinalizacao() != null) {
            this.dataFinalizacao = dados.dataFinalizacao();
        }
    }
}
