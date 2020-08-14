package vn.com.unit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.unit.entity.Account;
import vn.com.unit.service.AccountService;
import vn.com.unit.service.BillService;
import vn.com.unit.service.PaymentService;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	AccountService accountService;

	// Order
	@Autowired
	BillService billService;

	@Override
	public Long createBill(String address) {

		Account currentAccount = accountService.findCurrentAccount();

		Long currentAccountId = currentAccount.getId();

		// insert into p2p_bill (account, address) values (/*curent account id*/,
		// /*address*/);
		// select scope_identity(); => bill_id
		Long billId = billService.createBill(currentAccountId, address);

		billService.addBillItemFromCart(billId, currentAccountId);

		// insert into p2p_bill_item (id, product, quantity) (select /*bill_id*/ as id,
		// p2p_cart.product, p2p_cart.quantity from p2p_cart where p2p_cart.account =
		// /*current account id*/)

		// return bill id

		return billId;
	}

}
