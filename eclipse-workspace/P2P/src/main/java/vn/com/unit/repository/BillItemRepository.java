package vn.com.unit.repository;

import java.util.List;

import org.springframework.data.mirage.repository.MirageRepository;
import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.Bill;
import vn.com.unit.entity.BillItem;
import vn.com.unit.entity.Product;
import vn.com.unit.entity.Shop;

public interface BillItemRepository extends MirageRepository<Shop, Long> {

	public List<BillItem> findAllBillItemByBillId(@Param("bill_id") Long bill_id);
	
	public List<BillItem> findAllBillItem();
	
	
}
