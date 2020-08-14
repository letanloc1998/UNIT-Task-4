package vn.com.unit.repository;

import java.util.List;

import org.springframework.data.mirage.repository.MirageRepository;
import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.Brand;

public interface BrandRepository extends MirageRepository<Brand, Long> {

	public Brand findBrandByProductId(@Param("product_id") Long product_id);

}
