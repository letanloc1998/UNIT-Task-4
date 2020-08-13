package vn.com.unit.repository;

import java.util.List;

import org.springframework.data.mirage.repository.MirageRepository;
import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.Bill;
import vn.com.unit.entity.Product;
import vn.com.unit.entity.Shop;

public interface BillRepository extends MirageRepository<Shop, Long> {

	public List<Bill> findAllBillByAccountId(@Param("account_id") Long account_id);
	
	
}
