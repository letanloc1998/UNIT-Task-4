package vn.com.unit.service;

import java.util.List;
import vn.com.unit.entity.Shop;
import vn.com.unit.entity.Bill;
import vn.com.unit.entity.Brand;
import vn.com.unit.entity.Category;
import vn.com.unit.entity.Product;

public interface BrandService {
	
	public Brand findBrandByProductId(Long product_id);

	public List<Brand> findAllBrand();
	public List<Brand> findBrandPageable(int limit,int offset);
	public int countAllBrand();
	public Long createCategory(Brand brand);
	
	public Brand findBrandByName(String name);
	
	public Brand findBrandById(Long id);
	
	public void updateBrandById(Brand brand);
	public void deleteBrandById(Long id,Long disable);

}
