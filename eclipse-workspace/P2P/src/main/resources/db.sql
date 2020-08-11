use DMS_DEV;

drop table p2p_bill_item;
drop table p2p_bill;
drop table p2p_cart;
drop table p2p_product_tag;
drop table p2p_product;
drop table p2p_brand;
drop table p2p_tag;
drop table p2p_category;
drop table p2p_shop;
drop table p2p_account_role;
drop table p2p_role;
drop table p2p_account;

create table p2p_account (
    id bigint primary key identity(1,1),
    name nvarchar(50),
    username nvarchar(50) not null,
    password nvarchar(255) not null,
    email nvarchar(50),
    phone nvarchar(20),
    disable bit default 0,
    create_at datetime default getutcdate(),
)

create table p2p_role (
    id smallint primary key identity(1,1),
    name nvarchar(50) not null
)

create table p2p_account_role (
    account bigint,
    role smallint,

    constraint pk_p2p_account_role primary key (account, role),
    constraint fk_account_role_account__account_id foreign key (account) references p2p_account(id),
    constraint fk_account_role_role__role_id foreign key (role) references  p2p_role(id)
)

create table p2p_shop (
    id bigint primary key,
    constraint fk_shop_id foreign key (id) references p2p_account(id),

    name nvarchar(50) not null,
    address nvarchar(255),
    email nvarchar(50),
    phone nvarchar(20),
    detail nvarchar(500),
    disable bit default 0,
    create_at datetime default getutcdate()
)

create table p2p_category (
    id int primary key identity(1,1),
    name nvarchar(50) not null
)

create table p2p_tag (
    id bigint primary key identity(1,1),
    name nvarchar(10) not null,
)

create table p2p_brand (
    id int primary key identity(1,1),
    name nvarchar(50) not null,
)

create table p2p_product (
    id bigint primary key identity(1,1),

    shop bigint not null,
    constraint fk_produtc_shop__shop_id foreign key (shop) references p2p_shop(id),

    name nvarchar(255) not null,
    price int not null check (price > 0),
    detail nvarchar(1000),
    img nvarchar(500) not null,
    disable bit default 0,

    category int,
    constraint fk_product_category__category_id foreign key (category) references p2p_category(id),

    brand int,
    constraint fk_product_brand__brand_id foreign key (brand) references p2p_brand(id),
    
    quantity int not null check (quantity >= 0),

    create_at datetime default getutcdate()
)

create table p2p_product_tag (
    product bigint,
    tag bigint,

    constraint pk_product_tag primary key (product, tag),
    constraint fk_product_tag_product__product_id foreign key (product) references p2p_product(id),
    constraint fk_product_tag_tag__tag_id foreign key (tag) references p2p_tag(id)
)

create table p2p_cart (
    account bigint not null,

    product bigint not null,
    
    quantity int not null check (quantity > 0),

    create_at datetime default getutcdate(),

    constraint pk_p2p_cart primary key (account, product),
    constraint fk_cart_account__account_id foreign key (account) references p2p_account(id),
    constraint fk_cart_product__product_id foreign key (product) references p2p_product(id)
)

create table p2p_bill (
    id bigint primary key identity(1,1),
    account bigint not null,
    address nvarchar(255) not null,
    create_at datetime default getutcdate(),

    constraint fk_bill_account__account_id foreign key (account) references p2p_account(id),
)

create table p2p_bill_item (
    id bigint,
    constraint fk_bill_item_id__bill_id foreign key (id) references p2p_bill(id),

    product bigint not null,
    constraint fk_bill_item_product__product_id foreign key (product) references p2p_product(id),

    quantity int not null check (quantity > 0)
)

-- init data
insert into p2p_account(username, password) values ('admin', '');
insert into p2p_account(username, password) values ('vendor', '');
insert into p2p_account(username, password) values ('user', '');

insert into p2p_role (name) values ('ROLE_ADMIN');
insert into p2p_role (name) values ('ROLE_VENDOR');
insert into p2p_role (name) values ('ROLE_USER');

insert into p2p_account_role (account, role) values (1, 1);
insert into p2p_account_role (account, role) values (2, 2);
insert into p2p_account_role (account, role) values (3, 3);