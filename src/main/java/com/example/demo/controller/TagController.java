package com.example.demo.controller;

import com.example.demo.service.TagService;
import com.example.demo.tags.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping
    @Transactional
    public ResponseEntity criarTag(@RequestBody @Valid DadosCadastroTag dados, UriComponentsBuilder uriBuilder) {
        Tag tag = tagService.criar(dados);
        URI uri = uriBuilder.path("/tags/{id}").buildAndExpand(tag.getId()).toUri();

        return ResponseEntity.created(uri).body(tag);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DeleteMapping> excluirTag(@PathVariable Long id){
        tagService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTag>> listarTags(@PagableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = tagService.listar(paginacao);
        return ResponseEntity.ok(page);
    }

}