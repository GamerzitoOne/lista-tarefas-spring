create table tags(

    id bigint not null auto_increment,
    nome varchar(100) not null unique,
    descricao varchar(100) not null,

    primary key(id)

);