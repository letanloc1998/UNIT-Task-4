declare @bill int = /*bill_id*/;

select *
from p2p_bill_item bill_item
left join p2p_bill_separate bill_separate
on bill_separate.id = bill_item.id
where bill_separate.bill = @bill;