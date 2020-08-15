package vn.com.unit.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.Shop;
import vn.com.unit.entity.Product;

public interface ProductService {
	
	public List<Product> findAllProductByShopId(Long shop_id);
	
	public Product createNewProduct(String name,int price,int quantity,int category,int brand,String detail,String img,Long shop);

}
