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
import vn.com.unit.service.AccountService;
import vn.com.unit.service.BrandService;
import vn.com.unit.service.CategoryService;
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
	
	
	@Autowired
	BrandService brandService;
	
	@Autowired
	CategoryService categoryService;
	
	@Override
	public List<Product> findAllProductByShopId(Long shop_id) {

		List<Product> products = new ArrayList<Product>();
		try {
			products = productRepository.findAllProductByShopId(shop_id);

			for (Product product : products) {
				Brand brand = brandService.findBrandByProductId(product.getId());
				product.setBrand_name(brand);
				Category category = categoryService.findCategoryByProductId(product.getId());
				product.setCategory_name(category);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return products;
	}
	
	
	@Override
	public List<Product> findAllProductByCategoryId(int category_id) {

		List<Product> products = new ArrayList<Product>();
		try {
			products = productRepository.findAllProductByCategoryId(category_id);

			for (Product product : products) {
				Brand brand = brandService.findBrandByProductId(product.getId());
				product.setBrand_name(brand);
				Category category = categoryService.findCategoryByProductId(product.getId());
				product.setCategory_name(category);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return products;
	}
	
	
	@Override
	public Product findProductByProductId(Long product_id) {
		
		Product product = new Product();
		try {
				product = productRepository.findProductByProductId(product_id);
				Brand brand = brandService.findBrandByProductId(product_id);
				product.setBrand_name(brand);
				Category category = categoryService.findCategoryByProductId(product_id);
				product.setCategory_name(category);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return product;
	}
	
	@Override
	public Product createNewProduct(String name,int price,int quantity,int category,int brand,String detail,String img,Long shop) {
		productRepository.createNewProduct(name, price, quantity, category, brand, detail, img, shop);
		return null;
	}
	
	@Override
	public boolean setDisableProductByProductId(Long product_id, int status) {
		try {
			productRepository.setDisableProductByProductId(product_id, status);
			return true;
		} catch(Exception e) {
			
		}
		return false;
	}
	
	@Override
	public void saveProduct(Long product_id, String name, int price, String detail, int category, int brand, int quantity) {
		
		try {
			productRepository.saveProduct(product_id, name, price, quantity, category, brand, detail);
		}catch (Exception e) {		
		}
	}
	
	@Override
	public List<Product> findAllProduct(){
		
		return productRepository.findAllProduct();
	}
	
	@Override
	public List<Product> findProductByName(String name){
		List<Product> product = new ArrayList<Product>();
		try {
			product = productRepository.findProductByName(name);
		}catch(Exception e) {
			
		}
		return product;
	}


}
