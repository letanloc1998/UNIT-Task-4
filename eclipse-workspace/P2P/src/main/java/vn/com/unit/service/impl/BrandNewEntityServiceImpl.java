package vn.com.unit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.unit.entity.BrandNewEntity;
import vn.com.unit.repository.BrandNewEntityRepository;
import vn.com.unit.repository.BrandRepository;
import vn.com.unit.repository.CategoryRepository;
import vn.com.unit.repository.ProductRepository;
import vn.com.unit.repository.ShopRepository;
import vn.com.unit.service.BrandNewEntityService;
import vn.com.unit.service.BrandService;

@Service
@Transactional
public class BrandNewEntityServiceImpl implements BrandNewEntityService {

	@Autowired
	ShopRepository shopRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	BrandRepository brandRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	BrandNewEntityRepository brandNewEntityRepository;
	
	@Autowired
	BrandService brandService;
	
	@Autowired
	BrandNewEntityService brandNewEntityService;
	
	@Override
	public BrandNewEntity add(BrandNewEntity brandNewEntity) {
		
		return brandNewEntityRepository.save(brandNewEntity) ;
		
	};
	
	@Override
	public BrandNewEntity findBrandNewEntityByBrandId(Long brandId) {
		return brandNewEntityRepository.findBrandNewEntityByBrandId(brandId);
	}
	
	@Override
	public void edit(BrandNewEntity brandNewEntity) {
		
		Long brandId = 8L;
		
		BrandNewEntity brand = new BrandNewEntity();
		brand = this.findBrandNewEntityByBrandId(brandId);
		
		BrandNewEntity newBrand = new BrandNewEntity();
		brandNewEntityRepository.save(brand);
		
		newBrand.setName("Khanh");
		newBrand.setId(8L);
		
		brandNewEntityRepository.save(newBrand);
		
		
		
		
	};
	
	
}
