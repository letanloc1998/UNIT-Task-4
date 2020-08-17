use DMS_DEV;

drop table p2p_log
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
    username nvarchar(50) not null unique,
    password nvarchar(255) not null,
    email nvarchar(50),
    phone nvarchar(20),
    disable bit default 0,
    create_at datetime default getutcdate()
)

create table p2p_role (
    id smallint primary key identity(1,1),
    name nvarchar(50) not null unique
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
    name nvarchar(50) not null unique,
    address nvarchar(255),
    email nvarchar(50),
    phone nvarchar(20),
    detail nvarchar(500),
    
    -- 0 : waiting accept
    -- 1 : active
    -- 2 : delete by vendor (owner)
    -- 3 : delete by admin
    status tinyint default 0,
    
    create_at datetime default getutcdate()
)

create table p2p_category (
    id int primary key identity(1,1),
    name nvarchar(50) not null unique
)

create table p2p_tag (
    id bigint primary key identity(1,1),
    name nvarchar(10) not null unique,
)

create table p2p_brand (
    id int primary key identity(1,1),
    name nvarchar(50) not null unique,
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
    
    -- momo_order_id bigint,
    
    account bigint not null,
    address nvarchar(255) not null,
    create_at datetime default getutcdate(),

    -- 0 : wating payment
    -- 1 : payment success
    -- 2 : payment error
    payment tinyint default 0,
    
    -- 0 : waiting
    -- 1 : approve
    -- 2 : deny
    -- 3 : complete	(approve success, shipping success)
    -- 4 : cancel	(approve success, can't receive product/error) 
    status tinyint default 0,
    
    -- 0 : not refund
    -- 1 : refund success
    refund tinyint default 0,
    
    constraint fk_bill_account__account_id foreign key (account) references p2p_account(id),
)

create table p2p_bill_item (
    id bigint,
    constraint fk_bill_item_id__bill_id foreign key (id) references p2p_bill(id),

    product bigint not null,
    constraint fk_bill_item_product__product_id foreign key (product) references p2p_product(id),

    quantity int not null check (quantity > 0),
    
    constraint pk_p2p_bill_item primary key (id, product)
)

create table p2p_log (
	log nvarchar(2000),
	type nvarchar(50),
	author nvarchar(500),
	create_at datetime default getutcdate(),
)

-- init data

-- acount

insert into p2p_account(username, password) values ('admin', '');
insert into p2p_account(username, password) values ('vendor', '');
insert into p2p_account(username, password) values ('user', '');

insert into p2p_role (name) values ('ROLE_ADMIN');
insert into p2p_role (name) values ('ROLE_VENDOR');
insert into p2p_role (name) values ('ROLE_USER');

insert into p2p_account_role (account, role) values (1, 1);
insert into p2p_account_role (account, role) values (2, 2);
insert into p2p_account_role (account, role) values (3, 3);

-- product

insert into p2p_account(username, password) values ('vendor-1', '');
insert into p2p_account(username, password) values ('vendor-2', '');

insert into p2p_account_role (account, role) values (4, 2);
insert into p2p_account_role (account, role) values (5, 2);

insert into p2p_shop (id, name, status) values (4, 'shop-1', 1);
insert into p2p_shop (id, name, status) values (5, 'shop-2', 1);

insert into p2p_category (name) values ('category-1');
insert into p2p_category (name) values ('category-2');

insert into p2p_brand (name) values ('brand-1');
insert into p2p_brand (name) values ('brand-2');

insert into p2p_product (shop, name, price, img, category, brand, quantity, detail) values (4, 'product-1', 1000, '/static/product/default.png', 1, 1, 40, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas fermentum. laoreet turpis, nec sollicitudin dolor cursus at. Maecenas aliquet, dolor a faucibus efficitur, nisi tellus cursus urna, eget dictum lacus turpis.');
insert into p2p_product (shop, name, price, img, category, brand, quantity, detail) values (4, 'product-2', 1500, '/static/product/default.png', 1, 2, 30, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas fermentum. laoreet turpis, nec sollicitudin dolor cursus at. Maecenas aliquet, dolor a faucibus efficitur, nisi tellus cursus urna, eget dictum lacus turpis.');

insert into p2p_product (shop, name, price, img, category, brand, quantity) values (5, 'product-3', 2000, '/static/product/default.png', 2, 1, 20);
insert into p2p_product (shop, name, price, img, category, brand, quantity) values (5, 'product-4', 2500, '/static/product/default.png', 2, 2, 10);

select product.id, product.name, product.price, product.detail, product.img,
		product.disable, product.quantity, product.create_at,
		category.name as category, brand.name as brand, shop.name as shop
from p2p_product product
left join p2p_shop shop
on shop.id = product.shop
left join p2p_category category
on category.id = product.category
left join p2p_brand brand
on brand.id	= product.brand;

-- insert into p2p_log (log, type, author) values ('log', 'test', 'Loc');

insert into p2p_account(username, password) values ('user-1', '');
insert into p2p_account(username, password) values ('user-2', '');
insert into p2p_account(username, password) values ('user-3', '');
insert into p2p_account(username, password) values ('user-4', '');
insert into p2p_account(username, password) values ('user-5', '');
insert into p2p_account(username, password) values ('user-6', '');
insert into p2p_account(username, password) values ('user-7', '');
insert into p2p_account(username, password) values ('user-8', '');
insert into p2p_account(username, password) values ('user-9', '');

insert into p2p_account_role (account, role) values (6, 3);
insert into p2p_account_role (account, role) values (7, 3);
insert into p2p_account_role (account, role) values (8, 3);
insert into p2p_account_role (account, role) values (9, 3);
insert into p2p_account_role (account, role) values (10, 3);
insert into p2p_account_role (account, role) values (11, 3);
insert into p2p_account_role (account, role) values (12, 3);
insert into p2p_account_role (account, role) values (13, 3);
insert into p2p_account_role (account, role) values (14, 3);

-- init product in cart
insert into p2p_cart (account, product, quantity) values (3, 1, 1); -- 1000 * 1
insert into p2p_cart (account, product, quantity) values (3, 2, 3); -- 1500 * 3

--
-- init product in cart
insert into p2p_cart (account, product, quantity) values (6, 1, 2); -- 1000 * 1
insert into p2p_cart (account, product, quantity) values (6, 2, 2); -- 1500 * 3
/*
insert into p2p_bill (account, address) values (3, 'HCM');
-- select scope_identity();
insert into p2p_bill_item (id, product, quantity) values (1, 1, 1);
insert into p2p_bill_item (id, product, quantity) values (1, 2, 3);
delete from p2p_cart where account = 3;

select bill_item.*, product.price from
	(
	select *
	from p2p_bill_item
	where id = 1
	) bill_item
left join p2p_product product
on product.id = bill_item.product;

select sum(bill.price)
from (
	select bill_item.id, (bill_item.quantity * product.price) as price
	from
		(
		select *
		from p2p_bill_item
		where id = 1
		) bill_item
	left join p2p_product product
	on product.id = bill_item.product) bill
group by bill.id;

--select *
--from
--	(select p2p_bill_item.product, p2p_bill_item.quantity from p2p_bill_item where id = 1) cart_item
--join ( select * from  (values (1)) as temp_table(id_bill) )

select 1 as bill_id, p2p_bill_item.product, p2p_bill_item.quantity from p2p_bill_item where id = 1

-- 1 as bill_id
insert into p2p_bill_item (id, product, quantity) (select 1 as id, p2p_cart.product, p2p_cart.quantity from p2p_cart where p2p_cart.account = 1)
*/

/*
select *
from p2p_product product

left join p2p_category category
on category.id = product.category

left join p2p_brand brand
on brand.id = product.brand
*/
