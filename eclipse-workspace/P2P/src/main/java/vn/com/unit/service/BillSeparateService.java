package vn.com.unit.service;

import java.util.List;

import vn.com.unit.entity.BillSeparate;

public interface BillSeparateService {

	public List<BillSeparate> findBillSeparatePaymentSuccessAndStatusWaitingByShopId(Long shop_id);
	
}
