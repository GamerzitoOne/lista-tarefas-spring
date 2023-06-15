package com.example.demo.tags;

import com.example.demo.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Page<Tag> findAllByAtivoTrue(Pageable paginacao);

}
