----- Produtos
create table produtos
(
    id             serial primary key,
    nome           varchar not null ,
    preco          numeric(19, 2) not null,
    nome_usuario   varchar not null,
    bloqueado      boolean default false,
    deleted        boolean   default false,
    created_at     timestamp default now(),
    updated_at     timestamp,
    deleted_at     timestamp
);