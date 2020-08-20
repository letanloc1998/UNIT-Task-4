select *
from p2po_category
where id
in (select category
	from p2po_product
	where id = /*product_id*/)