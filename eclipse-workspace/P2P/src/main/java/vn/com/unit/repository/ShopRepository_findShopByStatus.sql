SELECT S.*,A.name owner_name
FROM  p2po_shop S left Join p2po_account A on A.id=S.id
where status=/*status*/
order by S.id
OFFSET  /*offset*/ ROWS FETCH NEXT  /*sizeOfPage*/ ROWS ONLY