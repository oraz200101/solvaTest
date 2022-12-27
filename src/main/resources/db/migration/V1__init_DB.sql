drop table if exists transactions;
drop table if exists limit_money;
create table transaction
(
    id                  bigint not null auto_increment,
    account_from        bigint not null,
    account_to          bigint not null,
    currency_short_name varchar(255),
    expense_category    varchar(255),
    limit_money_id      bigint not null,
    date_tame           datetime (6),
    sum                 float(32, 2
) ,
    primary key (id)
);

create table limit_money
(
    id                        bigint not null auto_increment,
    date_time                 datetime(6),
    expense_category          varchar(255),
    limit_exceeded            bit    not null,
    limit_currency_short_name varchar(255),
    limit_cost                float(32, 2),
    remainder_limit float(32,2),
     primary key (id)
);
alter table transaction
    add constraint limit_fk foreign key (limit_money_id) references limit_money (id);