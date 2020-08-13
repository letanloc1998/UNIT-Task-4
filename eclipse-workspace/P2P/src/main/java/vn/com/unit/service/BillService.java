package vn.com.unit.service;

import java.util.List;
import vn.com.unit.entity.Shop;
import vn.com.unit.entity.Bill;
import vn.com.unit.entity.Product;

public interface BillService {
	
	public List<Bill> findAllBillByAccountId(Long account_id);

}
