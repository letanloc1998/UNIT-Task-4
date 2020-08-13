package vn.com.unit.repository;

import java.util.List;

import org.springframework.data.mirage.repository.MirageRepository;
import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.Product;
import vn.com.unit.entity.Shop;

public interface ProductRepository extends MirageRepository<Shop, Long> {

	public List<Product> findAllProductByShopId(@Param("shop_id") Long shop_id);
	
	
}
