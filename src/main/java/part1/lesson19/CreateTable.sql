CREATE TABLE IF NOT EXISTS person (
    id SERIAL PRIMARY KEY,
    firstName varchar(15) not null,
    lastName varchar(20) not null,
    age smallint not null
);


CREATE TABLE IF NOT EXISTS animal (
    id SERIAL primary key,
    nickname varchar(20),
    age smallint not null
);
