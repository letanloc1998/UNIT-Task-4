select sum(bill.price)
from
	(
		select bill_item.id, (bill_item.quantity * product.price) as price
		from
			(
				select *
				from p2po_bill_item
				where id = /*bill_id*/
			) bill_item
		left join p2po_product product
		on product.id = bill_item.product
	) bill
group by bill.id;