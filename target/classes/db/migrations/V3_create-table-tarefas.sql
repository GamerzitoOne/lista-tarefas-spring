CREATE TABLE tarefas (
    id bigint not null auto_increment,
    nome varchar(255) not null unique,
    descricao varchar(255) not null,
    data_criacao datetime not null,
    data_finalizacao datetime not null,
    prioridade varchar(50),
    tag_id bigint not null,

    primary key(id),
    constraint fk_tarefas_tag_id foreign key(tag_id) references tags(id)
);
