package vn.com.unit.service;

import java.util.List;
import vn.com.unit.entity.Shop;
import vn.com.unit.entity.Bill;
import vn.com.unit.entity.BillItem;
import vn.com.unit.entity.Product;

public interface BillItemService {
	
	public List<BillItem> findAllBillItemByBillSeparateId(Long bill_separate_id);
	
	public List<BillItem> findAllBillItem();

}
