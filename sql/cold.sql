create database cold character set utf8mb4;
create table cold.company
(
    id                    int auto_increment
        primary key,
    company_name          varchar(20)                         not null,
    company_number        varchar(20)                         not null,
    company_manager_name  varchar(20)                         not null,
    company_manager_phone varchar(20)                         not null,
    company_address       varchar(50)                         not null,
    company_type          varchar(4)                          not null,
    create_time           timestamp default CURRENT_TIMESTAMP null,
    update_time           timestamp default CURRENT_TIMESTAMP null,
    constraint company_number
        unique (company_number)
);

create table cold.host
(
    id               int auto_increment
        primary key,
    company_number   varchar(20)                          not null,
    warehouse_number varchar(20)                          not null,
    host_name        varchar(20)                          not null,
    host_number      varchar(20)                          not null,
    host_status      varchar(6) default '正常'            null,
    create_time      timestamp  default CURRENT_TIMESTAMP null,
    update_time      timestamp  default CURRENT_TIMESTAMP null,
    constraint host_number
        unique (host_number)
);

create table cold.host_history
(
    id               bigint auto_increment
        primary key,
    host_id          int                                 not null,
    company_number   varchar(20)                         null,
    warehouse_number varchar(20)                         null,
    host_name        varchar(20)                         null,
    host_number      varchar(20)                         null,
    host_status      varchar(6)                          null,
    create_time      timestamp default CURRENT_TIMESTAMP null
);

create table cold.meter
(
    id               int auto_increment
        primary key,
    company_number   varchar(20)                          not null,
    warehouse_number varchar(20)                          not null,
    host_number      varchar(20)                          not null,
    meter_number     varchar(20)                          not null,
    min_temperature  double                               null,
    max_temperature  double                               null,
    min_humidity     double                               null,
    max_humidity     double                               null,
    meter_status     varchar(6) default '正常'            null,
    create_time      timestamp  default CURRENT_TIMESTAMP null,
    update_time      timestamp  default CURRENT_TIMESTAMP null,
    constraint meter_number
        unique (meter_number)
);

create table cold.meter_history
(
    id                  bigint auto_increment
        primary key,
    meter_id            int                                 not null,
    company_number      varchar(20)                         null,
    warehouse_number    varchar(20)                         null,
    host_number         varchar(20)                         null,
    min_temperature     double                              not null,
    max_temperature     double                              not null,
    current_temperature double                              not null,
    min_humidity        double                              not null,
    max_humidity        double                              not null,
    current_humidity    double                              not null,
    meter_status        varchar(6)                          null,
    create_time         timestamp default CURRENT_TIMESTAMP null
);

create table cold.user
(
    id       int auto_increment
        primary key,
    username varchar(20)  null,
    password varchar(100) null
);

create table cold.user_history
(
    id         int auto_increment
        primary key,
    username   varchar(20) null,
    login_time datetime    null,
    ip         varchar(20) null
);

create table cold.user_token
(
    user_id     bigint       not null
        primary key,
    username    varchar(20)  not null,
    token       varchar(100) not null comment 'token',
    expire_time datetime     null comment '过期时间',
    update_time datetime     null comment '更新时间',
    constraint token
        unique (token)
);

create table cold.warehouse
(
    id                      int auto_increment
        primary key,
    company_number          varchar(20)                          not null,
    warehouse_name          varchar(20)                          not null,
    warehouse_number        varchar(20)                          not null,
    warehouse_manager_name  varchar(20)                          null,
    warehouse_manager_phone varchar(20)                          null,
    warehouse_size          varchar(20)                          null,
    warehouse_address       varchar(50)                          null,
    warehouse_type          varchar(6)                           null,
    warehouse_status        varchar(6) default '正常'            null,
    latitude                decimal(10, 7)                       null,
    longitude               decimal(10, 7)                       null,
    create_time             timestamp  default CURRENT_TIMESTAMP null,
    update_time             timestamp  default CURRENT_TIMESTAMP null,
    constraint warehouse_number
        unique (warehouse_number)
);

INSERT INTO cold.user (id, username, password)
VALUES (1, 'root', '4813494d137e1631bba301d5acab6e7bb7aa74ce1185d456565ef51d737677b2');
INSERT INTO cold.user_token (user_id, username, token, expire_time, update_time) VALUES (1, 'root', '53bcfd962ed8703f32c955c9fd1a5e9a', '2024-04-16 12:04:23', '2024-04-16 00:04:23');