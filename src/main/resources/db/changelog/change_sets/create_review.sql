create table review
(
    id            serial
        constraint review_pk
            primary key,
    Restaurant_id bigint not null
        constraint review_restaurant_id_fk
            references restaurant,
    rating   int not null,
    review   varchar(256)
);

