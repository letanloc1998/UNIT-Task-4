package vn.com.unit.repository;

import java.util.List;

import org.springframework.data.mirage.repository.MirageRepository;
import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.Account;
import vn.com.unit.entity.Brand;
import vn.com.unit.entity.Category;

public interface CategoryRepository extends MirageRepository<Category, Long> {

	public Category findCategoryByProductId(@Param("product_id") Long product_id);
	
	public List<Category> findAllCategory();
	
	public List<Category> findCategoryPageable(@Param("sizeOfPage") Integer sizeOfPage,@Param("offset") Integer offset);
	
	public int countAllCategory();
	
	public Long createCategory(@Param("name") String name);
}
