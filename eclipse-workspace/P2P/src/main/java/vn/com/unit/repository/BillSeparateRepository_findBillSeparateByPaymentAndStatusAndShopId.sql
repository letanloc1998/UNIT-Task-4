declare @shop int = /*shop_id*/;

select bill_separate.*, bill.address, bill.create_at, account.username
from p2p_bill_separate bill_separate
left join p2p_bill bill
on bill.id = bill_separate.bill
left join p2p_account account
on bill.account = account.id
where bill_separate.shop = @shop
/*IF payment > 0 */
  and p2p_bill.payment > 0
  and p2p_bill_separate.status = /*status*/
/*END*/
/*IF payment < 0 */
  and p2p_bill.payment < 0
  and p2p_bill_separate.status = 0
  /*END*/
/*IF payment == 0 */
  and p2p_bill.payment = 0
    and p2p_bill_separate.status = 0
/*END*/  
order by p2p_bill_separate.id desc
OFFSET  /*offset*/ ROWS FETCH NEXT  /*sizeOfPage*/ ROWS ONLY
