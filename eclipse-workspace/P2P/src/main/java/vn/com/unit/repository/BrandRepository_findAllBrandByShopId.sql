select *
from p2po_brand
where id
in
	(
	select brand
	from p2po_product
	where shop = /*shop_id*/
	)