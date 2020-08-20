package vn.com.unit.repository;

import java.util.List;

import org.springframework.data.mirage.repository.MirageRepository;
import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.BillSeparate;

public interface BillSeparateRepository extends MirageRepository<BillSeparate, Long> {

	public List<BillSeparate> findBillSeparatePaymentSuccessAndStatusWaitingByShopId(@Param("shop_id") Long shop_id);

}
