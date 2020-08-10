create table user (
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
    id bigint primary key identity(1,1),
    name nvarchar(50) not null
)

create table user_role (
    user bigint,
    role bigint,

    constraint pk_user_role primary key (user, role),
    constraint fk_user_role_user__user_id foreign key (user) references user(id),
    constraint fk_user_role_role__role_id foreign key (role) references role(id)
)

create table shop (
    id bigint primary key,
    constraint fk_shop_id foreign key (id) references user(id)

    name nvarchar(50) not null,
    address nvarchar(255),
    email nvarchar(50),
    phone nvarchar(50),
    detail nvarchar(500),
    disable bit default 0,
)

create table category (
    id bigint primary key identity(1,1),
    name varchar(50) not null
)

create table tag (
    id bigint primary key identity(1,1),
    name nvarchar(10),
)

create table brand (
    id bigint primary key identity(1,1),
    name nvarchar(50),
)

create table product (
    id bigint primary key identity(1,1),

    shop bigint
    constraint fk_produtc_shop__shop_id foreign key (shop) references shop(id),

    name varchar(255) not null,

    detail nvarchar(1000),

    disable bit default 0,

    category bigint,
    constraint fk_product_category__category_id foreign key (category) references category(id),

    brand bigint,
    constraint fk_product_brand__brand_id foreign key (brand) references brand(id),
)

create table product_tag (
    product bigint,
    tag bigint,

    constraint pk_product_tag primary key (product, tag),
    constraint fk_product_tag_product__product_id foreign key (product) references product(id),
    constraint fk_product_tag_tag__tag_id foreign key (tag) references tag(id)
)

create table cart (
    user bigint,

    product bigint

    constraint pk_cart primary key (user, product),
    constraint fk_cart_user__user_id foreign key (user) references user(id),
    constraint fk_cart_product__product_id foreign key (product) references product(id)
)

create table bill (
    id bigint primary key identity(1,1),
    user bigint,
    constraint fk_bill_user__user_id foreign key (user) references user(id),
)

create table bill_item (
    id bigint,
    constraint fk_bill_item_id__bill_id foreign key (id) references bill(id),

    product bigint not null,
    constraint fk_bill_item_product__product_id foreign key (product) references product(id),

    quantity bigint not null

)