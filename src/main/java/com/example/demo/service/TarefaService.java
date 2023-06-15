package com.example.demo.service;

import com.example.demo.error.ValidacaoException;
import com.example.demo.tags.Tag;
import com.example.demo.tags.TagRepository;
import com.example.demo.tarefa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;
    @Autowired
    private TagRepository tagRepository;

    public DadosDetalhamentoTarefa criar(DadosCadastroTarefa dados) {
        Optional<Tag> tagOptional = tagRepository.findById(dados.idTag());
        if (tagOptional.isEmpty()) {
            throw new ValidacaoException("Id da tag informada não existe!");
        }

        Tag tag = tagOptional.get();
        LocalDateTime dateNow = LocalDateTime.now();
        LocalDateTime dataFinalizacao = dados.dataFinalizacao();

        if (dataFinalizacao.isBefore(dateNow)) {
            throw new ValidacaoException("A data de finalização deve ser uma data futura!");
        }

        Tarefa tarefa = new Tarefa(null, dados.nome(), dados.descricao(), dateNow, dados.dataFinalizacao(), dados.prioridade(), tag);
        tarefaRepository.save(tarefa);

        return new DadosDetalhamentoTarefa(tarefa);
    }
    public Page<DadosListagemTarefa> listar(Pageable paginacao) {
        Page<Tarefa> tarefas = tarefaRepository.findAll(paginacao);
        return tarefas.map(DadosListagemTarefa::new);
    }

    public DadosDetalhamentoTarefa atualizar(DadosAtualizacaoTarefa dados) {
        Tarefa tarefa = tarefaRepository.getReferenceById(dados.id());
        tarefa.atualizarInformacoes(dados);

        return new DadosDetalhamentoTarefa(tarefa);
    }

    public void excluir(Long id) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        if (tarefaOptional.isEmpty()) {
            throw new ValidacaoException("Tarefa não encontrada");
        }
        Tarefa tarefa = tarefaOptional.get();
        tarefaRepository.delete(tarefa);
    }
}
