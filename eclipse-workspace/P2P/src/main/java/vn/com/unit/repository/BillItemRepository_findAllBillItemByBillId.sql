select bill_item.*, bill_separate.bill
from p2po_bill_item bill_item
left join p2po_bill_separate bill_separate
on bill_separate.id = bill_item.id
where bill_separate.bill = /*bill_id*/