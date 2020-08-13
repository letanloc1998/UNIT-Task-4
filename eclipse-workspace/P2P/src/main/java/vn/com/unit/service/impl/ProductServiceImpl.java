package vn.com.unit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.unit.entity.Product;
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
		
		return productRepository.findAllProductByShopId(shop_id);
	}
	

}
