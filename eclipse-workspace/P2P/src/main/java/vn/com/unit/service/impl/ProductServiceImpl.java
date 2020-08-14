package vn.com.unit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.unit.entity.Account;
import vn.com.unit.entity.Product;
import vn.com.unit.entity.Role;
import vn.com.unit.repository.ProductRepository;
import vn.com.unit.repository.ShopRepository;
import vn.com.unit.service.ProductService;
import vn.com.unit.service.ShopService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ShopRepository shopRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	
	
	@Override
	public List<Product> findAllProductByShopId(Long shop_id) {
		List<Product> products = new ArrayList<Product>();
		try {
			products = productRepository.findAllProductByShopId(shop_id);

			for (Product product : products) {
				List<Brand> brands = roleService.findRoleByAccountId(account.getId());
				account.setRoles(roles);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return products;
	}
	

}
