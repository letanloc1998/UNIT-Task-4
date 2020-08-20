SELECT *
FROM p2po_category
Where disable = 0
order by id
OFFSET  /*offset*/ ROWS FETCH NEXT  /*sizeOfPage*/ ROWS ONLY