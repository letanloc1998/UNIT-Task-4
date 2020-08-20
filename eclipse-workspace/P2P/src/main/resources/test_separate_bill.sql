insert into p2p_bill (account, address) values (/*account_id*/, /*address*/);

declare @bill_id int = (select scope_identity());

select count(distinct product.shop)
from p2p_cart cart
left join p2p_product product
on product.id = cart.product

--
declare @i int = 
	(
	select count(distinct product.shop)
	from p2p_cart cart
	left join p2p_product product
	on product.id = cart.product
	);

print @i

WHILE @i > 0
BEGIN
   PRINT 'Inside FOR LOOP';
   SET @i = @i - 1;
END;

--
insert into p2p_bill (account, address) values (1, '1');

declare @bill_id int = (select scope_identity());

create table p2p_bill_separate (
    id bigint,
    constraint fk_bill_separate_id__bill_id foreign key (id) references p2p_bill(id),

	shop bigint,
	constraint fk_bill_separate_shop__shop_id foreign key (shop) references p2p_shop(id),
);

--
drop table p2p_bill_separate;

insert into p2p_bill (account, address) values (1, '1');

declare @bill_id int = (select scope_identity());

create table p2p_bill_separate (
    id bigint,
    constraint fk_bill_separate_id__bill_id foreign key (id) references p2p_bill(id),

	shop bigint,
	constraint fk_bill_separate_shop__shop_id foreign key (shop) references p2p_shop(id),
);

--
drop table p2p_bill_separate;

insert into p2p_bill (account, address) values (1, '1');

declare @bill_id int = (select scope_identity());

create table p2p_bill_separate (
	id bigint primary key identity(1,1),

    bill bigint,
    constraint fk_bill_separate_bill__bill_id foreign key (bill) references p2p_bill(id),

	shop bigint,
	constraint fk_bill_separate_shop__shop_id foreign key (shop) references p2p_shop(id),
);

insert into p2p_bill_separate (bill, shop)
	select @bill_id as bill, temp.*
	from 
		(
		select distinct product.shop
		from p2p_cart cart
		left join p2p_product product
		on product.id = cart.product
		) temp

--
drop table p2p_bill_separate;

insert into p2p_bill (account, address) values (1, '1');

declare @bill_id int = (select scope_identity());

create table p2p_bill_separate (
	id bigint primary key identity(1,1),

    bill bigint,
    constraint fk_bill_separate_bill__bill_id foreign key (bill) references p2p_bill(id),

	shop bigint,
	constraint fk_bill_separate_shop__shop_id foreign key (shop) references p2p_shop(id),
);

insert into p2p_bill_separate (bill, shop)
	select @bill_id as bill, temp.*
	from 
		(
		select distinct product.shop
		from p2p_cart cart
		left join p2p_product product
		on product.id = cart.product
		) temp
--

