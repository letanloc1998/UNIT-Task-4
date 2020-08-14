package vn.com.unit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.unit.entity.Account;
import vn.com.unit.entity.Brand;
import vn.com.unit.entity.Category;
import vn.com.unit.entity.Product;
import vn.com.unit.entity.Role;
import vn.com.unit.repository.BrandRepository;
import vn.com.unit.repository.CategoryRepository;
import vn.com.unit.repository.ProductRepository;
import vn.com.unit.repository.ShopRepository;
import vn.com.unit.service.BrandService;
import vn.com.unit.service.ProductService;
import vn.com.unit.service.ShopService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ShopRepository shopRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	BrandRepository brandRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Product> findAllProductByShopId(Long shop_id) {
		/*
		 * List<Product> products = new ArrayList<Product>(); try {
		 * 
		 * 
		 * for (Product product : products) { Brand brand =
		 * brandRepository.findBrandByProductId(product.getId());
		 * product.setBrand_name(brand);; Category category =
		 * categoryRepository.findCategoryByProductId(product.getId());
		 * product.setCategory_name(category); } } catch (Exception e) { // TODO: handle
		 * exception }
		 */
		return productRepository.findAllProductByShopId(shop_id);
	}
	

}
