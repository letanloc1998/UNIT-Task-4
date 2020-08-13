package vn.com.unit.service;

import java.util.List;
import vn.com.unit.entity.Shop;
import vn.com.unit.entity.Product;

public interface ProductService {
	
	public List<Product> findAllProductByShopId(Long shop_id);

}
