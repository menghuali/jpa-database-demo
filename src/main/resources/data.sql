-- create tables
create table person
(
    id integer not null,
    name varchar(255) not null,
    location varchar(255),
    birth_date timestamp,
    primary key (id)
);

-- insert some records
insert into person (id, name, location, birth_date) values(1001, 'John', 'Toronto', sysdate());
insert into person (id, name, location, birth_date) values(1002, 'Mary', 'Calgary', sysdate());
insert into person (id, name, location, birth_date) values(1003, 'Mike', 'Vancouver ', sysdate());
insert into person (id, name, location, birth_date) values(1004, 'Mary', 'Vancouver', sysdate());
insert into person (id, name, location, birth_date) values(1005, 'Peter', 'Toronto', sysdate());