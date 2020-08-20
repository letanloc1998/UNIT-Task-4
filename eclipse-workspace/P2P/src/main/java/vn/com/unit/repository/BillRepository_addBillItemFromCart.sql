insert into p2po_bill_item (id, product, quantity)
	(
	select /*bill_id*/ as id, p2po_cart.product, p2po_cart.quantity
	from p2po_cart
	where p2po_cart.account = /*account_id*/
	);

delete from p2po_cart
where account = /*account_id*/;