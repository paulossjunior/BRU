# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table campus (
  id                        bigint not null,
  nome                      varchar(255),
  constraint pk_campus primary key (id))
;

create table categoria (
  id                        bigint not null,
  nome                      varchar(255),
  constraint pk_categoria primary key (id))
;

create table gerente_compra (
  id                        bigint not null,
  nome                      varchar(255),
  senha                     varchar(255),
  email                     varchar(255),
  categoria_id              bigint,
  campus_id                 bigint,
  constraint pk_gerente_compra primary key (id))
;

create table produto (
  id                        bigint not null,
  nome                      varchar(255),
  descricao                 varchar(255),
  numero_compras_net        varchar(255),
  categoria_id              bigint,
  unidade_id                bigint,
  constraint pk_produto primary key (id))
;

create table unidade (
  id                        bigint not null,
  nome                      varchar(255),
  constraint pk_unidade primary key (id))
;

create sequence campus_seq;

create sequence categoria_seq;

create sequence gerente_compra_seq;

create sequence produto_seq;

create sequence unidade_seq;

alter table gerente_compra add constraint fk_gerente_compra_categoria_1 foreign key (categoria_id) references categoria (id) on delete restrict on update restrict;
create index ix_gerente_compra_categoria_1 on gerente_compra (categoria_id);
alter table gerente_compra add constraint fk_gerente_compra_campus_2 foreign key (campus_id) references campus (id) on delete restrict on update restrict;
create index ix_gerente_compra_campus_2 on gerente_compra (campus_id);
alter table produto add constraint fk_produto_categoria_3 foreign key (categoria_id) references categoria (id) on delete restrict on update restrict;
create index ix_produto_categoria_3 on produto (categoria_id);
alter table produto add constraint fk_produto_unidade_4 foreign key (unidade_id) references unidade (id) on delete restrict on update restrict;
create index ix_produto_unidade_4 on produto (unidade_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists campus;

drop table if exists categoria;

drop table if exists gerente_compra;

drop table if exists produto;

drop table if exists unidade;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists campus_seq;

drop sequence if exists categoria_seq;

drop sequence if exists gerente_compra_seq;

drop sequence if exists produto_seq;

drop sequence if exists unidade_seq;

