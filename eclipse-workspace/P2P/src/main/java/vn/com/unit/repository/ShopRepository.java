package vn.com.unit.repository;

import java.util.List;

import org.springframework.data.mirage.repository.MirageRepository;
import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.Shop;

public interface ShopRepository extends MirageRepository<Shop, Long> {

	public Shop findShopByAccountId(@Param("account_id") Long account_id);
}
