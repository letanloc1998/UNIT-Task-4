package vn.com.unit.service;

import java.util.List;
import vn.com.unit.entity.Shop;
import vn.com.unit.entity.Bill;
import vn.com.unit.entity.Brand;
import vn.com.unit.entity.Product;

public interface BrandService {
	
	public Brand findBrandByProductId(Long product_id);



}