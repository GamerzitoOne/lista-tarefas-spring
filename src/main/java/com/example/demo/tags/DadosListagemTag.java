package com.example.demo.tags;

import com.example.demo.tags.Tag;

public record DadosListagemTag(Long id, String nome, String descricao) {
    public DadosListagemTag(Tag tag){
        this(tag.getId(), tag.getNome(), tag.getDescricao());
    }
}
