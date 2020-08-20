select sum(cart.quantity * product.price)
from 
	(
	select *
	from p2po_cart
	where account = /*account_id*/
	) cart
left join p2po_product product
on product.id = cart.product