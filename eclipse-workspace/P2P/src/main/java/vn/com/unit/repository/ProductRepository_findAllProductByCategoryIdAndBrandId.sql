select *
from p2po_product
WHERE
disable = 'false' AND shop=/*shop_id*/

/*IF category_id != null*/
    AND category = /*category_id*/
/*END*/

/*IF brand_id != null*/
    AND brand = /*brand_id*/
/*END*/
order by id
OFFSET  /*offset*/ ROWS FETCH NEXT  /*sizeOfPage*/ ROWS ONLY