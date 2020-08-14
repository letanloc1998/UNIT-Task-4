package vn.com.unit.service;

import java.util.List;
import vn.com.unit.entity.Shop;
import vn.com.unit.entity.Product;

public interface ShopService {
	
	public Shop findShopByAccountId(Long account_id);
	
	public void saveShop(Long shop_id, String name, String email, String phone, String address, String detail);
	
	public boolean setDisableShop(Long account_id, String status);
	
	public List<Shop> findAllShop(int limit,int offset);
	
	public int countAllShop();
	public List<Shop> findShopByStatus(int limit,int offset,int status);
}
