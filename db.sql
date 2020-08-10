create table account (
    id bigint primary key identity(1,1),
    name nvarchar(50),
    username nvarchar(50) not null,
    password nvarchar(50) not null,
    email nvarchar(50),
    phone nvarchar(20),
    active bit default 0,
    create_at datetime default getutcdate(),
)

create table role (
    id smallint primary key identity(1,1),
    name nvarchar(50) not null
)

create table account_role (
    account bigint,
    role smallint,

    constraint pk_account_role primary key (account, role),
    constraint fk_account_role_account__account_id foreign key (account) references account(id),
    constraint fk_account_role_role__role_id foreign key (role) references role(id)
)

create table shop (
    id bigint primary key,
    constraint fk_shop_id foreign key (id) references account(id),

    name nvarchar(50) not null,
    address nvarchar(255),
    email nvarchar(50),
    phone nvarchar(50),
    detail nvarchar(500),
    disable bit default 0,
    create_at datetime default getutcdate()
)

create table category (
    id int primary key identity(1,1),
    name varchar(50) not null
)

create table tag (
    id bigint primary key identity(1,1),
    name nvarchar(10),
)

create table brand (
    id int primary key identity(1,1),
    name nvarchar(50),
)

create table product (
    id bigint primary key identity(1,1),

    shop bigint,
    constraint fk_produtc_shop__shop_id foreign key (shop) references shop(id),

    name varchar(255) not null,
    price int not null,
    detail nvarchar(1000),
    img nvarchar(500),
    disable bit default 0,

    category int,
    constraint fk_product_category__category_id foreign key (category) references category(id),

    brand int,
    constraint fk_product_brand__brand_id foreign key (brand) references brand(id),
    
    create_at datetime default getutcdate()
)

create table product_tag (
    product bigint,
    tag bigint,

    constraint pk_product_tag primary key (product, tag),
    constraint fk_product_tag_product__product_id foreign key (product) references product(id),
    constraint fk_product_tag_tag__tag_id foreign key (tag) references tag(id)
)

create table cart (
    account bigint,

    product bigint,

    create_at datetime default getutcdate(),

    constraint pk_cart primary key (account, product),
    constraint fk_cart_account__account_id foreign key (account) references account(id),
    constraint fk_cart_product__product_id foreign key (product) references product(id)
)

create table bill (
    id bigint primary key identity(1,1),
    account bigint,
    create_at datetime default getutcdate(),

    constraint fk_bill_account__account_id foreign key (account) references account(id),
)

create table bill_item (
    id bigint,
    constraint fk_bill_item_id__bill_id foreign key (id) references bill(id),

    product bigint not null,
    constraint fk_bill_item_product__product_id foreign key (product) references product(id),

    quantity bigint not null

)

-- test
insert into account(username, password) values ('admin', '');
insert into account(username, password) values ('vendor', '');
insert into account(username, password) values ('user', '');

insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_VENDOR');
insert into role (name) values ('ROLE_USER');

insert into account_role (account, role) values (1, 1);

