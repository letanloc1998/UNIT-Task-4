package vn.com.unit.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.Shop;
import vn.com.unit.entity.Product;

public interface ProductService {
	
	public List<Product> findAllProductByShopId(Long shop_id,int limit,int offset);
	
	public List<Product> findAllProductByCategoryId(Long category_id);
	
	public List<Product> findAllProductByBrandId(Long brand_id);
	
	public List<Product> findAllProductByCategoryIdAndBrandId(Long category_id, Long brand_id,Long shop_id,int limit,int offset);
	
	public Product findProductByProductId(Long product_id);
	
	public Product createNewProduct(String name,int price,int quantity,int category,int brand,String detail,String img,Long shop);
	
	public boolean setDisableProductByProductId(Long product_id, int status);
	
	public void saveProduct(Long product_id, String name, int price, String detail, int category, int brand, int quantity);
	
	public List<Product> findAllProduct();
	
	public List<Product> findProductByName(String name);
	
	public int CountAllProductByShopId(Long shop_id);
	
	public int countAllProductByCategoryIdAndBrandId(Long category_id, Long brand_id,Long shop_id);
}
