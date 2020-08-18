select *
from p2p_product
/*BEGIN*/
  WHERE
   disable = 'false' AND shop=/*shop_id*/ AND
  /*IF category_id != null*/
        category = /*category_id*/
  /*END*/
  /*IF brand_id != null*/
     AND brand = /*brand_id*/
  /*END*/
/*END*/
order by id
OFFSET  /*offset*/ ROWS FETCH NEXT  /*sizeOfPage*/ ROWS ONLY