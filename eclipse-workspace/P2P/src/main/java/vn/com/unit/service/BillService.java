package vn.com.unit.service;

import java.util.List;
import vn.com.unit.entity.Shop;
import vn.com.unit.entity.Bill;
import vn.com.unit.entity.Product;

public interface BillService {
	
	public List<Bill> findAllBillByAccountId(Long account_id);

	public Long createBill(Long account_id, String address);

	public void addBillItemFromCart(Long bill_id, Long account_id);

}
