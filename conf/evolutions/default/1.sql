# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table addactor (
  actorid                   integer auto_increment not null,
  firstname                 varchar(255),
  lastname                  varchar(255),
  photo                     varchar(255),
  url                       varchar(255),
  constraint pk_addactor primary key (actorid))
;

create table comparision (
  id                        integer auto_increment not null,
  actor1id                  integer auto_increment not null,
  actor2id                  integer auto_increment not null,
  actor1rating              integer,
  actor2rating              integer)
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table addactor;

drop table comparision;

SET FOREIGN_KEY_CHECKS=1;

