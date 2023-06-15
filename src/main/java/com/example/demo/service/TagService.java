package com.example.demo.service;

import com.example.demo.tags.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    private TagRepository repository;


    public Tag criar(DadosCadastroTag dados) {
        var tag = new Tag(dados);
        return repository.save(tag);
    }

    public void excluir(Long id) {
        Tag tag = repository.getReferenceById(id);
        tag.excluir();
    }

    public Page<DadosListagemTag> listar(Pageable paginacao) {
        Page<Tag> tags = repository.findAllByAtivoTrue(paginacao);
        return tags.map(DadosListagemTag::new);
    }
}
