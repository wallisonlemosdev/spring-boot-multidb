----- USUÁRIOS
create table usuarios
(
    id             serial primary key,
    nome           varchar not null,
    email          varchar unique not null ,
    senha          varchar(255) not null ,
    telefone       varchar unique not null ,
    bloqueado      boolean default false,
    deleted        boolean   default false,
    created_at     timestamp default now(),
    updated_at     timestamp,
    deleted_at     timestamp
);