create table user (
    id bigint primary key identity(1,1),
    name varchar(50),
    username varchar(50) not null,
    password varchar(50) not null,
    email varchar(50),
    phone varchar(20),
    active bit default 0,
    create_at datetime default getutcdate(),
)

create table role (
    id bigint primary key identity(1,1),
    name varchar(50) not null
)

create table user_role (
    user_id bigint,
    role_id bigint,

    constraint pk_user_role primary key (user_id, role_id),
    constraint fk_user_id foreign key (user_id) references user(id),
    constraint fk_role_id foreign key (role_id) references role(id)
)

create table admin (
    id bigint primary key,
    constraint fk_admin_id foreign key (id) references user(id)
)

create table vendor (
    id bigint primary key,
    constraint fk_vendor_id foreign key (id) references user(id)
)

create table customer(
    id bigint primary key,
    constraint fk_customer_id foreign key (id) references user(id)
)
