select sum(bill.price)
from
	(
		select (bill_item.quantity * product.price) as price
		from
			(
				select bill_item.*
				from p2po_bill_item bill_item
				left join p2po_bill_separate bill_separate
				on bill_separate.id = bill_item.id
				where bill_separate.bill = 1
			) bill_item
		left join p2po_product product
		on product.id = bill_item.product
	) bill