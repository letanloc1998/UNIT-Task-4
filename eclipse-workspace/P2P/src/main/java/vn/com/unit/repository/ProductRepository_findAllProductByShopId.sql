select *
from p2po_product
where shop = /*shop_id*/ AND disable = 'false'
order by id
OFFSET  /*offset*/ ROWS FETCH NEXT  /*sizeOfPage*/ ROWS ONLY