-- auto-generated definition
create schema cold collate utf8mb4_0900_ai_ci;

use cold;

-- auto-generated definition
create table company
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
    update_time           timestamp default CURRENT_TIMESTAMP null
);

INSERT INTO cold.company (id, company_name, company_number, company_manager_name, company_manager_phone, company_address, company_type, create_time, update_time) VALUES (1, 'xx运输', '001', '李老板', '100001', 'jms', '私企', '2024-04-09 22:55:09', '2024-04-09 22:55:09');

-- auto-generated definition
create table host
(
    id               int auto_increment
        primary key,
    company_number   varchar(20)                          not null,
    warehouse_number varchar(20)                          not null,
    host_name        varchar(20)                          not null,
    host_number      varchar(20)                          not null,
    host_status      varchar(6) default '正常'            null,
    create_time      timestamp  default CURRENT_TIMESTAMP null,
    update_time      timestamp  default CURRENT_TIMESTAMP null
);

-- auto-generated definition
create table meter
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
    update_time      timestamp  default CURRENT_TIMESTAMP null
);

-- auto-generated definition
create table user
(
    id       int auto_increment
        primary key,
    username varchar(20)  null,
    password varchar(100) null
);

INSERT INTO cold.user (id, username, password) VALUES (1, 'root', '4813494d137e1631bba301d5acab6e7bb7aa74ce1185d456565ef51d737677b2');

-- auto-generated definition
create table user_history
(
    id         int auto_increment
        primary key,
    username   varchar(20) null,
    login_time datetime    null,
    ip         varchar(20) null
);

-- auto-generated definition
create table user_token
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

-- auto-generated definition
create table warehouse
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
    latitude                decimal(10, 8)                       null,
    longitude               decimal(10, 8)                       null,
    create_time             timestamp  default CURRENT_TIMESTAMP null,
    update_time             timestamp  default CURRENT_TIMESTAMP null
);

