package vn.com.unit.service;

import java.util.List;

import vn.com.unit.entity.BillSeparate;
import vn.com.unit.entity.BillSeparateShop;

public interface BillSeparateService {

	public List<BillSeparate> findBillSeparatePaymentSuccessAndStatusWaitingByShopId(Long shop_id);
	
	public List<BillSeparateShop> findBillSeparateByPaymentAndStatusAndShopId(Long payment,Long status,Long shop_id);
	
	public void saveBillSeparateStatus(Long bill_separate_id, int status);
	
}
