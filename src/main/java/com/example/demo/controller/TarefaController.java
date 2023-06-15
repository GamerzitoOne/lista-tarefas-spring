package com.example.demo.controller;

import com.example.demo.service.TarefaService;
import com.example.demo.tarefa.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tarefas")
public class TarefaController {

    @Autowired
    TarefaService tarefaService;


    @PostMapping("tarefas")
    @Transactional
    public ResponseEntity criarTarefa(@RequestBody @Valid DadosCadastroTarefa dados) {
        var tarefa = tarefaService.criar(dados);
        return ResponseEntity.ok(tarefa);
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemTarefa>> listarTarefa(@PagableDefault(size = 10, sort = {"dataFinalizacao"}) Pageable paginacao){
        var page = tarefaService.listar(paginacao);
        return ResponseEntity.ok(page);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DeleteMapping> excluirTarefa(@PathVariable Long id){
        tarefaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoTarefa> atualizarTarefa(@RequestBody @Valid DadosAtualizacaoTarefa dados) {
        var tarefa = tarefaService.atualizar(dados);
        return ResponseEntity.ok(tarefa);
    }

}
