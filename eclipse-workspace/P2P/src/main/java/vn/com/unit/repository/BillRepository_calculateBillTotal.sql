select sum(bill.price)
from
	(
		select bill_item.id, (bill_item.quantity * product.price) as price
		from
			(
				select *
				from p2p_bill_item
				where id = 1
			) bill_item
		left join p2p_product product
		on product.id = bill_item.product
	) bill
group by bill.id;