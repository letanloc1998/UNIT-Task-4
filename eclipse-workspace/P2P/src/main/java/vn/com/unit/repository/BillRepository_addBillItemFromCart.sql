insert into p2p_bill_item (id, product, quantity)
	(
	select /*bill_id*/ as id, p2p_cart.product, p2p_cart.quantity
	from p2p_cart
	where p2p_cart.account = /*account_id*/
	)

delete from p2p_cart
where account = /*account_id*/;