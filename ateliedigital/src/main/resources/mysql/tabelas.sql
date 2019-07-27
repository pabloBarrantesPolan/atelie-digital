create table profissional(
    id integer primary key auto_increment,
    nome varchar(50) not null ,
    cep integer not null ,
    email varchar(50) not null unique ,
    telefone integer not null,
    cpf varchar(11) not null,
    regiao VARCHAR(30) not null,
    plano tinyint not null
);
drop table profissional;

create table cliente(

    id integer primary key auto_increment,
    nome varchar(50) not null ,
    email varchar(50) not null unique,
    senha varchar(255) not null
);

create table empresa(
    id integer primary key auto_increment,
    razao_social varchar(50) not null ,
    nome_fantasia varchar(50) not null ,
    cep integer not null ,
    email varchar(50) not null unique ,
    telefone integer not null,
    cnpj varchar(11) not null,
    regiao VARCHAR(30) not null ,
    plano tinyint not null
);

select * from cliente;
select * from profissional;
