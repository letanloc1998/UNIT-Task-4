package vn.com.unit.service;

import java.util.List;
import vn.com.unit.entity.Shop;
import vn.com.unit.entity.Product;

public interface ShopService {
	
	public Shop findShopByAccountId(Long account_id);
}
