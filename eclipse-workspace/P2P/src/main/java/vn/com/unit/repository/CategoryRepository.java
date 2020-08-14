package vn.com.unit.repository;

import java.util.List;

import org.springframework.data.mirage.repository.MirageRepository;
import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.Brand;
import vn.com.unit.entity.Category;

public interface CategoryRepository extends MirageRepository<Category, Long> {

	public Category findCategoryByProductId(@Param("product_id") Long product_id);

}
