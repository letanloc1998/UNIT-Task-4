declare @shop int = /*shop_id*/;

select p2p_bill_separate.*, p2p_bill.address, p2p_bill.create_at, p2p_account.username
from p2p_bill_separate 
left join p2p_bill 
on p2p_bill.id = p2p_bill_separate.bill
left join p2p_account
on p2p_bill.account = p2p_account.id
where bill_separate.shop = @shop
/*IF payment > 0 */
  and bill.payment > 0
  and bill_separate.status = /*status*/
/*END*/
/*IF payment < 0 */
  and bill.payment < 0
  and bill_separate.status = 0
  /*END*/
/*IF payment == 0 */
  and bill.payment = 0
    and bill_separate.status = 0
/*END*/  
order by bill_separate.id desc
OFFSET  /*offset*/ ROWS FETCH NEXT  /*sizeOfPage*/ ROWS ONLY
