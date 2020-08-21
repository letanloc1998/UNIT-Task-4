package vn.com.unit.service;

import java.util.List;

import vn.com.unit.entity.BillItem;

public interface BillItemService {
	
	public List<BillItem> findAllBillItemByBillId(Long bill_id);
	
	public List<BillItem> findAllBillItem();

}
