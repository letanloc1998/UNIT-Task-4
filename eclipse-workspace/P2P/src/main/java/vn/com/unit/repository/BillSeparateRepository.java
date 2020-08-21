package vn.com.unit.repository;

import java.util.List;

import org.springframework.data.mirage.repository.MirageRepository;
import org.springframework.data.mirage.repository.query.Modifying;
import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.BillSeparate;
import vn.com.unit.entity.HistoryBillSeparate;

public interface BillSeparateRepository extends MirageRepository<BillSeparate, Long> {

	public List<BillSeparate> findBillSeparatePaymentSuccessAndStatusWaitingByShopId(@Param("shop_id") Long shop_id);
	
	@Modifying
	public void saveBillSeparateStatus(@Param("bill_separate_id") Long bill_separate_id, @Param("status") int status);
	
	public List<HistoryBillSeparate> findAllBillSeparateByAccountId(@Param("account_id") Long account_id,@Param("status") Long status,@Param("payment") Long payment);
}
