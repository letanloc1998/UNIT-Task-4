package vn.com.unit.service;

import java.util.List;
import vn.com.unit.entity.Shop;
import vn.com.unit.entity.Bill;
import vn.com.unit.entity.Brand;
import vn.com.unit.entity.Category;
import vn.com.unit.entity.Product;

public interface CategoryService {
	
	public Category findCategoryByProductId(Long product_id);

	public List<Category> findAllCategory();
	
	public List<Category> findCategoryPageable(int limit,int offset);
	
	public int countAllCategory();
		
	public Long createCategory(Category category);
}
