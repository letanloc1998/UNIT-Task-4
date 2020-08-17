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
import vn.com.unit.service.CategoryService;
import vn.com.unit.service.ProductService;
import vn.com.unit.service.ShopService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	ShopRepository shopRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	BrandRepository brandRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Category findCategoryByProductId(Long product_id) {
		
		return categoryRepository.findCategoryByProductId(product_id);
		
	};
	
	@Override
	public List<Category> findAllCategory(){
		return categoryRepository.findAllCategory();
	}

	@Override
	public List<Category> findCategoryPageable(int limit, int offset) {
		// TODO Auto-generated method stub
		try {
			return categoryRepository.findCategoryPageable(limit, offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public int countAllCategory() {
		// TODO Auto-generated method stub
		try {
			return categoryRepository.countAllCategory();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

}
