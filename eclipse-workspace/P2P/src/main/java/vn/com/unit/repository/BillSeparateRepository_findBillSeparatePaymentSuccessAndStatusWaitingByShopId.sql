declare @shop int = /*shop_id*/;

select bill_separate.*, p2p_bill.payment
from p2p_bill_separate bill_separate
left join p2p_bill
on p2p_bill.id = bill_separate.bill
where bill_separate.shop = @shop
	and bill_separate.status = 0;