package vn.com.unit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.unit.entity.BillSeparate;
import vn.com.unit.repository.BillSeparateRepository;
import vn.com.unit.service.BillSeparateService;

public class BillSeparateServiceImpl implements BillSeparateService {

	@Autowired
	BillSeparateRepository billSeparateRepository;
	
	@Override
	public List<BillSeparate> findBillSeparatePaymentSuccessAndStatusWaitingByShopId(Long shop_id) {
		// TODO Auto-generated method stub
		
		return billSeparateRepository.findBillSeparatePaymentSuccessAndStatusWaitingByShopId(shop_id);
	}

}
