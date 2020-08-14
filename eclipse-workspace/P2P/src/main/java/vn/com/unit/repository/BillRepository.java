package vn.com.unit.repository;

import java.util.List;

import org.springframework.data.mirage.repository.MirageRepository;
import org.springframework.data.mirage.repository.query.Modifying;
import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.Bill;
import vn.com.unit.entity.Product;
import vn.com.unit.entity.Shop;

public interface BillRepository extends MirageRepository<Shop, Long> {

	public List<Bill> findAllBillByAccountId(@Param("account_id") Long account_id);

	public Long createBill(@Param("account_id") Long account_id, @Param("address") String address);

	@Modifying
	public void addBillItemFromCart(@Param("bill_id") Long bill_id, @Param("account_id") Long account_id);

	public Long calculateBillTotal(@Param("bill_id") Long bill_id);
	
}
