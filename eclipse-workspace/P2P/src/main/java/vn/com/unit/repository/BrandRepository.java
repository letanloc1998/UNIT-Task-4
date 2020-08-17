package vn.com.unit.repository;

import java.util.List;

import org.springframework.data.mirage.repository.MirageRepository;
import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.Brand;

public interface BrandRepository extends MirageRepository<Brand, Long> {

	public Brand findBrandByProductId(@Param("product_id") Long product_id);
	
	public List<Brand> findAllBrand();
	
	public List<Brand> findBrandPageable(@Param("sizeOfPage") Integer sizeOfPage,@Param("offset") Integer offset);
	
	public int countAllBrand();
	
	public long addNewBrand(@Param("name") String name);
	
	public void setBrandById(@Param("name") String name, @Param("id") Long id);
}
