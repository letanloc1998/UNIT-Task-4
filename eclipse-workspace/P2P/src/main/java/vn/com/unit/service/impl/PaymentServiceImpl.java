package vn.com.unit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.unit.entity.Account;
import vn.com.unit.service.AccountService;
import vn.com.unit.service.PaymentService;

public class PaymentServiceImpl implements PaymentService {

	@Autowired
	AccountService accountService;
	
	@Override
	public Long createBill(String address) {

		Account currentAccount = accountService.findCurrentAccount();
		
		Long currentAccountId = currentAccount.getId();
		
		// insert into p2p_bill (account, address) values (/*curent account id*/, /*address*/);
		// select scope_identity(); => bill_id
		
		// insert into p2p_bill_item (id, product, quantity) (select /*bill_id*/ as id, p2p_cart.product, p2p_cart.quantity from p2p_cart where p2p_cart.account = /*current account id*/)

		// return bill id
		
		return null;
	}

}
