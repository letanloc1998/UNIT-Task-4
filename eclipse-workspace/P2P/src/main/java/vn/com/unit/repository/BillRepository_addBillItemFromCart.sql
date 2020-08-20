declare @bill_id int = /*bill_id*/

declare @current_account int = /*account_id*/

-- create bill separate
insert into p2po_bill_separate (bill, shop)
	select @bill_id as bill, temp.*
	from 
		(
		select distinct product.shop
		from
			(
				-- select product from cart of current account
				select product
				from p2po_cart
				where p2po_cart.account = @current_account
			) cart
		left join p2po_product product
		on product.id = cart.product
		) temp;

declare @i int = 
	(
	select count(distinct product.shop)
	from
		(
			select product
			from p2po_cart
			where p2po_cart.account = @current_account
		) cart
	left join p2po_product product
	on product.id = cart.product
	);

declare @shop int;
declare @bill_separate int;

WHILE @i > 0
BEGIN
   
	set @shop = (select distinct top 1 product.shop
	from
		(
		select product
		from p2po_cart
		where p2po_cart.account = @current_account
		) cart
	left join p2po_product product
	on product.id = cart.product);

	print '@shop';
	print @shop;

	set @bill_separate =
		(
			select id
			from p2po_bill_separate
			where bill = @bill_id and shop = @shop
		);

	print '@bill_separate';
	print @bill_separate;

	insert into p2po_bill_item (id, product, quantity)
		(
		select @bill_separate as id, p2po_cart.product, p2po_cart.quantity
		from p2po_cart
		where p2po_cart.account = @current_account and product in (select id from p2po_product where shop = @shop)
		);

	delete from p2po_cart
	where account = @current_account
		and product
			in
			(
				select product from p2po_bill_item where p2po_bill_item.id = @bill_separate
			);

    SET @i = @i - 1;

END;

