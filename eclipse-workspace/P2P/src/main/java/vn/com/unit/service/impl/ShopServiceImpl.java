package vn.com.unit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.unit.entity.Shop;
import vn.com.unit.entity.Account;
import vn.com.unit.entity.Product;
import vn.com.unit.repository.ShopRepository;
import vn.com.unit.service.ShopService;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

	@Autowired
	ShopRepository shopRepository;
	
	
	
	
	@Override
	public Shop findShopByAccountId(Long account_id) {
		return shopRepository.findShopByAccountId(account_id);
	}
	
	//setInforShop
	@Override
	public void saveShop(Long shop_id, String name,String email, String phone, String address, String detail) {
		try {
			shopRepository.saveShop(shop_id, name, email, phone, address, detail);
		}catch (Exception e) {
			
		}

		
	}
}
