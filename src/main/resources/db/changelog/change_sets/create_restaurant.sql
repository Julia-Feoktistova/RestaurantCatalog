create table restaurant
(
    id serial
        constraint restaurant_pk
            primary key,
    name varchar(20) not null ,
    address varchar(100) not null ,
    description varchar(500),
    email varchar(100),
    telephone_number varchar(100),
    foundation_date date default current_date
);