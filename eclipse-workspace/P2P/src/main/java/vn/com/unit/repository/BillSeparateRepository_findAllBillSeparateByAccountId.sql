SELECT 
	bill_s.id 			as id,
	shop.id 			as shop_id,
	bill.id 			as bill_id,
	shop.name 			as shop_name,
	shop.email 			as shop_email,
	shop.phone 			as shop_phone,
	bill.address		as shipping_add,
	bill.create_at 		as create_at,
	bill_s.status 		as status,
	bill_s.refund  		as refund,
	bill.payment 		as payment
	
  FROM p2p_bill_separate bill_s 
  left join p2p_shop shop on bill_s.shop= shop.id
  left join p2p_bill bill on bill.id=bill_s.bill
  where bill.account = /*account_id*/ AND
  
/*IF status != null*/
    AND bill_s.status = /*status*/
/*END*/

/*IF payment != null && payment < 0 */
    AND bill.payment  < 0
/*END*/
 	
/*IF payment != null && payment = 0 */
    AND bill.payment  = 0
/*END*/
    
/*IF payment != null && payment > 0 */
    AND bill.payment  > 0
/*END*/