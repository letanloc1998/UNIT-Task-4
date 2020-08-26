package vn.com.unit.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.BillSeparate;
import vn.com.unit.entity.BillSeparateShop;
import vn.com.unit.entity.HistoryBillSeparate;
import vn.com.unit.entity.billItemSeparate;

public interface BillSeparateService {

	public List<BillSeparate> findBillSeparatePaymentSuccessAndStatusWaitingByShopId(Long shop_id);
	
	public List<BillSeparateShop> findBillSeparateByPaymentAndStatusAndShopId(Long payment,Long status,Long shop_id);
	
	public void saveBillSeparateStatus(Long bill_separate_id, int status);
	
	public List<HistoryBillSeparate> findAllBillSeparateByAccountId(Long account_id,Long status, Long payment);
	
	public List<billItemSeparate> findBillItemByBillSeparateId(Long bill_separate_id,Long account);
	
	public HistoryBillSeparate findBillSeparateById(Long id);
}